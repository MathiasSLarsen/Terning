package terning;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Matt_Lab on 26/09/2016.
 */
public class DiceTest {
    terning.Dice dice = new terning.Dice();

    // Declares variables
    @org.junit.Test
    public void roll() throws Exception {
        int value;
        int en = 0;
        int to = 0;
        int tre = 0;
        int fire = 0;
        int fem = 0;
        int seks = 0;
        int forkertnr = 0;

        // Rolling the dice 60000 times.
        // Counts the values a specific value has been rolled.

        for (int i = 0; i < 60000; i++) {
            value = dice.roll();
            // System.out.println(value + " ");
            switch (value) {
                case 1:
                    en++;
                    break;
                case 2:
                    to++;
                    break;
                case 3:
                    tre++;
                    break;
                case 4:
                    fire++;
                    break;
                case 5:
                    fem++;
                    break;
                case 6:
                    seks++;
                    break;
                default:
                    forkertnr++;
                    break;
            }

        }

        // Tests the program.
        // Checks if all values, of the dice (1-6), has been rolled and equal amount of times (10000/60000)
        // with a deviation of 400 times.
        assertEquals(0, forkertnr);
        assertEquals(10000, en, 400);
        assertEquals(10000, to, 400);
        assertEquals(10000, tre, 400);
        assertEquals(10000, fire, 400);
        assertEquals(10000, fem, 400);
        assertEquals(10000, seks, 400);


    }

    // Specifies the OutputStream and puts it in an array
    //region Print-out Test (http://stackoverflow.com/questions/1119385/junit-test-for-system-out-println)
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // The output-console outputs to the new OutputStream array "outContent"
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    // Tests if the program has rolled the dice multiple times.
    @org.junit.Test
    public void rollMultiple() throws Exception {
        dice.rollMultiple(1);
        assertEquals(true, Pattern.matches("\\d.", outContent.toString()));
        outContent.reset();

        dice.rollMultiple(3);
        assertEquals(true, Pattern.matches("\\d.\\d.\\d.", outContent.toString()));
    }
    //endregion

}