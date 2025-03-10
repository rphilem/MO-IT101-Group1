Payroll System (MO-IT101-Group1)
Milestone 2: Initial Code Submission
At this time, our team’s code has been uploaded to GitHub.

Next Steps:
Add Mentor as a Collaborator to the repository.
Review the project rubric to ensure completeness.
Submit the GitHub repository link individually in Camu.
Submission Format (for Camu):

## Project Structure (as of March 10, 2025):

```
PayrollSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── attendance/
│   │   │   │   └── Attendance.java              # Tracks employee attendance
│   │   │   ├── employee/
│   │   │   │   └── Employee.java                # Stores employee details
│   │   │   ├── payrollsystem/
│   │   │   │   ├── PayrollProcessor.java        # Handles salary calculations
│   │   │   │   ├── payrollsystem.java           # Main entry point for payroll system
│   │   ├── resources/
│   │   │   ├── application.properties           # Configuration file for app settings
│   │   │   ├── employees.csv                    # Sample employee data
│   │   │   ├── payroll_reports/                 # Folder to store exported payroll reports
│   │   │   ├── logs/                            # Folder for log files
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── payrollsystem/
│   │   │   │   │   ├── PayrollSystemTests.java  # Unit tests for payroll functionalities
│   │   │   │   │   ├── EmployeeTests.java       # Tests employee-related functions
│   │   │   │   │   ├── PayrollProcessorTests.java # Tests salary calculations
│   │   │   │   │   ├── DeductionsTests.java     # Tests government deductions
├── .gitignore                                   # Excludes unnecessary files from Git
├── README.md                                    # Project description & setup guide
├── pom.xml                                      # Maven build configuration
├── docs/                                        # Documentation folder
│   ├── project_requirements.md                  # Project requirements & scope
│   ├── developer_guide.md                       # Developer setup & contribution guide
│   ├── user_manual.md                           # User instructions for payroll system
│   └── API_reference.md                         # API endpoints & usage guide
```
