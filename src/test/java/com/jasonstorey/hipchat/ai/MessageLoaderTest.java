package com.jasonstorey.hipchat.ai;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MessageLoaderTest {

    @Test
    public void shouldParseScrapedJsonDataIntoMessageObjects() {
        String expectedName = "Alfy Willis";
        String expectedContent = "\n      HOLY SHEEEET    ";
        String expectedTime = "11:17:36";

        MessageLoader messageLoader = new MessageLoader();
        List<Message> messages =  messageLoader.parseFromJson("scraped-hc-data.json");

        Message message = messages.get(6);
        assertEquals(expectedName, message.getName());
        assertEquals(expectedContent, message.getContent());
        assertEquals(expectedTime, message.getTime());
    }

}