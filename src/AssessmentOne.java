// github link : https://github.com/452154/OOP-A1
// video link  :https://scuonline-my.sharepoint.com/:f:/g/personal/y_qin_12_student_scu_edu_au/EopIE9l7vcVJrrTSZDOlsdABf6AHO1r2xIkTV7svusAMUw?e=uOou7U

import java.util.ArrayList;

public class AssessmentOne {
    public static void main(String[] args) {
        System.out.println("Part 3");
        // Create GeneralPractitioner and NursePractitioner objects using constructors with arguments,
        // and then call the print methods inside the objects.
        GeneralPractitioner gp1 = new GeneralPractitioner("1001", "Devin", "General Practitioner", 15);
        gp1.printInformation();
        System.out.println("------------------------------------");
        GeneralPractitioner gp2 = new GeneralPractitioner("1002", "Nice", "General Practitioner", 10);
        gp2.printInformation();
        System.out.println("------------------------------------");
        GeneralPractitioner gp3 = new GeneralPractitioner("1003", "Tom", "General Practitioner", 6);
        gp3.printInformation();
        System.out.println("------------------------------------");


        NursePractitioner np1 = new NursePractitioner("1004", "Yang", "Nurse Practitioner", 20);
        np1.printInformation();
        System.out.println("------------------------------------");
        NursePractitioner np2 = new NursePractitioner("1005", "Ming", "Nurse Practitioner", 7);
        np2.printInformation();

        System.out.println();
        System.out.println("Part 5");
        //Declares an ArrayList that can store instances of the Appointment class.
        ArrayList<Appointment> appointments = new ArrayList<>();

        // Use the createAppointment method to add an appointment
        createAppointment(appointments, "Alice", "1234567890", "08:00", gp1);
        createAppointment(appointments, "Bob", "0987654321", "10:00", gp2);
        createAppointment(appointments, "Charlie", "1122334455", "14:30", np1);
        createAppointment(appointments, "David", "2233445566", "08:00", np2);

        printExistingAppointments(appointments);

        cancelBooking(appointments, "1234567890"); // Cancel Alice's reservation

        printExistingAppointments(appointments);
    }

    //Create an appointment method, pass in an appointments parameter and all the parameters for the patient,
    // and then add an appointments object.
    public static void createAppointment(ArrayList<Appointment> appointments, String patientName, String patientPhone,
                                         String Time, HealthProfessional selectedHealthProfessional) {
        appointments.add(new Appointment(patientName, patientPhone, Time, selectedHealthProfessional));
    }

    // Create a printExistingAppointments method, pass in an appointments parameters.
    // If the appointments variable is not empty, print all the appointment information for the arraylist.
    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        }
        else {
            for (Appointment appointment: appointments) {
                appointment.printAppointmentInformation();
                System.out.println("------------------------------------");
            }
        }
    }

    // Creates a cancelBooking method that returns a Boolean value, passing in an appointments parameter and a phone parameter.
    // Go through all the appointment information in the arraylist,
    //  if the phone and the patient's phone are the same, remove the appointment.
    public static boolean cancelBooking(ArrayList<Appointment> appointments, String phone) {
        for (Appointment appointment : appointments) {
            if (appointment.patientPhone == phone) {
                System.out.println("Appointment cancelled for patient: " + appointment.patientName);
                appointments.remove(appointment);
                return true;
            }
        }
        System.out.println("No appointment found for phone: " + phone);
        return false;
    }
}
