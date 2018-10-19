package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.web.HTMLEditor;

import java.sql.SQLException;

import static controller.controller.addWordToDatabase;
import static controller.controller.findWord;


public class addNewWordController {
    @FXML
    private TextField textFieldWordTarget = new TextField();
    @FXML
    private HTMLEditor htmlEditorWordExplain = new HTMLEditor();



    @FXML
    public void handleButtonActionOk(ActionEvent e) throws SQLException {
        String wordTarget = textFieldWordTarget.getText();
        String wordExplain = htmlEditorWordExplain.getHtmlText();
        String wordTargetOuput = findWord(wordTarget);

        if(wordTargetOuput.equals("")) {
            addWordToDatabase(wordTarget, wordExplain);
            textFieldWordTarget.setText("");
            htmlEditorWordExplain.setHtmlText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Added word successfully");
            alert.setTitle("Information");
            alert.setHeaderText("Done");
            alert.show();
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Error");
            alert1.setHeaderText("ERROR");
            alert1.setContentText("This word is in Dictionary!");
            alert1.show();

            textFieldWordTarget.setText("");
            htmlEditorWordExplain.setHtmlText("");
        }
    }
}
