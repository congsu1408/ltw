package murach.email;

import murach.business.User;
import murach.data.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns={"/emailList"}, initParams={@InitParam(name="relativePathToFile", value="/WEB-INF/EmailList.txt")})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";
        String path1 = this.getServletConfig().getInitParameter("relativePathToFile");
        String path = this.getServletContext().getRealPath(path1);
//        "/WEB-INF/EmailList.txt"
        UserDB userDB = new UserDB();
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } else if (action.equals("add")) {
            String emailMessage = "";
            String firstNameMessage = "";
            String lastNameMessage = "";

            String firstName = request.getParameter("firtsName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            if (email == null) {
                System.out.println("email is null");
            }
            else if(email.equals("")){
                System.out.println("email is not null");
            }
            String[] listTypeOfMusic;
            if (request.getParameterValues("typeOfMusic") != null) {
                listTypeOfMusic = request.getParameterValues("typeOfMusic");
            } else {
                listTypeOfMusic = new String[0];
            }

            boolean checkEmailExisted = userDB.emailExisted(email, path);

            if (email.isEmpty() || checkEmailExisted || firstName.isEmpty() || lastName.isEmpty()) {
                if (email.isEmpty()) {
                    emailMessage = "Please enter a email";
                } else if (checkEmailExisted) {
                    emailMessage = "Email is exist, please choose new email";
                }
                if (firstName.isEmpty()) {
                    firstNameMessage = "Please enter a first name";
                }
                if (lastName.isEmpty()) {
                    lastNameMessage = "Please enter a last name";
                }
                request.setAttribute("emailMessage", emailMessage);
                request.setAttribute("firtsNameMessage", firstNameMessage);
                request.setAttribute("lastNameMessage", lastNameMessage);
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("email", email);
                url = "/index.jsp";
            } else {
                User user = new User(firstName, lastName, email, listTypeOfMusic);
                userDB.insert(user, path);
                request.setAttribute("user", user);
                url = "/thanks.jsp";
            }

        }
        // forward request and response objects to specified URL
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}