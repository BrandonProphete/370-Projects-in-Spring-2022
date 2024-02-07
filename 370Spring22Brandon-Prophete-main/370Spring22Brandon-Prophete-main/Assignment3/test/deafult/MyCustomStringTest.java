package deafult;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.qc.seclass.MyCustomString;
import edu.qc.seclass.MyCustomStringInterface;
import edu.qc.seclass.MyIndexOutOfBoundsException;

import static org.junit.Assert.assertEquals;


public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    //Checks special characters, numbers, and letters with spaces too
    public void testCountNumbers2() {
        mycustomstring.setString("1!2 @3#4 $5 6&ABCD");
        assertEquals(6, mycustomstring.countNumbers());
    }
    
    //Checks if a NullPointerException is thrown by the method when string is null
    @Test (expected = NullPointerException.class)
    public void testCountNumbers3() {
          mycustomstring.setString(null);
          mycustomstring.countNumbers();
    }

    @Test
    //Checks if 3 7 8 9 are treated as 4 numbers or as one number
    public void testCountNumbers4() {
         mycustomstring.setString("3 7 8 9");
         assertEquals(4, mycustomstring.countNumbers());
    }

    @Test
    //Checks to see what happens when numbers are mixed with letters
    public void testCountNumbers5() {
        mycustomstring.setString("H8y man");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    //Checks to see if this is counted as one number
    public void testCountNumbers6() {
        mycustomstring.setString("12");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = NullPointerException.class)
    //Checks if NullPointerException is thrown when string is null and is greater than 0, from ending
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
           mycustomstring.setString(null);
           mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true);
    }

    @Test//Checks if empty string is returned when n is greater than the string
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
           mycustomstring.setString("lonnnnnnnnnog");
           assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(30, true));
    }

    @Test(expected = IllegalArgumentException.class)
    //Checks if an IllegalArgumentException is thrown the method has a negative n, start from beginning
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
          mycustomstring.setString("Hello people peeeple Helllloo");
          mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-6, false);
    }

    @Test(expected = NullPointerException.class)
  //Checks if NullPointerException is thrown when string is null and is greater than 0, from beginning
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
          mycustomstring.setString(null);
          mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
       //Checks for every second Nth, start from beginning
        mycustomstring.setString("Pizz6 1s s0 good");
        assertEquals("iz ss o", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
  //Checks for every second Nth, start from ending
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
       mycustomstring.setString("Pizz6 1s s0 good");
       assertEquals("z61 0go", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test(expected = IllegalArgumentException.class)
  //Checks if an IllegalArgumentException is thrown the method has a negative n, start from ending
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
       mycustomstring.setString("Hello people peeeple Helllloo");
       mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-6, true);
    }

    @Test
    //Checks if the method works with only letters in the string, start from beginning
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("Freddy Fazbear Pizzas");
        assertEquals("dz a", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test
  //Checks if the method works with only letters in the string, start from ending
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
       mycustomstring.setString("Freddy Fazbear Pizzas");
       assertEquals("r ei", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true));
    }

    @Test
  //Checks if the method works with only numbers in the string, start from beginning
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("234567879");
        assertEquals("58", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
  //Checks if the method works with only numbers in the string, start from ending
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
       mycustomstring.setString("234567879");
       assertEquals("47", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    //Checks if the method is affected by more spaces between words, start from beginning
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("Your   New   Name");
        assertEquals("u e a", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    
    //Checks if MyIndexOutOfBoundsException is thrown
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("");
        mycustomstring.convertDigitsToNamesInSubstring(0, 1);
    }
    
    //Checks if NullPointerException is thrown
    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring3() {
         mycustomstring.setString(null);
         mycustomstring.convertDigitsToNamesInSubstring(0,0);
    }

    //Checks if IllegalArgumentException is thrown
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("");
        mycustomstring.convertDigitsToNamesInSubstring(2, 1);
    }

    @Test
    //Checks when converting one number to a string using the method
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("10");
        mycustomstring.convertDigitsToNamesInSubstring(1, 2);
        assertEquals("OneZero", mycustomstring.getString());
    }

    @Test
    //Checks when converting two numbers to a string using the method
    public void testConvertDigitsToNamesInSubstring6() {
       mycustomstring.setString("10 10");
       mycustomstring.convertDigitsToNamesInSubstring(1, 5);
       assertEquals("OneZero OneZero", mycustomstring.getString());
    }

    @Test
    //Checks if there are no numbers in the string that start at 1 
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("This is a string with no numbers");
        mycustomstring.convertDigitsToNamesInSubstring(1, 6);
        
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    //Checks whether the method convertDigitsToNamesInSubstrings throws an MyIndexOutOfBoundsException if endPositioon is greater than the string
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("");
        mycustomstring.convertDigitsToNamesInSubstring(1, 2);
    }

}
