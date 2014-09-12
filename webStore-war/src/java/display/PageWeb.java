package display;

/**
 * Create the a web page template
 * @author Julien Duribreux, Dufour Justin
 */
public class PageWeb {
    /**
     * Content to display inside the template page
     */
    private String content ;
    /**
     * Top of HTML page code
     */
    private String top = ""
            + "<!DOCTYPE html> \n" +
            "<html>\n" +
            "    <head> \n" +
            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "        <link rel=\"stylesheet\" href=\"gumby/css/gumby.css\" />\n" +
            "        <link rel=\"stylesheet\" href=\"gumby/css/style.css\" />\n" +
            "        <script type=\"text/javascript\" src=\"gumby/js/libs/modernizr-2.6.2.min.js\"></script>\n" +
            "        <script type=\"text/javascript\" src=\"js/booksPackage.js\"></script>\n" +
            "        <title>WebStore J2EE</title>\n" +
            "     </head>\n" +
            "     <body>\n" +
            "        <div id=\"container\" class=\"container\">\n" +
            "           <div id=\"header\" class=\"row\">\n" +
            "                <h6 class=\"centered sixteen colums\">WebStore J2EE</h6>\n" +
            "            </div>\n" +
            "            <hr/>\n" +
            "            <p class=\"row center_text\"><i class=\"icon-home\"></i><a href=\"index.jsp\">Home</a><i class=\"icon-tag\"></i><a href=\"addBookForm.jsp\">Add a new Book</a> - <i class=\"icon-basket\"></i><a href=\"listBooks.jsp\">Buy Books</a> - <i class=\"icon-attach\"></i><a href=\"basket.jsp\">Basket</a> - <i class=\"icon-alert\"></i><a href=\"commands.jsp\">Commands</a> - <i class=\"icon-floppy\"></i><a href=\"register.jsp\">Register</a> / <a href=\"login.jsp\">Login</a></p><hr/>" ;
    
    /**
     * Bottom of HTML page code
     */
    private String bottom = "" +
            "            <hr/>\n" +
            "            <div id=\"footer\" class=\"row\">\n" +
            "                <p class=\"centered four columns\">Par Julien Duribreux et Justin Dufour</p>\n" +
            "            </div>\n" +
            "\n" +
            "        </div>  \n" +
            "        <script type=\"text/javascript\" src=\"gumby/js/libs/jquery-1.8.3.min.js\"></script>\n" +
            "        <script type=\"text/javascript\" src=\"gumby/js/libs/gumby.min.js\"></script>\n" +
            "        <script type=\"text/javascript\" src=\"gumby/js/plugins.js\"></script>\n" +
            "    </body>\n" +
            "</html>" ;
    
    /**
     * Constructor
     * @param content the content to display
     */
    public PageWeb(String content) {
        this.content = content ;
    }
    
    /**
     * Build the HTML code of a fully valid HTML page
     * @return HTML Code
     */
    public String toString() {
        return this.top + this.content + this.bottom ;
    }
}
