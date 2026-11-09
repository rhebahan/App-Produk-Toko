package kelas.controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormProdukController {

    @FXML
    private TextField kodeField, namaField, hargaField;
    @FXML
    private ComboBox<String> kategoriBox;
    @FXML
    private ImageView gambarView;
    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;
    private String gambarUri;

    @FXML
    private void initialize() {
        kategoriBox.getItems().addAll(Produk.MAKANAN, Produk.MINUMAN);
        kategoriBox.setValue(Produk.MAKANAN);
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        kodeField.setText(data.kodeBerikutnya() + " (otomatis)");
    }

    @FXML
    private void pilihGambar() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Pilih gambar produk");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Gambar PNG/JPEG", "*.png", "*.jpg", "*.jpeg"));
        File file = chooser.showOpenDialog(namaField.getScene().getWindow());
        if (file == null) {
            return; 
        }
        if (file.length() > 5L * 1024 * 1024) {
            tampilError("Maksimum gambar 5 MB.");
            return;
        }
        Image image = new Image(file.toURI().toString(), 640, 480, true, true);
        if (image.isError()) {
            tampilError("Gambar tidak dapat dibaca.");
            return;
        }
        gambarUri = file.toURI().toString();
        gambarView.setImage(image);
        pesanLabel.setText("");
    }

    @FXML
    private void hapusGambar() {
        gambarUri = null;
        gambarView.setImage(null);
    }

    @FXML
    private void simpan() {
        if (namaField.getText() == null || namaField.getText().isBlank()) {
            tampilError("Nama produk tidak boleh kosong.");
            return;
        }
        long harga;
        try {
            harga = Long.parseLong(hargaField.getText().trim().replace(".", ""));
        } catch (NumberFormatException e) {
            tampilError("Harga harus berupa angka bulat.");
            return;
        }
        Produk baru;
        try {
            baru = data.tambah(namaField.getText(), kategoriBox.getValue(), harga, gambarUri);
        } catch (IllegalArgumentException e) {
            tampilError(e.getMessage());
            return;
        }
        try {
            navigator.bukaDaftar("Produk " + baru.getKode() + " berhasil disimpan.");
        } catch (IOException e) {
            tampilError("Produk tersimpan, tetapi Daftar gagal dibuka. Periksa DaftarProduk.fxml.");
            e.printStackTrace();
        }
    }

    @FXML
    private void kembali() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            tampilError("Gagal membuka daftar.");
            e.printStackTrace();
        }
    }

    private void tampilError(String teks) {
        pesanLabel.setText(teks);
    }
}
