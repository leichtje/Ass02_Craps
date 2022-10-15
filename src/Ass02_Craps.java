import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner in = new Scanner(System.in);


        int die1 = 0;
        int die2 = 0;
        int crapsRoll =0;
        int thePoint;
        boolean playAgain=false;
        String shouldContinue="";


        do {
            System.out.println("Welcome to the game of Craps. Following is your first roll");
            die1 = rand.nextInt(6)+1;
            die2 = rand.nextInt(6)+1;
            crapsRoll = die1 + die2;
            System.out.println("Your roll consisted of: " + die1 + " and " + die2);
            System.out.println("For a Craps Roll of: " + crapsRoll);

            if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("You win! Congratulations!");
            } else if (crapsRoll == 2 || crapsRoll ==3 || crapsRoll ==12) {
                System.out.println("You have crapped out!");
            }else{
                thePoint=die1 + die2;
                System.out.println("The point is: " + thePoint + " You are now trying for the point.");
                do {
                    die1=rand.nextInt(6)+1;
                    die2=rand.nextInt(6)+1;
                    crapsRoll = die1 + die2;
                    System.out.println("Your next roll was: " + die1 + " and " + die2 + ". For a Craps Roll of: " + crapsRoll);
                    if (crapsRoll == thePoint){
                        System.out.println("You rolled the point. You Win!");
                        continue;
                    } else if (crapsRoll == 7) {
                        System.out.println("You crapped out!");
                        continue;
                    }else{
                        System.out.println("You did not roll the point or have crapped out.  Try for the point again. Roll again.");
                    }

                }while(!(crapsRoll == thePoint || crapsRoll == 7));
            }


            System.out.println("Do you want to play again [Y/N]");
            if (in.hasNext()) {
                shouldContinue = in.nextLine();//Receive a string input from user
                if (shouldContinue.equalsIgnoreCase("N")) {
                    playAgain = true;
                }
            }
        }while (!playAgain) ;

    }
}
