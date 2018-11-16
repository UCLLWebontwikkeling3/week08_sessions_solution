package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            command = "";
        }
        String destination = "menu.jsp";
        session = request.getSession();
        switch (command) {
            case "setLanguage":
                destination = setLanguage(request, response);
                break;
            case "switchLanguage":
                destination = switchLanguage(request, response);
                break;
            default:
                destination = home(request, response);
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        String currentLanguage = getCurrentLanguage(request);
        if (currentLanguage.equals("en")) {
            request.setAttribute("taal", "ENGELS");
        } else {
            request.setAttribute("taal", "NEDERLANDS");
        }
        return "menu.jsp";
    }

    private String switchLanguage(HttpServletRequest request, HttpServletResponse response) {
        String currentLanguage = getCurrentLanguage(request);

        String newLanguage = switchLanguage(currentLanguage);
        Cookie cookie = new Cookie("language", newLanguage);
        response.addCookie(cookie);

        // store new language status
        session.setAttribute("language", newLanguage);
        //count number of language switches
        if (!currentLanguage.equals(newLanguage)) {
            if (session.getAttribute("numberOfSwitches") == null)
                session.setAttribute("numberOfSwitches", 1);
            else
                session.setAttribute("numberOfSwitches", (int) session.getAttribute("numberOfSwitches") + 1);
            session.setAttribute("previousLanguage",currentLanguage);

        }


        return getPage(newLanguage);
    }

    private String getCurrentLanguage(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("language"))
                    return cookie.getValue();
        return "nl";
    }

    private String setLanguage(HttpServletRequest request, HttpServletResponse response) {
        String selectedLanguage = request.getParameter("language");
        Cookie cookie = new Cookie("language", selectedLanguage);
        response.addCookie(cookie);
        return getPage(selectedLanguage);
    }

    private String getPage(String language) {
        if (language.equals("nl")) {
            return "welkom.jsp";
        } else {
            return "welcome.jsp";
        }
    }

    private String switchLanguage(String language) {
        String newLanguage = "nl";
        if (language.equals("nl")) {
            newLanguage = "en";
        }
        return newLanguage;
    }

}
