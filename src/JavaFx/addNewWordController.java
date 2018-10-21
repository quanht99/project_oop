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

        String wordExplainOuput = findWord(wordTarget);

        if(!wordTarget.equals("") && !wordExplain.equals("") ) // cai thu 2 nay laf html k chay dc
        {

            if (wordExplainOuput.equals("") ) {

                addWordToDatabase(wordTarget, wordExplain);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("Added word successfully");
                alert.setHeaderText("Done");
                alert.show();

                textFieldWordTarget.setText("");
                htmlEditorWordExplain.setHtmlText("");
            } else {

                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Warning");
                alert1.setContentText("This word is already in Dictionary!");
                alert1.show();

                textFieldWordTarget.setText("");
                htmlEditorWordExplain.setHtmlText("");

            }
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Warning");
            alert1.setContentText("You must enter the full word target and word explain!");
            alert1.show();

            textFieldWordTarget.setText("");
            htmlEditorWordExplain.setHtmlText("");
        }
    }

}
