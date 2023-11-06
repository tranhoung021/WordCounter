import java.util.ArrayList;
import java.util.List;

public class WordCounter {
    private List<String> longestWords = new ArrayList<>();
    private int lineCount = 0;
    private int wordCount = 0;
    private int charCount = 0;
    private StringBuilder allInputs = new StringBuilder();
    private boolean continueCounting = true;

    public void counter(String text) {
        if (text.equals("stop")) {
            continueCounting = false;
            return;
        }
        if(!text.isEmpty()) {
            String[] words = text.trim().split("\\s");
            wordCount += words.length;
            charCount += text.replaceAll("\\s", "").length();
            for (String word : words) {
                String wordWithoutPeriod = word.replace(".", "");
                if (wordWithoutPeriod.length() > getLongestWordLength()) {
                    longestWords.clear();
                    longestWords.add(wordWithoutPeriod);
                } else if (wordWithoutPeriod.length() == getLongestWordLength() && !longestWords.contains(wordWithoutPeriod)) {
                    longestWords.add(wordWithoutPeriod);
                }
            }
            allInputs.append(text).append("\n");
            lineCount++;
        }
    }

    public boolean shouldContinue() {
        return continueCounting;
    }

    public String getAllInputs() {
        return allInputs.toString();
    }
    private int getLongestWordLength() {
        return longestWords.isEmpty() ? 0 : longestWords.get(0).length();
    }

    public String getLongestWords() {
        return String.join(", ", longestWords);
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }
}