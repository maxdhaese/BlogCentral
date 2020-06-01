package be.intecbrussel.listeners;

import be.intecbrussel.tools.SessionController;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// TODO testing this thing in one way or another
// TODO learn about session TTL
public class SessionListener implements HttpSessionListener {
    // A list containing all sessions online
    private static Integer onlineCount = 0;

    @Override
    // When a user is online (session online), add it to the list
    public void sessionCreated(HttpSessionEvent se) {
        onlineCount++;
        se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
        SessionController.addAVisitor(se.getSession());
    }

    @Override
    // When a user is offline (session offline/dead) remove it from the list
    public void sessionDestroyed(HttpSessionEvent se) {
        onlineCount--;
        se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
    }
}
