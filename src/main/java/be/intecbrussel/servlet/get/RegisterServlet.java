package be.intecbrussel.servlet.get;

import be.intecbrussel.tools.SessionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // Adds the current page to the page history
        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());

        // Check if user is already logged in, if yes, use alert box and send them back to their last visited page
        if (SessionController.isLoggedIn(session)) {
            resp.sendRedirect("AlreadyLoggedIn");
        }

        // Load the register page
        else {
            req.getRequestDispatcher("resources/1-Front-End/signup/register.jsp").forward(req, resp);
        }
    }


}
