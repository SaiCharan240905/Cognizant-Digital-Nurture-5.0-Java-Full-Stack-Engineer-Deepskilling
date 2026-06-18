-- Scenario 3 Requirement : Check if a customer has sufficient balance before making a transaction.

CREATE OR REPLACE FUNCTION HasSufficientBalance
(
    p_account_id NUMBER,
    p_amount     NUMBER
)
RETURN VARCHAR2
AS

    v_balance NUMBER;

BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN

        RETURN 'TRUE';

    ELSE

        RETURN 'FALSE';

    END IF;

EXCEPTION

    WHEN NO_DATA_FOUND THEN

        RETURN 'FALSE';

END;
/

-- Test -1
SELECT HasSufficientBalance(
           1,
           500
       ) AS Balance_Check
FROM DUAL;

/* Output
Function HASSUFFICIENTBALANCE compiled
Elapsed: 00:00:00.005
BALANCE_CHECK 
------------- 
FALSE         
-------------
Elapsed: 00:00:00.002
1 rows selected. 
*/

-- Test -2
SELECT HasSufficientBalance(
           1,
           5000
       ) AS Balance_Check
FROM DUAL;

/* Output
Function HASSUFFICIENTBALANCE compiled
Elapsed: 00:00:00.005
BALANCE_CHECK 
------------- 
FALSE         
-------------
Elapsed: 00:00:00.002
1 rows selected. 
*/