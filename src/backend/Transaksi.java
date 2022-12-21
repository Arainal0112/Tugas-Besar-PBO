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
public class Transaksi {
    private int idTransaksi;
    private Mobil mobil;
    private String tglPinjam;
    private String tglKembali;
    private int lamaPinjam;
    private int total;

    public Transaksi() {
    }

    public Transaksi(int idTransaksi, Mobil mobil, String tglPinjam, String tglKembali, int lamaPinjam, int total) {
        this.idTransaksi = idTransaksi;
        this.mobil = mobil;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.lamaPinjam = lamaPinjam;
        this.total = total;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public void setLamaPinjam(int lamaPinjam) {
        this.lamaPinjam = lamaPinjam;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
  
    
    public static Transaksi getById(int id) {
        Transaksi trans = null;
        ResultSet rs = DBHelper.selectQuery("SELECT transaksi.*, mobil.* FROM transaksi "
                                + " LEFT JOIN mobil ON transaksi.idMobil = mobil.idMobil"
                                + " WHERE idTransaksi = " + id);

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
                
                trans = new Transaksi();
                trans.setMobil(mobil);
                trans.setIdTransaksi(rs.getInt("idTransaksi"));
                trans.setTglPinjam(rs.getString("tglPeminjaman"));
                trans.setTglKembali(rs.getString("tglPengembalian"));
                trans.setLamaPinjam(rs.getInt("lamaPinjam"));
                trans.setTotal(rs.getInt("total"));

                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trans;
    }

    public static ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT transaksi.*,mobil.noPol FROM transaksi "
                                            + "LEFT JOIN mobil ON transaksi.idMobil = mobil.idMobil");

        try {
            while (rs.next()) {
                Mobil mobil = new Mobil();
                mobil.setIdMobil(rs.getInt("idMobil"));
//                mobil.setMerk(rs.getString("merk"));
//                mobil.setTipe(rs.getString("tipe"));
//                mobil.setTahun(rs.getString("tahun"));
                mobil.setNoPol(rs.getString("noPol"));
//                mobil.setHargaSewa(rs.getInt("hargaSewa"));
//                mobil.setStatus(rs.getString("status"));
                
                Transaksi trans = new Transaksi();
                trans.setIdTransaksi(rs.getInt("idTransaksi"));
                trans.setMobil(mobil);
                trans.setTglPinjam(rs.getString("tglPeminjaman"));
                trans.setTglKembali(rs.getString("tglPengembalian"));
                trans.setLamaPinjam(rs.getInt("lamaPinjam"));
                trans.setTotal(rs.getInt("total"));

                listTransaksi.add(trans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }

    public static ArrayList<Transaksi> search(String keyword) {
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();
        String query = "SELECT  mobil.*, transaksi.* FROM transaksi "
                        + "LEFT JOIN  mobil ON transaksi.idMobil = mobil.idMobil"
                        + " WHERE merk LIKE '%"+keyword+"%'"
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
                
                Transaksi trans = new Transaksi();
                trans.setIdTransaksi(rs.getInt("idTransaksi"));
                trans.setMobil(mobil);
                trans.setTglPinjam(rs.getString("tglPeminjaman"));
                trans.setTglKembali(rs.getString("tglPengembalian"));
                trans.setLamaPinjam(rs.getInt("lamaPinjam"));
                trans.setTotal(rs.getInt("total"));

                listTransaksi.add(trans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }

    public void save() {
        
        
        String query = "INSERT INTO transaksi (tglPeminjaman, tglPengembalian, lamaPinjam, total, idMobil) VALUES ("
                    + " " + this.tglPinjam + ", "
                    + " '" + this.tglKembali + "', "
                    + " '" + this.lamaPinjam + "', "
                    + " '" + this.mobil.getIdMobil() + "', "
                    + " '" + this.total + "') ";
            
            DBHelper.insertQueryGetId(query);
    }

    public void delete() {
        String SQL = "DELETE FROM transaksi WHERE idTransaksi = '" + this.idTransaksi + "'";
        DBHelper.executeQuery(SQL);
    }

    
}
