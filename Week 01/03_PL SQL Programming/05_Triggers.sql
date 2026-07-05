-- Setup: Create AuditLog table for Scenario 2
CREATE TABLE IF NOT EXISTS AuditLog (
                                        LogID INTEGER PRIMARY KEY AUTOINCREMENT,
                                        AccountID INTEGER,
                                        Amount REAL,
                                        TransactionType TEXT,
                                        LogTimestamp TEXT
);

-- Scenario 1: Automatically update LastModified date on Customer record changes
CREATE TRIGGER IF NOT EXISTS UpdateCustomerLastModified
AFTER UPDATE ON Customers
BEGIN
UPDATE Customers
SET LastModified = datetime('now')
WHERE CustomerID = NEW.CustomerID;
END;

-- Scenario 2: Maintain an audit log for all new transactions
CREATE TRIGGER IF NOT EXISTS LogTransaction
AFTER INSERT ON Transactions
BEGIN
INSERT INTO AuditLog (AccountID, Amount, TransactionType, LogTimestamp)
VALUES (NEW.AccountID, NEW.Amount, NEW.TransactionType, datetime('now'));
END;

-- Scenario 3: Enforce business rules (Prevent bad deposits/withdrawals using RAISE)
CREATE TRIGGER IF NOT EXISTS CheckTransactionRules
BEFORE INSERT ON Transactions
BEGIN
    -- Rule A: Prevent negative or zero deposits
SELECT CASE
           WHEN NEW.TransactionType = 'Deposit' AND NEW.Amount <= 0
               THEN RAISE(ABORT, 'Business Rule Violation: Deposit amount must be positive.')
           END;

-- Rule B: Prevent overdraft withdrawals
SELECT CASE
           WHEN NEW.TransactionType = 'Withdrawal' AND NEW.Amount > (SELECT Balance FROM Accounts WHERE AccountID = NEW.AccountID)
               THEN RAISE(ABORT, 'Business Rule Violation: Insufficient balance for withdrawal.')
           END;
END;
