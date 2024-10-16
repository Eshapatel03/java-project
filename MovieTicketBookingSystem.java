import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private String title;
    private int availableSeats;

    public Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int number) {
        if (number <= availableSeats) {
            availableSeats -= number;
        } else {
            System.out.println("Not enough seats available!");
        }
    }
}

class Booking {
    private String movieTitle;
    private int numberOfTickets;

    public Booking(String movieTitle, int numberOfTickets) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;
    }

    public String toString() {
        return "Movie: " + movieTitle + ", Tickets: " + numberOfTickets;
    }
}

public class MovieTicketBookingSystem {
    private List<Movie> movies;
    private List<Booking> bookings;
    private Scanner scanner;

    public MovieTicketBookingSystem() {
        movies = new ArrayList<>();
        bookings = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeMovies();
    }

    private void initializeMovies() {
        movies.add(new Movie("Movie A", 10));
        movies.add(new Movie("Movie B", 5));
        movies.add(new Movie("Movie C", 20));
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - Available Seats: " + movie.getAvailableSeats());
        }
    }

    public void bookTickets() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        Movie selectedMovie = null;

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie != null) {
            System.out.print("Enter number of tickets to book: ");
            int tickets = scanner.nextInt();
            scanner.nextLine();

            selectedMovie.bookSeats(tickets);
            bookings.add(new Booking(selectedMovie.getTitle(), tickets));
            System.out.println("Booking successful!");
        } else {
            System.out.println("Movie not found!");
        }
    }

    public void viewBookings() {
        System.out.println("Your Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of available seats: ");
        int availableSeats = scanner.nextInt();
        scanner.nextLine();

        movies.add(new Movie(title, availableSeats));
        System.out.println("Movie added successfully!");
    }

    public static void main(String[] args) {
        MovieTicketBookingSystem system = new MovieTicketBookingSystem();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View Bookings");
            System.out.println("4. Add Movie");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = system.scanner.nextInt();
            system.scanner.nextLine();

            switch (choice) {
                case 1:
                    system.displayMovies();
                    break;
                case 2:
                    system.bookTickets();
                    break;
                case 3:
                    system.viewBookings();
                    break;
                case 4:
                    system.addMovie();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}
