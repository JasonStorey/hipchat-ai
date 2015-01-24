package com.jasonstorey.hipchat.ai;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TokeniserTest {

    @Test
    public void shouldExtractTokens_fromSimpleString() throws Exception {
        String textMessage = "here is a simple string";
        String[] expectedTokens = {"here", "is", "a", "simple", "string"};

        assertArrayEquals(expectedTokens, Tokeniser.extractTokens(textMessage));
    }

    @Test
    public void shouldExtractTokens_fromStringWithLeadingWhitespace() throws Exception {
        String textMessage = "\n\t   here is \t a simple string\n";
        String[] expectedTokens = {"here", "is", "a", "simple", "string"};

        assertArrayEquals(expectedTokens, Tokeniser.extractTokens(textMessage));
    }
}