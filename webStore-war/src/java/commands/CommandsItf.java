package commands;

import java.util.List;
import javax.ejb.Remote;

/**
 * All method used in Books
 * @author Julien Duribreux, Dufour Justin
 */
@Remote
public interface CommandsItf {
    /**
     * Constructor used to add a new entry in the database
     * @param books all the names of books (primary keys)
     */
    public void addCommand(String[] books, String username);
    
    /**
     * Give all the commands
     * @return a list of CommandsEntity
     */
    public List<CommandsEntity> listCommands();
}