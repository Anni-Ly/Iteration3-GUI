package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public static boolean isValidCPR(String cpr) {
        Boolean result = false;
        if (cpr.length() == 11) {
            result = true;
        } else {
            return false;
        }
        String birthday = cpr.substring(0,6);
        Character hyphen = cpr.charAt(6);
        String lastNumber = cpr.substring(7,11);
        try { 
            int d = Integer.parseInt(birthday);
        } catch (NumberFormatException nfe) {
            System.out.println("First part is not a number");
            return false;
        }
        if (! hyphen.equals('-')) {
            System.out.println("Missing hyphen");
            return false; };
        try { 
            int running = Integer.parseInt(lastNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Last part is not a number");
            return false;
        }
      
        if (cpr.matches("^[0-9]{6}-[0-9]{4}$")) {
            System.out.println("matches regex");
            result = true;

        } else {
            result = false;
        }

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMuu");
            LocalDate b = LocalDate.parse(birthday, dateFormatter);
        }
        catch (DateTimeParseException dtpe) {
            System.err.println("Illegal birthday:"+birthday.toString());
            return false;

        }

        return result;
    }
    public static boolean isValidName(String name) {

        if (name.length() > 1 &&
                name.chars().allMatch(Character::isAlphabetic)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        final String EMAIL_PATTERN =
                "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                        + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        final String PHONE_PATTERN =
                "^\\+(?:[0-9] ?){6,14}[0-9]$";

        Pattern pattern = Pattern.compile(PHONE_PATTERN);

        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();

    }

    public static boolean isValidCoronaLocation(String CoronaLocation) {
        String testcenter = "testcenter";
        return CoronaLocation.toLowerCase().startsWith(testcenter);
    }


    public static boolean isValidCovidData (String CoronaData ) {
        System.out.println(CoronaData);
        if (CoronaData.toLowerCase().trim().equals("positive") || CoronaData.toLowerCase().trim().equals("negative")) {
            return true;
        } else {
            return false;
        }

    }

}






