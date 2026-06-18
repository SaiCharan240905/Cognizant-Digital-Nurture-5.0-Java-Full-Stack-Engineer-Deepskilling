-- Scenario 1 Requirement: Apply a 1% discount to loan interest rates for customers above 60 years old.

DECLARE

    CURSOR customer_cursor IS
        SELECT c.CustomerID,
               c.Name,
               c.DOB,
               l.LoanID,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
            ON c.CustomerID = l.CustomerID;

    v_age NUMBER;

BEGIN

    FOR customer_record IN customer_cursor LOOP

        v_age :=
            FLOOR(
                MONTHS_BETWEEN(
                    SYSDATE,
                    customer_record.DOB
                ) / 12
            );

        IF v_age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_record.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied for Customer: '
                || customer_record.Name
            );

        ELSE

            DBMS_OUTPUT.PUT_LINE(
                'Customer '
                || customer_record.Name
                || ' is not eligible for discount.'
            );

        END IF;

    END LOOP;

END;
/

/* Ouput

Customer John Doe is not eligible for discount.


PL/SQL procedure successfully completed.

Elapsed: 00:00:00.012

*/