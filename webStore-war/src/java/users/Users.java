package users ;

import books.BooksEntity;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Used to interact with BooksEntity
 * @author Julien Duribreux, Dufour Justin
 */
@Stateless
@LocalBean
public class Users implements UsersItf{
    /**
     * Handle the persistence of books
     */
    @PersistenceContext
    private EntityManager UsersEntity ;
    
    /**
     * Add a new user in the database
     * @param pseudo the user's name
     * @param password the user's password
     * @param permission permission level to this user
     */
    public void addUser(String pseudo, String password, String permission) {
        UsersEntity.persist(new UsersEntity(pseudo, password, permission));
    }
    
    /**
     * Check if user already exits
     * @param pseudo the user's name
     * @param password the user's password
     * @return true if exits, false if not
     */
    public boolean userExists(String pseudo,String password) {
        Query query = UsersEntity.createQuery("select OBJECT(u) from UsersEntity u where u.pseudo='"+pseudo+"' and u.password = '"+password+"'");
        try {
            UsersEntity res = (UsersEntity) query.getSingleResult();
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }
    
    /**
     * Check if an user is an admin
     * @param pseudo the user's pseudo
     * @return true if he is, false if not
     */
    public boolean isAdmin(String pseudo) {
        Query query = UsersEntity.createQuery("select OBJECT(u) from UsersEntity u where u.pseudo='"+pseudo+"'");
        try {
            UsersEntity res = (UsersEntity) query.getSingleResult();
            if (res.getPermissionLevel().equals("1")) {
                return true ;
            } else {
                return false ;
            }
        } catch (Exception e) {
            return false ;
        }
    }
}
