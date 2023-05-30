package co.edu.sena.java_avanzado.model;

public class Category {

 private Integer category_id;
    private String category_name;

    public Category() {
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public Category(Integer category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;

    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String Category_name) {
        this.category_name = category_name;
    }



    @Override
    public String toString() {
        return "category{" +
                "category_id=" + category_id +
                ", user_password='" + category_name + '\'' +
                '}';
    }
}
