import java.util.Scanner;

public class ElectionDriver {
    public static void main(String[] args){
        ElectionBoard board = new ElectionBoard();

        System.out.println("Enter the citizen information of the city");
        System.out.println("=========================================");
        board.addCitizens();

        System.out.println("Enter the candidate details");
        System.out.println("=========================================");
        board.addCandidates();

        System.out.println("The candidates contesting in election are:");
        System.out.println("=========================================");
        board.electionDetails();
        System.out.println("=========================================");

        while (true){
            System.out.println("");
            System.out.println("ENTER 1 FOR ADDING RATING");
            System.out.println("ENTER 2 FOR REMOVING RATING");
            System.out.println("ENTER 3 FOR ADDING IDEA");
            System.out.println("ENTER 0 TO EXIT");
            System.out.println("Please Enter your choice");
            Scanner sc= new Scanner(System.in);
            int option=Integer.parseInt(sc.nextLine());
            boolean exit=false;
            switch (option) {
                case 1 -> {
                    System.out.println("Add Rating");
                    System.out.println("=========================================");
                    board.addRating();
                }
                case 2 -> {
                    System.out.println("Remove Rating");
                    System.out.println("=========================================");
                    board.removeRating();
                }
                case 3 -> {
                    System.out.println("Add Idea");
                    System.out.println("=========================================");
                    board.addIdea();
                }
                default -> exit = true;
            }
            if(exit) {
                System.out.println("Exiting from the Menu");
                break;
            }
        }
        board.decideWinner();
    }
}
