package airline;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int seatsAvailable;

    public Flight(String flightNumber, String source, String destination, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void bookTicket() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Sorry, no seats available on this flight.");
        }
    }
}

public class AirlineTicketBooking {
    private List<Flight> flights;

    public AirlineTicketBooking() {
        flights = new ArrayList<>();
        // Adding sample flights
        flights.add(new Flight("FL001", "New York", "Los Angeles", 100));
        flights.add(new Flight("FL002", "Los Angeles", "New York", 80));
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight.getFlightNumber() + ": " + flight.getSource() + " to " + flight.getDestination() +
                    " (" + flight.getSeatsAvailable() + " seats available)");
        }
    }

    public void bookTicket(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flight.bookTicket();
                return;
            }
        }
        System.out.println("Invalid flight number.");
    }

    public static void main(String[] args) {
        AirlineTicketBooking bookingSystem = new AirlineTicketBooking();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. View available flights");
            System.out.println("2. Book a ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookingSystem.displayAvailableFlights();
                    break;
                case 2:
                    System.out.print("Enter the flight number to book a ticket: ");
                    String flightNumber = scanner.next();
                    bookingSystem.bookTicket(flightNumber);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
        scanner.close();
    }
}
