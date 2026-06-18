-- Scenario 3 Requirement : Transfer money between accounts after checking sufficient balance.

CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
AS

    v_balance NUMBER;

BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN

        DBMS_OUTPUT.PUT_LINE(
            'Insufficient funds. Transfer cancelled.'
        );

        RETURN;

    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Funds transferred successfully.'
    );

EXCEPTION

    WHEN NO_DATA_FOUND THEN

        DBMS_OUTPUT.PUT_LINE(
            'Account not found.'
        );

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Failed: '
            || SQLERRM
        );

END;
/


-- Test Success
BEGIN
    TransferFunds(
        1,
        2,
        200
    );
END;
/

/* Output
Funds transferred successfully.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.011
*/

-- Test Failure
BEGIN
    TransferFunds(
        1,
        2,
        5000
    );
END;
/

/* Output
Insufficient funds. Transfer cancelled.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.004
*/
