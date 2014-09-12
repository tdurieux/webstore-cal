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
    private String fname;
    private String email;
    private String address;
    private String city;
    private String pcode;
    private String country;
    private String phone;

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
    UsersEntity(String pseudo, String password, String permission, String fname, String email, String address, String city, String pcode, String country, String phone) {
        this.pseudo = pseudo ;
        this.password = password ;
        this.permissionLevel = permission ;
        this.fname = fname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.pcode = pcode;
        this.country = country;
        this.phone = phone;
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
    
    /**
     * Get the user's full name
     * @return the fullname
     */
    public String getFullName() {
        return fname;
    }
    
    /**
     * Get the user's email
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Get the user's address
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Get the user's city
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Get the user's postal code
     * @return the postal code
     */
    public String getPostalCode() {
        return pcode;
    }
    
    /**
     * Get the user's country
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * Get the user's phone number
     * @return the phone number
     */
    public String getPhone() {
        return phone;
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
