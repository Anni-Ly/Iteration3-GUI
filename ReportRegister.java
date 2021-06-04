package sample;

import java.util.ArrayList;

public class ReportRegister {
    // An arraylist that will hold the registered patients
    public ArrayList<Report> reports;
    // Constructor - EXPLAIN
    public ReportRegister() {
        this.reports = new ArrayList<Report>();
    }
    public void addReport(Report report) throws Exception{
        // fill in code here
        Boolean contains = false;
        for (Report report1 : reports) {
            if (report1.getDato().equals(report.getDato())) {
                contains = true;
            };

        }
       // if (! contains) {
         //   this.reports.add(report);
        //} else {
          //  throw new Exception("Already in list");
      //  }
    }
    // The method should remove the patientToRemove from the patients list.
    public void removeReport(Report report) {
        if (this.reports.contains(report)) {this.reports.remove(report);}
        // fill in code here
    }

    // The method should first print the current number of patients in the patients-list.
    // Then loop through the patients in the patients-list,
    // and print out their name and cpr.
    public void printReports() {
        // Fill in code here
        System.out.println("Number of reports: " + this.reports.size());
        for (Report r : this.reports) {
            System.out.println("Dato:" + r.getDato() + " - "+
                    "Postnr" + r.getPostnr() + " - " +
                    "CoronaVariant" + r.getCoronaVariant());

        }
    }

    public String listReports() {
        // Fill in code here
        String returnString;
        returnString="Number of reports: " + this.reports.size() +"\n\n";
        returnString+="+-------+--------+----------------+---------------------+\n";
        returnString+="| Dato  | Postnr | CoronaVariant  | Smittetal           |\n";
        returnString+="+=======+========+================+=====================+\n";

        for (Report r : this.reports) {

            //String newLine = String.format("CPR-number: %11s  Name: %-30s  Gender: %6s  Age: %3d  Phone: %16s  Email: %s\n",
            //        p.getCpr(),fullName,p.getGender(),p.getAge(),p.getPhoneNumber(),p.getEmail());
            String newLine = String.format("| %11s | %-6s | %-30s |\n",
                    r.getDato(),r.getPostnr(),r.getCoronaVariant());
            returnString += newLine;
            returnString+="=======+========+==============+=====+====================+\n";

        }
        return returnString;
    }

    @Override
    public String toString() {
        return "ReportRegister{" +
                "reports=" + reports +
                '}';
    }
}
