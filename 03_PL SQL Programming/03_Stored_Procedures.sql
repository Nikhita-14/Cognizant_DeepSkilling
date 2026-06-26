-- Scenario 1: Process monthly interest of 1% for all Savings accounts
UPDATE Accounts
SET Balance = Balance * 1.01
WHERE AccountType = 'Savings';

-- Scenario 2: Update employee bonus (e.g., 5% bonus for the 'IT' department)
UPDATE Employees
SET Salary = Salary * (1 + 0.05)
WHERE Department = 'IT';

-- Scenario 3: Transfer funds ($200) from Account 1 to Account 2 with balance check
BEGIN TRANSACTION;
UPDATE Accounts
SET Balance = Balance - 200
WHERE AccountID = 1 AND Balance >= 200;

UPDATE Accounts
SET Balance = Balance + 200
WHERE AccountID = 2 AND (SELECT changes() FROM Accounts) > 0;
COMMIT;
