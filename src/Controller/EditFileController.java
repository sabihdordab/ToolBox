package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EditFileController implements Initializable {

    FileChooser fileChooser = new FileChooser();

    @FXML
    private TextArea TXT;

    @FXML
    private Button chooseFileBTN;

    @FXML
    private Label errorLBL;

    @FXML
    private TextField fileNameFLD;

    @FXML
    private Button saveBTN;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        saveBTN.setVisible(false);

        Stage stage = new Stage();

        chooseFileBTN.setOnAction(e -> {
            String data = "";

            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
            );
            try {
                File file = fileChooser.showOpenDialog(stage);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {

                    data = data + myReader.nextLine() + "\n" ;
                }
                TXT.setText(data);
                fileNameFLD.setText(file.getName());
                saveBTN.setVisible(true);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

        });

        saveBTN.setOnAction(e -> {
//            if (fileNameFLD.getText() != null && Pattern.matches("^[a-zA-Z][a-zA-Z0-9\\s]*\\.(txt)$",fileNameFLD.getText()))
//            {
            try {
                File file = fileChooser.showSaveDialog(new Stage());
                saveSystem(file,TXT.getText());
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

                //comments :  for save file here  :

//                  File file = new File(fileNameFLD.getText());
//                FileWriter myWriter = null;
//                try {
//                    myWriter = new FileWriter(fileNameFLD.getText());
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    myWriter.write(TXT.getText());
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    myWriter.close();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Done");
                errorLBL.setStyle("-fx-border-color: green");
//            }
//            else
//            {
//                errorLBL.setTextFill(Color.RED);
//                errorLBL.setText("file name!!!!!!");
//                errorLBL.setStyle("-fx-border-color: red");
//            }
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
