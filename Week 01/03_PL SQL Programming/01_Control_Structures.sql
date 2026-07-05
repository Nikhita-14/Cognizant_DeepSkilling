-- Scenario 1: Apply a 1% discount to loan interest rates for customers over 60 years old
-- Logic: Calculates age based on the DOB text column and subtracts 1 from InterestRate
UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE CustomerID IN (
    SELECT CustomerID
    FROM Customers
    WHERE (strftime('%Y', 'now') - strftime('%Y', DOB)) > 60
);

-- Scenario 2: Promote customers to VIP status (IsVIP = 'TRUE') if balance is over $10,000
UPDATE Customers
SET IsVIP = 'TRUE'
WHERE Balance > 10000;

-- Scenario 3: Fetch all loans due in the next 30 days and generate a reminder string
-- Logic: Simulates the print statement by outputting a calculated text column
SELECT
    'Reminder: Customer ' || c.Name || ', your loan ID ' || l.LoanID ||
    ' is due within ' || CAST(julianday(l.EndDate) - julianday('now') AS INT) || ' days.' AS ReminderMessage
FROM Loans l
         JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE julianday(l.EndDate) - julianday('now') BETWEEN 0 AND 30;
