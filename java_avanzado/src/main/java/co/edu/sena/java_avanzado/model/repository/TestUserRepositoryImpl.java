package co.edu.sena.java_avanzado.model.repository;

import co.edu.sena.java_avanzado.model.User;

import java.sql.SQLException;

public class TestUserRepositoryImpl {


    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();

        System.out.println("=========== saveObJ INSERT =============");
        User userInsert = new User();
        userInsert.setUser_firstname("Brayan");
        userInsert.setUser_lastname("Giraldo");
        userInsert.setUser_email("brayangiraldo@gmail.com");
        userInsert.setUser_password("2012_q@");
        repository.saveObj(userInsert);

        userInsert.setUser_firstname("Jhonatan");
        userInsert.setUser_lastname("Fonseca");
        userInsert.setUser_email("jfonse20@gmail.com");
        userInsert.setUser_password("Jhona_82=@");
        repository.saveObj(userInsert);


        System.out.println("=========== listAllObj =============");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=========== byIdObj =============");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("=========== saveObJ =============");
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("Beatriz");
        userUpdate.setUser_lastname("Castro");
        userUpdate.setUser_email("bcastro2011@yahoo.com");
        userUpdate.setUser_password("Margaret23_");
        repository.saveObj(userInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=========== deleteObj =============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);

    }
}