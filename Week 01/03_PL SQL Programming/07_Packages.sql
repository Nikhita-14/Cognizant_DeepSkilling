-- ====================================================================
-- PACKAGE SIMULATION: CustomerManagement
-- ====================================================================

-- 1. Add a new customer
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Charlie Green', '1995-11-12', 500.00, DATE('now'));

-- 2. Update customer details
UPDATE Customers
SET Name = 'Charles Green', LastModified = DATE('now')
WHERE CustomerID = 3;

-- 3. Get customer balance
SELECT CustomerID, Name, Balance
FROM Customers
WHERE CustomerID = 3;


-- ====================================================================
-- PACKAGE SIMULATION: EmployeeManagement
-- ====================================================================

-- 1. Hire a new employee
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (3, 'David White', 'Analyst', 55000.00, 'Finance', DATE('now'));

-- 2. Update employee details
UPDATE Employees
SET Position = 'Senior Analyst', Salary = 62000.00
WHERE EmployeeID = 3;

-- 3. Calculate annual salary
SELECT EmployeeID, Name, Salary AS MonthlySalary, (Salary * 12) AS AnnualSalary
FROM Employees
WHERE EmployeeID = 3;


-- ====================================================================
-- PACKAGE SIMULATION: AccountOperations
-- ====================================================================

-- 1. Open a new account
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Checking', 500.00, DATE('now'));

-- 2. Get total balance of a customer across all their accounts (e.g., CustomerID = 3)
SELECT CustomerID, SUM(Balance) AS TotalCombinedBalance
FROM Accounts
WHERE CustomerID = 3
GROUP BY CustomerID;

-- 3. Close an account (removes it from active accounts)
DELETE FROM Accounts
WHERE AccountID = 3;
