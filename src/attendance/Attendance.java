/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package attendance;  // ✅ Package name is correct!

public class Attendance {  // ✅ Class name should start with uppercase
    private int employeeID;
    private String date;
    private String logInTime;
    private String logOutTime;
    private double hoursWorked;

    // ✅ Constructor
    public Attendance(int employeeID, String date, String logInTime, String logOutTime, double hoursWorked) {
        this.employeeID = employeeID;
        this.date = date;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.hoursWorked = hoursWorked;
    }

    // ✅ Getters (Fixes the errors in the Navigator)
    public int getEmployeeID() { return employeeID; }
    public String getDate() { return date; }
    public String getLogInTime() { return logInTime; }
    public String getLogOutTime() { return logOutTime; }
    public double getHoursWorked() { return hoursWorked; }
}