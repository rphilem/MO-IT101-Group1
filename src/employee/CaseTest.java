// ✅ CaseTest.java (previously Main.java)
package employee;

import employee.EmployeeMenu;
import java.util.*;

public class CaseTest {
    public static void main(String[] args) {
        // Use PayrollProcessor to load employee data from CSV
        payrollsystem.PayrollProcessor processor = new payrollsystem.PayrollProcessor();
        processor.importEmployeesFromCSV();

        // Get the up-to-date employee list
        List<Employee> employees = processor.getEmployees();

        // Launch the interactive menu
        EmployeeMenu menu = new EmployeeMenu(employees);
        menu.showMainMenu();
    }
}
