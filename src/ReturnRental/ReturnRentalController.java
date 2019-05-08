package ReturnRental;

import ServerConnect.RequestCallback;
import ServerConnect.ServerRequest;
import Start.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;

public class ReturnRentalController implements RequestCallback {

    @FXML
    public TextField productID;

    public void returnRental(MouseEvent mouseEvent) {
        try {
            ServerRequest.createServerRequest(this, new JSONObject().put("command", "returnrental")
                    .put("productID", Integer.parseInt(productID.getText())).toString());
        } catch (Exception e) {
            e.printStackTrace();
            Main.makeText(Main.pStage, "product ID must be filled and be a int", 3500, 500, 500);
        }

    }

    @Override
    public void response(JSONObject obj) {
        Platform.runLater(() -> {
            if (obj.getBoolean("success")) {
                Main.makeText(Main.pStage, "success return title ", 3500, 500, 500);
            } else {
                Main.makeText(Main.pStage, obj.getString("error"), 3500, 500, 500);
            }
        });
    }

    @Override
    public void fail() {
        Main.makeText(Main.pStage, "Could not connect to server", 2500, 500, 500);
    }


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
}
