package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.LoginService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Controller
@RequestMapping
public class LoginController {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Autowired
    private LoginService auth;

    @PostMapping("/login")
    public void login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/login.html");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Sorry, you are not authorized to enter this page!");
        }
    }

    @GetMapping
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        Optional<String> usernameOptional = auth.getUsername(req);
        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Hi " + usernameOptional.get() +
                        "</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Hi " + usernameOptional.get() + " you have logged in successfully!</h1>");
                out.println("<p><a href='" + req.getContextPath() +
                        "/main.html'>Return</a></p>");
                out.println("<p><a href='" + req.getContextPath() +
                        "/logout'>Sign off</a></p>");
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }
    }
}
