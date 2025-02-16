package DAOs;
import DTOs.User;
import Exceptions.DaoException;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlUserDaoTest {
    UserDaoInterface IUserDao=null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        IUserDao = new MySqlUserDao();
    }
    @Test
    void testFindAllUsers() throws DaoException {
        List<User> users = IUserDao.findAllUsers();
        assertNotNull(users, "User list should not be null");
    }
}
