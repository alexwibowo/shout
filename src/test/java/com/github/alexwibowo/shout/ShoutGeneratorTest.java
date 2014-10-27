package com.github.alexwibowo.shout;

import org.junit.Test;

import static com.github.alexwibowo.shout.ShoutGenerator.ShoutStyle.BOLD;
import static com.github.alexwibowo.shout.ShoutGenerator.ShoutStyle.ITALIC;
import static com.github.alexwibowo.shout.ShoutGenerator.shout;

/**
 * User: alexwibowo
 */
public class ShoutGeneratorTest {

    @Test
    public void testPlain() {
        System.out.println(shout("EXPLODE"));
    }

    @Test
    public void testItalic() {
        System.out.println("===================");
        System.out.println(shout("Hi there", ITALIC, 25));
        System.out.println("===================");
    }

    @Test
    public void testBold() {
        System.out.println("===================");
        System.out.println(shout("Careful!", BOLD, 15));
        System.out.println("===================");
    }
}
