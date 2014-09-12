package commands;

import books.BooksEntity;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Used to interact with CommandsEntity
 * @author Julien Duribreux, Dufour Justin
 */
@Stateless
@LocalBean
public class Commands implements CommandsItf{
    
    @PersistenceContext
    private EntityManager CommandsEntity ;
    
    public Commands() {
    }

    @Override
    public void addCommand(String[] books, String username) {
        CommandsEntity.persist(new CommandsEntity(books, username));
    }
        
    @Override
    public List<CommandsEntity> listCommands() {
        Query query = CommandsEntity.createNamedQuery("getAllCommands");
        return (List<CommandsEntity>) query.getResultList();
    }
    
}
