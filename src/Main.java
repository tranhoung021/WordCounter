import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        WordCounter wordCounter = new WordCounter();
        System.out.println("Type stop to quit");
        while (wordCounter.shouldContinue()) {
            String text = scan.nextLine();
            wordCounter.counter(text);
        }

        System.out.println("You wrote: \n" + wordCounter.getAllInputs());
        System.out.println("Amount of characters: " + wordCounter.getCharCount());
        System.out.println("Amount of rows: " + wordCounter.getLineCount());
        System.out.println("Amount of words: " + wordCounter.getWordCount());
        System.out.println("Longest word(s): " + wordCounter.getLongestWords());
    }
}