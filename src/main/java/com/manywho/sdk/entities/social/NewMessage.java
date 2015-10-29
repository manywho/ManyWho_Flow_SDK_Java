package com.manywho.sdk.entities.social;

import java.util.List;

public class NewMessage {
    private String senderId;
    private String messageText;
    private String repliedTo;
    private List<File> uploadedFiles;
    private List<MentionedWho> mentionedWhos;

    public String getSenderId() {
        return senderId;
    }

    public NewMessage setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }

    public String getMessageText() {
        return messageText;
    }

    public NewMessage setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public String getRepliedTo() {
        return repliedTo;
    }

    public NewMessage setRepliedTo(String repliedTo) {
        this.repliedTo = repliedTo;
        return this;
    }

    public List<File> getUploadedFiles() {
        return uploadedFiles;
    }

    public NewMessage setUploadedFiles(List<File> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
        return this;
    }

    public List<MentionedWho> getMentionedWhos() {
        return mentionedWhos;
    }

    public NewMessage setMentionedWhos(List<MentionedWho> mentionedWhos) {
        this.mentionedWhos = mentionedWhos;
        return this;
    }
}
