package employee;

import java.io.*;
import java.util.*;

import payrollsystem.PayrollProcessor;

public class EmployeeMenu {
    private List<Employee> employees;
    private Scanner scanner;

    public EmployeeMenu(List<Employee> employees) {
        this.employees = employees;
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\n==================== EMPLOYEE MENU SYSTEM ====================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> showViewSubmenu();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> System.out.println("Exiting Employee Menu System. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void addEmployee() {
        System.out.println("\n[ Add New Employee ]");

        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Full Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Status (e.g. Regular): ");
            String status = scanner.nextLine();

            System.out.print("Enter Position: ");
            String position = scanner.nextLine();

            System.out.print("Enter Basic Salary: ");
            double basicSalary = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Rice Subsidy: ");
            double riceSubsidy = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Phone Allowance: ");
            double phoneAllowance = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Clothing Allowance: ");
            double clothingAllowance = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Gross Semi-Monthly: ");
            double grossSemiMonthly = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Hourly Rate: ");
            double hourlyRate = Double.parseDouble(scanner.nextLine());

            double govDeductions = 0.0;
            double netSalary     = 0.0;

            Employee newEmp = new Employee(id, name, status, position,
                basicSalary, riceSubsidy, phoneAllowance, clothingAllowance,
                grossSemiMonthly, hourlyRate, govDeductions, netSalary);

            employees.add(newEmp);
            writeEmployeesToCSV();
            System.out.println("\u2705 Employee added successfully!");

        } catch (Exception e) {
            System.out.println("\u274C Failed to add employee: " + e.getMessage());
        }
    }

    public void writeEmployeesToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PayrollProcessor.EMPLOYEE_CSV_PATH))) {
            bw.write("Employee #,Last Name,First Name,Birthday,Address,Phone Number,SSS #,Philhealth #,TIN #,Pag-ibig #,Status,Position,Immediate Supervisor,Basic Salary,Rice Subsidy,Phone Allowance,Clothing Allowance,Gross Semi-monthly Rate,Hourly Rate\n");

            for (Employee emp : employees) {
                String[] nameParts = emp.getName().split(" ", 2);
                String lastName = nameParts.length > 1 ? nameParts[1] : "";
                String firstName = nameParts[0];

                bw.write(String.format("%d,%s,%s,,,,,,,,%s,%s,,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f\n",
                    emp.getEmployeeID(), lastName, firstName,
                    emp.getStatus(), emp.getPosition(),
                    emp.getBasicSalary(), emp.getRiceSubsidy(), emp.getPhoneAllowance(),
                    emp.getClothingAllowance(), emp.getGrossSemiMonthlyRate(), emp.getHourlyRate()
                ));
            }

        } catch (IOException e) {
            System.out.println("\u274C Error writing to CSV: " + e.getMessage());
        }
    }

    private void showViewSubmenu() {
        int choice;
        do {
            System.out.println("\n[ VIEW EMPLOYEE DETAILS ]");
            System.out.println("1. Personal Details");
            System.out.println("2. Employment Details");
            System.out.println("3. Government Numbers");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select view option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewPersonalDetails();
                case 2 -> viewEmploymentDetails();
                case 3 -> viewGovernmentNumbers();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private void viewPersonalDetails() {
        System.out.println("\n======================== EMPLOYEE PERSONAL DETAILS ========================");
        System.out.printf("%-6s | %-25s | %-12s | %-15s | %-30s%n", "ID", "Name", "Birthday", "Phone Number", "Address");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Employee emp : employees) {
            System.out.printf("%-6d | %-25s | %-12s | %-15s | %-30s%n",
                emp.getEmployeeID(), emp.getName(), emp.getBirthday(), emp.getPhoneNumber(), emp.getAddress());
        }
    }

    private void viewEmploymentDetails() {
    System.out.println("\n======================== EMPLOYMENT DETAILS ========================");
    System.out.printf("%-6s | %-30s | %-35s | %-12s | %12s | %12s | %12s | %10s | %15s%n",
        "ID", "Name", "Position", "Status", "Rice", "Phone", "Clothing", "Hourly", "Semi-Monthly");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------");

    for (Employee emp : employees) {
        System.out.printf("%-6d | %-30s | %-35s | %-12s | %,12.2f | %,12.2f | %,12.2f | %,10.2f | %,15.2f%n",
            emp.getEmployeeID(),
            emp.getName(),
            emp.getPosition(),
            emp.getStatus(),
            emp.getRiceSubsidy(),
            emp.getPhoneAllowance(),
            emp.getClothingAllowance(),
            emp.getHourlyRate(),
            emp.getGrossSemiMonthlyRate());
    }
}

    private void viewGovernmentNumbers() {
        System.out.println("\n======================== GOVERNMENT NUMBERS ========================");
        System.out.printf("%-6s | %-25s | %-15s | %-15s | %-15s | %-15s%n",
            "ID", "Name", "SSS #", "Philhealth #", "TIN #", "Pag-IBIG #");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Employee emp : employees) {
            System.out.printf("%-6d | %-25s | %-15s | %-15s | %-15s | %-15s%n",
                emp.getEmployeeID(), emp.getName(), emp.getSssNumber(), emp.getPhilhealthNumber(),
                emp.getTinNumber(), emp.getPagibigNumber());
        }
    }

    private void searchEmployee() {
        System.out.println("[Search Function Placeholder]");
    }

    private void updateEmployee() {
        System.out.println("[Update Function Placeholder]");
    }

    private void deleteEmployee() {
        System.out.println("[Delete Function Placeholder]");
    }
}
