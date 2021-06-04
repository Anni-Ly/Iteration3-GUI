package sample;

import java.util.ArrayList;

public class PatientRegister {
    public ArrayList<Patient> patients;
    public PatientRegister() {
        this.patients = new ArrayList<Patient>();
    }
    public void addPatient(Patient patient) throws Exception{
        Boolean contains = false;
        for (Patient patient1 : patients) {
            if (patient1.getCpr().equals(patient.getCpr())) {
                contains = true;
            };

        }

        if (! contains) {
            this.patients.add(patient);
        } else {
            throw new Exception("Already in list");
        }
    }
    public void removePatient(Patient patient) {
        if (this.patients.contains(patient)) {this.patients.remove(patient);}
    }
    public void printPatients() {
        System.out.println("Number of patients: " + this.patients.size());
        for (Patient p : this.patients) {
            System.out.println("Name:" + p.getFirstName() +" "+ p.getLastName() + " - "+
                    "CoronaData" + p.getCoronaData() + " - " +
                    "CoronaLocation" + p.getCoronaLocation() + " - " +
                    "SensorData" + p.getSenorData() + " - " +
                    "CPR-number: " + p.getCpr() + " - " +
                    "Gender: " + p.getGender() +" - " +
                    "Age: " + p.getAge());

        }
    }

    public String listPatients() {
        String returnString;
        returnString="Number of patients: " + this.patients.size() +"\n\n";
        returnString+="+-------------+--------------------------------+--------+-----+------------------+----------------------------------+\n";
        returnString+="| CPR-number  | Name                           | Gender | Age | Phone            | Email                            |\n";
        returnString+="| Corona Data | Corona Location               | Sensor Data |                                                      |\n";
        returnString+="+=============+================================+========+=====+==================+==================================+\n";

        for (Patient p : this.patients) {
            String fullName = p.getFirstName()+" "+p.getLastName();
            String newLine = String.format("| %11s | %-30s | %-6s | %3d | %-16s | %-32s |\n",
                    p.getCpr(),fullName,p.getGender(),p.getAge(),p.getPhoneNumber(),p.getEmail(),p.getCoronaData(),p.getCoronaLocation(),p.getSenorData());
            String newLine2 = String.format("| %11s | %-30s | %-66s |\n",
                    p.getCoronaData(),p.getCoronaLocation(),p.getSenorData());
            returnString += newLine;
            returnString += newLine2;
            returnString+="+=============+================================+========+=====+==================+==================================+\n";

        }
        return returnString;
    }

    @Override
    public String toString() {
        return "PatientRegister{" +
                "patients=" + patients +
                '}';
    }
}
