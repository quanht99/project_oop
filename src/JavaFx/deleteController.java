package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Optional;

import static controller.controller.deletaWordFromDatabase;
import static controller.controller.findWord;

public class deleteController {
    @FXML
    private TextField textFieldXoa = new TextField();

    @FXML
    public void handleButtonAction1(ActionEvent e) throws SQLException {

        String textEqualInput = textFieldXoa.getText();
        String textEqualOutput = findWord(textEqualInput);

        if(textEqualOutput.equals("") || textEqualInput.equals(""))
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Error");
            alert1.setHeaderText("ERROR");
            alert1.setContentText("Not found this word in Dictionary!");
            alert1.show();
        }
        else {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);

            ButtonType buttonTypeYes = new ButtonType("Yes");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");

            alert2.getButtonTypes().addAll(buttonTypeYes,buttonTypeCancel);
            alert2.setTitle("Confirmation");
            alert2.setContentText("Do you want to delete it?");

            Optional<ButtonType> result  = alert2.showAndWait();
            alert2.show();

            if (result.get().getText() == "Yes") {
                alert2.close();
                String text = textFieldXoa.getText();
                deletaWordFromDatabase(text);
                textFieldXoa.setText("");

                Alert alert3 = new Alert(Alert.AlertType.NONE);
                alert3.setTitle("Information");
                alert3.setContentText("Deleted word successfully");
                alert3.show();
                System.out.println("da xoa");
            } else {
                alert2.close();
            }
        }

    }
}
