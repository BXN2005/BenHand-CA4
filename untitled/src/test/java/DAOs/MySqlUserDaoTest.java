package DAOs;

import DTOs.User;
import Exceptions.DaoException;

import static org.junit.jupiter.api.Assertions.*;

class MySqlUserDaoTest {
    UserDaoInterface IUserDao=null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        IUserDao = new MySqlUserDao();  // create the DAO class
    }


}
