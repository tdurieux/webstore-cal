package users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity used to control the persistence of data
 * @author Julien Duribreux, Justin Dufour
 */
@Entity
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo ;
    private String password ;
    private String permissionLevel ;

    /**
     * Constructor, not used
     */
    public UsersEntity() {
    }

    /**
     * Constructor
     * @param pseudo user name
     * @param password password user
     * @param permission permission level, admin or user
     */
    UsersEntity(String pseudo, String password, String permission) {
        this.pseudo = pseudo ;
        this.password = password ;
        this.permissionLevel = permission ;
    }
    
    /**
     * Get the user's permission level
     * @return permission level
     */
    public String getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * Get the user's pseudo
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
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
        if (!(object instanceof UsersEntity)) {
            return false;
        }
        UsersEntity other = (UsersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user.UsersEntity[ id=" + id + " ]";
    }
    
}
