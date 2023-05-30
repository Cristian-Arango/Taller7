package co.edu.sena.java_avanzado.servlets;

import co.edu.sena.java_avanzado.model.User;
import co.edu.sena.java_avanzado.model.Category;
import co.edu.sena.java_avanzado.model.repository.CategoryRepositoryImpl;
import co.edu.sena.java_avanzado.model.repository.Repository;
import co.edu.sena.java_avanzado.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerCategory")
public class CategoryRegisterServlet extends HttpServlet {

    //Metodo doGet - dopost
    //EL metodo do post es seguro y es mejor practica

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //collect all form data
        String category_name=request.getParameter("category_name");


        // fill it up a User bean
        //Crear el objeto
        Category category=new Category(category_name);

        // call Repository layer and save the user object to DB
        Repository<Category> repository=new CategoryRepositoryImpl();
        int ros=0;
        try {
            ros= repository.saveObj(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // prepare an information message for user about success or failure of the operation
        String infoMessage=null;
        if(ros==0){
            System.out.println("Fallure the procediment");

        }else{
            System.out.println("register successful");

        }

        // todo write the message back to the page in client browser
    }
}



