package com.example.asitakipprogrami;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // HASH TABLE -> KULLANİCİBİLGİFRAME - 60
        // LİNKED LİST -> ESKİRANDEVUITEM - 20
        // QUEUE -> RANDEVUALFRAME - 228
        // STACK -> REGİSTER PAGE - 121

        FXMLLoader loginFXML = new FXMLLoader(Main.class.getResource("login_page.fxml"));
        Scene scene = new Scene(loginFXML.load(), 1345, 720);

        stage.setTitle("Aşı Randevusu Takip Sistemi");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}