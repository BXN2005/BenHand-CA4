package BusinessObjects;

import DAOs.IncomeDaoInterface;
import DAOs.MySqlIncomeDao;
import DAOs.MySqlUserDao;
import DAOs.UserDaoInterface;
import DTOs.Income;
import DTOs.User;
import Exceptions.DaoException;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        UserDaoInterface IUserDao = new MySqlUserDao();
        IncomeDaoInterface IIncomeDao = new MySqlIncomeDao();
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.println("\nCall findAllUsers()");
            List<User> users = IUserDao.findAllUsers();

            if (users.isEmpty())
                System.out.println("There are no expenses");
            else {
                for (User user : users)
                    System.out.println("Expense: " + user.toString());
            }


        } catch (DaoException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("\nEnter new expense details:");
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            Date dateIncurred = new Date();


            IUserDao.addExpense(title, category, amount, dateIncurred);

            System.out.println("Expense added successfully!");

            List<User> users = IUserDao.findAllUsers();

            if (users.isEmpty())
                System.out.println("There are no expenses");
            else {
                for (User user : users)
                    System.out.println("Expense: " + user.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }


        try {

            System.out.println("\nEnter Expense ID to delete: ");
            int expenseId = scanner.nextInt();
            scanner.nextLine();


            IUserDao.deleteExpenseById(expenseId);
            System.out.println("Expense deleted successfully!");

            List<User> users = IUserDao.findAllUsers();

            if (users.isEmpty())
                System.out.println("There are no expenses");
            else {
                for (User user : users)
                    System.out.println("Expense: " + user.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("\nCall findAllIncome()");
            List<Income> incomes = IIncomeDao.findAllIncome();

            if (incomes.isEmpty())
                System.out.println("There is no income");
            else {
                for (Income income : incomes)
                    System.out.println("Income: " + income.toString());
            }


        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("\nEnter new income details:");
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            Date dateIncurred = new Date();


            IIncomeDao.addIncome(title, amount, dateIncurred);

            System.out.println("Income added successfully!");

            List<Income> incomes = IIncomeDao.findAllIncome();

            if (incomes.isEmpty())
                System.out.println("There are is no incomes");
            else {
                for (Income income : incomes)
                    System.out.println("Income: " + income.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {

            System.out.println("\nEnter Income ID to delete: ");
            int incomeId = scanner.nextInt();
            scanner.nextLine();


            IIncomeDao.deleteIncomeById(incomeId);


            List<Income> incomes = IIncomeDao.findAllIncome();

            if (incomes.isEmpty())
                System.out.println("There are is no incomes");
            else {
                for (Income income : incomes)
                    System.out.println("Income: " + income.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }


        try {
            System.out.print("Enter year (YYYY): ");
            int year = scanner.nextInt();
            System.out.print("Enter month (MM): ");
            int month = scanner.nextInt();

            List<Income> incomes = IIncomeDao.findIncomeByMonth(year, month);
            List<User> expenses = IUserDao.findExpensesByMonth(year, month);

            double totalIncome = 0;
            for (Income income : incomes) {
                totalIncome += income.getAmount();
            }

            double totalExpense = 0;
            for (User expense : expenses) {
                totalExpense += expense.getAmount();
            }
            double remainingBalance = totalIncome - totalExpense;


            System.out.println("\nSummary for " + year + "-" + month);
            System.out.println("Total Income: " + totalIncome);
            System.out.println("Total Expenses: " + totalExpense);
            System.out.println("Remaining Balance: " + remainingBalance);

            System.out.println("\nIncome Details:");
            for (Income income : incomes) {
                System.out.println(income);
            }

            System.out.println("\nExpense Details:");
            for (User expense : expenses) {
                System.out.println(expense);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}







