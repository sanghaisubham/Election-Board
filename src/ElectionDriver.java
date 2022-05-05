import service.ConsoleUtility;
import service.ElectionServiceImpl;

public class ElectionDriver {
    public static void main(String[] args){
        ElectionServiceImpl electionService = new ElectionServiceImpl();

        System.out.println("Enter the citizen information of the city");
        System.out.println("=========================================");
        electionService.addCitizens();

        System.out.println("Enter the candidate details");
        System.out.println("=========================================");
        electionService.addCandidates();

        System.out.println("The candidates contesting in election are:");
        System.out.println("=========================================");
        electionService.getElectionDetails();
        System.out.println("=========================================");

        while (true){
            System.out.println("");
            System.out.println("ENTER 1 FOR ADDING RATING");
            System.out.println("ENTER 2 FOR REMOVING RATING");
            System.out.println("ENTER 3 FOR ADDING IDEA");
            System.out.println("ENTER 0 TO EXIT");
            System.out.println("Please Enter your choice");
            int option= ConsoleUtility.inputNumber();
            boolean exit=false;
            switch (option) {
                case 1 -> {
                    System.out.println("Add Rating");
                    System.out.println("=========================================");
                    electionService.addRating();
                }
                case 2 -> {
                    System.out.println("Remove Rating");
                    System.out.println("=========================================");
                    electionService.removeRating();
                }
                case 3 -> {
                    System.out.println("Add Idea");
                    System.out.println("=========================================");
                    electionService.addIdea();
                }
                default -> exit = true;
            }
            if(exit) {
                System.out.println("Exiting from the Menu");
                break;
            }
        }
        electionService.decideWinner();
    }
}
