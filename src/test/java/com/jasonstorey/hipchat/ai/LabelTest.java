package com.jasonstorey.hipchat.ai;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LabelTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void labelIsConstructedWithCorrectName() {
        String labelName = "Bobby McFerrin";
        Label label = new Label(labelName);

        assertEquals(labelName, label.getName());
    }

    @Test
    public void returnsOccurrencesOfTokens() {
        String labelName = "Bobby McFerrin";
        String[] tokens = {"here", "are", "some", "tokens"};

        Label label = new Label(labelName);
        label.addTokens(tokens);

        assertEquals(new Integer(1), label.getOccurrences("tokens"));

        String[] moreTokens = {"more", "tokens"};
        label.addTokens(moreTokens);
        assertEquals(new Integer(2), label.getOccurrences("tokens"));
    }

    @Test
    public void returnsZeroOccurrencesIfTokenIsNotFound() {
        String labelName = "Bobby McFerrin";
        String[] tokens = {"tokens"};

        Label label = new Label(labelName);
        label.addTokens(tokens);

        assertEquals(new Integer(0), label.getOccurrences("gadzukes"));
    }
}
