package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


import java.time.LocalDate;

public class PatientController {
    public Label cprLabel;
    public TextField cprText;
    public Label labelFirstName;
    public TextField firstNameText;
    public Label labelLastName;
    public TextField lastNameText;
    public Label labelPhone;
    public TextField phoneText;
    public TextField emailText;
    public Label labelEmail;
    public TextArea patientListTextArea;
    public Button buttonAdd;
    public Button buttonClearAll;
    public TextField coronaDataText;
    public TextField coronaLocationText;
    public TextField sensorDataText;

    @FXML
    private GridPane grid;


    private PatientRegister patientRegister= new PatientRegister();

    private void clearTextFields(GridPane grid) {
        // Simple method to clear the text fields in a grid
        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
                node.setStyle(null);
            }
        }
    }

    private void resetTextFields(GridPane grid) {
        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                System.out.println(node.getStyle());
                // clear
                if (node.getStyle() != null && !node.getStyle().equals("")) {
                    ((TextField) node).setText("");
                    node.setStyle(null);
                }
            }
        }
    }
    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public void initialize() {

        Patient p1 = new Patient("Lars","Lonesen","120920-9877", "Positiv", "København V"," bodytemperature 37°C" );
        Patient p2 = new Patient("Signe","Vestergaard","011202-1234", "Negativ" , "Jyllinge","bodytemperature 37.2°C");
        p1.setPhoneNumber("+45 78338272");
        p1.setEmail("mand@ku.dk");
        p1.setCoronaData("Positive");
        p1.setCoronaLocation("København V");
        p1.setSenorData("bodytemperature 37°C");

        System.out.println(p1);

        p1.setEmail("mand@ku.dk");

        System.out.println("email changed\n"+p1);

        p2.setPhoneNumber("+45 26374637");
        p2.setEmail("kvinde@ku.dk");
        p2.setCoronaData("Negative");
        p2.setCoronaLocation("Jyllinge");
        p2.setSenorData("Bodytemperature 37.2°C");

        System.out.println(p2);

        try {
            patientRegister.addPatient(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            patientRegister.addPatient(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        patientRegister.printPatients();
        System.out.println(patientRegister);

        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                ((TextField)node).setFont(Font.font ("Courier New", 11));
            }
        }

        for (Node node : grid.getChildren()) {
            if (node instanceof Label) {
                node.setStyle("-fx-border-color:white; -fx-background-color: white; -fx-padding:4px");
            }
        }

        patientListTextArea.setText(patientRegister.listPatients());

    }

    public void onAddPatient(ActionEvent actionEvent) {
        String cprInput= cprText.getText();
        String firstNameInput= capitalize(firstNameText.getText());
        String lastNameInput= capitalize(lastNameText.getText());
        String phoneInput = phoneText.getText();
        String emailInput = emailText.getText();
        String coronaDataInput = capitalize(coronaDataText.getText());
        String coronaLocationInput = capitalize(coronaLocationText.getText());
        String sensorDataInput = sensorDataText.getText();
        boolean validInput= true;


        if (!DataValidator.isValidCPR(cprInput)){
            cprText.setStyle("-fx-background-color: pink");
            validInput = false;

        }
        if (!emailInput.isEmpty() && ! DataValidator.isValidEmail(emailInput)){
            emailText.setStyle("-fx-background-color: pink");
            validInput = false;
        }

        if (!phoneInput.isEmpty()  && ! DataValidator.isValidPhone(phoneInput)){
            phoneText.setStyle("-fx-background-color: pink");
        }

        if (firstNameInput.isEmpty() || ! DataValidator.isValidName(firstNameInput)){
            firstNameText.setStyle("-fx-background-color: pink");
            validInput = false;
        }

        if (lastNameInput.isEmpty() || ! DataValidator.isValidName(lastNameInput)){
            lastNameText.setStyle("-fx-background-color: pink");
            validInput = false;
        }

        if (coronaDataInput.isEmpty() || ! DataValidator.isValidCovidData(coronaDataInput)){
            coronaDataText.setStyle("-fx-background-color: pink");
            validInput = false;
        }

        if (coronaLocationInput.isEmpty() || ! DataValidator.isValidCoronaLocation(coronaLocationInput)){
            coronaLocationText.setStyle("-fx-background-color: pink");
            validInput = false;
        }



        if (validInput) {
            Patient p = new Patient(firstNameInput,lastNameInput,cprInput,coronaDataInput,coronaLocationInput,sensorDataInput);
            p.setPhoneNumber(phoneInput);
            p.setEmail(emailInput);
            try {
                patientRegister.addPatient(p);
                clearTextFields(grid);
                resetTextFields(grid);
            } catch (Exception e) {

                e.printStackTrace();

                cprText.setStyle("-fx-background-color: pink");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //alert.setTitle("Error Dialog");
                alert.setHeaderText("Registration problem");
                alert.setContentText("CPR-number " + cprInput +" already found in register");

                alert.showAndWait();
                clearTextFields(grid);
                resetTextFields(grid);
            }

        } else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Registration problem");
            alert.setContentText("Correct highlighted fields");


            alert.showAndWait();
            resetTextFields(grid);
        }
        patientListTextArea.setText(patientRegister.listPatients());

    }

    public void onClearAll(ActionEvent actionEvent) {
        clearTextFields(grid);
    }
}
