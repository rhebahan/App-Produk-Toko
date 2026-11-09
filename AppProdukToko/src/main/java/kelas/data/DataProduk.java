/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas.data;

import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

/**
 *
 * @author ASUS
 */
public class DataProduk {

    private final ObservableList<Produk> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public String kodeBerikutnya() {
        return String.format("PRD%03d", urutan);
    }

    public Produk tambah(String nama, String kategori, long harga, String gambarUri) {
        String kode = String.format("PRD%03d", urutan);
        Produk p = new Produk(kode, nama, kategori, harga, gambarUri);
        daftar.add(p);
        urutan++;
        return p;
    }

    public ObservableList<Produk> cari(String kata) {
        String kunci = kata == null ? "" : kata.trim().toLowerCase(Locale.ROOT);
        ObservableList<Produk> hasil = FXCollections.observableArrayList();
        for (Produk p : daftar) {
            if (p.getNama().toLowerCase(Locale.ROOT).contains(kunci)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

}
