package be.intecbrussel.servlet.get;

import be.intecbrussel.data.GenericMapper;
import be.intecbrussel.data.mappers.AuthorMapper;
import be.intecbrussel.data.mappers.BlogMapper;
import be.intecbrussel.exceptions.AuthorNotFoundException;
import be.intecbrussel.model.entities.Author;
import be.intecbrussel.model.entities.Blog;
import be.intecbrussel.tools.SessionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "author", value = "/author")
public class AuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());
        BlogMapper bm = new BlogMapper();
        GenericMapper<Author> am = new AuthorMapper();

        String username = req.getParameter("username");
        try {
            Author authorFromPage = am.getObject(new Author(), username);
            List<Blog> list = bm.getAllBlogsFromAuthor(authorFromPage);
            req.setAttribute("blogs", list);
            req.getRequestDispatcher("resources/1-Front-End/author/author.jsp").forward(req, resp);
        } catch (AuthorNotFoundException e) {
            resp.sendRedirect("home");
        }
    }
}
