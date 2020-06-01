package be.intecbrussel.servlet.post;

import be.intecbrussel.data.GenericMapper;
import be.intecbrussel.exceptions.AuthorNotFoundException;
import be.intecbrussel.exceptions.PasswordInvalidException;
import be.intecbrussel.model.entities.Author;
import be.intecbrussel.tools.SessionController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginpost")
public class LoginPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        // Make a author mapper using the generic mapper
        GenericMapper<Author> authorMapper = new GenericMapper<>();

        // Get the username and password from the login form
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            // Get the author with corresponding username from the database
            Author author = authorMapper.getObject(new Author(), username);

            // If the password is incorrect, exception \o/
            if (!author.checkPW(password))
                throw new PasswordInvalidException();

            // Log the user in
            SessionController.logsIn(session, author);
            // Send the user back to the last visited page
            resp.sendRedirect(SessionController.getLastPage(session));
        }

        // If the username was incorrect, or the password didn't match, we would end up arriving here
        catch (AuthorNotFoundException | PasswordInvalidException e) {
            // Sets the invalid credential flag on true
            SessionController.setInvalidCredentialsFlag(session);
            // Send the user back to the login page
            resp.sendRedirect("login");
        }

    }
}
