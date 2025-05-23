/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

// This means: Hey Java, I’m going to use the Employee class from the employee package:)
import employee.Employee; 
import java.io.*;
import java.util.*;

public class PayrollProcessor {
    // This is the path to the CSV file where employee records are stored.
    // Make sure the file exists and the path is correct for the system you're using.
    public static final String EMPLOYEE_CSV_PATH = "C:\\Users\\HP\\Documents\\NetBeansProjects\\PayrollSystem\\csv\\ref\\Copy of MotorPH Employee Data - Employee Details.csv";
    private List<Employee> employees;
    private static final boolean DEBUG = false; // ← Set to true if you want to enable logs

    // Constructor to initialize the employee list when PayrollProcessor is created.
    // This list will hold all imported employee data as Employee object.
    public PayrollProcessor() {
        employees = new ArrayList<>();
    }
    // Utility method to check if the file path exists and is readable.
    // I can use this to confirm that my file path is correct before importing employees.
    public void testFilePath() {
        File file = new File(EMPLOYEE_CSV_PATH);
        if (file.exists()) {
            System.out.println("File found: " + EMPLOYEE_CSV_PATH);
        } else {
            System.out.println("File not found: " + EMPLOYEE_CSV_PATH);
        }
    }

    // Import Employees for Payroll Processing
    // This function loads and parses employee data from the CSV file.
    // It also converts each CSV row into an Employee object and stores it in the 'employees' list.
    public void importEmployeesFromCSV() {
    try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEE_CSV_PATH))) {
        String line;
        br.readLine(); // / Skip the first line (header)

        while ((line = br.readLine()) != null) {
            line = line.trim();

            // This skips lines that are blank or just commas
            if (line.isEmpty() || line.replace(",", "").trim().isEmpty()) continue;

            String[] data = parseCSVLine(line);

            // This part skips broken/test data rows
            if (data.length < 5 || data[0].trim().isEmpty()) {
                if (DEBUG) System.out.println("⛔ Skipping invalid row: " + Arrays.toString(data));
                continue;
            }

            // Now parse your data
            try {
                // Now I extract and clean all the data from the CSV row
                int employeeID = Integer.parseInt(data[0].trim());
                String name = data[2].trim() + " " + data[1].trim(); // FirstName LastName
                String birthday = data[3].trim();
                String address = data[4].trim();
                String phoneNumber = data[5].trim();
                String sssNumber = data[6].trim();
                String philhealthNumber = data[7].trim();
                String tinNumber = data[8].trim();
                String pagibigNumber = data[9].trim();
                String status = data[10].trim();
                String position = data[11].trim();
                double basicSalary = Double.parseDouble(data[13].replace(",", "").trim());
                double riceSubsidy = Double.parseDouble(data[14].replace(",", "").trim());
                double phoneAllowance = Double.parseDouble(data[15].replace(",", "").trim());
                double clothingAllowance = Double.parseDouble(data[16].replace(",", "").trim());
                double grossSemiMonthlyRate = Double.parseDouble(data[17].replace(",", "").trim());
                double hourlyRate = Double.parseDouble(data[18].replace(",", "").trim());
                
                //I create a new Employee object with all the data above
                Employee emp = new Employee(
                    employeeID, name, status, position,
                    basicSalary, riceSubsidy, phoneAllowance, clothingAllowance,
                    grossSemiMonthlyRate, hourlyRate, 0.0, 0.0,
                    birthday, phoneNumber, address, sssNumber, philhealthNumber, tinNumber, pagibigNumber
                );

                employees.add(emp);

            } catch (Exception e) {
                if (DEBUG) System.out.println("⚠️ Error parsing row: " + Arrays.toString(data));
            }
        }
    } catch (IOException e) {
        System.out.println("⚠️ Error reading the CSV file: " + e.getMessage());
    }
}
    // This method prints the main payroll report
    public void processPayroll() {
        // Print the table header and formatting lines
        String border = "=".repeat(200);
        String separator = "-".repeat(200);
        String title = "PAYROLL REPORT";
        int totalWidth = border.length();
        int padding = (totalWidth - title.length()) / 2;

        System.out.println("\n" + border);
        System.out.println(" ".repeat(padding) + title);
        System.out.println(border);

        System.out.printf("%-6s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-18s | %-15s | %-15s | %-15s%n",
                "ID", "Employee Name", "Status", "Basic Salary", "Rice Subsidy", "Phone Allow.",
                "Clothing Allow.", "Gross Semi-Monthly", "Hourly Rate", "Gov. Deductions", "Net Salary");
        System.out.println(separator);

        // Variables to store totals for future calculations
        double totalBasicSalary = 0, totalRiceSubsidy = 0, totalPhoneAllowance = 0, totalClothingAllowance = 0;
        double totalGrossSemiMonthly = 0, totalHourlyRate = 0, totalGovDeductions = 0, totalNetSalary = 0;
        int employeeCount = employees.size();

        // Loop through each employee and print their data
        for (Employee emp : employees) {
            // We’ll compute net salary and deductions later, so we just show placeholders for now
            double netSalary = emp.getBasicSalary(); // Placeholder

            System.out.printf(
                    "%-6d | %-25s | %-15s | %,-15.2f | %,-15.2f | %,-15.2f | %,-15.2f | %,-18.2f | %,-15.2f | %-15s | %-15s%n",
                    emp.getEmployeeID(),              // ID
                    emp.getName(),                    // Name
                    emp.getStatus(),                  // Status
                    emp.getBasicSalary(),             // Basic Salary
                    emp.getRiceSubsidy(),             // Rice Subsidy
                    emp.getPhoneAllowance(),          // Phone Allowance
                    emp.getClothingAllowance(),       // Clothing Allowance
                    emp.getGrossSemiMonthlyRate(),    // Gross Semi-Monthly
                    emp.getHourlyRate(),              // Hourly Rate
                    String.format("%,.2f", emp.getGovDeductions()),           // Gov. Deductions (placeholder)
                    String.format("%,.2f", emp.getNetSalary())                // Net Salary (placeholder)
            );

            // add up totals for final rows
            totalBasicSalary += emp.getBasicSalary();
            totalRiceSubsidy += emp.getRiceSubsidy();
            totalPhoneAllowance += emp.getPhoneAllowance();
            totalClothingAllowance += emp.getClothingAllowance();
            totalGrossSemiMonthly += emp.getGrossSemiMonthlyRate();
            totalHourlyRate += emp.getHourlyRate();
            totalGovDeductions += emp.getGovDeductions();
            totalNetSalary += emp.getNetSalary();
        }

        // Print summary totals row before the footer
        System.out.println(separator);
        System.out.printf("%-6s | %-25s | %-15s | %,-15.2f | %,-15.2f | %,-15.2f | %,-15.2f | %,-18.2f | %,-15.2f | %,-15.2f | %,-15.2f%n",
                "TOTAL", "-", "-", totalBasicSalary, totalRiceSubsidy, totalPhoneAllowance,
                totalClothingAllowance, totalGrossSemiMonthly, totalHourlyRate, totalGovDeductions, totalNetSalary);

        // ✅ Format grand summary to evenly space it across the 191-character width
        String grossStr = String.format("GRAND TOTAL: %,.2f", totalGrossSemiMonthly);
        String netStr = String.format("NET TOTAL: %,.2f", totalNetSalary);
        String countStr = String.format("TOTAL EMPLOYEES: %d", employeeCount);

        int sectionWidth = (totalWidth - 4) / 3; // spacing buffer
        System.out.printf("%-" + sectionWidth + "s | %-" + sectionWidth + "s | %-" + sectionWidth + "s%n",
                grossStr, netStr, countStr);

        System.out.println(border);
    }
    // This is the table for printing detailed government deductions
    public void printDeductionTable() {
    String border = "=".repeat(150);
    String separator = "-".repeat(150);
    String title = "GOVERNMENT DEDUCTIONS BREAKDOWN";

    System.out.println("\n" + border);
    System.out.println(" ".repeat((border.length() - title.length()) / 2) + title);
    System.out.println(border);

    // Print header 
    System.out.printf("%-6s | %-25s | %15s | %15s | %15s | %18s | %18s%n",
            "ID", "Employee Name", "SSS", "PhilHealth", "Pag-IBIG", "Withholding Tax", "Total Deduction");
    System.out.println(separator);
    
    // Totals
    double totalSSS = 0,totalPhilHealth = 0, totalPagibig = 0, totalWTax = 0, totalGovDeduction = 0;
                
    // Loop through employees and print values neatly
    for (Employee emp : employees) {
        double total = emp.getSssContribution() +
                       emp.getPhilhealthContribution() +
                       emp.getPagibigContribution() +
                       emp.getWithholdingTax();
        
        totalSSS += emp.getSssContribution();
                totalPhilHealth += emp.getPhilhealthContribution();
                totalPagibig += emp.getPagibigContribution();
                totalWTax += emp.getWithholdingTax();
                totalGovDeduction += total;

        System.out.printf("%-6d | %-25s | %,15.2f | %,15.2f | %,15.2f | %,18.2f | %,18.2f%n",
                emp.getEmployeeID(),
                emp.getName(),
                emp.getSssContribution(),
                emp.getPhilhealthContribution(),
                emp.getPagibigContribution(),
                emp.getWithholdingTax(),
                total);
    }
    
    // Total Rows
    System.out.println(separator);
    System.out.printf("%-6s | %-25s | %,15.2f | %,15.2f | %,15.2f | %,18.2f | %,18.2f%n",
            "TOTAL", "-", totalSSS, totalPhilHealth, totalPagibig, totalWTax, totalGovDeduction);
    System.out.println(border);
}
    // This is the actual gov deduction formula (SSS, PhilHealth, etc.) based on salary
    private void computeGovernmentDeductions(Employee emp) {
    double salary = emp.getGrossSemiMonthlyRate() * 2; // This converts semi-monthly to monthly

    // SSS — simplified bracketed logic (example only; use actual table for precision)
    double sss = 0;
    if (salary <= 3250) sss = 135;
    else if (salary <= 3749.99) sss = 157.5;
    else if (salary <= 4249.99) sss = 180;
    else if (salary <= 4749.99) sss = 202.5;
    else if (salary <= 5249.99) sss = 225;
    else sss = 247.5;

    // PhilHealth — 3% of monthly salary, min 300, max 1800
    double philhealth = Math.max(300, Math.min(salary * 0.03, 1800));

    // Pag-IBIG — 1% if ≤1500, else 2%, capped at 100
    double pagibig = (salary <= 1500) ? salary * 0.01 : salary * 0.02;
    pagibig = Math.min(pagibig, 100);

    // Withholding Tax — simplified formula
    double wtax = 0;
    if (salary <= 20832) wtax = 0;
    else if (salary < 33333) wtax = (salary - 20833) * 0.2;
    else if (salary < 66667) wtax = 2500 + (salary - 33333) * 0.25;
    else if (salary < 166667) wtax = 10833 + (salary - 66667) * 0.3;
    else wtax = 40833.33 + (salary - 166667) * 0.32;

    double totalDeduction = sss + philhealth + pagibig + wtax;
    double netSalary = emp.getGrossSemiMonthlyRate() - (totalDeduction / 2); // semi-monthly deduction

    // Save to employee object
    emp.setSssContribution(sss);
    emp.setPhilhealthContribution(philhealth);
    emp.setPagibigContribution(pagibig);
    emp.setWithholdingTax(wtax);
    emp.setGovDeductions(totalDeduction / 2);
    emp.setNetSalary(netSalary);
}

public void computeAllDeductions() {
    for (Employee emp : employees) {
        computeGovernmentDeductions(emp);
    }
}

    public List<Employee> getEmployees() {
        return employees;
    }

    // Entry point of the program
    // We first import employees and then immediately print the payroll report
    public static void main(String[] args) {
        PayrollProcessor payroll = new PayrollProcessor();
        payroll.importEmployeesFromCSV();
        payroll.computeAllDeductions(); // Compute before printing
        payroll.processPayroll(); // First clean payroll report
        payroll.printDeductionTable(); // Clean deduction table
    }

    // Helper method to properly handle CSV parsing (handles commas inside quotes)
    // We wrote this to safely break each row into fields even if some have commas within quotes.
    private String[] parseCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char ch : line.toCharArray()) {
            if (ch == '"') {
                inQuotes = !inQuotes;
            } else if (ch == ',' && !inQuotes) {
                tokens.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(ch);
            }
        }
        tokens.add(sb.toString().trim()); // Add the last token
        return tokens.toArray(new String[0]);
    }
}

// 📌 Raw CSV Lines above payroll report to be hidden once computation has been implemented.
// 📌 To print a new table below "payroll report" that will display detailed goverment deductions per employee