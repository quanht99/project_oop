package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.json.JSONException;

import java.awt.*;
import java.sql.SQLException;

import static controller.googleAPI.getAPI;

public class getAPIController {
    @FXML
    public Label label1 = new Label();
    @FXML
    public Label label2 = new Label();
    @FXML
    private TextArea textAreaGetWordOutput;
    @FXML
    private TextField textFieldGetWordInput;

    @FXML
    public void handleButtonActionChange(ActionEvent e)
    {
        String text1 = label1.getText();
        String text2 = label2.getText();

        label1.setText(text2);
        label2.setText(text1);

    }
    @FXML
    public void handleButtonActionSearchAPI() throws JSONException {
        String text1 = label1.getText();
        String text2 = label2.getText();


        if(text1.equals("Tiếng Việt") && text2.equals("Tiếng Anh"))
        {
            String text3 = textFieldGetWordInput.getText();
            String text4 = getAPI("vi", "en", text3);
            textAreaGetWordOutput.setText(text4);
        }
        else
        {
            String text3 = textFieldGetWordInput.getText();
            String text4 = getAPI("en", "vi", text3);
            textAreaGetWordOutput.setText(text4);
        }

    }
    @FXML
    public void KeyPress(KeyEvent e) throws SQLException, JSONException {
        if(e.getCode() == KeyCode.ENTER)
        {
            handleButtonActionSearchAPI();
        }

    }
}
