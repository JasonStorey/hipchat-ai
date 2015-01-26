package com.jasonstorey.hipchat.ai;

import java.util.HashMap;

public class Label {
    private String name;
    private HashMap<String, Integer> tokenOccurrences;
    private Integer occurrences;

    public Label(String name) {
        this.name = name;
        this.tokenOccurrences = new HashMap();
        this.occurrences = 0;
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

    public Integer getOccurrencesOfToken(String token) {
        Integer occurrences = tokenOccurrences.get(token);

        if(occurrences != null) {
            return occurrences.intValue();
        } else {
            return 0;
        }
    }

    public Integer getOccurrences() {
        return occurrences;
    }

    public void incrementOccurrences() {
        occurrences++;
    }
}
