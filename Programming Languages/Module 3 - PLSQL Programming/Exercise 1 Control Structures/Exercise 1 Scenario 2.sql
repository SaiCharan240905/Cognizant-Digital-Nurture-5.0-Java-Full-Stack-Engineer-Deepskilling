-- Scenario 2 Requirement : Set IsVIP = TRUE when balance > 10000.

DECLARE

BEGIN

    FOR customer_record IN
    (
        SELECT CustomerID,
               Name,
               Balance
        FROM Customers
    )
    LOOP

        IF customer_record.Balance > 10000 THEN

            DBMS_OUTPUT.PUT_LINE(
                'Customer '
                || customer_record.Name
                || ' qualifies for VIP status.'
            );

        ELSE

            DBMS_OUTPUT.PUT_LINE(
                'Customer '
                || customer_record.Name
                || ' does not qualify for VIP status.'
            );

        END IF;

    END LOOP;

END;
/

/* Ouput 

Customer John Doe does not qualify for VIP status.
Customer Jane Smith does not qualify for VIP status.


PL/SQL procedure successfully completed.

Elapsed: 00:00:00.006

*/