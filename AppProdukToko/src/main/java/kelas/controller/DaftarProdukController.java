/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kelas.controller;

import java.io.IOException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarProdukController {

    @FXML
    private TableView<Produk> tabel;
    @FXML
    private TableColumn<Produk, String> kodeCol;
    @FXML
    private TableColumn<Produk, String> namaCol;
    @FXML
    private TableColumn<Produk, String> kategoriCol;
    @FXML
    private TableColumn<Produk, Long> hargaCol;
    @FXML
    private TextField cariField;
    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;
    private final ObservableList<Produk> dataTampilan = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        kodeCol.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getKode()));
        namaCol.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getNama()));
        kategoriCol.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getKategori()));
        hargaCol.setCellValueFactory(c -> new ReadOnlyObjectWrapper<Long>(c.getValue().getHarga()));

        hargaCol.setCellFactory(kolom -> new TableCell<Produk, Long>() {
            {
                setAlignment(Pos.CENTER_RIGHT);
            }

            @Override
            protected void updateItem(Long nilai, boolean kosong) {
                super.updateItem(nilai, kosong);
                setText(kosong || nilai == null ? null : Produk.formatRupiah(nilai));
            }
        });

        kodeCol.prefWidthProperty().bind(tabel.widthProperty().multiply(0.15));
        namaCol.prefWidthProperty().bind(tabel.widthProperty().multiply(0.40));
        kategoriCol.prefWidthProperty().bind(tabel.widthProperty().multiply(0.21));
        hargaCol.prefWidthProperty().bind(tabel.widthProperty().multiply(0.22));

        tabel.setItems(dataTampilan);
        tabel.setPlaceholder(new Label("Belum ada produk yang sesuai."));
    }

    public void setKonteks(Navigator navigator, DataProduk data, String pesan) {
        this.navigator = navigator;
        this.data = data;
        cari();
        if (pesan != null) {
            tampilPesan(pesan, "sukses");
        }
    }

    @FXML
    private void cari() {
        if (data == null) {
            return;
        }
        dataTampilan.setAll(data.cari(cariField.getText()));
        tampilPesan("Jumlah produk yang tampil: " + dataTampilan.size(), null);
    }

    @FXML
    private void reset() {
        cariField.clear();
        cari();
    }

    @FXML
    private void tambah() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            tampilPesan("Form gagal dibuka. Periksa FormProduk.fxml.", "error");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {
        Produk dipilih = tabel.getSelectionModel().getSelectedItem();
        if (dipilih == null) {
            tampilPesan("Pilih satu baris dahulu.", "error");
            return;
        }
        try {
            navigator.bukaDetail(dipilih);
        } catch (IOException e) {
            tampilPesan("Detail gagal dibuka. Periksa DetailProduk.fxml.", "error");
            e.printStackTrace();
        }
    }

    private void tampilPesan(String teks, String gaya) {
        pesanLabel.getStyleClass().removeAll("error", "sukses");
        if (gaya != null) {
            pesanLabel.getStyleClass().add(gaya);
        }
        pesanLabel.setText(teks);
    }
}
