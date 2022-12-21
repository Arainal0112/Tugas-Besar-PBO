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
 * @author mobil
 */
public class Mobil {
    private int idMobil;
    private String merk;
    private String tipe;
    private String tahun;
    private String noPol;
    private int hargaSewa;
    private String status;

    public Mobil() {
    }

    public Mobil(int idMobil, String merk, String tipe, String tahun, String noPol, int hargaSewa, String status) {
        this.idMobil = idMobil;
        this.merk = merk;
        this.tipe = tipe;
        this.tahun = tahun;
        this.noPol = noPol;
        this.hargaSewa = hargaSewa;
        this.status = status;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getNoPol() {
        return noPol;
    }

    public void setNoPol(String noPol) {
        this.noPol = noPol;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return noPol;
    }
    
    
    public static Mobil getById(int id) {
        Mobil mobil = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mobil " + "WHERE idMobil = " + id + "");

        try {
            while (rs.next()) {
                mobil = new Mobil();
                mobil.setIdMobil(rs.getInt("idMobil"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setTipe(rs.getString("tipe"));
                mobil.setTahun(rs.getString("tahun"));
                mobil.setNoPol(rs.getString("noPol"));
                mobil.setHargaSewa(rs.getInt("hargaSewa"));
                mobil.setStatus(rs.getString("status"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobil;
    }
    public static Mobil getByNoPol(String noPol) {
        Mobil mobil = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mobil " + "WHERE noPol =" + noPol + "");

        try {
            while (rs.next()) {
                mobil = new Mobil();
                mobil.setIdMobil(rs.getInt("idMobil"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setTipe(rs.getString("tipe"));
                mobil.setTahun(rs.getString("tahun"));
                mobil.setNoPol(rs.getString("noPol"));
                mobil.setHargaSewa(rs.getInt("hargaSewa"));
                mobil.setStatus(rs.getString("status"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobil;
    }

    public static ArrayList<Mobil> getAll() {
        ArrayList<Mobil> listMobil = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mobil");

        try {
            while (rs.next()) {
                Mobil mobil = new Mobil();
                mobil.setIdMobil(rs.getInt("idMobil"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setTipe(rs.getString("tipe"));
                mobil.setTahun(rs.getString("tahun"));
                mobil.setNoPol(rs.getString("noPol"));
                mobil.setHargaSewa(rs.getInt("hargaSewa"));
                mobil.setStatus(rs.getString("status"));

                listMobil.add(mobil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMobil;
    }

    public static ArrayList<Mobil> search(String keyword) {
        ArrayList<Mobil> listMobil = new ArrayList<>();
        String query = "SELECT * FROM mobil WHERE merk LIKE '%"+keyword+"%'"
                        + " OR tipe LIKE '%"+keyword+"%'"
                        + " OR noPol LIKE '%"+keyword+"%'"
                        + " OR status LIKE '%"+keyword+"%'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                Mobil mobil = new Mobil();
                mobil.setIdMobil(rs.getInt("idMobil"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setTipe(rs.getString("tipe"));
                mobil.setTahun(rs.getString("tahun"));
                mobil.setNoPol(rs.getString("noPol"));
                mobil.setHargaSewa(rs.getInt("hargaSewa"));
                mobil.setStatus(rs.getString("status"));

                listMobil.add(mobil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMobil;
    }

    public void save() {
        if (this.idMobil == 0) {
            String query = "INSERT INTO mobil (merk, tipe, tahun, noPol, hargaSewa, status) VALUES ("
                    + " '" + this.merk + "', "
                    + " '" + this.tipe + "', "
                    + " '" + this.tahun + "', "
                    + " '" + this.noPol + "', "
                    + " '" + this.hargaSewa + "', "
                    + " '" + this.status + "') ";
            this.idMobil = DBHelper.insertQueryGetId(query);
        } else {
            String query = "UPDATE  mobil SET "
                    + " merk = '" + this.merk + "', "
                    + " tipe = '" + this.tipe + "', "
                    + " tahun = '" + this.tahun + "' "
                    + " noPol = '" + this.noPol + "', "
                    + " hargaSewa = '" + this.hargaSewa + "', "
                    + " status = '" + this.status + "', "
                    + " WHERE idMobil = '" + this.idMobil + "'";

            DBHelper.executeQuery(query);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM mobil WHERE idMobil = '" + this.idMobil + "'";
        DBHelper.executeQuery(SQL);
    }
    
}
