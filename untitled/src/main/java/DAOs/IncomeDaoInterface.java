package DAOs;

import DTOs.Income;
import Exceptions.DaoException;

import java.util.Date;
import java.util.List;

public interface IncomeDaoInterface {

    public List<Income> findAllIncome() throws DaoException;

    void addIncome(String title, Double amount, Date dateEarned) throws DaoException;

    void deleteIncomeById(int incomeId) throws DaoException;
}
