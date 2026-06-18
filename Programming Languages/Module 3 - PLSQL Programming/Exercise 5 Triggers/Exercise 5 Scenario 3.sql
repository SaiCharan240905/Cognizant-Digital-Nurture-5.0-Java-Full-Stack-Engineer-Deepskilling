-- Scenario 3 Requirement : Before inserting a transaction ensure withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table.

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT
ON Transactions
FOR EACH ROW

DECLARE

    v_balance NUMBER;

BEGIN

    IF :NEW.TransactionType = 'Deposit' THEN

        IF :NEW.Amount <= 0 THEN

            RAISE_APPLICATION_ERROR(
                -20010,
                'Deposit amount must be positive.'
            );

        END IF;

    ELSIF :NEW.TransactionType = 'Withdrawal' THEN

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN

            RAISE_APPLICATION_ERROR(
                -20011,
                'Withdrawal exceeds available balance.'
            );

        END IF;

    END IF;

END;
/

-- Test 1: Valid Deposit
INSERT INTO Transactions
VALUES
(
    4,
    1,
    SYSDATE,
    100,
    'Deposit'
);

/* Output
Trigger CHECKTRANSACTIONRULES compiled
Elapsed: 00:00:00.032
1 row inserted.
Elapsed: 00:00:00.014

*/

-- Test 2: Invalid Deposit
INSERT INTO Transactions
VALUES
(
    5,
    1,
    SYSDATE,
    -100,
    'Deposit'
);

/* Output
ORA-20010: Deposit amount must be positive.
*/

-- Test 3: Invalid Withdrawal
INSERT INTO Transactions
VALUES
(
    6,
    1,
    SYSDATE,
    100000,
    'Withdrawal'
);

/* Output
ORA-20011: Withdrawal exceeds available balance.
*/