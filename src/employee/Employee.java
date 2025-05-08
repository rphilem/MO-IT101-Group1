package employee;

public class Employee {
    private int employeeID;
    private String name;
    private String status;
    private String position;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
    private double govDeductions;
    private double netSalary;
    
    // New for payroll computation
    private double sssContribution;
    private double philhealthContribution;
    private double pagibigContribution;
    private double withholdingTax;

    // Additional Fields from CSV Structure
    private String birthday;
    private String phoneNumber;
    private String address;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;

    // Updated Constructor to Match Full CSV + PayrollProcessor.java
    public Employee(int employeeID, String name, String status, String position,
                    double basicSalary, double riceSubsidy, double phoneAllowance,
                    double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate,
                    double govDeductions, double netSalary,
                    String birthday, String phoneNumber, String address,
                    String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber) {

        this.employeeID = employeeID;
        this.name = name;
        this.status = status;
        this.position = position;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
        this.govDeductions = govDeductions;
        this.netSalary = netSalary;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
    }

    Employee(int id, String name, String status, String position, double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthly, double hourlyRate, double govDeductions, double netSalary) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters for Employee Attributes
    public int getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getPosition() { return position; }
    public double getBasicSalary() { return basicSalary; }
    public double getRiceSubsidy() { return riceSubsidy; }
    public double getPhoneAllowance() { return phoneAllowance; }
    public double getClothingAllowance() { return clothingAllowance; }
    public double getGrossSemiMonthlyRate() { return grossSemiMonthlyRate; }
    public double getHourlyRate() { return hourlyRate; }
    public double getGovDeductions() { return govDeductions; }
    public double getNetSalary() { return netSalary; }

    //New getters and setters for payroll computation
    public double getSssContribution() {
           return sssContribution;
    }
    public void setSssContribution(double sssContribution){
        this.sssContribution = sssContribution;
    }
    public double getPhilhealthContribution(){
        return philhealthContribution;
    }
    public void setPhilhealthContribution(double philhealthContribution){
        this.philhealthContribution = philhealthContribution;
    }   
        public double getPagibigContribution() {
        return pagibigContribution;
    }
    public void setPagibigContribution(double pagibigContribution) {
        this.pagibigContribution = pagibigContribution;
    }
    public double getWithholdingTax() {
        return withholdingTax;
    }
    public void setWithholdingTax(double withholdingTax) {
        this.withholdingTax = withholdingTax;
    }
    
    public String getBirthday() { return birthday; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getSssNumber() { return sssNumber; }
    public String getPhilhealthNumber() { return philhealthNumber; }
    public String getTinNumber() { return tinNumber; }
    public String getPagibigNumber() { return pagibigNumber; }

    // Setters (if needed)
    public void setGovDeductions(double govDeductions) { this.govDeductions = govDeductions; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    // Formatted Display for Debugging
    @Override
    public String toString() {
        return String.format(
            "%-6d | %-25s | %-15s | %,-15.2f | %,-15.2f | %,-15.2f | %,-15.2f | %,-18.2f | %,-15.2f | %-15s | %,-15.2f",
            employeeID, name, status, basicSalary, riceSubsidy, phoneAllowance,
            clothingAllowance, grossSemiMonthlyRate, hourlyRate, "-", netSalary
        );
    }
}
