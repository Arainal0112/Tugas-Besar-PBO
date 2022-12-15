/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class User {
    private int idUser;
    private String nama;
    private String email;
    private String username;
    private String password;

    public User() {
    }

    public User(int idUser, String nama, String email, String username, String password) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static User getById(int id) {
        User user = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user " + "WHERE idUser = " + id + "");

        try {
            while (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<User> getAll() {
        ArrayList<User> listUser = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user");

        try {
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public static ArrayList<User> search(String keyword) {
        ArrayList<User> listUser = new ArrayList<>();
        String query = "SELECT * FROM user WHERE nama LIKE '%"+keyword+"%'"
                        + " OR email LIKE '%"+keyword+"%'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public void save() {
        if (this.idUser == 0) {
            String query = "INSERT INTO user (nama, email, username, password) VALUES ("
                    + " '" + this.nama + "', "
                    + " '" + this.email + "', "
                    + " '" + this.username + "', "
                    + " '" + this.password + "') ";
            this.idUser = DBHelper.insertQueryGetId(query);
        } else {
            String query = "UPDATE  user SET "
                    + " nama = '" + this.nama + "', "
                    + " email = '" + this.email + "', "
                    + " username = '" + this.username + "' "
                    + " password = '" + this.password + "', "
                    + " WHERE idUser = '" + this.idUser + "'";

            DBHelper.executeQuery(query);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM user WHERE idUser = '" + this.idUser + "'";
        DBHelper.executeQuery(SQL);
    }
    
    
}
