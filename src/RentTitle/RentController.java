package RentTitle;

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


public class RentController implements RequestCallback {

    @FXML
    public TextField customerID;
    @FXML
    public TextField productID;
    @FXML
    public ChoiceBox rentalType;

    @FXML
    public void initialize() {
        customerID.requestFocus();
    }

    public void rent(MouseEvent mouseEvent) {
        //test for
        String selectedOption = (String) rentalType.getValue();
        if(selectedOption == null){
            Main.makeText(Main.pStage, "must add rental type", 3500, 500, 500);
            return;
        }
        String command = "rentOutWithAccessPlan";
        if (selectedOption.equals("Loyalty Points")) {
            command = "rentwithloyaltypoints";
        }
        if (selectedOption == null) {
            Main.makeText(Main.pStage, "must select rent type", 3500, 500, 500);
            return;
        }
        int IntcustomerID;
        int IntproductID;
        try {
            IntcustomerID = Integer.valueOf(customerID.getText());
            IntproductID = Integer.valueOf(productID.getText());
        } catch (NumberFormatException e) {
            Main.makeText(Main.pStage, "must enter ID and they must be numbers", 3500, 500, 500);
            return;
        }

        ServerRequest.createServerRequest(this,
                new JSONObject().put("customerID", IntcustomerID)
                        .put("productID", IntproductID)
                        .put("command", command)
                        .toString());
    }

    @Override
    public void response(JSONObject obj) {
        Platform.runLater(() -> {
            if (obj.getBoolean("success")) {
                Main.makeText(Main.pStage, "success id= " + obj.getInt("customerID"), 3500, 500, 500);
            } else {
                Main.makeText(Main.pStage, obj.getString("error"), 3500, 500, 500);
            }
        });
    }

    @Override
    public void fail() {
        Platform.runLater(() -> {
            Main.makeText(Main.pStage, "unSuccess", 3500, 500, 500);
        });
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
