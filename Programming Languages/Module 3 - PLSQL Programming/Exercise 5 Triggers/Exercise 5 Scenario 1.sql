-- Scenario 1 Requirement : Whenever a customer record is updated, automatically update the LastModified column.

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE
ON Customers
FOR EACH ROW
BEGIN

    :NEW.LastModified := SYSDATE;

END;
/

-- Test -1
UPDATE Customers
SET Balance = Balance + 100
WHERE CustomerID = 1;

--Verifying
SELECT CustomerID,
       Name,
       Balance,
       LastModified
FROM Customers
WHERE CustomerID = 1;

/* Output
Trigger UPDATECUSTOMERLASTMODIFIED compiled
Elapsed: 00:00:00.030
1 row updated.
Elapsed: 00:00:00.005
    | CUSTOMERID  | NAME    | BALANCE    | LASTMODIFIED          |
-----------------------------------------------------------------
  1 |          1  | John Doe| 1100       | 6/17/2026, 4:45:50 PM |
-----------------------------------------------------------------
*/