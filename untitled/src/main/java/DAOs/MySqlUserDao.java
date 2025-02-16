package DAOs;

import DTOs.User;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySqlUserDao extends MySqlDao implements UserDaoInterface {
    @Override
    public List<User> findAllUsers() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> usersList = new ArrayList<>();
        double totalAmount = 0.0;

        try {
            connection = this.getConnection();

            String query = "SELECT * FROM EXPENSE";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int expenseId = resultSet.getInt("EXPENSE_ID");
                String title = resultSet.getString("TITLE");
                String category = resultSet.getString("CATEGORY");
                Double amount = resultSet.getDouble("AMOUNT");
                Date dateIncurred = resultSet.getDate("DATEINCURED");
                totalAmount += amount;

                User u = new User(expenseId, title, category, amount, dateIncurred);
                usersList.add(u);
            }

            System.out.println("Total Expense Amount: " + totalAmount);
        } catch (SQLException e) {
            throw new DaoException("findAllUsers() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return usersList;
    }

    @Override
    public void addExpense(String title, String category, Double amount, Date dateIncurred) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();


            String query = "INSERT INTO EXPENSE (TITLE, CATEGORY, AMOUNT, DATEINCURED) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, title);
            preparedStatement.setString(2, category);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setDate(4, new java.sql.Date(dateIncurred.getTime()));


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Expense added successfully!");
            } else {
                System.out.println("Failed to add expense.");
            }
        } catch (SQLException e) {
            throw new DaoException("addExpense() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();

                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("addExpense() " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteExpenseById(int expenseId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();
            String query = "DELETE FROM EXPENSE WHERE EXPENSE_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, expenseId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Expense with ID " + expenseId + " deleted successfully!");
            } else {
                System.out.println("No expense found with ID " + expenseId);
            }
        } catch (SQLException e) {
            throw new DaoException("deleteExpenseById() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("deleteExpenseById() " + e.getMessage());
            }
        }
    }
}
