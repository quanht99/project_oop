package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.util.Optional;

import static controller.controller.deletaWordFromDatabase;
import static controller.controller.findWord;

public class deleteController {
    @FXML
    private TextField textFieldXoa = new TextField();

    @FXML
    public void handleButtonActionDelete() throws SQLException {

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
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Confirmation");
            alert2.setContentText("Do you want to delete this word?");

            Optional<ButtonType> result  = alert2.showAndWait();

            if (result.get().getText().equals("OK")) {

                String text = textFieldXoa.getText();
                deletaWordFromDatabase(text);
                textFieldXoa.setText("");

                Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                alert3.setTitle("Information");
                alert3.setHeaderText("Done");
                alert3.setContentText("Deleted word successfully");
                alert3.show();
            }
        }

    }
    public void keyPress(KeyEvent e) throws SQLException {
        if( e.getCode() == KeyCode.ENTER)
        {
            handleButtonActionDelete();
        }
    }
}
