package payrollsystem;

import payrollsystem.PayrollProcessor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
public class payrollsystem {
    
    public static void main(String[] args) {
        PayrollProcessor payroll = new PayrollProcessor();

        // ✅ Automatically set CSV file paths (No need for Scanner input)
        String importPath = "C:\\Users\\HP\\OneDrive - Ecohotels Inc\\Desktop\\MMDC\\Copy of MotorPH Employee Data - Employee Details.csv";
        String exportPath = "C:\\Users\\HP\\OneDrive - Ecohotels Inc\\Desktop\\MMDC\\Payroll_Report.csv";

        // ✅ Import Employees
        payroll.importEmployeesFromCSV(importPath);
        payroll.displayEmployees();

        // ✅ Process Payroll
        payroll.processPayroll();

        // ✅ Export Payroll Report
        payroll.exportPayrollToCSV(exportPath);

        System.out.println("✔ Payroll processing complete. Exported to: " + exportPath);
    }
}