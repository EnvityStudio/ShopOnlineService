/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DataBaseAccess {

    private static DataBaseAccess dataBaseAccess;
    private static Connection con;
    private static final String user = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/bookshop";
    public static DataBaseAccess newInstance() {
        if (dataBaseAccess == null) {
            dataBaseAccess = new DataBaseAccess();
        }
        if (con == null) {
            connectDB();
        }
        return dataBaseAccess;
    }

    public static void connectDB() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM  bookshop.product");
            while (result.next()) {
                int id = result.getInt("idproduct");
                String name = result.getString("name");
                int state = result.getInt("state");
                int special = result.getInt("special");
                String image1 = result.getString("image1");
                String image2 = result.getString("image2");
                String shortDescription = result.getString("shortdescription");
                String description = result.getString("description");
                int idCategory = result.getInt("idcategory");
                int idBrand = result.getInt("idbrand");
                int quantity = result.getInt("quantity");
                BigDecimal price = result.getBigDecimal("price");
                Product product = new Product(id,name,state,special,image1,image2,shortDescription,description,idCategory,idBrand,quantity,price);
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return list;
    }
}
