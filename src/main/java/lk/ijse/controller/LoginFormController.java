package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.controller.client.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtName;

    @FXML
    public void btnLoginForm(ActionEvent actionEvent) {
        try {
            if (Pattern.matches("^[a-zA-Z\\s]+", txtName.getText())) {
                Client client = new Client(txtName.getText());

                Thread thread = new Thread(client);
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
