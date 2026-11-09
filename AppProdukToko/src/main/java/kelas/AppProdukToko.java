/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kelas;

import javafx.application.Application;
import javafx.stage.Stage;
import kelas.data.DataProduk;

public class AppProdukToko extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new Navigator(stage, new DataProduk()).bukaDaftar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
