package edu.drexel.se320;

import edu.drexel.se320.Min;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Exceptions {

    @Test
    public void testExceptions() {
	Exception exception = assertThrows(UnsupportedOperationException.class,
			/* The bit between this and the next comment is a 
			 * *lambda expression*: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
			 * If you've taken PL, this is Java's lambda.
			 * If not, this is like special syntax for a function object with one method.
			 * Notice the form is:
			 *   _args_ -> { body } */
			() -> { throw new UnsupportedOperationException("Bad jasdf;lkasdjlfk"); }
			/* end of lambda expression. The () at the beginning is the (empty)
			 * argument list of the lambda */
			); // <-- This is closing off the call to assertThrows
	// Here you can use any methods on the Exception type to inspect whether the right exception was thrown.
     	assertEquals("Bad Operation", exception.getMessage());   
    }

}


