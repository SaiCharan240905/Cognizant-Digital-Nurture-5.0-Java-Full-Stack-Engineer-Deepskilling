-- Scenario 2 Requirement : Increase salary by percentage. Handle: Employee does not exist.

CREATE OR REPLACE PROCEDURE UpdateSalary
(
    p_employee_id IN NUMBER,
    p_percentage  IN NUMBER
)
AS

BEGIN

    UPDATE Employees
    SET Salary =
        Salary +
        (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN

        RAISE_APPLICATION_ERROR(
            -20002,
            'Employee ID not found'
        );

    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Salary updated successfully.'
    );

EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Salary Update Failed: '
            || SQLERRM
        );

END;
/

--Test
BEGIN
    UpdateSalary(
        1,
        10
    );
END;
/ 

/* Output
Salary updated successfully.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.012
*/

-- Test Exception
BEGIN
    UpdateSalary(
        999,
        10
    );
END;
/

/* Output
Salary Update Failed: ORA-20002: Employee ID not found
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.004
*/