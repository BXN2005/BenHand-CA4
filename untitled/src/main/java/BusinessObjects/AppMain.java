package BusinessObjects;

import DAOs.MySqlUserDao;
import DAOs.UserDaoInterface;
import DTOs.User;
import Exceptions.DaoException;
import java.util.List;

public class AppMain
{
    public static void main(String[] args)
    {
        UserDaoInterface IUserDao = new MySqlUserDao();


        try
        {
            System.out.println("\nCall findAllUsers()");
            List<User> users = IUserDao.findAllUsers();

            if( users.isEmpty() )
                System.out.println("There are no Users");
            else {
                for (User user : users)
                    System.out.println("User: " + user.toString());
            }



        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}