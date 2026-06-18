-- Scenario 2 Requirement : EmployeeManagement Package

-- 1. Package Specification (declaration)
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee
    (
        p_employee_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hiredate DATE
    );

    PROCEDURE UpdateEmployee
    (
        p_employee_id NUMBER,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary
    (
        p_employee_id NUMBER
    )
    RETURN NUMBER;

END EmployeeManagement;
/

-- 2. Package Body (implementation)
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee
    (
        p_employee_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hiredate DATE
    )
    IS
    BEGIN

        INSERT INTO Employees
        VALUES
        (
            p_employee_id,
            p_name,
            p_position,
            p_salary,
            p_department,
            p_hiredate
        );

        COMMIT;

    END HireEmployee;

    PROCEDURE UpdateEmployee
    (
        p_employee_id NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN

        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_employee_id;

        COMMIT;

    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary
    (
        p_employee_id NUMBER
    )
    RETURN NUMBER
    IS

        v_salary NUMBER;

    BEGIN

        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;

        RETURN v_salary * 12;

    END CalculateAnnualSalary;

END EmployeeManagement;
/

--Test
SELECT EmployeeManagement.CalculateAnnualSalary(1)
AS AnnualSalary
FROM DUAL;

/* Output
Package EMPLOYEEMANAGEMENT compiled
Elapsed: 00:00:00.018
Package Body EMPLOYEEMANAGEMENT compiled
Elapsed: 00:00:00.017

+--------+--------------+
|        | ANNUALSALARY | 
+--------+--------------+
|   1    | 1118040      |   
+--------+--------------+
*/