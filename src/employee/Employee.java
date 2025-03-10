/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

public class Employee {
    private int employeeID;
    private String name;
    private String status;
    private String position;
    private double basicSalary;
    private double hourlyRate;
    private double allowances;
    private double deductions;
    private double hoursWorked;

    public Employee(int employeeID, String name, String status, String position, 
                    double basicSalary, double hourlyRate, double allowances, double deductions) {
        this.employeeID = employeeID;
        this.name = name;
        this.status = status;
        this.position = position;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
        this.allowances = allowances;
        this.deductions = deductions;
        this.hoursWorked = 0;  
    }

    public int getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getPosition() { return position; }
    public double getBasicSalary() { return basicSalary; }
    public double getHourlyRate() { return hourlyRate; }
    public double getAllowances() { return allowances; }
    public double getDeductions() { return deductions; }
    public double getHoursWorked() { return hoursWorked; }

    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
}
