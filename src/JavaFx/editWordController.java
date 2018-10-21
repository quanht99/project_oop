package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;


import javax.swing.*;
import java.sql.SQLException;

import static controller.controller.editDetail;
import static controller.controller.findWord;


public class editWordController {

    @FXML
    private TextField textFieldEdit = new TextField();
    @FXML
    private HTMLEditor htmlEditorEdit = new HTMLEditor();

    @FXML
    public void handleButtonFind() throws SQLException {
        String textFindInput = textFieldEdit.getText();
        String textFindOutput = findWord(textFindInput);

        if(textFindOutput.equals(""))
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Error");
            alert1.setHeaderText("ERROR");
            alert1.setContentText("Not found this word in Dictionary!");
            alert1.show();
        }
        else {
            htmlEditorEdit.setHtmlText(findWord(textFindInput));
        }
    }
    @FXML
    public void handleButtonEdit(ActionEvent e) throws SQLException {

        if(!textFieldEdit.getText().equals("")) //them htmleditor de kiem tra word mean chua nhap
        {
            editDetail(textFieldEdit.getText(), htmlEditorEdit.getHtmlText());

            textFieldEdit.setText("");
            htmlEditorEdit.setHtmlText("");

            Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
            alert3.setTitle("Information");
            alert3.setHeaderText("Done");
            alert3.setContentText("Edited word successfully");
            alert3.show();
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Warning");
            alert1.setHeaderText("Warning");
            alert1.setContentText("You must enter the full word target and word explain!");
            alert1.show();
        }

    }
    @FXML
    public void KeyPress(KeyEvent e) throws SQLException {
        if(e.getCode() == KeyCode.ENTER)
        {
            handleButtonFind();
        }

    }

}
