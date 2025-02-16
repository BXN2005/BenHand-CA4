package DAOs;

import DTOs.Income;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySqlIncomeDao extends MySqlDao implements IncomeDaoInterface {

    @Override
    public List<Income> findAllIncome() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Income> incomesList = new ArrayList<>();
        double totalAmount = 0;
        try {
            connection = this.getConnection();

            String query = "SELECT * FROM INCOME";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int incomeId = resultSet.getInt("INCOME_ID");
                String title = resultSet.getString("TITLE");
                Double amount = resultSet.getDouble("AMOUNT");
                Date dateEarned = resultSet.getDate("DATEEARNED");
                totalAmount += amount;
                Income income = new Income(incomeId, title, amount, dateEarned);
                incomesList.add(income);
            }
            System.out.println("Total Income Amount: " + totalAmount);
        } catch (SQLException e) {
            throw new DaoException("findAllIncome() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllIncome() " + e.getMessage());
            }
        }
        return incomesList;
    }

    @Override
    public void addIncome(String title, Double amount, Date dateEarned) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();


            String query = "INSERT INTO INCOME (TITLE, AMOUNT, DATEEARNED) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, title);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setDate(3, new java.sql.Date(dateEarned.getTime()));


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Income added successfully!");
            } else {
                System.out.println("Failed to add income.");
            }
        } catch (SQLException e) {
            throw new DaoException("addIncome() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("addIncome() " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteIncomeById(int incomeId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();
            String query = "DELETE FROM INCOME WHERE INCOME_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, incomeId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Income with ID " + incomeId + " deleted successfully!");
            } else {
                System.out.println("No income found with ID " + incomeId);
            }
        } catch (SQLException e) {
            throw new DaoException("deleteIncomeById() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("deleteIncomeById() " + e.getMessage());
            }
        }
    }
}
