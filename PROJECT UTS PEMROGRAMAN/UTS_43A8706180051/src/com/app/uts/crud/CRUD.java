
package com.app.uts.crud;

import com.app.uts.koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Zulhaidar Irvansyah
 */
public class CRUD {
    
    static Connection koneksi = new Koneksi().konekToDB();
    static Statement stmt;
    static ResultSet rs;
    
    int Tahun;
    String Judul, Pengarang, Penerbit, IdBuku;
    
    
    Scanner inputConsole = new Scanner(System.in);
    Scanner inputINT = new Scanner(System.in);
    
    //Menu
    public void showMenu(){
         
        System.out.println("\n************* M E N U *************");
        System.out.println("1. Input data ");
        System.out.println("2. Tampilkan Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Hapus Data");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Masukkan Pilihan Anda : ");
        
        try {
            int pilihan = Integer.parseInt(inputConsole.next());
            
            switch(pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insert();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    System.out.println("Pilihan Anda Salah!");
            }                    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insert(){
        System.out.println("Masukan data yang akan di input");
        
        System.out.print("ID Buku = ");
        IdBuku = inputConsole.next();
        
        System.out.print("Judul = ");
        Judul = inputConsole.next();
        
        System.out.print("Pengarang = ");
        Pengarang = inputConsole.next();
        
        System.out.print("Penerbit = ");
        Penerbit = inputConsole.next();
        
        System.out.print("Tahun = ");
        Tahun = Integer.parseInt(inputINT.next());
        
        
        try {
            String sql = "INSERT INTO buku VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, IdBuku);
            ps.setString(2, Judul);
            ps.setString(3, Pengarang);
            ps.setString(4, Penerbit);
            ps.setInt(5, Tahun);
            ps.executeUpdate();
            System.out.println("Data berhasil disimpan");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        showMenu();
        }
    
    public void showData(){
        String sql = "SELECT * FROM buku";
        try {
            stmt = koneksi.createStatement();
            rs = stmt.executeQuery(sql);
            
            System.out.println("+================================+");
            System.out.println("| UPDATE BUKU                    |");
            System.out.println("+================================+");
            
            while(rs.next()){
                IdBuku = rs.getString("IdBuku");
                Judul = rs.getString("Judul");
                Pengarang = rs.getString("Pengarang");
                Penerbit = rs.getString("Penerbit");
                Tahun = rs.getInt("Tahun");
                                
                System.out.println(String.format("%s. %s - %s - %s - %d ", IdBuku, Judul, Pengarang, Penerbit, Tahun));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        showMenu();
    }
    
    public void update(){
        System.out.print("ID Buku = ");
        IdBuku = inputConsole.next();
        
        System.out.print("Judul  = ");
        Judul = inputConsole.next();
        
        System.out.print("Pengarang = ");
        Pengarang = inputConsole.next();
        
        System.out.print("Penerbit = ");
        Penerbit = inputConsole.next();
        
        System.out.print("Tahun = ");
        Tahun = Integer.parseInt(inputINT.next());
        
        try {
            String sql = "UPDATE buku SET Judul=?, Pengarang=?, Penerbit=?, Tahun=? WHERE IdBUku=?";
            
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, Judul);
            ps.setString(2, Pengarang);
            ps.setString(3, Penerbit);
            ps.setInt(4, Tahun);
            ps.setString(5, IdBuku);
            
            ps.executeUpdate();
            
            System.out.println("Data berhasil diubah!");
                        
        } catch (Exception e) {
            e.getMessage();
        }
        
        showMenu();        
    }
    
    public void delete(){
                
        System.out.println("\nMasukan data yang akan dihapus");
        System.out.print("ID Anggota = ");
        IdBuku = inputConsole.next();
        
        try {
            String sql = "DELETE FROM buku WHERE IdBuku=?";
            
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, IdBuku);
            ps.executeUpdate();
            
            System.out.println("Data berhasil di delete");
        } catch (Exception e) {
            e.getMessage();
        }
        
        showMenu();
    }
}
