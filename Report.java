package sample;

import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Report {

    private String Dato;
    private String Postnr;
    private String CoronaVariant;
    private String Smittetal;


    public Report(String Dato, String Postnr, String CoronaVariant) {
        this.Dato=Dato;
        this.Postnr=Postnr;
        this.CoronaVariant=CoronaVariant;
    }

    public String getPostnr() {
        return Postnr;
    }

    public void setPostnr(String Postnr) {
        this.Postnr = Postnr;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato=Dato;
    }

    public String getCoronaVariant() {
        return CoronaVariant;
    }

    public void setCoronaVariant(String CoronaVariant) {
        this.CoronaVariant=CoronaVariant;
    }



    @Override
    public String toString() {
        return "Report{" +
                "Dato='" + Dato + '\'' +
                ", Postnr='" + Postnr + '\'' +
                ", CoronaVariant'" + CoronaVariant + '\'' +
                ", Smittetal='" + Smittetal + '\'' +
                '}';
    }
}


