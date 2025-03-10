/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import employee.Employee;
import java.io.*;
import java.util.*;

public class PayrollProcessor {
    private List<Employee> employees;

    public PayrollProcessor() {
        employees = new ArrayList<>();
    }

// ✅ Import Employees from CSV (Corrected)
public void importEmployeesFromCSV(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        br.readLine(); // Skip header row

        while ((line = br.readLine()) != null) { // Read each row
            if (line.trim().isEmpty()) continue; // Skip empty lines

            // ✅ Use the updated parseCSVLine method
            String[] data = parseCSVLine(line);
            if (data.length < 10) continue; // Ensure correct field count

            // ✅ Debugging: Print row content
            System.out.println("Processing row: " + Arrays.toString(data));

            try {
                int employeeID = Integer.parseInt(data[0].trim()); // Employee ID
                String name = data[1].trim() + " " + data[2].trim(); // First + Last Name
                String status = data[10].trim(); // Employment Status
                String position = data[11].trim(); // Position

                // ✅ Ensure numeric values are properly converted (Remove commas)
                double basicSalary = Double.parseDouble(data[15].replace(",", "").trim());
                double hourlyRate = Double.parseDouble(data[16].replace(",", "").trim());
                double allowances = Double.parseDouble(data[17].replace(",", "").trim());
                double deductions = Double.parseDouble(data[18].replace(",", "").trim());

                Employee emp = new Employee(employeeID, name, status, position, basicSalary, hourlyRate, allowances, deductions);
                employees.add(emp); // ✅ Add employee to list
            } catch (NumberFormatException e) {
                System.out.println("❌ Error parsing number: " + e.getMessage());
            }
        }

        System.out.println("✔ Import complete! Total Employees: " + employees.size());

    } catch (IOException e) {
        System.out.println("❌ Error reading CSV: " + e.getMessage());
    }
}

    // ✅ Display Employees
    public void displayEmployees() {
        System.out.println("\n=========================================");
        System.out.println("EMPLOYEE DATABASE");
        System.out.println("=========================================");
        System.out.printf("%-5s | %-15s | %-10s | %-12s | %-10s%n",
                          "ID", "Name", "Status", "Position", "Basic Salary");
        System.out.println("-----------------------------------------");

        for (Employee emp : employees) {
            System.out.printf("%-5d | %-15s | %-10s | %-12s | %,.2f%n",
                              emp.getEmployeeID(), emp.getName(),
                              emp.getStatus(), emp.getPosition(),
                              emp.getBasicSalary());
        }
        System.out.println("=========================================");
    }

// ✅ Calculate Pay (Updated)
public double calculatePay(Employee emp) {
    String status = emp.getStatus().toLowerCase(); // Normalize case

    if (status.equals("hourly")) {
        return emp.getHourlyRate() * 160; // Assuming 160 hours per month
    } else if (status.equals("regular") || status.equals("monthly") || status.equals("probationary")) {
        return emp.getBasicSalary();
    }

    System.out.println("⚠ Invalid Pay Type for " + emp.getName());
    return 0.0;
}


    // ✅ Process Payroll Report
    public void processPayroll() {
        System.out.println("\n=========================================");
        System.out.println("          PAYROLL PROCESS REPORT         ");
        System.out.println("=========================================");
        System.out.printf("%-20s | %-12s%n", "Employee Name", "Total Pay");
        System.out.println("-----------------------------------------");

        double totalPayroll = 0;
        for (Employee emp : employees) {
            double totalPay = calculatePay(emp);
            totalPayroll += totalPay;
            System.out.printf("%-20s | %,.2f%n", emp.getName(), totalPay);
        }

        System.out.println("-----------------------------------------");
        System.out.printf("Total Payroll Cost: %,.2f%n", totalPayroll);
        System.out.println("Total Employees: " + employees.size());
        System.out.println("=========================================");
    }

    // ✅ Export Payroll Report to CSV
    public void exportPayrollToCSV(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Employee ID,Name,Status,Position,Basic Salary,Hourly Rate,Hours Worked,Total Pay");

            double totalPayroll = 0;
            for (Employee emp : employees) {
                double totalPay = calculatePay(emp);
                totalPayroll += totalPay;

                writer.printf("%d,%s,%s,%s,%.2f,%.2f,%.2f,%.2f%n",
                              emp.getEmployeeID(), emp.getName(), emp.getStatus(),
                              emp.getPosition(), emp.getBasicSalary(), emp.getHourlyRate(),
                              emp.getHoursWorked(), totalPay);
            }

            // ✅ Add total payroll at the last row
            writer.printf("\nTotal Payroll Cost,,,,,,%.2f%n", totalPayroll);

            System.out.println("✅ Payroll report exported successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error exporting payroll to CSV: " + e.getMessage());
        }
    }

    // ✅ Method to handle quoted values in CSV
    private String[] parseCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char ch : line.toCharArray()) {
            if (ch == '"' && inQuotes) {
                inQuotes = false; // Closing quote
            } else if (ch == '"') {
                inQuotes = true; // Opening quote
            } else if (ch == ',' && !inQuotes) {
                tokens.add(sb.toString().trim()); // Add token
                sb.setLength(0); // Reset builder
            } else {
                sb.append(ch);
            }
        }
        tokens.add(sb.toString().trim()); // Add last field

        return tokens.toArray(new String[0]);
    }

    // ✅ Helper method to parse numbers safely (removes commas)
    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value.replace(",", ""));
        } catch (NumberFormatException e) {
            System.out.println("⚠ Error parsing number: " + value);
            return 0.0;
        }
    }
}
