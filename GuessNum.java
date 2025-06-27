import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;

        System.out.println("🔢 Welcome to the Number Guessing Game!");

        System.out.print("Enter the number of rounds you want to play: ");
        int numRounds = sc.nextInt();

        System.out.print("Enter the maximum number of attempts per round: ");
        int maxAttempts = sc.nextInt();

        for(int round = 1; round <= numRounds; round++){
            int numToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrect = false;

            System.out.println("\n🎮 Round " + round + " - Guess the number between 1 and 100");

            while(attempts < maxAttempts){
                System.out.print("Attempt: " + (attempts + 1) + "/" + maxAttempts + " - Your Guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if(userGuess > numToGuess){
                    System.out.println("📈 Too High!");
                }
                else if(userGuess < numToGuess){
                    System.out.println("📉 Too Low!");
                }
                else{
                    System.out.println("✅ Correct! You guessed the number in: " + (attempts) + "attempt(s).");
                    guessedCorrect = true;
                    break;
                }
            }
        int roundScore = 0;
        if(guessedCorrect){
            roundScore = maxAttempts = attempts + 1;
            System.out.println("Score for Round " + round + " is " + roundScore);
        }
        else {
        System.out.println("❌ You have exhausted all attempts. The correct number to be guessed was: " + numToGuess);
        roundScore = 0;
        }

        totalScore += roundScore;
        System.out.println("🎯 Round " + round + " score: " + roundScore);
        }
        
        System.out.println("\n 🏁 Game Over! Your total score after " + numRounds + " round(s) " + totalScore);
        sc.close();

    }
    
}
