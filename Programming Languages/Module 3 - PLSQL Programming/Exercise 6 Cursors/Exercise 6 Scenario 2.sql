-- Scenario 2 Requirement : Deduct annual maintenance fee from all accounts.

DECLARE

    CURSOR ApplyAnnualFee IS
        SELECT AccountID,
               Balance
        FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;

BEGIN

    OPEN ApplyAnnualFee;

    LOOP

        FETCH ApplyAnnualFee
        INTO v_account_id,
             v_balance;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = v_account_id;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee applied to Account ID '
            || v_account_id
        );

    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

END;
/

/* Output
Annual fee applied to Account ID 1
Annual fee applied to Account ID 2
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.010
*/

-- Verify
SELECT *
FROM Accounts;

/* Output
ACCOUNTID |   CUSTOMERID | ACCOUNTTYPE  |  BALANCE|
---------------------------------------------------
1         |  1           | Savings      | -100    | 
2         |  2           | Checking     | 2400    | 
---------------------------------------------------
*/