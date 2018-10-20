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
            /*
            hoi
             */
            if (textFieldWordTarget.getText().equals("") || htmlEditorWordExplain.getHtmlText().equals("")) {
                Alert alert1 = new Alert(Alert.AlertType.NONE);
                alert1.setTitle("Error");
                alert1.setContentText("ERROR");
                alert1.show();

                textFieldWordTarget.setText("");
                htmlEditorWordExplain.setHtmlText("");

                System.out.println("xoa");
            }
            else {
                addWordToDatabase(wordTarget, wordExplain);
                System.out.println("da them");
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setContentText("Added word successfully");
                alert.setTitle("Information");
                alert.show();

                textFieldWordTarget.setText("");
                htmlEditorWordExplain.setHtmlText("");
            }
        }
        else
        {
            System.out.println(htmlEditorWordExplain.getHtmlText());
            Alert alert1 = new Alert(Alert.AlertType.NONE);
            alert1.setTitle("Error");
            alert1.setContentText("This word is in Dictionary!");
            alert1.show();

            textFieldWordTarget.setText("");
            htmlEditorWordExplain.setHtmlText("");

            System.out.println("K tim thay");

        }
    }

}
