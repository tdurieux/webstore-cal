package books;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity used to control the persistence of data
 * @author Julien Duribreux, Dufour Justin
 */
@Entity(name = "BooksEntity")
@NamedQuery(name="getAllBooks",query="select OBJECT(b) from BooksEntity b")
public class BooksEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Primary key of the booksEntity
     */
    @Id
    private String title ;
    
    /**
     * The author's name
     */
    private String author ;
    /**
     * The publishing date of the book
     */
    private String pushingDate ;

    /**
     * Default constructor, not used
     */
    public BooksEntity() {
    }

    /**
     * Constructor
     * @param title the book title
     * @param author the author of the book
     * @param date  the publishing date
     */
    public BooksEntity(String title, String author, String date) {
        this.title = title ;
        this.author = author ;
        this.pushingDate = date ;
    }
    
    /**
     * Get the primary key 
     * @return the id / title of a book
     */
    public String getId() {
        return title;
    }

    /**
     * Set the primary key
     * @param id the key
     */
    public void setId(String id) {
        this.title = id;
    }

    /**
     * Get the author of a book
     * @return the author's name
     */
    public String getAuthor() {
        return this.author ;
    }
    
    /**
     * Set the author of a book
     * @param author author's name 
     */
    public void setAuthor(String author) {
        this.author = author ;
    }
    
    /**
     * Get the date of publishing
     * @return the date
     */
    public String getDate() {
        return this.pushingDate ;
    }
    
    /**
     * Set the publishing date
     * @param date of publishing
     */
    public void setdate(String date) {
        this.pushingDate = date ;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BooksEntity)) {
            return false;
        }
        BooksEntity other = (BooksEntity) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "books.BooksEntity[ id=" + title + " ]";
    }
    
}
