DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Employees;

-- 2. Create the clean SQLite Tables
CREATE TABLE Customers (
                           CustomerID INTEGER PRIMARY KEY,
                           Name TEXT,
                           DOB TEXT,
                           Balance REAL,
                           IsVIP TEXT DEFAULT 'FALSE',
                           LastModified TEXT
);

CREATE TABLE Accounts (
                          AccountID INTEGER PRIMARY KEY,
                          CustomerID INTEGER,
                          AccountType TEXT,
                          Balance REAL,
                          LastModified TEXT,
                          FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
                              TransactionID INTEGER PRIMARY KEY,
                              AccountID INTEGER,
                              TransactionDate TEXT,
                              Amount REAL,
                              TransactionType TEXT,
                              FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
                       LoanID INTEGER PRIMARY KEY,
                       CustomerID INTEGER,
                       LoanAmount REAL,
                       InterestRate REAL,
                       StartDate TEXT,
                       EndDate TEXT,
                       FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
                           EmployeeID INTEGER PRIMARY KEY,
                           Name TEXT,
                           Position TEXT,
                           Salary REAL,
                           Department TEXT,
                           HireDate TEXT
);

-- 3. Populate Sample Data
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', '1955-05-15', 12000, DATE('now'));

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', '1990-07-20', 1500, DATE('now'));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, DATE('now'), DATE('now', '+60 months'));
