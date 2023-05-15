package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex10Test {
    @Test
    public void shortString() {
        assertTrue("Short string".length() < 15);
    }

    @Test
    public void longString() {
        assertTrue("Very long string with many additional words".length() < 15, "length more than 15");
    }
}
