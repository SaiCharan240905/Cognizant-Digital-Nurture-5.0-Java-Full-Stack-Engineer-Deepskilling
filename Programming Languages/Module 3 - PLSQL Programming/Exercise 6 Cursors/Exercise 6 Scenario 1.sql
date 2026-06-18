-- Scenario 1 Requirement : Retrieve all transactions for the current month and print statements.

DECLARE

    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name,
               t.TransactionID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a
            ON c.CustomerID = a.CustomerID
        JOIN Transactions t
            ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) =
              EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) =
              EXTRACT(YEAR FROM SYSDATE);

    v_name Customers.Name%TYPE;
    v_transaction_id Transactions.TransactionID%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;

BEGIN

    OPEN GenerateMonthlyStatements;

    LOOP

        FETCH GenerateMonthlyStatements
        INTO v_name,
             v_transaction_id,
             v_transaction_date,
             v_amount,
             v_transaction_type;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_name ||
            ' | Transaction ID: ' || v_transaction_id ||
            ' | Amount: ' || v_amount ||
            ' | Type: ' || v_transaction_type
        );

    END LOOP;

    CLOSE GenerateMonthlyStatements;

END;
/

/* Output
Customer: John Doe | Transaction ID: 3 | Amount: 100 | Type: Deposit
Customer: John Doe | Transaction ID: 4 | Amount: 100 | Type: Deposit
Customer: John Doe | Transaction ID: 1 | Amount: 200 | Type: Deposit
Customer: Jane Smith | Transaction ID: 2 | Amount: 300 | Type: Withdrawal

PL/SQL procedure successfully completed.
Elapsed: 00:00:00.024
*/