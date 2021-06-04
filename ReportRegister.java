package sample;

import java.util.ArrayList;

public class ReportRegister {
    public ArrayList<Report> reports;
    public ReportRegister() {
        this.reports = new ArrayList<Report>();
    }
    public void addReport(Report report) throws Exception{
        Boolean contains = false;
        for (Report report1 : reports) {
            if (report1.getDato().equals(report.getDato())) {
                contains = true;
            };

        }
    }
    public void removeReport(Report report) {
        if (this.reports.contains(report)) {this.reports.remove(report);}
    }

    public void printReports() {
        System.out.println("Number of reports: " + this.reports.size());
        for (Report r : this.reports) {
            System.out.println("Dato:" + r.getDato() + " - "+
                    "Postnr" + r.getPostnr() + " - " +
                    "CoronaVariant" + r.getCoronaVariant());

        }
    }

    public String listReports() {
        String returnString;
        returnString="Number of reports: " + this.reports.size() +"\n\n";
        returnString+="+-------+--------+----------------+---------------------+\n";
        returnString+="| Dato  | Postnr | CoronaVariant  | Smittetal           |\n";
        returnString+="+=======+========+================+=====================+\n";

        for (Report r : this.reports) {
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
