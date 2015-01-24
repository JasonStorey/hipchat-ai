package com.jasonstorey.hipchat.ai;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MessageLoader {

    public MessageLoader() {

    }

    public List<Message> parseMessages(File jsonFile) {
        List<Message> messages = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            messages = objectMapper.readValue(jsonFile, new TypeReference<List<Message>>(){});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public List<Message> parseFromJson(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        return parseMessages(file);
    }
}
