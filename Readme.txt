WebStore J2EE
Duribreux Julien, Dufour Justin
23/04/2013

Notes :
Pleinement fonctionnel sur Firefox 20.0 / Distrib : Mint
Glassfish 3.0.1, théoriquement compatible 3.1.2

###########
Différences
############

V1.0 - None
	
############
Introduction
############

Ce logiciel permet de gérer et passer commandes sur un site web et est développé en J2EE.
Il s'agit là d'une maquette, toutes les pages sont accessibles et ne nécessitent pas d'authentification (pas demandé dans l'énoncé)
Par conséquent, tout le monde peut créer et supprimer les différents livres disponibles.
A chaque redeployement, la base est nettoyée. A modifier dans persistence.xml si nécessaire.

############
Architecture
############

Web Pages
-- WEB-INF
-- gumby
-- includes
-- js

Packages
-- books
-- -- Books
-- -- BooksEntity
-- -- BooksItf
-- commands
-- -- Commands
-- -- CommandsEntity
-- -- CommandsItf
-- display
-- -- ListBooks
-- -- ListBooks2Buy
-- -- PageWeb
-- servlets
-- -- AddBooks2BasketServlet
-- -- AddBooksServlet
-- -- ListBooksServlet

- Concernant Web Pages :
Ce répertoire contient les principaux includes necessaires au bon fonctionnement de la passerelle REST.
Gumby/ : Le framework CSS Gumby a été utilisé, afin d'obtenir un visuel agréable
includes/ : Contient deux includes jsp utilisés uniquement pour la page index.jsp afin de pouvoir modifier le design facilement si nécessaire sur toutes les pages jsp
js/ : Contient quelques lignes de JS afin de cacher / afficher la liste dans la page de création d'un livre

- Concernant books, commands :
Ces deux packages ont la meme structures, d'une part l'interface (*Itf) qui est implémentée par la classe associée du même nom (*) et qui ont pour objectif de controler les différentes opérations effectuées sur l'entité associée (*Entity)

- Concernant display
Controle l'ensemble des affichages utilisés pour la génération des différentes pages HTML.

- Concernant servlets
Servlet contacté pour déclancher certaines operations d'ajouts / suppression sur les entités précédemment citées. 

############
Code samples
############

- Extrait de code utilisé pour récupérer les livres disponibles dans l'application, ce code est présent dans une JSP.
Du code java ainsi que du code HTML y cohabitent. L'affichage est géré via un appel de méthode qui est prévu pour la mise en forme.

<%
    // Initialization used to list all books
    BooksItf books;
    Context context = new InitialContext();
    books = (BooksItf) context.lookup(BooksItf.class.getName());
    int nbBooks = books.listBooks().size() ;
    if (nbBooks > 0) {
        %><div class="row"><%
        out.println(new ListBooks2Buy(books.listBooks()).toString()) ;
        %></div><%
    } else {
        %><div class="row center_text"><div class="centered four columns"><i class="icon-info-circled"></i>There is no book !</div></div><%
    }
    %></div><%
%>

- Methode permettant la génération du tableau qui est inséré au sein de la page jsp précédente :

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

- Extrait de Books.java, cette methode permet de tester l'existance d'un livre dans un entité via une requête similaire à du SQL facilement compréhensible.

    public boolean bookExists(String name, String author, String date) {
        Query query = BooksEntity.createQuery("select OBJECT(b) from BooksEntity b where b.title='"+name+"' and b.author = '"+author+"' and b.pushingDate='"+date+"'");
        try {
            BooksEntity res = (BooksEntity) query.getSingleResult();
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }

- Extrait du servlet ListBooksServlet qui permet d'afficher les livres présents dans la base de données s'il y en a :
Très simple puis qu'il s'agit principalement d'un simple appel de méthode et de son affichage

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            List<BooksEntity> list = books.listBooks() ;
            String list2String = new ListBooks(list).toString() ;
            out.println(new PageWeb(list2String).toString());
        } finally {            
            out.close();
        }
    }
