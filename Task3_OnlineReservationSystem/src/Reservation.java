public class Reservation {
    private int pnrNumber;
    private String passengerName;
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String classType;
    private double ticketPrice;
    public Reservation(
            int pnrNumber,
            String passengerName,
            int trainNumber,
            String trainName,
            String source,
            String destination,
            String classType,
            double ticketPrice) {
        this.pnrNumber = pnrNumber;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.classType = classType;
        this.ticketPrice = ticketPrice;
    }
    public int getPnrNumber() {
        return pnrNumber;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public int getTrainNumber() {
        return trainNumber;
    }
    public String getTrainName() {
        return trainName;
    }
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public String getClassType() {
        return classType;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setClassType(String classType) {
        this.classType = classType;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public void displayReservation() {
        System.out.println("\n=================================");
        System.out.println("       RESERVATION DETAILS");
        System.out.println("=================================");
        System.out.println("PNR Number      : " + pnrNumber);
        System.out.println("Passenger Name  : " + passengerName);
        System.out.println("Train Number    : " + trainNumber);
        System.out.println("Train Name      : " + trainName);
        System.out.println("Source          : " + source);
        System.out.println("Destination     : " + destination);
        System.out.println("Class Type      : " + classType);
        System.out.println("Ticket Price    : ₹" + ticketPrice);
        System.out.println("=================================");
    }
}