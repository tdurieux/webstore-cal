
package display;

import books.BooksEntity;
import java.util.List;

/**
 * Used to generate HTML code to display Books
 * @author Julien Duribreux, Dufour Justin
 */
public class ListBooks {

    /**
     * List of BooksEntity to display
     */
    List<BooksEntity> booksList ;
    
    /**
     * Constructor
     * @param list of BooksEntity  
     */
    public ListBooks(List<BooksEntity> list) {
        this.booksList = list ;
    }
    
    /**
     * Display a table of BooksEntity
     * @return HTML code
     */
    public String toString() {
        String output = "" ;
        if (this.booksList.size() > 0) {
            output += "<table id=\"tbl_list_books\"><tr><th>Title</th><th>Author</th><th>Date</th></tr>" ;
            for(BooksEntity b : this.booksList) {
                output += "<tr><td>" + b.getId() + "</td><td>" + b.getAuthor() + "</td><td>" + b.getDate() + "</td></tr>" ;
            }
            output += "</table>" ;
        } else {
            output += "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"primary alert\">There is no book !</li></div></div>" ;
        }
        return output ;
    }
}
