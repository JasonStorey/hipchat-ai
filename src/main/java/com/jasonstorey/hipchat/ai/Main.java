package com.jasonstorey.hipchat.ai;

import java.util.List;

public class Main {

    public static void main( String[] args ) {
        MessageLoader messageLoader = new MessageLoader();

        List<Message> messages = messageLoader.parseFromJson(args[0]);

        Brain brain = new Brain();
        HipchatAI hipchatAI = new HipchatAI(brain, messages);
        hipchatAI.train();
    }
}
