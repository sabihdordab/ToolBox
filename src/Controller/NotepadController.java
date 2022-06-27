package Controller;

import com.sun.javaws.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NotepadController implements Initializable {

    @FXML
    private Button editeFileBTN;

    @FXML
    private Button newFileBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newFileBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/WriteFile.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage writeFileStage= new Stage();
            writeFileStage.setScene(new Scene(loader.getRoot()));
            writeFileStage.show();
        });

        editeFileBTN.setOnAction(e ->{
            Stage editeFileStage= new Stage();

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/EditeFilePage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            editeFileStage.setScene(new Scene(loader.getRoot()));
            editeFileStage.show();
        });
    }
}
