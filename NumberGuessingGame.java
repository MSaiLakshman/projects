import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void startGame(int range, int maxAttempts){
        Random random=new Random();
        int numberToGuess=random.nextInt(range)+1;
        int attempts=0;
        boolean hasWon=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Number Guessing Game");
        System.out.println("Please select the number within the "+range);
        System.out.println("You have "+maxAttempts+" to attemps to guess the correct number\n");

        while(attempts<maxAttempts){
            System.out.print("Enter your guess: ");
            int playerGuess=sc.nextInt();
            attempts++;
            if(playerGuess==numberToGuess){
                hasWon=true;
                break;
            }
            else if(playerGuess<numberToGuess){
                System.out.println("Number too less, Increase the number");
            }
            else{
                System.out.println("Number too high, Decrease the number");
            }
            System.out.println("Attempts remaining: "+(maxAttempts-attempts));
        }

        if (hasWon)
            System.out.println("Congratulations you guessed the correct number: \n"+numberToGuess+" in "+attempts+" attempts");
        else
            System.out.println("Sorry you have completed all the attempts. The correct answer is : "+numberToGuess);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range in which you want to guess the number: ");
        System.out.println("1. 1 to 100");
        System.out.println("2. 1 to 1000");
        int choice = sc.nextInt();
        int range;
        int maxAttempts;

        if(choice==1){
            range=100;
            maxAttempts=10;
        } else if (choice==2) {
            range=1000;
            maxAttempts=15;
        }
        else{
            System.out.println("Invalid choice. ");
            range=100;
            maxAttempts=10;
        }
        startGame(range, maxAttempts);
    }
}
