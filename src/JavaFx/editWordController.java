package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

import java.sql.SQLException;

import static controller.controller.*;

public class editWordController {

    @FXML
    private TextField textFieldEdit = new TextField();
    @FXML
    private HTMLEditor htmlEditorEdit = new HTMLEditor();

    @FXML
    public void handleButtonFind(ActionEvent event) throws SQLException {
        String textFind = textFieldEdit.getText();
        htmlEditorEdit.setHtmlText(findWord(textFind));

    }
    @FXML
    public void handleButtonEdit(ActionEvent e)
    {
        editDetail(textFieldEdit.getText(), htmlEditorEdit.getHtmlText());
    }

}

