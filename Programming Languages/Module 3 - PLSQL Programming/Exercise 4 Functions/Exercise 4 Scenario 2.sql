-- Scenario 2 Requirement : Compute monthly installment amount.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment
(
    p_loan_amount   NUMBER,
    p_interest_rate NUMBER,
    p_years         NUMBER
)
RETURN NUMBER
AS

    v_total_amount NUMBER;
    v_monthly_installment NUMBER;

BEGIN

    v_total_amount :=
        p_loan_amount +
        (
            p_loan_amount
            * p_interest_rate
            * p_years
            / 100
        );

    v_monthly_installment :=
        v_total_amount /
        (p_years * 12);

    RETURN ROUND(
        v_monthly_installment,
        2
    );

END;
/

-- Test 
SELECT CalculateMonthlyInstallment(
           5000,
           5,
           5
       ) AS Monthly_Installment
FROM DUAL;

/* Output
MONTHLY_INSTALLMENT
---
104.17
---
Function CALCULATEMONTHLYINSTALLMENT compiled
Elapsed: 00:00:00.023
*/