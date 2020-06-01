package be.intecbrussel.servlet.post;

import be.intecbrussel.data.GenericMapper;
import be.intecbrussel.data.mappers.CommentMapper;
import be.intecbrussel.model.entities.Comment;
import be.intecbrussel.tools.SessionController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "deletecomment", value = "/deletecomment")
public class DeleteCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());
        GenericMapper<Comment> cm = new CommentMapper();

        Integer commentID = Integer.valueOf(req.getParameter("commentID"));
        cm.removeObject(new Comment(), commentID);
        resp.sendRedirect(SessionController.getLastPage(session));

    }
}
