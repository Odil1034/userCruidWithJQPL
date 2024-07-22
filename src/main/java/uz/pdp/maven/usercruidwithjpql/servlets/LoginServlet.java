package uz.pdp.maven.usercruidwithjpql.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.maven.usercruidwithjpql.entity.user.User;
import uz.pdp.maven.usercruidwithjpql.service.userService.UserService;
import uz.pdp.maven.usercruidwithjpql.service.userService.UserServiceImp;

import java.io.IOException;

@WebServlet (name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserService userService = UserServiceImp.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        userService.login(username, email, password);

        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        session.setAttribute("email", email);
        session.setAttribute("password", password);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Profile.jsp");
        requestDispatcher.forward(req, resp);
    }
}
