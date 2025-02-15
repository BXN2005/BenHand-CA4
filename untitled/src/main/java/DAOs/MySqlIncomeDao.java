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

        try {

            connection = this.getConnection();

            String query = "SELECT * FROM INCOME";
            preparedStatement = connection.prepareStatement(query);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int incomeId = resultSet.getInt("INCOME_ID");
                String title = resultSet.getString("TITLE");
                Double amount = resultSet.getDouble("AMOUNT");
                Date dateearned = resultSet.getDate("DATEEARNED");
                Income u = new Income(incomeId, title, amount, dateearned);
                incomesList.add(u);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllIncomeesultSet() " + e.getMessage());
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
}
