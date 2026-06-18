-- Scenario 3 Requirement : AccountOperations Package

-- 1. Package Specification (declaration)
CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount
    (
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_account_type VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount
    (
        p_account_id NUMBER
    );

    FUNCTION GetTotalBalance
    (
        p_customer_id NUMBER
    )
    RETURN NUMBER;

END AccountOperations;
/

-- 2. Package Body (implementation)
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount
    (
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_account_type VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN

        INSERT INTO Accounts
        (
            AccountID,
            CustomerID,
            AccountType,
            Balance,
            LastModified
        )
        VALUES
        (
            p_account_id,
            p_customer_id,
            p_account_type,
            p_balance,
            SYSDATE
        );

        COMMIT;

    END OpenAccount;

    PROCEDURE CloseAccount
    (
        p_account_id NUMBER
    )
    IS
    BEGIN

        DELETE FROM Accounts
        WHERE AccountID = p_account_id;

        COMMIT;

    END CloseAccount;

    FUNCTION GetTotalBalance
    (
        p_customer_id NUMBER
    )
    RETURN NUMBER
    IS

        v_total_balance NUMBER;

    BEGIN

        SELECT SUM(Balance)
        INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN NVL(v_total_balance,0);

    END GetTotalBalance;

END AccountOperations;
/

--Test
SELECT AccountOperations.GetTotalBalance(1)
AS TotalBalance
FROM DUAL;

/* Output
Package ACCOUNTOPERATIONS compiled
Elapsed: 00:00:00.021
Package Body ACCOUNTOPERATIONS compiled
Elapsed: 00:00:00.013

+--------+--------------+
|        | TOTALBALANCE | 
+--------+--------------+
|   1    | -100         |   
+--------+--------------+
*/