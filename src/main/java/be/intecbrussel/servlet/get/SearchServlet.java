package be.intecbrussel.servlet.get;

import be.intecbrussel.data.mappers.AuthorMapper;
import be.intecbrussel.data.mappers.BlogMapper;
import be.intecbrussel.data.mappers.CommentMapper;
import be.intecbrussel.model.entities.Author;
import be.intecbrussel.model.entities.Blog;
import be.intecbrussel.model.entities.Comment;
import be.intecbrussel.tools.SessionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());
        String tags = req.getParameter("query");
        System.out.println(tags);

        AuthorMapper am = new AuthorMapper();
        BlogMapper bm = new BlogMapper();
        CommentMapper cm = new CommentMapper();

        List<Author> authorList = am.getAuthorsByTags(tags);
        List<Blog> blogList = bm.getBlogsByTags(tags);
        List<Comment> commentList = cm.getCommentsFromTags(tags);

        req.setAttribute("authorlist", authorList);
        req.setAttribute("bloglist", blogList);
        req.setAttribute("commentlist", commentList);

        System.out.println("Authorscount -> " + authorList.size());
        System.out.println("Blogscount -> " + blogList.size());
        System.out.println("commentscount -> " + commentList.size());

        req.getRequestDispatcher("resources/1-Front-End/search/search.jsp").forward(req, resp);
    }
}
