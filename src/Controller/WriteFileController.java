package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class WriteFileController implements Initializable {

    @FXML
    private Button AddFileBTN;

    @FXML
    private Label errorLBL;

    @FXML
    private TextArea fileTXT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
        );
       AddFileBTN.setOnAction(e ->{
           try {
               File file = fileChooser.showSaveDialog(new Stage());
               saveSystem(file,fileTXT.getText());
               errorLBL.setTextFill(Color.GREEN);
               errorLBL.setText("Done");
               errorLBL.setStyle("-fx-border-color: green");
           }
           catch (Exception ex)
           {
               System.out.println(ex.getMessage());
           }

       });

    }

    public void saveSystem(File file , String content)
    {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
