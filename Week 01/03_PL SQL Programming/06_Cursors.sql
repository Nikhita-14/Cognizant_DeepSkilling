-- Scenario 1: Generate monthly statements for all customers
-- Logic: Retrieves all transactions for the current month and formats them as a clean statement view
SELECT
    c.Name AS CustomerName,
    t.AccountID,
    t.TransactionID,
    t.TransactionType,
    t.Amount,
    t.TransactionDate
FROM Transactions t
         JOIN Accounts a ON t.AccountID = a.AccountID
         JOIN Customers c ON a.CustomerID = c.CustomerID
WHERE strftime('%Y-%m', t.TransactionDate) = strftime('%Y-%m', 'now');

-- Scenario 2: Apply annual maintenance fee to all accounts
-- Logic: Deducts a fixed annual maintenance fee (e.g., $25) from every active account balance
UPDATE Accounts
SET Balance = Balance - 25.00;

-- Scenario 3: Update the interest rate for all loans based on a new policy
-- Logic: Applies a macro-adjustment policy (e.g., adding 0.5% to all active loans)
UPDATE Loans
SET InterestRate = InterestRate + 0.5;
