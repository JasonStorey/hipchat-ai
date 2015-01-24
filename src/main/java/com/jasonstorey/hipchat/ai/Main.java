package com.jasonstorey.hipchat.ai;

import java.util.List;

public class Main {

    public static void main( String[] args ) {
        MessageLoader messageLoader = new MessageLoader();

        List<Message> messages = messageLoader.parseFromJson(args[0]);

        for (Message message : messages) {
            System.out.printf("Name: %s", message.getName());
            System.out.printf("Content: %s", message.getContent());
            System.out.printf("Time: %s", message.getTime());
        }

        Brain brain = new Brain();
        HipchatAI hipchatAI = new HipchatAI(brain, messages);
    }
}
