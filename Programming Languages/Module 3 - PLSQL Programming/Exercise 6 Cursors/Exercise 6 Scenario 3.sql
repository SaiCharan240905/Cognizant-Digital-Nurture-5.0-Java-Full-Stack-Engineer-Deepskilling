-- Scenario 3 Requirement : Update interest rates based on new policy.

DECLARE

    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID,
               InterestRate
        FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;

BEGIN

    OPEN UpdateLoanInterestRates;

    LOOP

        FETCH UpdateLoanInterestRates
        INTO v_loan_id,
             v_interest_rate;

        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = v_loan_id;

        DBMS_OUTPUT.PUT_LINE(
            'Interest rate updated for Loan ID '
            || v_loan_id
        );

    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

END;
/

/* Output
Interest rate updated for Loan ID 1
PL/SQL procedure successfully completed.
Elapsed: 00:00:00.017
*/

-- Verify
SELECT *
FROM Loans;

/* Output
+--------+------------+------------+--------------+--------------+----------------------+
| LOANID | CUSTOMERID | LOANAMOUNT | INTERESTRATE | STARTDATE    | ENDDATE              |
+--------+------------+------------+--------------+--------------+----------------------+
|   1    |     1      |    5000    |     5.5      | 17-JUN-2026  | 17-JUN-2031          |
+--------+------------+------------+--------------+--------------+----------------------+
*/