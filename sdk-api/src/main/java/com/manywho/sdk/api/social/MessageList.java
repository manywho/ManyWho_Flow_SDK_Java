package com.manywho.sdk.api.social;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;

public class MessageList {
    private List<Message> messages = Lists.newArrayList();
    private String nextPage;

    public List<Message> getMessages() {
        return messages;
    }

    public MessageList setMessages(List<Message> messages) {
        this.messages = MoreObjects.firstNonNull(messages, Lists.newArrayList());
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
