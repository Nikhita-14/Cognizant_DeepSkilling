-- Scenario 1: Safe Transfer Funds between two accounts
-- Rule: Only transfer if the source account has sufficient funds, otherwise leave unchanged.
BEGIN TRANSACTION;

-- Attempt transfer from Account 1 to Account 2 (Amount: $500)
UPDATE Accounts
SET Balance = Balance - CASE WHEN (SELECT Balance FROM Accounts WHERE AccountID = 1) >= 500 THEN 500 ELSE 0 END
WHERE AccountID = 1;

UPDATE Accounts
SET Balance = Balance + CASE WHEN (SELECT Changes() > 0) THEN 500 ELSE 0 END
WHERE AccountID = 2;

COMMIT;


-- Scenario 2: Manage errors when updating employee salaries
-- Rule: Ensure the employee exists before attempting an update (Simulating an existence guard)
UPDATE Employees
SET Salary = Salary * 1.10
WHERE EmployeeID = 999; -- Using a non-existent ID to demonstrate safe execution with 0 rows affected

-- Verify execution status (If this returns 0, it logs that the ID did not exist)
SELECT CASE WHEN changes() = 0 THEN 'Error: Employee ID does not exist.' ELSE 'Salary updated successfully.' END AS ExecutionLog;


-- Scenario 3: Ensure data integrity when adding a new customer
-- Rule: Prevent inserting if the CustomerID already exists (Using INSERT OR IGNORE)
INSERT OR IGNORE INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'Duplicate John', '1985-05-15', 5000, DATE('now'));

-- Check if the unique constraint prevented insertion
SELECT CASE WHEN changes() = 0 THEN 'Error: Customer ID already exists. Insertion prevented.' ELSE 'Customer added successfully.' END AS IntegrityLog;
