package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    private static String[][] cinema;
    private static int numOfTickets = 0;
    private static int currIncome = 0;
    private static int totalIncome = 0;

    private static int numOfRows;
    private static int numOfSeats;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.

        System.out.println("Enter the number of rows:");
        int numOfRows = Integer.parseInt(sc.nextLine()); //reads string.
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = Integer.parseInt(sc.nextLine()); //reads string.

        //Cinema builder
        buildCinema(numOfRows, numOfSeats);

        String exit = "";
        while ( exit != "exit"){

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int value = sc.nextInt();

            switch (value ){
                case 0:
                     return;
                case 1:
                    printCinema();
                    break;
                case 2:
                    buyTickets(numOfRows, numOfSeats);
                    break;
                case 3:
                    printStats(numOfRows, numOfSeats);
                }
        }
    }
    private static void printCinema(){
        System.out.println("Cinema:");
        for (String[] x : cinema)
        {
            for (String y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
    private static void buyTickets(int numOfRows, int numOfSeats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNumVal = Integer.parseInt(sc.nextLine()); //reads string.
        System.out.println("Enter a seat number in that row:");
        int seatRowVal = Integer.parseInt(sc.nextLine()); //reads string.

        if(rowNumVal <0 || rowNumVal > numOfRows || numOfSeats < 0 || seatRowVal > numOfSeats) {
            System.out.println("Wrong input!");
            buyTickets(numOfRows, numOfSeats);
        } else if (cinema[rowNumVal][seatRowVal] == "B"){
            System.out.println("That ticket has already been purchased!");
            buyTickets(numOfRows,numOfSeats);
        } else{
            cinema[rowNumVal][seatRowVal] = "B";
            numOfTickets += 1;
            if (numOfRows * numOfSeats > 60) {
                if (rowNumVal > numOfRows / 2) {
                    System.out.println("Ticket price: $8");
                    currIncome += 8;
                } else {
                    System.out.println("Ticket price: $10");
                    currIncome += 10;
                }
            }else{
                System.out.println("Ticket price: $10");
                currIncome += 10;
            }
        }

    }
    private static void buildCinema( int rowNum, int seatRow){
        cinema = new String[rowNum+1][seatRow+1];
        cinema[0][0] = " ";
        for ( int i = 1; i <= seatRow; i++){
            cinema[0][i] = String.valueOf(i);
        }
        for ( int i = 1; i <= rowNum; i++ ){
            cinema[i][0] = String.valueOf(i);
            for( int j = 1; j <= seatRow;j++ ){
                cinema[i][j] = "S";
            }
        }
        if (rowNum * seatRow > 60) {
//                System.out.println("Ticket price: $8");
                totalIncome += rowNum * seatRow / 2 * 8;
                totalIncome += rowNum * seatRow / 2 * 10;
        }else{
            System.out.println("Ticket price: $10");
            totalIncome = rowNum * seatRow * 10;
            currIncome += 10;
        }
    }
    private static void printStats(int numOfRows, int numOfSeats){
        float totalTickets = numOfRows*numOfSeats;
        float percentage = numOfTickets/totalTickets*100;
        String myFloat = String.format("%.2f",percentage);
        System.out.printf("Number of purchased tickets: %d\n", numOfTickets);
        System.out.println("Percentage: " + myFloat + "%");
        System.out.printf("Current income: $%d\n", currIncome);
        System.out.printf("Total income: $%d\n", totalIncome);

    }
}