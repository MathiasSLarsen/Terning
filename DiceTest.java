import static org.junit.Assert.*;

/**
 * Created by Matt_Lab on 26/09/2016.
 */
public class DiceTest {
    terning.Dice dice = new terning.Dice();
    @org.junit.Test
    public void roll() throws Exception {
        int value;
        int en = 0;
        int to = 0;
        int tre = 0;
        int fier = 0;
        int fem = 0;
        int seks = 0;
        int fokertnr = 0;

        for(int i =0; i<60000; i++){
            value = dice.roll();
           // System.out.println(value + " ");
            switch (value){
                case 1: en++;
                    break;
                case 2: to++;
                    break;
                case 3: tre++;
                    break;
                case 4: fier++;
                    break;
                case 5: fem++;
                    break;
                case 6: seks++;
                    break;
                default: fokertnr++;
                    break;
            }

        }
        assertEquals(0, fokertnr);
        assertEquals(10000, en , 400);
        assertEquals(10000, to , 400);
        assertEquals(10000, tre , 400);
        assertEquals(10000, fier , 400);
        assertEquals(10000, fem , 400);
        assertEquals(10000, seks , 400);


    }


//    @org.junit.Test
//    public void rollMultiple() throws Exception {
//
//    }

}