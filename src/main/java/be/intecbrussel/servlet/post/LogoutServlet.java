package be.intecbrussel.servlet.post;


import be.intecbrussel.tools.SessionController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logout", value="/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // only use to test logout

        HttpSession session = req.getSession();
        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());

        req.getSession().setAttribute("isLoggedIn", false);
        resp.sendRedirect(SessionController.getLastPage(session));
    }
}
