package com.manywho.sdk.entities.social;

import java.util.ArrayList;
import java.util.List;

public class MessageList {
    private List<Message> messages = new ArrayList<>();
    private String nextPage;

    public List<Message> getMessages() {
        return messages;
    }

    public MessageList setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public String getNextPage() {
        return nextPage;
    }

    public MessageList setNextPage(String nextPage) {
        this.nextPage = nextPage;
        return this;
    }
}
