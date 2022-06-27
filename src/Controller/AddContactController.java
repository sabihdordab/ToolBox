package Controller;


import Model.Contact;
import View.AddContactPage;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.regex.Pattern;

public class AddContactController {
    private AddContactPage addContact ;
    private PhoneBookController phoneBookController ;

    public AddContactController(PhoneBookController phoneBookController)
    {
        addContact = new AddContactPage();
        this.phoneBookController = phoneBookController ;

        addContact.getAddBTN().setOnAction(e -> {

            String name = addContact.getNameField().getText();
            String lastName = addContact.getLastNameField().getText();
            String phoneNumber= addContact.getPhoneNumberField().getText();
            String address = addContact.getAddressFLD().getText();
            Label errorLBL = addContact.getErrorLBL() ;

            if (Pattern.matches("^[A-Za-z]+$",name))
            {

                if (Pattern.matches("^[A-Za-z]+$",lastName))
                {

                    if (phoneNumber != null && Pattern.matches("^\\+989[0-9]{9}$",phoneNumber) || Pattern.matches("^09[0-9]{9}$",phoneNumber) ||Pattern.matches("^00989[0-9]{9}",phoneNumber))
                    {
                        Contact contact = new Contact(name,lastName,phoneNumber,address);

                            if (isContactThere(contact))
                            {

                                errorLBL.setTextFill(Color.GREEN);
                                errorLBL.setText("Contact Added");
                                errorLBL.setStyle("-fx-border-color: green");
                                phoneBookController.addContactToTable(contact);
                                phoneBookController.contacts.add(contact);

                            }
                            else
                            {
                                errorLBL.setTextFill(Color.RED);
                                errorLBL.setText(" contact added before ");
                                errorLBL.setStyle("-fx-border-color: red");
                            }
                    }
                    else {
                        errorLBL.setTextFill(Color.RED);
                        errorLBL.setText("invalid phoneNumber");
                        errorLBL.setStyle("-fx-border-color: red");
                    }

                }
                else
                {
                    errorLBL.setTextFill(Color.RED);
                    errorLBL.setText("invalid lastname");
                    errorLBL.setStyle("-fx-border-color: red");

                }

            }
            else {

                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid name");
                errorLBL.setStyle("-fx-border-color: red");
            }

        });
    }

    public AddContactPage getAddContact()
    {
        return addContact;
    }

    public Boolean isContactThere(Contact contact)
    {
        Boolean scale = true ;
        for (int i = 0 ; i < phoneBookController.contacts.size() ; i++)
        {
            if(phoneBookController.contacts.get(i).getPhoneNumber().equals(contact.getPhoneNumber()))
            {
                scale = false;
                break;
            }
        }
        return scale ;
    }

}

