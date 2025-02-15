package DAOs;
import DTOs.User;
import Exceptions.DaoException;
import java.util.List;

public interface UserDaoInterface
{
    public List<User> findAllUsers() throws DaoException;


}
