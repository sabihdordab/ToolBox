package Controller;

import Model.Contact;
import View.PhoneBookPage;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneBookController {

    public ArrayList<Contact> contacts = new ArrayList<>();

    private PhoneBookPage phoneBookPage ;

    public PhoneBookPage getPhoneBookPage() {

        return phoneBookPage;
    }

    public PhoneBookController()
    {
        phoneBookPage = new PhoneBookPage() ;

        phoneBookPage.getAddBTN().setOnAction(e -> {

            AddContactController addContactController = new AddContactController(this);
            Stage addContactStage = new Stage();
            addContactStage.setScene(new Scene(addContactController.getAddContact()));
            addContactStage.setWidth(1000);
            addContactStage.setHeight(700);
            addContactStage.show();
        });

        phoneBookPage.getRemoveBTN().setOnAction(e -> {
            Contact selectedContact = phoneBookPage.getTableView().getSelectionModel().getSelectedItem();
            if (selectedContact != null)
            {
                phoneBookPage.getTableView().getItems().remove(selectedContact);
                for (Contact contact : contacts)
                {
                    if (contact.equals(selectedContact))
                    {
                        contacts.remove(contact);
                        break;
                    }
                }
                phoneBookPage.getSaveBTN().setText("Save In File");
            }
        });

        phoneBookPage.getSaveBTN().setOnAction(e -> {
            SaveContactsInFile();
            phoneBookPage.getSaveBTN().setText("Saved");

        });

        phoneBookPage.getEditBTN().setOnAction(e -> {

//            Contact selectedContact = phoneBookPage.getTableView().getSelectionModel().getSelectedItem();
//            if (selectedContact != null)
//            {
//            }


        });

    }

    public void addContactToTable(Contact contact)
    {
        phoneBookPage.getTableView().getItems().add(contact);
    }


    public void SaveContactsInFile()
    {
        String fileName = "contacts.txt";
        try {
            File file = new File(fileName);

                FileWriter myWriter = new FileWriter(fileName);
                for (Contact contact : contacts)
                {
                    myWriter.write(contact.getName() +"\t");
                    myWriter.write(contact.getLastname() +"\t");
                    myWriter.write(contact.getPhoneNumber() +"\t");
                    myWriter.write(contact.getAddress() +"\t"+"\n");
                }
                myWriter.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

