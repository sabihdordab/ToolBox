package View;


import Model.Contact;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PhoneBookPage extends BorderPane {


    private Button addBTN;
    private Button removeBTN;
    private Button saveBTN ;
    private Button editBTN ;

    public Button getEditBTN() {
        return editBTN;
    }

    public void setEditBTN(Button editBTN) {
        this.editBTN = editBTN;
    }

    public Button getSaveBTN() {
        return saveBTN;
    }

    public void setSaveBTN(Button saveBTN) {
        this.saveBTN = saveBTN;
    }

    private TableView<Contact> tableView ;

    public TableView<Contact> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Contact> tableView) {
        this.tableView = tableView;
    }

    public Button getAddBTN() {
        return addBTN;
    }

    public void setAddBTN(Button addBTN) {
        this.addBTN = addBTN;
    }

    public Button getRemoveBTN() {
        return removeBTN;
    }

    public void setRemoveBTN(Button removeBTN) {
        this.removeBTN = removeBTN;
    }



    public PhoneBookPage()
    {
        creatNewElement();
        TableColumn<Contact,String> nameCol = new TableColumn<>("Name") ;
        TableColumn<Contact,String> lastnameCol = new TableColumn<>("Last Name ") ;
        TableColumn<Contact,String> phoneNumberCol = new TableColumn<>("Phone Number") ;
        TableColumn<Contact,String> addressCol = new TableColumn<>("Address") ;

        //nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableView.getColumns().addAll(nameCol,lastnameCol,phoneNumberCol,addressCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vBox = new VBox(addBTN,removeBTN,editBTN,saveBTN);
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.BASELINE_CENTER);

        this.setCenter(tableView);
        this.setRight(vBox);

    }


    public void creatNewElement(){

        addBTN = new Button("Add Contact");
        addBTN.setMaxWidth(Double.MAX_VALUE);

        removeBTN = new Button("Remove Contact");
        removeBTN.setMaxWidth(Double.MAX_VALUE);

        saveBTN= new Button("Save In File") ;
        saveBTN.setMaxWidth(Double.MAX_VALUE);

        editBTN= new Button("Edit Contact") ;
        editBTN.setMaxWidth(Double.MAX_VALUE);

        tableView = new TableView<>();
    }


}

