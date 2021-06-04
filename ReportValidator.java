package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportValidator {


    public static boolean isValidDato(String strDate) {
        if (strDate == null || strDate.isEmpty()) { 
            System.out.println("Given value can not be null or empty");
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        try {
            formatter.parse(strDate);
            System.out.println(strDate + " is valid date format");
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(strDate + " is Invalid Date format");
            return false;
        }
    }

    public static boolean isValidCoronaVariant(String CoronaVariant) {

        if (CoronaVariant.length() > 1 &&
                CoronaVariant.chars().allMatch(Character::isAlphabetic)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidPostnr(String Postnr) {
        boolean yes = false;
        if (Postnr.matches("[0-9]+") && Postnr.length() == 4) {
            yes = true;
        }
        return yes;
    }
}




