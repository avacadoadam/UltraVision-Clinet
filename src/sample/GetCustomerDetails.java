package sample;

import ServerConnect.RequestCallback;
import ServerConnect.ServerRequest;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONObject;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GetCustomerDetails implements RequestCallback{

    @FXML
    public DatePicker DOB;

    @FXML
    public TextField cardnum;
    @FXML
    public TextField fname;
    @FXML
    public TextField lname;
    @FXML
    public TextField address;

    @FXML
    public ChoiceBox accesstype;
    @FXML
    public ChoiceBox cardtype;
    @FXML
    public Label error_message;


    public void createcustomer(MouseEvent mouseEvent) {
        JSONObject obj = new JSONObject();
        obj.put("command", "createcustomer");
        obj.put("fname", fname.getText());
        obj.put("lname", lname.getText());
        String date = DOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
        obj.put("DOB", date);
        obj.put("address", address.getText());
        obj.put("accessPlan", accesstype.getValue().toString());
        obj.put("cardType", cardtype.getValue().toString());
        obj.put("cardNumber", cardnum.getText());
        ServerRequest.createServerRequest(this, obj.toString());
    }


    @Override
    public void response(JSONObject obj) {
        Platform.runLater(() -> {
            if (obj.getBoolean("success")) {
                Main.makeText(Main.pStage, "success id= "+obj.getInt("customerID"), 3500, 500, 500);
            } else {
                Main.makeText(Main.pStage, obj.getString("error"), 3500, 500, 500);
                error_message.setText("server response " + obj.getString("error"));
            }
        });

    }

    @Override
    public void fail() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("get_customer_details.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setTitle("customer details");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
