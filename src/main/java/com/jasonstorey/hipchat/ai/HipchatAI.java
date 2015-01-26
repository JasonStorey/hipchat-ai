package com.jasonstorey.hipchat.ai;

import java.util.List;

public class HipchatAI {

    private Brain brain;
    private List<Message> messages;

    public HipchatAI(Brain brain, List<Message> messages) {
        this.brain = brain;
        this.messages = messages;
    }

    public void train() {
        brain.train(messages);
    }
}
