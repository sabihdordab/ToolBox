package View;


import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddContactPage extends VBox {
    private TextField nameField ;
    private TextField lastNameField ;
    private TextField phoneNumberField ;
    private TextField addressFLD ;
    private Label errorLBL ;

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public Label getErrorLBL() {
        return errorLBL;
    }

    public void setErrorLBL(Label errorLBL) {
        this.errorLBL = errorLBL;
    }

    private Button  addBTN ;

    public TextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public void setPhoneNumberField(TextField phoneNumberField) {
        this.phoneNumberField = phoneNumberField;
    }

    public TextField getAddressFLD() {
        return addressFLD;
    }

    public void setAddressFLD(TextField addressFLD) {
        this.addressFLD = addressFLD;
    }

    public TextField getNameField() {
        return nameField;
    }


    public TextField getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(TextField lastNameField) {
        this.lastNameField = lastNameField;
    }


    public Button getAddBTN() {
        return addBTN;
    }

    public void setAddBTN(Button addBTN) {
        this.addBTN = addBTN;
    }

    public AddContactPage() {
        Label nameLBL = new Label("Name : ")  ;
        nameField = new TextField() ;


        Label lastNameLBL = new Label("LastName : ")  ;
        lastNameField = new TextField() ;


        Label phoneNumberLBL = new Label("Phone Number : ")  ;
        phoneNumberField = new TextField() ;

        Label addressLBL = new Label("Address : ")  ;
        addressFLD = new TextField() ;


        addBTN = new Button("Add Contact");

        VBox lbls = new VBox(nameLBL,lastNameLBL,phoneNumberLBL,addressLBL);
        lbls.setAlignment(Pos.CENTER_LEFT);
        lbls.setSpacing(5);

        VBox fields = new VBox(nameField,lastNameField,phoneNumberField,addressFLD);
        fields.setAlignment(Pos.CENTER_LEFT);
        fields.setSpacing(5);

        errorLBL = new Label("");
        errorLBL.setAlignment(Pos.CENTER);


        HBox hBox = new HBox(lbls,fields);
        hBox.setAlignment(Pos.CENTER);

        this.setSpacing(15);

        this.getChildren().addAll(hBox,addBTN,errorLBL);
        this.setAlignment(Pos.CENTER);

    }

}
