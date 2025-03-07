package com.example.javamavenjunithelloworld;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Unit test for Hello.
 * <p/>
 * A unit test aims to test all code and code paths of a specific class.
 */
public class HelloTest {

    @Test
    public void testSayHello() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Hello hi = new Hello();
        hi.sayHello(stream);
        //assertThat(os.toString(), is(equalTo(Hello.HELLO + "\n")));
        assertThat(os.toString(), is(equalTo(Hello.HELLO + "\n")));
    }

    @Test
    public void testSayHelloAFewTimes() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(os, true);

        Hello hi = new Hello();
        hi.setTimes(3);
        hi.sayHello(stream);

        // Does it say "Hello!" three times?
        String goal = Hello.HELLO + "\n" + Hello.HELLO + "\n" + Hello.HELLO + "\n";
       // assertThat(os.toString(), is(equalTo(goal)));
        assertThat(os.toString(), is(equalTo(goal)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentForHello21() {
        Hello hi = new Hello();
        hi.setTimes(Hello.MAXIMUM_AMOUNT_OF_TIMES + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentForHelloNegative() {
        Hello hi = new Hello();
        hi.setTimes(-1);
    }
}
