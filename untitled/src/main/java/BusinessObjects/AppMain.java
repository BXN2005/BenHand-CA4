package BusinessObjects;

import DAOs.IncomeDaoInterface;
import DAOs.MySqlIncomeDao;
import DAOs.MySqlUserDao;
import DAOs.UserDaoInterface;
import DTOs.Income;
import DTOs.User;
import Exceptions.DaoException;
import java.util.List;

public class AppMain
{
    public static void main(String[] args)
    {
        UserDaoInterface IUserDao = new MySqlUserDao();
        IncomeDaoInterface IIncomeDao = new MySqlIncomeDao();

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
        try
        {
            System.out.println("\nCall findAllIncome()");
            List<Income> incomes = IIncomeDao.findAllIncome();

            if( incomes.isEmpty() )
                System.out.println("There are no Users");
            else {
                for (Income income : incomes)
                    System.out.println("User: " + income.toString());
            }



        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}