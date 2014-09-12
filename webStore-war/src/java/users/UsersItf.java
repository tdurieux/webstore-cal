package users ;

import java.util.List;
import javax.ejb.Remote;

/**
 * All method used in Books
 * @author Julien Duribreux, Dufour Justin
 */
@Remote
public interface UsersItf {
    public void addUser(String pseudo, String password, String permission);
    public boolean userExists(String pseudo,String password);
    public boolean isAdmin(String pseudo);
}