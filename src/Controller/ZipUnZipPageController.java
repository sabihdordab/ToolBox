package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUnZipPageController implements Initializable {

    @FXML
    private Button UnZipFileBTN;

    @FXML
    private Button zipFileBTN;


    @FXML
    private Label errorLBL;


    private static final int BUFFER_SIZE = 4096;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        zipFileBTN.setOnAction(e -> {

            FileChooser fileChooser = new FileChooser();
            try {
                File file = fileChooser.showOpenDialog(new Stage());
                String zipFileName = file.getName() + ".zip" ;
                ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(zipFileName));
                zOut.setLevel(9);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zOut.putNextEntry(zipEntry);
                zOut.write(Files.readAllBytes(Paths.get(file.getPath())));
                zOut.closeEntry();
                zOut.close();

                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("your file zipped  here ;)");
                errorLBL.setStyle("-fx-border-color: green");

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

        });
        UnZipFileBTN.setOnAction( e ->{

            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ZIP files (*.zip)", "*.zip");
            fileChooser.getExtensionFilters().add(extFilter);
            try {

                File file = fileChooser.showOpenDialog(new Stage());

                File destDir = new File("./extractedFiles");
                if (!destDir.exists()) {
                    destDir.mkdir();
                }

                ZipInputStream zIn = new ZipInputStream(new FileInputStream(file.getPath()));
                ZipEntry zipEntry = zIn.getNextEntry();

                while (zipEntry != null)
                {
                    String filePath = "./extractedFiles" + File.separator + zipEntry.getName();
                    if (!zipEntry.isDirectory()) {
                        // if the entry is a file, extracts it
                        extractFile(zIn, filePath);
                    } else {
                        // if the entry is a directory, make the directory
                        File dir = new File(filePath);
                        dir.mkdirs();
                    }
                    zIn.closeEntry();
                    zipEntry = zIn.getNextEntry();
                }
                zIn.close();

                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("your file unZipped  in extracted files dir ;)");
                errorLBL.setStyle("-fx-border-color: green");

            }catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

        });
    }

    public void extractFile(ZipInputStream zipIn, String filePath) {
        try {
            BufferedOutputStream bOS = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bOS.write(bytesIn, 0, read);
            }
            bOS.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}

