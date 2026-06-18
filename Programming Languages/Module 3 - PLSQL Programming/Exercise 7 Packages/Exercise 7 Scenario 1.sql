-- Scenario 1 Requirement : CustomerManagement Package

-- 1. Package Specification (declaration)
CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer
    (
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer
    (
        p_customer_id NUMBER,
        p_name VARCHAR2
    );

    FUNCTION GetCustomerBalance
    (
        p_customer_id NUMBER
    )
    RETURN NUMBER;

END CustomerManagement;
/
-- 2. Package Body (implementation)
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer
    (
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    )
    IS
    BEGIN

        INSERT INTO Customers
        (
            CustomerID,
            Name,
            DOB,
            Balance,
            LastModified
        )
        VALUES
        (
            p_customer_id,
            p_name,
            p_dob,
            p_balance,
            SYSDATE
        );

        COMMIT;

    END AddCustomer;

    PROCEDURE UpdateCustomer
    (
        p_customer_id NUMBER,
        p_name VARCHAR2
    )
    IS
    BEGIN

        UPDATE Customers
        SET Name = p_name
        WHERE CustomerID = p_customer_id;

        COMMIT;

    END UpdateCustomer;

    FUNCTION GetCustomerBalance
    (
        p_customer_id NUMBER
    )
    RETURN NUMBER
    IS

        v_balance NUMBER;

    BEGIN

        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;

        RETURN v_balance;

    END GetCustomerBalance;

END CustomerManagement;
/
--Test
BEGIN
    CustomerManagement.UpdateCustomer(
        1,
        'John Updated'
    );
END;
/
--Verify
SELECT CustomerManagement.GetCustomerBalance(1)
AS Balance
FROM DUAL;


/* Output
Package CUSTOMERMANAGEMENT compiled
Elapsed: 00:00:00.022
Package Body CUSTOMERMANAGEMENT compiled
Elapsed: 00:00:00.013

+--------+---------+
| LOANID | BALANCE | 
+--------+---------+
|   1    | 1100    |   
+--------+---------+
*/