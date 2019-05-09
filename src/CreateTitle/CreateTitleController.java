package CreateTitle;

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

public class CreateTitleController implements RequestCallback {


    @FXML
    public TextField Title;
    @FXML
    public TextField yearOfRelease;
    @FXML
    public ChoiceBox typeOfMovie;

    public void createTitle(MouseEvent mouseEvent) {
        try {
            ServerRequest.createServerRequest(this, new JSONObject().put("command", "createtitle")
                    .put("titleName", Title.getText())
                    .put("yearOfRelease", yearOfRelease.getText())
                    .put("typeOfMovie", typeOfMovie.getValue())
                    .toString());
        } catch (Exception e) {
            Main.makeText(Main.pStage, "Every field must be fileld", 2500, 500, 500);
        }


    }

    @Override
    public void response(JSONObject obj) {
        Platform.runLater(() -> {
            if (obj.getBoolean("success")) {
                Main.makeText(Main.pStage, "success created title " + Title.getText(), 3500, 500, 500);
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
            stage.setTitle("customer details");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
