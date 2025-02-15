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
                Date dateincured = resultSet.getDate("DATEINCURED");
                User u = new User(expenseId, title, category, amount, dateincured);
                usersList.add(u);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllUseresultSet() " + e.getMessage());
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
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return usersList;
    }
}