package display;

import books.BooksEntity;
import java.util.List;

/**
 * Used to generate HTML code to display Books to buy
 * @author Julien Duribreux, Dufour Justin
 */
public class ListBooks2Buy {

    /**
     * List of BooksEntity to display
     */
    List<BooksEntity> booksList ;
    
    /**
     * Constructor
     * @param list list of BooksEntity
     */
    public ListBooks2Buy(List<BooksEntity> list) {
        this.booksList = list ;
    }

    /**
     * Display a table of BooksEntity
     * @return HTML code
     */
    public String toString() {
        String output = "<form action=\"AddBooks2BasketServlet\" method=\"GET\">" ;
        output += "<input type=\"hidden\" name=\"action\" value=\"buyBooks\" />" ;
        output += "<table id=\"tbl_list_books\"><tr><th>Title</th><th>Author</th><th>Date</th><th>Buy</th></tr>" ;
        for(BooksEntity b : this.booksList) {
            output += "<tr><td>" + b.getId() + "</td><td>" + b.getAuthor() + "</td><td>" + b.getDate() + "</td><td><input type=\"checkbox\" name=\"book\" value=\""+b.getId()+"\"></td></tr>" ;
        }
        output += "</table>" ;
        output +=   "<div style=\"margin-top:10px;\" class=\"row center_text\">\n" +
                    "        <div class=\"medium default btn pretty\"><input type=\"submit\" value=\"Add to basket\" /></div>\n" +
                    "    </div>" ;
        output += "</form>" ;
        return output ;
    }
}