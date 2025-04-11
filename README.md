# Terminal Assessment: Final Code Submission

## Overview  
This repository contains the Payroll System code developed for **MotorPH** as part of our coursework.  
It includes payroll processing functionalities, government deductions, and employee attendance tracking.  

## Our latest version includes:
- Refactored class files (`EmployeeMenu`, `PayrollProcessor`, and `CaseTest` as test runner)
- Payroll computation with **semi-monthly net salary**, full allowance, and government deduction breakdown
- Finalized `Payroll_Report.csv` that matches printed NetBeans output
- Cleaned Git history using `.gitignore` to remove `build/` and `dist/` folders
- Synced successfully with GitHub after resolving merge issues

### Submission Details
- **Repository:** [MO-IT101-Group1](https://github.com/rphilem/MO-IT101-Group1)  
- **Mentor Added:** — *03/10/2025, expired invitation*
- **Re-added** — *04/10/2025*   

---

##  Features Implemented:

✔ Interactive Employee Menu System  
✔ Add, View, Update, Delete Employee (CRUD-ready)  
✔ Submenus: Personal Info / Work Info / Government Numbers  
✔ Payroll Calculation (Gross, Hourly, Semi-Monthly, Net Salary)  
✔ Government Deductions (SSS, PhilHealth, Pag-IBIG, Tax)  
✔ CSV Read and Write with Data Validation for importing employee data  
✔ Payroll Report CSV with full deduction breakdown  
✔ Deductions Table View  
✔ `.gitignore` implemented (ignores compiled class files and `.jar`) and repository cleanup  
✔ Terminal Git Sync (via `pull --rebase` & `push`)  


Payroll System (MO-IT101-Group1)
Terminal Assessment: Final Code Submission

## Project Structure (as of April 11, 2025):

```
PayrollSystem/
├── src/
│   ├── attendance/
│   │   └── Attendance.java                  # (Optional stub for future use)
│
│   ├── employee/
│   │   ├── Employee.java                    # Employee model
│   │   ├── EmployeeMenu.java                # Interactive CLI menu
│   │   └── CaseTest.java                    # Test launcher (was Main.java)
│
│   ├── payrollsystem/
│   │   └── PayrollProcessor.java            # Handles CSV import, payroll logic, deductions
│
├── csv/
│   └── ref/
│       ├── Copy of MotorPH Employee Data - Employee Details.csv
│       ├── Copy of Withholding Tax.xlsx
│       ├── Copy of Philhealth Contribution.xlsx
│       └── Copy of Pag-ibig Contribution.xlsx
│
├── dist/
│   └── (ignored by Git) PayrollSystem.jar   # Auto-generated JAR (now ignored)
├── build/                                   # (ignored auto-compiled .class files)
├── .gitignore                               # Prevents pushing unnecessary build artifacts
├── README.md                                # Project description & setup guide
```


### Salary Computation Note:
- All Net Salary values in `Payroll_Report.csv` are computed based on **semi-monthly payout** (half of monthly gross).
- Deductions and allowances are also computed proportionally.
- **Gross Semi-Monthly = (Basic Salary + Rice Allowance + Phone Allowance + Clothing Allowance) / 2**
- **Deductions**:
  - **SSS**: Based on fixed bracketed values using monthly salary.
  - **PhilHealth**: 3% of monthly salary, minimum ₱300, maximum ₱1800.
  - **Pag-IBIG**: 1% if salary ≤ ₱1500, else 2%, capped at ₱100.
  - **Withholding Tax**: Tiered formula based on monthly income brackets.
- **Net Salary = Gross Semi-Monthly - (Total Deductions / 2)**

## Not Implemented

**Attendance Integration**
- Although Attendance.java exists, attendance data is not yet factored into salary calculations.
- Salary is computed from static employee information only — no deductions/additions for absences, late, or overtime.

**Payroll Export Menu Option**
- While payroll can be exported to a CSV via PayrollProcessor, the export is not yet linked as an option in the interactive EmployeeMenu interface.

**Search, Update, Delete Functions**
- The menu placeholders are present, but the actual logic for modifying employee records is pending implementation.

**Error Handling Enhancements**
- Basic validation is done, but input error handling (example: invalid salary input) can be improved.

## MO-IT101 - Computer Programming 1
**Term 2  SY 2024 - 25  Bachelor of Science in Information Technology  H1103**
