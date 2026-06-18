-- Scenario 3 Requirement : Insert customer. Handle duplicate CustomerID..

CREATE OR REPLACE PROCEDURE AddNewCustomer
(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
)
AS
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

    DBMS_OUTPUT.PUT_LINE(
        'Customer added successfully.'
    );

EXCEPTION

    WHEN DUP_VAL_ON_INDEX THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Error: Customer ID already exists.'
        );

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Insert Failed: '
            || SQLERRM
        );
END;
/

--Test
BEGIN
    AddNewCustomer(
        3,
        'David Wilson',
        TO_DATE(
            '1995-01-10',
            'YYYY-MM-DD'
        ),
        2000
    );
END;
/ 

/* Output
Customer added successfully.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.010
*/

-- Test Duplicate
BEGIN
    AddNewCustomer(
        1,
        'Duplicate Customer',
        SYSDATE,
        1000
    );
END;
/

/* Output
Error: Customer ID already exists.
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.007
*/