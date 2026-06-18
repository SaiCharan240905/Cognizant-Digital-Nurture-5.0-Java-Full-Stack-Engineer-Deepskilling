-- Scenario 3 Requirement : Fetch all loans due within the next 30 days and print a reminder message for each customer.

DECLARE
    v_count NUMBER := 0;
BEGIN

    DBMS_OUTPUT.PUT_LINE('Starting Loan Reminder Check...');

    FOR loan_record IN
    (
        SELECT l.LoanID,
               c.Name,
               l.EndDate
        FROM Loans l
        JOIN Customers c
            ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE
                            AND SYSDATE + 30
    )
    LOOP

        v_count := v_count + 1;

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear '
            || loan_record.Name
            || ', your Loan ID '
            || loan_record.LoanID
            || ' is due on '
            || TO_CHAR(
                    loan_record.EndDate,
                    'DD-MON-YYYY'
               )
        );

    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE(
            'No loans are due within the next 30 days.'
        );
    END IF;

END;
/

/* Ouput 
Starting Loan Reminder Check...
No loans are due within the next 30 days.
*/