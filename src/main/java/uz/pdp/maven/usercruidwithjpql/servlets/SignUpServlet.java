package uz.pdp.maven.usercruidwithjpql.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.maven.usercruidwithjpql.entity.user.User;
import uz.pdp.maven.usercruidwithjpql.service.userService.UserService;
import uz.pdp.maven.usercruidwithjpql.service.userService.UserServiceImp;

import java.io.IOException;

@WebServlet (name = "signUpServlet", urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {

    UserService userService = UserServiceImp.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("SignUp.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User build = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .username(username)
                .password(password)
                .email(email)
                .build();

        userService.signUp(build);

        resp.sendRedirect("/");
    }
}
