package cinema;

import java.util.Scanner;

public class Cinema {

    public static int row;

    public static int col;

    private static int purchasedTickets;

    private static double percentagTicketsBooked = 0.00;

    private static int currentIncome;

    private static int totalIncome;

    public static char[][] seats;

    public static final int MAX_ROW = 9;

    public static final int MIN_ROW = 1;

    public static final int MIN_COL = 1;

    public static final int MAX_COL = 9;

    private static int totalTickets;

    private static final int SMALL_CINEMA_THRESHOLD = 60;

    private static final int PREMIUM_SEAT_PRICE = 10;

    private static final int REGULAR_SEAT_PRICE = 8;

    public static void main(String[] args) {
        // Write your code here
        int rowSelected, colSelected, ticketPrice;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        row = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        col = s.nextInt();
        seats = new char[row + 1][col + 1];
        totalIncome=computeTotalIncome();
        totalTickets = row * col; //total tickets
        fillSeatMatrix();
        //  displaySeats(seats,row,col);//display the seats
        int choice;
        while (true) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            choice = s.nextInt();
            if (choice == 0) //Exit if 0
            {
                System.out.println("See you again!");
                break;
            }
            switch (choice) {
                //display seats
                case 1:
                    displaySeats();
                    break;
                //book ticket and update seat matrix
                case 2:
                    //Ask the user for seat selection until the user selects a seat which is not booked and which is valid
                    while (true) {
                        System.out.println("Enter a row number:");
                        rowSelected = s.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        colSelected = s.nextInt();
                        if (!isValidSeats(rowSelected, colSelected))//check if selected seats are valid
                        {
                            System.out.println("Wrong input!");
                            continue;

                        }
                        ticketPrice = buyTicket(rowSelected, colSelected);
                        if (ticketPrice == -1) //if seat is already booked
                            System.out.println("That ticket has already been purchased!");
                        else {
                            System.out.println("Ticket price: $" + ticketPrice); //display ticket price
                            break;
                        }

                    }
                    break;
                case 3:
                    showStatistics();
                    break;

                default:
                    System.out.println("Enter valid choice(0,1,2,3)");// Take only valid input from user


            }


        }


    }


    private static int buyTicket(int rowSelected, int colSelected) {
        //check if seat is booked
        if (seats[rowSelected][colSelected] == 'B')
            return -1;

        //if seat is available for booking
        int ticketPrice = computeTicketPrice(rowSelected, colSelected);
        updateStatistics(ticketPrice);
        updateSeatMatrixAfterSeatSelection(rowSelected, colSelected);

        return ticketPrice;

    }

    //this fills the array with character and prepares it for display
    private static void fillSeatMatrix() {
        seats[0][0] = ' ';
        for (int i = 1; i <= col; i++) {
            seats[0][i] = (char) (i + '0');  //i->1 to col
        }

        for (int i = 1; i <= row; i++) {
            seats[i][0] = (char) (i + '0');
            for (int j = 1; j <= col; j++)
                seats[i][j] = 'S';
        }
    }


    private static int computeTicketPrice(int seatRow, int seatCol) {
        int seats = row * col;
        if (seats <=SMALL_CINEMA_THRESHOLD)
            return 10;
        else
            return seatRow <= row / 2 ? PREMIUM_SEAT_PRICE : REGULAR_SEAT_PRICE;//for front seats 10 dollar and for back seats 8


    }


    //display movie seat arrangements
    private static void displaySeats() {
        System.out.println("Cinema:");

        for (int i = 0; i <= row; i++) {

            for (int j = 0; j <= col; j++)
                System.out.print(seats[i][j] + " ");
            System.out.println();
        }


    }

    //this method updates the seat arrangement replacing the seat selected by user with 'B'
    private static void updateSeatMatrixAfterSeatSelection(int rowSelected, int colSelected) {
        seats[rowSelected][colSelected] = 'B';


    }

    private static void showStatistics() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentagTicketsBooked);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);

    }

    private static boolean isValidSeats(int rowSelected, int colSelected) {
        return ((rowSelected >= MIN_ROW && rowSelected <= MAX_ROW) && (colSelected >= MIN_COL && colSelected <= MAX_COL));
    }


    private static void updateStatistics(int ticketPrice) {
        purchasedTickets++;
        currentIncome += ticketPrice;
        percentagTicketsBooked = (purchasedTickets / totalTickets) * 100;
    }


    private static int computeTotalIncome() {
        int totalSeats = row * col;

        if (totalSeats <= 60) {
            // Small cinema: all seats $10
            return totalSeats * 10;
        } else {
            // Large cinema: front half $10, back half $8
            int frontRows = row / 2;
            int backRows = row - frontRows;

            int frontIncome = frontRows * col * 10;  // Front rows: $10 each
            int backIncome = backRows * col * 8;     // Back rows: $8 each

            return frontIncome + backIncome;
        }
    }

}