package commands;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity used to control the persistence of data
 * @author Julien Duribreux, Dufour Justin
 */
@Entity(name = "CommandsEntity")
@NamedQuery(name="getAllCommands",query="select OBJECT(c) from CommandsEntity c")
public class CommandsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Primary key, auto indent mode
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /**
     * List of books
     */
    private String[] command;

    private String username ;
    
    /**
     * Default constructor, not used
     */
    public CommandsEntity() {
    }

    /**
     * Create a new entry in the database
     * @param books array of books names
     */
    public CommandsEntity(String[] books, String username) {
        this.command = books;
        this.username = username ;
    }

    /**
     * Get the primary key 
     * @return the id a command
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the primary key
     * @param id the key
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the name of the command taker
     * @return the name
     */
    public String getUsername() {
        return this.username ;
    }
    
    /**
     * Get the detail of a command
     * @return an array of names
     */
    public String[] getCommand() {
        return this.command ;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandsEntity)) {
            return false;
        }
        CommandsEntity other = (CommandsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commands.CommandsEntity[ id=" + id + " ]";
    }
    
}
