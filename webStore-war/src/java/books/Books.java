package books;

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
public class Books implements BooksItf{
    
    /**
     * Handle the persistence of books
     */
    @PersistenceContext
    private EntityManager BooksEntity ;

    /**
     * Default constructor, not used
     */
    public Books() {
    }

    public void addBook(String title, String author, String date) {
        BooksEntity.persist(new BooksEntity(title, author, date));
    }
    
    public BooksEntity getBook(String name) {
        try {
            Query query = BooksEntity.createQuery("select OBJECT(b) from BooksEntity b where b.title='"+name+"'");
            return (BooksEntity) query.getSingleResult();
        } catch (Exception e) {
            return null ;
        }   
    }

    public boolean bookExists(String name, String author, String date) {
        Query query = BooksEntity.createQuery("select OBJECT(b) from BooksEntity b where b.title='"+name+"' or b.author = '"+author+"' or b.pushingDate='"+date+"'");
        try {
            BooksEntity res = (BooksEntity) query.getSingleResult();
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }
    

    public void deleteBook(String name) {
        Query query = BooksEntity.createQuery("delete from BooksEntity b where b.title='"+name+"'");
        query.getSingleResult();
        return ;
    }

    public List<BooksEntity> listBooks() {
        Query query = BooksEntity.createNamedQuery("getAllBooks");
        return (List<BooksEntity>) query.getResultList();
    }
    
}
