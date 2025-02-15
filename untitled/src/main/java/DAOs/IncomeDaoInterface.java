package DAOs;
import DTOs.Income;
import Exceptions.DaoException;
import java.util.List;

public interface IncomeDaoInterface
{

    public List<Income> findAllIncome() throws DaoException;


}
