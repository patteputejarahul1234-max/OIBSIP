import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=================================");
            System.out.println(" ONLINE RESERVATION SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Reservation");
            System.out.println("2. Display All Reservations");
            System.out.println("3. Search Reservation");
            System.out.println("4. Update Reservation");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    system.addReservation();
                    break;
                case 2:
                    system.displayReservations();
                    break;
                case 3:
                    system.searchReservation();
                    break;
                case 4:
                    system.updateReservation();
                    break;
                case 5:
                    system.cancelReservation();
                    break;
                case 6:
                    System.out.println("\nExiting Reservation System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }
}