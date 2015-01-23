package com.jasonstorey.hipchat.ai;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldParseScrapedJsonDataIntoMessageObjects() {
        String expectedName = "Alfy Willis";
        String expectedContent = "\n      HOLY SHEEEET    ";
        String expectedTime = "11:17:36";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("scraped-hc-data.json").getFile());


        List<Message> messages = Main.parseMessages(file);
        Message message = messages.get(6);
        assertEquals(expectedName, message.getName());
        assertEquals(expectedContent, message.getContent());
        assertEquals(expectedTime, message.getTime());
    }
}
