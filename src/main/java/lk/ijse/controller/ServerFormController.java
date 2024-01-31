package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.controller.server.Server;

import java.io.IOException;

public class ServerFormController {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgLogo;

    @FXML
    private JFXButton loginBtn;

    @FXML
    public void loginBtnOnAction(ActionEvent actionEvent) {
        try {
            Server server = Server.getServerSocket();
            Thread thread = new Thread(server);
            thread.start();

            root.getChildren().clear();
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_window_form.fxml"))));
            stage.show();
            stage.setOnCloseRequest(e-> {
                System.exit(0);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
