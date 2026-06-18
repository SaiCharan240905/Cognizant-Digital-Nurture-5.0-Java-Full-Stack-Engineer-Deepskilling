-- Scenario 1 Requirement : Handle exceptions during fund transfers between accounts.

CREATE OR REPLACE PROCEDURE SafeTransferFunds
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

        RAISE_APPLICATION_ERROR(
            -20001,
            'Insufficient Funds'
        );

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

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Failed: '
            || SQLERRM
        );

END;
/

-- Test
BEGIN
    SafeTransferFunds(
        1,
        2,
        500
    );
END;
/
/* Output
Funds transferred successfully.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.016
*/

-- Test Error Handling
BEGIN
    SafeTransferFunds(
        1,
        2,
        5000
    );
END;
/
/* Output
Transfer Failed: ORA-20001: Insufficient Funds
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.004
*/