package com.jasonstorey.hipchat.ai;

import java.util.HashMap;

public class Label {
    private String name;
    private HashMap<String, Integer> tokenOccurrences;

    public Label(String name) {
        this.name = name;
        tokenOccurrences = new HashMap();
    }

    public String getName() {
        return name;
    }

    public void addTokens(String[] tokens) {
        for(String token : tokens) {
            Integer occurrences = 1;
            if(tokenOccurrences.containsKey(token)) {
                occurrences += tokenOccurrences.get(token);
            }

            tokenOccurrences.put(token, occurrences);
        }
    }

    public Integer getOccurrences(String token) {
        Integer occurrences = tokenOccurrences.get(token);

        if(occurrences != null) {
            return occurrences.intValue();
        } else {
            return 0;
        }
    }
}
