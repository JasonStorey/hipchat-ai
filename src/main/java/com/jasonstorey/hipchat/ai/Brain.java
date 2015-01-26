package com.jasonstorey.hipchat.ai;

import java.util.HashMap;
import java.util.List;

public class Brain {

    private HashMap<String, Label> memory;

    public Brain() {
        memory = new HashMap();
    }

    public void train(List<Message> messages) {
        messages.stream().forEach((message) -> {
            if (message != null) {
                String[] tokens = Tokeniser.extractTokens(message.getContent());
                Label label;

                if (memory.containsKey(message.getName())) {
                    label = memory.get(message.getName());
                } else {
                    label = new Label(message.getName());
                }

                label.addTokens(tokens);

                memory.put(label.getName(), label);
            }
        });
    }

    public HashMap<String, Label> getMemory() {
        return memory;
    }
}
