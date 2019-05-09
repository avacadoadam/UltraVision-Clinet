package MainMenu;

import Start.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    public void CreateUser(MouseEvent mouseEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CreateCustomer/getCustomerDetails.fxml"));
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

    public void RentTitle(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/RentTitle/RentTitleScanBarcode.fxml"));
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

    public void CreateTitle(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CreateTitle/CreateTitleScene.fxml"));
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

    public void returnRental(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ReturnRental/ReturnRental.fxml"));
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

    public void ChangeAddress(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ChangeCustomerAddress/CustomerChangeAddress.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Change customer address");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeCustomerCard(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ChangeCustomerCard/ChangeCustomerCard.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Change customer address");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ChangeAccessPlan(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ChangeCustomerAccessPlan/ChangeCustomerAccessPlan.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Change customer address");
            stage.setScene(new Scene(root1));
            stage.setFullScreen(true);
            Main.pStage.setScene(stage.getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
