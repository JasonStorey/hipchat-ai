package com.jasonstorey.hipchat.ai;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class HipchatAITest {

    private HipchatAI hipchatAI;
    private Brain brain;
    private List<Message> messages;

    @Before
    public void setup() {
        brain = mock(Brain.class);
        messages = new ArrayList<Message>();
        messages.add(mock(Message.class));
        hipchatAI = new HipchatAI(brain, messages);
    }

    @Test
    public void callingTrainShouldPassMessageListToBrain() {
        hipchatAI.train();
        verify(brain, times(1)).train(messages);
    }
}