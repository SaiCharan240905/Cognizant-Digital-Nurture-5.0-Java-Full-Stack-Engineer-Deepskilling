-- Scenario 2 Requirement : Update salary of employees belonging to a specified department by adding a bonus percentage.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
AS

BEGIN

    UPDATE Employees
    SET Salary =
        Salary +
        (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Bonus updated successfully for department '
        || p_department
    );

EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Error Updating Bonus: '
            || SQLERRM
        );

END;
/

--Test
BEGIN
    UpdateEmployeeBonus(
        'HR',
        10
    );
END;
/

/* Output
Bonus updated successfully for department HR
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.011
*/