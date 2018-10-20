package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

public class getAPIController {
    @FXML
    public Label label1 = new Label();
    @FXML
    public Label label2 = new Label();

    @FXML
    public void handleButtonActionChange(ActionEvent e)
    {
        String text1 = label1.getText();
        String text2 = label2.getText();

        label1.setText(text2);
        label2.setText(text1);
    }
}
