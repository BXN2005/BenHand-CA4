DROP DATABASE IF EXISTS `expense_income_database`;
CREATE DATABASE `expense_income_database`;
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense` (
                           `EXPENSE_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `TITLE` varchar(50) NOT NULL,
                           `CATEGORY` varchar(50) NOT NULL,
                           `AMOUNT` double(20,2) NOT NULL,
                           `DATEINCURED` DATE NOT NULL,
                           PRIMARY KEY (`EXPENSE_ID`)
);

INSERT INTO `expense` (`TITLE`, `CATEGORY`, `AMOUNT`, `DATEINCURED`)
VALUES
    ("Weekly Shop", "Groceries", 47.50, "2025-01-07"),  -- Original
    ("Electricity Bill", "Utilities", 120.75, "2025-01-10"),
    ("Dinner Out", "Dining", 35.40, "2025-01-12"),
    ("Gym Membership", "Health & Fitness", 50.00, "2025-01-15"),
    ("Movie Tickets", "Entertainment", 25.00, "2025-01-18"),
    ("Pet Food", "Pets", 30.99, "2025-01-20");

DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
                          `INCOME_ID` int(11) NOT NULL AUTO_INCREMENT,
                          `TITLE` varchar(50) NOT NULL,
                          `AMOUNT` double(20,2) NOT NULL,
                          `DATEEARNED` DATE NOT NULL,
                          PRIMARY KEY (`INCOME_ID`)
);

INSERT INTO `income` (`TITLE`, `AMOUNT`, `DATEEARNED`)
VALUES
    ("Babysitting", 60.00, "2025-01-05"),
    ("Birthday", 200.00, "2025-01-08"),
    ("Gift from Family", 100.00, "2025-01-11"),
    ("Stock Dividend", 75.25, "2025-01-14"),
    ("Gift", 150.00, "2025-01-17"),
    ("Bonus from Work", 500.00, "2025-01-22");