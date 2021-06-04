package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


import java.time.LocalDate;

public class ReportController1 {
    public Label labelDato;
    public TextField DatoText;
    public Label labelPostnr;
    public TextField PostnrText;
    public Label labelCoronaVariant;
    public TextField CoronaVariantText;
    public TextArea ReportListTextArea;
    public Button buttonSearch;
    public Button buttonClearAll;
    public Button buttonExportSelected;
    public Button buttonClearResults;

    @FXML
    private GridPane grid;

    private ReportRegister reportRegister = new ReportRegister();

    private void clearTextFields(GridPane grid) {
        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                // clear
                ((TextField) node).setText("");
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
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }


    public void initialize() {

        Report r1 = new Report("2020-05-31", "2650", "dansk");
        Report r2 = new Report("2020-05-31", "2610", "indisk");
        r1.setDato("2020/05/31");
        r1.setPostnr("2650");
        r1.setCoronaVariant("dansk");

        System.out.println(r1);

        r2.setDato("2020-05-31");
        r2.setPostnr("2610");
        r2.setCoronaVariant("indisk");

        System.out.println(r2);

        try {
            reportRegister.addReport(r1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            reportRegister.addReport(r2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        reportRegister.printReports();
        System.out.println(reportRegister);

        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setFont(Font.font("Courier New", 11));
            }
        }

        for (Node node : grid.getChildren()) {
            if (node instanceof Label) {
                node.setStyle("-fx-border-color:white; -fx-background-color: white; -fx-padding:4px");
            }
        }

        ReportListTextArea.setText(reportRegister.listReports());

    }

    public void addReport(ActionEvent actionEvent) {
        String DatoInput = DatoText.getText();
        String PostnrInput = PostnrText.getText();
        String CoronaVariantInput = capitalize(CoronaVariantText.getText());
        boolean validInput = true;



        if (!ReportValidator.isValidDato(DatoInput)) {
            DatoText.setStyle("-fx-background-color: pink");
            validInput = false;
        }
        if (!ReportValidator.isValidPostnr(PostnrInput)) {
            PostnrText.setStyle("-fx-background-color: pink");
            validInput = false;

        }
        if (CoronaVariantInput.isEmpty() || !ReportValidator.isValidCoronaVariant(CoronaVariantInput)) {
            CoronaVariantText.setStyle("-fx-background-color: pink");
            validInput = false;
        }


        if (validInput) {
            Report r = new Report(DatoInput, PostnrInput, CoronaVariantInput);
            r.setDato(DatoInput);
            r.setPostnr(PostnrInput);
            try {
                reportRegister.addReport(r);
                clearTextFields(grid);
                resetTextFields(grid);
            } catch (Exception e) {

                e.printStackTrace();

                DatoText.setStyle("-fx-background-color: pink");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Registration problem");
                alert.setContentText("Dato " + DatoInput + " already found in register");

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
        ReportListTextArea.setText(reportRegister.listReports());

    }

    public void onClearAll (ActionEvent actionEvent){
        clearTextFields(grid);
    }

    public void onExportSelected(ActionEvent actionEvent) {
    }

    public void onClearResults(ActionEvent actionEvent) {
    }
}
