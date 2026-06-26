-- Scenario 1: Calculate the age of a customer (using CustomerID = 1)
SELECT Name,
       (strftime('%Y', 'now') - strftime('%Y', DOB)) - (strftime('%m-%d', 'now') < strftime('%m-%d', DOB)) AS CalculatedAge
FROM Customers
WHERE CustomerID = 1;

-- Scenario 2: Compute monthly loan installment (Formula: [P * r * (1+r)^n] / [(1+r)^n - 1])
-- Example: $5000 loan, 5% annual interest (0.05/12 monthly), 5-year duration (60 months)
SELECT LoanID, LoanAmount, InterestRate,
       (LoanAmount * (InterestRate / 100 / 12) * power(1 + (InterestRate / 100 / 12), 60)) /
       (power(1 + (InterestRate / 100 / 12), 60) - 1) AS MonthlyInstallment
FROM Loans;

-- Scenario 3: Check if an account has sufficient balance for a transaction ($500 check on Account 1)
SELECT AccountID, Balance,
       CASE WHEN Balance >= 500 THEN 'TRUE' ELSE 'FALSE' END AS HasSufficientBalance
FROM Accounts
WHERE AccountID = 1;
