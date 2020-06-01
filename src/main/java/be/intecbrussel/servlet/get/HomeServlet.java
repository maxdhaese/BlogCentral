package be.intecbrussel.servlet.get;

import be.intecbrussel.data.GenericMapper;
import be.intecbrussel.exceptions.AuthorNotFoundException;
import be.intecbrussel.model.entities.Blog;
import be.intecbrussel.tools.SessionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the user's session
        HttpSession session = req.getSession();
        SessionController.addNewPageToSessionHistory(session, this.getServletName(), req.getQueryString());

        // Create an instance of the genericmapper user as the class
        GenericMapper<Blog> dao = new GenericMapper<>();


        // Create list of cards to be read from database
        List<Blog> blogsDynamic = new ArrayList<>();

        // Read first 6 blogs from blogcentral database
        for (int i = 0; i < 6; i++) {

            try {
                Blog blogRead = dao.getObject(new Blog(), i);
                blogsDynamic.add(blogRead);
            }

            catch (AuthorNotFoundException e) {
                e.printStackTrace();
            }
        }

//        req.setAttribute("bloglist",blogList);
        req.setAttribute("blogsDynamic", blogsDynamic);

        // Load the home page
        req.getRequestDispatcher("resources/1-Front-End/home/index.jsp").forward(req, resp);

    }
}
