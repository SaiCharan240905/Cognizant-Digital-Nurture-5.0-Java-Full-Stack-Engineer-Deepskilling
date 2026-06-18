-- Scenario 1 Requirement : Calculate customer age from Date of Birth.

CREATE OR REPLACE FUNCTION CalculateAge
(
    p_dob DATE
)
RETURN NUMBER
AS

    v_age NUMBER;

BEGIN

    v_age :=
        FLOOR(
            MONTHS_BETWEEN(
                SYSDATE,
                p_dob
            ) / 12
        );

    RETURN v_age;

END;
/

-- Test 
SELECT CalculateAge(
           TO_DATE(
               '1985-05-15',
               'YYYY-MM-DD'
           )
       ) AS Age
FROM DUAL;

/* Output
AGE
---
41
---
Function CALCULATEAGE compiled
Elapsed: 00:00:00.023
*/