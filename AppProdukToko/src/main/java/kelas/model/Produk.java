/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas.model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author ASUS
 */
public class Produk {

    public static final String MAKANAN = "Makanan";
    public static final String MINUMAN = "Minuman";

    private final String kode;
    private final String nama;
    private final String kategori;
    private final long harga;
    private final String gambarUri;

    public Produk(String kode, String nama, String kategori, long harga, String gambarUri) {
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        if (!MAKANAN.equals(kategori) && !MINUMAN.equals(kategori)) {
            throw new IllegalArgumentException("Kategori harus Makanan atau Minuman.");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("harga harus lebih dari nol");
        }

        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.gambarUri = gambarUri;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public long getHarga() {
        return harga;
    }

    public String getGambarUri() {
        return gambarUri;
    }

    public static String formatRupiah(long nilai) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        nf.setMaximumFractionDigits(0);
        return nf.format(nilai);
    }
}
