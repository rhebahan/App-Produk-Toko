/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kelas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailProdukController {

    @FXML
    private Label kodeLabel, namaLabel, kategoriLabel, hargaLabel, pesanLabel;
    @FXML
    private ImageView gambarView;

    private Navigator navigator;

    public void setData(Navigator navigator, Produk p) {
        this.navigator = navigator;
        kodeLabel.setText(p.getKode());
        namaLabel.setText(p.getNama());
        kategoriLabel.setText(p.getKategori());
        hargaLabel.setText(Produk.formatRupiah((long) p.getHarga()));
        if (p.getGambarUri() == null) {
            pesanLabel.setText("Tanpa gambar.");
            return;
        }
        Image image = new Image(p.getGambarUri(), 640, 480, true, true);
        if (image.isError()) {
            pesanLabel.setText("Gambar tidak ditemukan atau tidak dapat dibaca.");
        } else {
            gambarView.setImage(image);
        }
    }

    @FXML
    private void kembali() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar.");
            e.printStackTrace();
        }
    }

    @FXML
    private void tambahLagi() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form.");
            e.printStackTrace();
        }
    }
}
