package com.jasonstorey.hipchat.ai;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BrainTest {

    private Brain brain;
    private List<Message> messages;
    private Message mockMessage1;
    private Message mockMessage2;
    private final static String mockName = "James Bob";
    private final static String mockContent = "here is a typical message from Jim Bob";
    private final static String mockTime = "12:00:00";
    private final static String mockContentWithMultiples = "typical message from typical Jim Bob";


    @Before
    public void setup() {
        brain = new Brain();
        messages = new ArrayList<>();
        mockMessage1 = mock(Message.class);
        mockMessage2 = mock(Message.class);
        when(mockMessage1.getName()).thenReturn(mockName);
        when(mockMessage1.getContent()).thenReturn(mockContent);
        when(mockMessage1.getTime()).thenReturn(mockTime);
        when(mockMessage2.getName()).thenReturn(mockName);
        when(mockMessage2.getContent()).thenReturn(mockContentWithMultiples);
        when(mockMessage2.getTime()).thenReturn(mockTime);
    }

    @Test
    public void trainStoresLabelsInMemory() throws Exception {
        messages.add(mockMessage1);

        brain.train(messages);

        Label label = brain.getMemory().get(mockName);
        assertEquals(mockName, label.getName());
    }

    @Test
    public void trainStoresTokenOccurrencesInMemory() throws Exception {
        messages.add(mockMessage1);
        messages.add(mockMessage2);

        brain.train(messages);

        Label label = brain.getMemory().get(mockName);
        int occurrencesOfHere = label.getOccurrences("here");
        int occurrencesOfTypical = label.getOccurrences("typical");

        assertEquals(1, occurrencesOfHere);
        assertEquals(3, occurrencesOfTypical);
    }

    @Test
    public void memoryShouldNotParseNullMessages() {
        String aNewLabel = "Bobby Fisher";
        int numOfValidMessages = 2;
        when(mockMessage2.getName()).thenReturn(aNewLabel);
        messages.add(mockMessage1);
        messages.add(mockMessage2);
        messages.add(null);

        brain.train(messages);

        assertEquals(numOfValidMessages, brain.getMemory().size());
    }
}