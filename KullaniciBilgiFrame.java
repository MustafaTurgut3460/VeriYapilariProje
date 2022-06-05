package com.example.asitakipprogrami;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class KullaniciBilgiFrame implements Initializable {

    @FXML
    private Button editButton;

    @FXML
    private Label userDateText, userGateText, userTCText, userTelNoText, userTitleText, userVaccineInfoText, usernameText;

    private DatabaseConnection connection = new DatabaseConnection();
    Statement statement = connection.getStatement();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getUsersData();

        editButton.setOnMouseClicked(mouseEvent -> {
            // duzenleme sayfasini ac
            openPage("edit_page.fxml");
        });
    }

    private void getUsersData() {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM kullanicilar WHERE durum='online'");
            while(resultSet.next()){
                userTitleText.setText(resultSet.getString("name").toUpperCase());
                usernameText.setText(resultSet.getString("name"));
                userTCText.setText(resultSet.getString("tc"));
                setUserVaccineInfoText();
                userDateText.setText(resultSet.getString("dogum_tarihi"));
                userTelNoText.setText(resultSet.getString("tel_no"));
                userGateText.setText(resultSet.getString("cinsiyet"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // HASH TABLE
    private void setUserVaccineInfoText() {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(0, "Henüz Aşı Yapılmadı");
        hashtable.put(1, "1 Doz Tamamlandı");
        hashtable.put(2, "2 Doz Tamamlandı");
        hashtable.put(3, "Aşı Süreci Tamamlandı");

        userVaccineInfoText.setText(hashtable.get(getUserVaccineValue()));
    }

    private int getUserVaccineValue() {
        String hastaAd = "";
        Statement statement1 = connection.getStatement();

        int value = 0;
        Statement statement = connection.getStatement();
        try {
            // hast adini cektik
            ResultSet resultSet1 = statement1.executeQuery("SELECT name FROM kullanicilar WHERE durum='online'");
            while(resultSet1.next()){
                hastaAd = resultSet1.getString("name");
            }
            // hasta adi ile eslesme
            ResultSet resultSet = statement.executeQuery("SELECT tip FROM randevular WHERE hasta_ad='" + hastaAd + "'");
            while (resultSet.next()){
                String tip = resultSet.getString("tip");
                if(tip.equals("gecmis"))
                    value++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return value;
    }

    private void openPage(String fxml){
        FXMLLoader FXML = new FXMLLoader(getClass().getResource(fxml));
        try {
            // show register page
            Stage stage = (Stage) editButton.getScene().getWindow();
            Scene scene = new Scene(FXML.load(), 1345, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



























