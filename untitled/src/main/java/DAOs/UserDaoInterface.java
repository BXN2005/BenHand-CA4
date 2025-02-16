package DAOs;


import DTOs.User;
import Exceptions.DaoException;

import java.util.Date;
import java.util.List;

public interface UserDaoInterface {
    public List<User> findAllUsers() throws DaoException;

    void addExpense(String title, String category, Double amount, Date dateIncurred) throws DaoException;

    void deleteExpenseById(int expenseId) throws DaoException;

    public List<User> findExpensesByMonth(int year, int month) throws DaoException;
}
