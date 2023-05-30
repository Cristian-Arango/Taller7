package co.edu.sena.java_avanzado.model.repository;


import co.edu.sena.java_avanzado.model.Category;
import co.edu.sena.java_avanzado.model.User;
import co.edu.sena.java_avanzado.test_connection.ConnectionPool;
import jakarta.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryRepositoryImpl implements Repository<Category> {
    private String sql=null;


    @Override
    public List<Category> listAllObj() throws SQLException {
        sql = "select c.category_id, c,category_name " +
                "from category_tbl c order by c.category_name";

        List<Category> categories = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){
                Category c = createObj(rs);
                categories.add(c);
            }//while
        }//try

        return categories;
    }//listAllObj


    @Override
    public Category byIdObj(Integer id) throws SQLException {
        sql = "select c.category_id, c.category_name" +
                "from category_tbl c where c.category_id = ?";
        Category category = null;

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    category=createObj(rs);
                }
            }

        }//try

        return category;
    }//byIdObj


    @Override
    public Integer saveObj(Category category) throws SQLException {
        int rowsAffected = 0;

        if (category.getCategory_id() != null && category.getCategory_id() > 0) {
            sql = "update category_tbl set category_name= ?" +
                    " where category_id = ?";
        }else{
            sql = "insert into category_tbl (category_name) "+
            " values (upper(?))";
            ;
        }

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategory_name());

            if (category.getCategory_id() != null && category.getCategory_id() > 0){
                ps.setInt(5, category.getCategory_id());
            }
            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }//saveObj

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from category_tbl where category_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }//try
    }//deleteObj


    @Override
    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_id(rs.getInt("category_id"));
        category.setCategory_name(rs.getString("category_name"));



        return category;
    }
}
