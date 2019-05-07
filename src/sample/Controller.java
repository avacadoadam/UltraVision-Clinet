package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    public void CreateUser(MouseEvent mouseEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("get_customer_details.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("customer details");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
