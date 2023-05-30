package co.edu.sena.java_avanzado.servlets;

import co.edu.sena.java_avanzado.model.User;
import co.edu.sena.java_avanzado.model.repository.Repository;
import co.edu.sena.java_avanzado.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerUser")

public class UserRegisterServlet extends HttpServlet {

    //Metodo doGet - dopost
    //EL metodo do post es seguro y es mejor practica

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //collect all form data
        String user_firstname=request.getParameter("user_firstname");
        String user_lastname=request.getParameter("user_lastname");
        String user_email=request.getParameter("user_email");
        String user_password=request.getParameter("user_password");


        // fill it up a User bean
        //Crear el objeto
        User user=new User(user_firstname,user_lastname,user_email,user_password);

        // call Repository layer and save the user object to DB
        Repository <User> repository=new UserRepositoryImpl();
        int rows=0;
        try {
           rows= repository.saveObj(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // prepare an information message for user about success or failure of the operation
            String infoMessage=null;
            if(rows==0){
                System.out.println("Fallure the procediment");

            }else{
                System.out.println("register successful");

            }

        // todo write the message back to the page in client browser
    }
}
