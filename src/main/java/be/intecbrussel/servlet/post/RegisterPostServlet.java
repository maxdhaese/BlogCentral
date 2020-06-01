package be.intecbrussel.servlet.post;

import be.intecbrussel.data.GenericMapper;
import be.intecbrussel.model.entities.Author;
import be.intecbrussel.tools.BCrypter;
import be.intecbrussel.tools.SessionController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/registerpost")
public class RegisterPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        // Get all parameters from the register form
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String userName = req.getParameter("user-name");
        String email = req.getParameter("email");
        String street = req.getParameter("street");
        String houseNr = req.getParameter("house-number");
        String city = req.getParameter("city");
        String zipcode = req.getParameter("zip");
        // Instead of storing the password in plain text, we hash it with a powerful algorithm
        String password = BCrypter.hashPassword(req.getParameter("password"));

        // Create an new Author using a constructor with all the required fields
        Author author = new Author(userName, password, firstName, lastName, email);
        // Check every non required element and add them to the author if it's not an empty String
        // (prevents NumberFormatException for houseNr and Zipcode due to parsing a empty String if not checked
        if (!street.equals(""))
            author.setStreet(street);

        if (!houseNr.equals(""))
            author.setHouseNumber(Integer.parseInt(houseNr));

        if (!city.equals(""))
            author.setCity(city);

        if (!zipcode.equals(""))
            author.setZipCode(Integer.parseInt(zipcode));

        // Create an instance of the genericmapper user as the class
        GenericMapper<Author> dao = new GenericMapper<>();
        // Add the user to the database using the genericmapper object
        author = dao.addObject(author);

        SessionController.updateTotalRegisters(session);

        // Logs in the user
        SessionController.logsIn(session, author);
        // Sends the user back to his last visited page
        resp.sendRedirect(SessionController.getLastPage(session));
    }
}
