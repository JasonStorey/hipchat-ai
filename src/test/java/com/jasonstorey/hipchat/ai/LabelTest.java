package com.jasonstorey.hipchat.ai;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LabelTest {

    private String labelName;

    @Before
    public void setUp() throws Exception {
        labelName = "Bobby McFerrin";
    }

    @Test
    public void labelIsConstructedWithCorrectName() {
        Label label = new Label(labelName);

        assertEquals(labelName, label.getName());
    }

    @Test
    public void returnsCountOfTokenOccurrences() {
        String[] tokens = {"here", "are", "some", "tokens"};

        Label label = new Label(labelName);
        label.addTokens(tokens);

        assertEquals(new Integer(1), label.getOccurrencesOfToken("tokens"));

        String[] moreTokens = {"more", "tokens"};
        label.addTokens(moreTokens);
        assertEquals(new Integer(2), label.getOccurrencesOfToken("tokens"));
    }

    @Test
    public void returnsZeroTokenOccurrencesIfTokenIsNotFound() {
        String[] tokens = {"tokens"};

        Label label = new Label(labelName);
        label.addTokens(tokens);

        assertEquals(new Integer(0), label.getOccurrencesOfToken("gadzukes"));
    }

    @Test
    public void incrementsLabelOccurrenceCounter() {
        Label label = new Label(labelName);
        assertEquals(new Integer(0), label.getOccurrences());

        label.incrementOccurrences();
        assertEquals(new Integer(1), label.getOccurrences());

        label.incrementOccurrences();
        assertEquals(new Integer(2), label.getOccurrences());
    }
}
