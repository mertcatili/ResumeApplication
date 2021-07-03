/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ozgecmisproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mert
 */
public class Baglanti {
    public static Statement Baglan() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/db_Ozgecmis", "sa", "as");
            Statement stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            System.out.println("Bağlantı Hatası Oluştu!    " + e);
            return null;
        }
    }
    int kisiID=0;
    public void BilgiEkle(String Ad, String Yil, String Yer, String Uyruk, int Medeni,String Ehliyet, String Askerlik) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList dizi = new ArrayList();
            String sorgu1 = String.format("select * from TBL_BILGILER");
            ResultSet ekleme1 = Baglan().executeQuery(sorgu1);
            while (ekleme1.next()) {
                dizi.add(ekleme1.getString("ID"));
            }
            int deger = dizi.size();
            kisiID=deger+1;
            String sorgu = String.format("insert into TBL_BILGILER values( %d, '%s', '%s','%s','%s',%d,'%s','%s')", (deger + 1), Ad, Yil, Yer, Uyruk, Medeni,Ehliyet, Askerlik);
            int ekleme = Baglan().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println("Kayıt Eklemede sorun oluştu.    " + e);
        }
    }
    public void DeneyimEkle(String DeneyimAd, int Sure) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList dizi = new ArrayList();
            String sorgu1 = String.format("select * from TBL_DENEYIM");
            ResultSet ekleme1 = Baglan().executeQuery(sorgu1);
            while (ekleme1.next()) {
                dizi.add(ekleme1.getString("ID"));
            }
            int deger = dizi.size();
            String sorgu = String.format("insert into TBL_DENEYIM values( %d, %d, '%s',%d)", (deger + 1), kisiID, DeneyimAd, Sure);
            int ekleme = Baglan().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println("Kayıt Eklemede sorun oluştu.    " + e);
        }
    }
    public void EgitimEkle(String OkulAdi, String Derece) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList dizi = new ArrayList();
            String sorgu1 = String.format("select * from TBL_EGITIM");
            ResultSet ekleme1 = Baglan().executeQuery(sorgu1);
            while (ekleme1.next()) {
                dizi.add(ekleme1.getString("ID"));
            }
            int deger = dizi.size();
            String sorgu = String.format("insert into TBL_EGITIM values( %d, %d, '%s','%s')", (deger + 1), kisiID, OkulAdi, Derece);
            int ekleme = Baglan().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println("Kayıt Eklemede sorun oluştu.    " + e);
        }
    }
    public void ReferansEkle(String ReferansAd) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList dizi = new ArrayList();
            String sorgu1 = String.format("select * from TBL_REFERANS");
            ResultSet ekleme1 = Baglan().executeQuery(sorgu1);
            while (ekleme1.next()) {
                dizi.add(ekleme1.getString("ID"));
            }
            int deger = dizi.size();
            String sorgu = String.format("insert into TBL_REFERANS values( %d, %d, '%s')", (deger + 1), kisiID, ReferansAd);
            int ekleme = Baglan().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println("Kayıt Eklemede sorun oluştu.    " + e);
        }
    }
    public void SertifikaEkle(String SertifikaAd, int Gecerlilik) {
        Scanner scan = new Scanner(System.in, "iso-8859-9");
        try {
            ArrayList dizi = new ArrayList();
            String sorgu1 = String.format("select * from TBL_SERTIFIKA");
            ResultSet ekleme1 = Baglan().executeQuery(sorgu1);
            while (ekleme1.next()) {
                dizi.add(ekleme1.getString("ID"));
            }
            int deger = dizi.size();
            String sorgu = String.format("insert into TBL_SERTIFIKA values( %d, %d, '%s', %d)", (deger + 1), kisiID, SertifikaAd, Gecerlilik);
            int ekleme = Baglan().executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
        } catch (Exception e) {
            System.out.println("Kayıt Eklemede sorun oluştu.    " + e);
        }
    }
}
