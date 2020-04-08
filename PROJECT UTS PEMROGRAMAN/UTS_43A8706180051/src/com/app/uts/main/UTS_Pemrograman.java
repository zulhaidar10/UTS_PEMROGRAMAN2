/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.main;

import com.app.uts.crud.CRUD;
import java.util.Scanner;

/**
 *
 * @author Zulhaidar Irvansyah
 */
public class UTS_Pemrograman {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
    
        CRUD crud = new CRUD();
        
        System.out.println("\n========= DATABASE PERPUSTAKAAN =========");
        System.out.println("1. TABEL ABSEN");
        System.out.println("0. EXIT");
        System.out.println("");
        System.out.print("MASUKKAN PILIHAN ANDA : ");
        
        int pilihan = Integer.parseInt(input.nextLine());
            
            switch(pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    crud.showMenu();
                    break;

                default:
                    System.out.println("Pilihan Anda Salah!");
                
        }
    }
}
