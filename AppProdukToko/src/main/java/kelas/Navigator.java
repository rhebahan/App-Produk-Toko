/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kelas.controller.DaftarProdukController;
import kelas.controller.DetailProdukController;
import kelas.controller.FormProdukController;
import kelas.data.DataProduk;
import kelas.model.Produk;


public class Navigator {

    private final Stage stage;
    private final DataProduk data;
    private Scene scene;

    public Navigator(Stage stage, DataProduk data) {
        this.stage = stage;
        this.data = data;
    }

    private FXMLLoader loader(String nama) {
        return new FXMLLoader(getClass().getResource("/kelas/" + nama + ".fxml"));
    }

    private void tampil(Parent root) {
        if (scene == null) {
            scene = new Scene(root, 900, 680);
            scene.getStylesheets().add(getClass().getResource("/kelas/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Aplikasi Pencatatan Produk Toko");
            stage.setMinWidth(640);
            stage.setMinHeight(480);
        } else {
            scene.setRoot(root);
        }
        stage.show();
    }

    public void bukaDaftar() throws IOException {
        bukaDaftar(null);
    }

    public void bukaDaftar(String pesan) throws IOException {
        FXMLLoader l = loader("DaftarProduk");
        Parent root = l.load();
        DaftarProdukController c = l.getController();
        c.setKonteks(this, data, pesan);
        tampil(root);
    }

    public void bukaForm() throws IOException {
        FXMLLoader l = loader("FormProduk");
        Parent root = l.load();
        FormProdukController c = l.getController();
        c.setKonteks(this, data);
        tampil(root);
    }

    public void bukaDetail(Produk p) throws IOException {
        FXMLLoader l = loader("DetailProduk");
        Parent root = l.load();
        DetailProdukController c = l.getController();
        c.setData(this, p);
        tampil(root);
    }
}

