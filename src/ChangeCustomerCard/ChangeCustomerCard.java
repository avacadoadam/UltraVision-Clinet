package ChangeCustomerCard;

import ServerConnect.RequestCallback;
import ServerConnect.ServerRequest;
import Start.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;

public class ChangeCustomerCard implements RequestCallback {
    public TextField cardNum;
    public TextField customerID;
    public ChoiceBox cardtype;

    public void back(MouseEvent mouseEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainMenu/MainMenuScence.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("customer details");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void change(MouseEvent mouseEvent) {
        try {
            ServerRequest.createServerRequest(this, new JSONObject().put("command", "changeuserCard")
                    .put("customerID", Integer.parseInt(customerID.getText()))
                    .put("cardType", cardtype.getValue())
                    .put("cardNumber", cardNum.getText())
                    .toString());
        } catch (Exception e) {
            Main.makeText(Main.pStage, "Every field must be filled", 2500, 500, 500);
        }
    }

    @Override
    public void response(JSONObject obj) {
        Platform.runLater(() -> {
            if (obj.getBoolean("success")) {
                Main.makeText(Main.pStage, "succesfully change", 3500, 500, 500);
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

}
