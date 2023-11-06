import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestRunner {

    @Test
    public void testCharCount() {
        WordCounter wordCounter = new WordCounter();
        String text = "This is a test sentence.";
        int expected = 20;
        wordCounter.counter(text);
        int actual = wordCounter.getCharCount();
        assertEquals(expected, actual);

    }

    @Test
    public void testLineCount() {
        WordCounter wordCounter = new WordCounter();
        String[] texts = {"Testing first row.", "Testing second row.", "Testing third row."};
        int expected = texts.length;

        for (String text : texts) {
            wordCounter.counter(text);
        }

        int actual = wordCounter.getLineCount();
        assertEquals(expected, actual);
    }


    @Test
    public void testWordCount() {
        WordCounter wordCounter = new WordCounter();
        String text = "Testing amount of words";
        int expected = 4;
        wordCounter.counter(text);
        int actual = wordCounter.getWordCount();
        assertEquals(expected, actual);
    }


    @Test
    public void testMultipleLongestWords() {
        WordCounter wordCounter = new WordCounter();
        String text = "Testing the longest word.";
        String expected = "Testing, longest";
        wordCounter.counter(text);
        String actual = wordCounter.getLongestWords();
        assertEquals(expected, actual);
    }

    @Test
    public void testStopCommand() {
        WordCounter wordCounter = new WordCounter();
        String text = "stop";
        boolean expected = false;
        wordCounter.counter(text);
        boolean actual = wordCounter.shouldContinue();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfPeriodCounts() {
        WordCounter wordCounter = new WordCounter();
        String text = "Testing.if.periods.count.";
        int expected = 25;
        wordCounter.counter(text);
        int actual = wordCounter.getCharCount();
        assertEquals(expected, actual);
    }

}
