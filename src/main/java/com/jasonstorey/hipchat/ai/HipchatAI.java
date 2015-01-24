package com.jasonstorey.hipchat.ai;

import java.util.List;

public class HipchatAI {

    private Brain brain;

    public HipchatAI(Brain brain, List<Message> messages) {
        this.brain = brain;
    }
}
