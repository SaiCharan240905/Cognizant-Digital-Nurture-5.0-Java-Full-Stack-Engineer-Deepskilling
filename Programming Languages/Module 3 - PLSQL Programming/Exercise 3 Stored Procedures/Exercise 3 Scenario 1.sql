-- Scenario 1 Requirement : Apply 1% monthly interest to all Savings Accounts.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Monthly interest processed successfully.'
    );

EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Error Processing Interest: '
            || SQLERRM
        );

END;
/

--Test
BEGIN
    ProcessMonthlyInterest;
END;
/

/* Output
Monthly interest processed successfully.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.011
*/
