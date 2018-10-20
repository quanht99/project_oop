package JavaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static controller.controller.*;

public class controllerFx implements Initializable {


    @FXML private TextField textFieldInput;
    @FXML private Label labelOutput;
    @FXML private WebView webView;
    @FXML private WebEngine webEngine;
    @FXML private ListView<String> listView;



    public void handleButtonFind() throws SQLException {

        String wordInput = textFieldInput.getText();
        String wordExplain = findWord(wordInput);

        if(wordExplain.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.NONE);

            ButtonType buttonTypeYesAPI = new ButtonType("Yes");
            ButtonType buttonTypeNoAPI = new ButtonType("No");

            alert.getButtonTypes().addAll(buttonTypeYesAPI,buttonTypeNoAPI);

            alert.setTitle("Information");
            alert.setContentText("Not found this word\n\nDo you want to use API google for the word?");

            Optional<ButtonType> result = alert.showAndWait();

            alert.show();
            switch (result.get().getText())
            {
                case "Yes":
                {
                    handleButtonActionAPI();
                    alert.close();
                    break;
                }
                case "No":
                {
                    alert.close();
                    break;
                }
            }
        }
        else
        {
            labelOutput.setText(wordInput);
            webEngine.loadContent(wordExplain);
        }

    }
    public void handleButtonActionAPI()
    {
        try
        {
            FXMLLoader fxmlAPI = new FXMLLoader((getClass().getResource("getAPI.fxml")));
            Parent rootAPI = (Parent) fxmlAPI.load();
            Stage stageAdd = new Stage();
            stageAdd.initStyle(StageStyle.UTILITY);

            stageAdd.hide();
            stageAdd.setTitle("Search new word by API google");
            stageAdd.setScene(new Scene(rootAPI));
            stageAdd.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
    public void showList() throws SQLException {
        String input = textFieldInput.getText();
        String word[] = {""};
        word = suggestionWord(input);
        ObservableList<String> data = FXCollections.observableArrayList(word);
        listView.setItems(data);

    }

    public void KeyPress(KeyEvent e) throws SQLException {
        if(e.getCode() == KeyCode.ENTER)
        {
            handleButtonFind();
        }

    }

    @FXML
    public void displayMouse(MouseEvent mouseEvent) throws SQLException {
        String text;
        text = listView.getSelectionModel().getSelectedItem();
        textFieldInput.setText(text);
        handleButtonFind();
        String word[] = {""};
        word = suggestionWord(text);
        ObservableList<String> data = FXCollections.observableArrayList(word);
        listView.setItems(data);

    }

    public void actionEvent(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //webView = new WebView(); k có dong nay
        webEngine = webView.getEngine();
    }


    @FXML
    public  void handleButtonActionAddNewWord(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("addNewWord.fxml")));
            Parent rootAdd = (Parent) fxmlLoader.load();
            Stage stageAdd = new Stage();
            stageAdd.initStyle(StageStyle.UTILITY);

            stageAdd.hide();
            stageAdd.setTitle("Add new Word");
            stageAdd.setScene(new Scene(rootAdd));
            stageAdd.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
    @FXML
    public  void handleButtonActionEditWord(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("editWord.fxml")));
            Parent rootEdit = (Parent) fxmlLoader.load();
            Stage stageEdit = new Stage();
            stageEdit.initStyle(StageStyle.UTILITY);

            stageEdit.hide();
            stageEdit.setTitle("Edit Word");
            stageEdit.setScene(new Scene(rootEdit));
            stageEdit.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
    @FXML
    public  void handleButtonActionDelete(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("delete.fxml")));
            Parent rootDel = (Parent) fxmlLoader.load();
            Stage stageDel = new Stage();
            stageDel.initStyle(StageStyle.UTILITY);

            stageDel.hide();
            stageDel.setTitle("Delete Word");
            stageDel.setScene(new Scene(rootDel));
            stageDel.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
    @FXML
    public void handleButtonActionListen()
    {
        String textListen = labelOutput.getText();
        System.out.println("ok");
        System.out.println(textListen);

        textToSpeech(textListen);
    }

    public void handleButtonActionExit()
    {
        System.exit(0);
    }


}
