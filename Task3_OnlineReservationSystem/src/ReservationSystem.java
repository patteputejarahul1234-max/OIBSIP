import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReservationSystem {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int pnrCounter = 1001;
    private final String FILE_NAME = "reservations.txt";
    public ReservationSystem() {
        loadReservationsFromFile();
    }
    public void addReservation() {
        scanner.nextLine();
        System.out.println("\n===== ADD RESERVATION =====");
        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine();
        while (passengerName.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Enter again: ");
            passengerName = scanner.nextLine();
        }
        System.out.print("Enter Train Number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter Source Station: ");
        String source = scanner.nextLine();
        System.out.print("Enter Destination Station: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Class Type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter Ticket Price: ₹");
        double ticketPrice = scanner.nextDouble();
        Reservation reservation = new Reservation(
                pnrCounter,
                passengerName,
                trainNumber,
                trainName,
                source,
                destination,
                classType,
                ticketPrice);
        reservations.add(reservation);
        saveReservationsToFile();
        System.out.println("\nReservation added successfully.");
        System.out.println("Generated PNR Number: " + pnrCounter);
        pnrCounter++;
    }
    public void displayReservations() {
        System.out.println("\n===== ALL RESERVATIONS =====");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation reservation : reservations) {
            reservation.displayReservation();
        }
    }
    public void searchReservation() {
        System.out.print("\nEnter PNR Number to search: ");
        int pnrNumber = scanner.nextInt();
        for (Reservation reservation : reservations) {
            if (reservation.getPnrNumber() == pnrNumber) {
                System.out.println("\nReservation Found:");
                reservation.displayReservation();
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
    public void updateReservation() {
        System.out.print("\nEnter PNR Number to update: ");
        int pnrNumber = scanner.nextInt();
        scanner.nextLine();
        for (Reservation reservation : reservations) {
            if (reservation.getPnrNumber() == pnrNumber) {
                System.out.print("Enter New Passenger Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Train Number: ");
                int newTrainNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter New Train Name: ");
                String newTrainName = scanner.nextLine();
                System.out.print("Enter New Source Station: ");
                String newSource = scanner.nextLine();
                System.out.print("Enter New Destination Station: ");
                String newDestination = scanner.nextLine();
                System.out.print("Enter New Class Type: ");
                String newClassType = scanner.nextLine();
                System.out.print("Enter New Ticket Price: ₹");
                double newTicketPrice = scanner.nextDouble();
                reservation.setPassengerName(newName);
                reservation.setTrainNumber(newTrainNumber);
                reservation.setTrainName(newTrainName);
                reservation.setSource(newSource);
                reservation.setDestination(newDestination);
                reservation.setClassType(newClassType);
                reservation.setTicketPrice(newTicketPrice);
                saveReservationsToFile();
                System.out.println("\nReservation updated successfully.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
    public void cancelReservation() {
        System.out.print("\nEnter PNR Number to cancel: ");
        int pnrNumber = scanner.nextInt();
        for (Reservation reservation : reservations) {
            if (reservation.getPnrNumber() == pnrNumber) {
                reservations.remove(reservation);
                saveReservationsToFile();
                System.out.println("\nReservation cancelled successfully.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
    private void saveReservationsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Reservation reservation : reservations) {
                writer.write(
                        reservation.getPnrNumber() + "," +
                        reservation.getPassengerName() + "," +
                        reservation.getTrainNumber() + "," +
                        reservation.getTrainName() + "," +
                        reservation.getSource() + "," +
                        reservation.getDestination() + "," +
                        reservation.getClassType() + "," +
                        reservation.getTicketPrice()
                );
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving reservation data.");
        }
    }
    private void loadReservationsFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int pnr = Integer.parseInt(data[0]);
                String passengerName = data[1];
                int trainNumber = Integer.parseInt(data[2]);
                String trainName = data[3];
                String source = data[4];
                String destination = data[5];
                String classType = data[6];
                double ticketPrice = Double.parseDouble(data[7]);
                Reservation reservation = new Reservation(
                        pnr,
                        passengerName,
                        trainNumber,
                        trainName,
                        source,
                        destination,
                        classType,
                        ticketPrice);
                reservations.add(reservation);
                if (pnr >= pnrCounter) {
                    pnrCounter = pnr + 1;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading reservation data.");
        }
    }
}