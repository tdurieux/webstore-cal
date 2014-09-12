package books;

import java.util.List;
import javax.ejb.Remote;

/**
 * All method used in Books
 * @author Julien Duribreux, Dufour Justin
 */
@Remote
public interface BooksItf {
    /**
     * Constructor used to add a new entry in the database
     * @param title the book title
     * @param author the author of the book
     * @param date  the publishing date
     */
    public void addBook(String title,String author,String date);
    
    /**
     * Used to return a bookEntity entry
     * @param name the book you searching for
     * @return the book if found
     */    
    public BooksEntity getBook(String name);
        
    /**
     * Check if a book already exists in the database
     * @param title the book title
     * @param author the author of the book
     * @param date  the publishing date
     * @return true if exists, false if not
     */
    public boolean bookExists(String name, String author, String date) ;
    
    /**
     * Delete a book from the database
     * @param name the book to delete
     */
    public void deleteBook(String name);
    
    /**
     * Give all the books
     * @return a list of BooksEntity
     */
    public List<BooksEntity> listBooks();
}