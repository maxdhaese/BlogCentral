package be.intecbrussel.servlet.post;

import be.intecbrussel.data.mappers.CommentMapper;
import be.intecbrussel.exceptions.AuthorNotLoggedInException;
import be.intecbrussel.tools.SessionController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "sendcommentoncomment", value = "/sendcommentoncomment")
public class SendCommentOnComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        CommentMapper cm = new CommentMapper();

        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());

        if (!SessionController.isLoggedIn(session))
            resp.sendRedirect("login");
        else {

            String commentToAdd = req.getParameter("usercomment");

            if (!commentToAdd.trim().isEmpty()) {
                Integer commentID = Integer.valueOf(req.getParameter("id"));
                String authorName;
                try {
                    authorName = SessionController.getAuthor(session).getUsername();
                    cm.addCommentToComment(commentID, authorName, commentToAdd);
                } catch (AuthorNotLoggedInException e) {
                    //shoudlnt happen
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
            resp.sendRedirect(SessionController.getLastPage(session));
        }
    }
}
