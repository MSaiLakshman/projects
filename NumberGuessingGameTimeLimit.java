import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class NumberGuessingGameTimeLimit {

    public static void startGame(int range, int maxAttempts, int timeLimit){
        Random random=new Random();
        int numberToGuess=random.nextInt(range)+1;
        int attempts=0;
        boolean hasWon=false;
        Scanner sc=new Scanner(System.in);

        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                System.out.println("\n. Time's up!! The correct answer is: "+numberToGuess);
                timer.cancel();
                System.exit(0);
            }
        }; timer.schedule(timerTask, timeLimit*1000);

        System.out.println("Welcome to Number Guessing game: ");
        System.out.println("Please select the number within the range: "+range);
        System.out.println("You have "+maxAttempts+" to guess the correct answer");

        while(attempts<maxAttempts) {
            System.out.println("Enter the guess: ");
            int numberGuess = sc.nextInt();
            attempts++;

            if (numberGuess == numberToGuess) {
                hasWon = true;
                timer.cancel();
                break;
            } else if (numberGuess < numberToGuess) {
                System.out.println("Number too less, Increase the number");
            } else {
                System.out.println("Number too high, Decrease the number");
            }
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }
            if(hasWon){
                System.out.println("You have guessed the correct number "+numberToGuess);
            }
            else{
                System.out.println("You have failed to guess the correct number. The correct answer is "+numberToGuess);
            }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range in which you want to guess the number: ");
        System.out.println("1. 1 to 100");
        System.out.println("2. 1 to 1000");
        int choice = sc.nextInt();
        int range;
        int maxAttempts;
        int timeLimit;
        if(choice==1){
            range=100;
            maxAttempts=10;
            timeLimit=30;
        } else if (choice==2) {
            range=1000;
            maxAttempts=15;
            timeLimit=60;
        } else {
            System.out.println("Invalid choice. ");
            range = 100;
            maxAttempts = 10;
            timeLimit = 30; // 30 seconds
        }

        startGame(range,maxAttempts,timeLimit);
    }
}
