package ChangeCustomerAccessPlan;

import ServerConnect.RequestCallback;
import ServerConnect.ServerRequest;
import Start.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;

public class ChangeCustomerAccessPlan implements RequestCallback {



    @FXML public TextField customerID;
    @FXML public ChoiceBox accesstype;


    @Override
    public void response(JSONObject obj) {
        Platform.runLater(() -> {
            if (obj.getBoolean("success")) {
                Main.makeText(Main.pStage, "change access plan", 3500, 500, 500);
            } else {
                Main.makeText(Main.pStage, obj.getString("error"), 3500, 500, 500);
            }
        });
    }

    @Override
    public void fail() {
        Platform.runLater(() -> {
            Main.makeText(Main.pStage, "Could not connect to server", 2500, 500, 500);
        });
    }

    public void back(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainMenu/MainMenuScence.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Main");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void change(MouseEvent mouseEvent) {
        try {
            ServerRequest.createServerRequest(this, new JSONObject().put("command", "changeuseraccessplan")
                    .put("customerID", Integer.parseInt(customerID.getText())).put("accessPlan",accesstype.getValue()).toString());
        } catch (Exception e) {
            e.printStackTrace();
            Main.makeText(Main.pStage, "product ID must be filled and be a int", 3500, 500, 500);
        }
    }
}
