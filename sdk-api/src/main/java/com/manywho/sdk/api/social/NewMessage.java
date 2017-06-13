package com.manywho.sdk.api.social;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class NewMessage {
    private String senderId;
    private String messageText;
    private String repliedTo;
    private List<File> uploadedFiles = Lists.newArrayList();
    private List<MentionedWho> mentionedWhos = Lists.newArrayList();

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
        this.uploadedFiles = MoreObjects.firstNonNull(uploadedFiles, new ArrayList<File>());
        return this;
    }

    public List<MentionedWho> getMentionedWhos() {
        return mentionedWhos;
    }

    public NewMessage setMentionedWhos(List<MentionedWho> mentionedWhos) {
        this.mentionedWhos = MoreObjects.firstNonNull(mentionedWhos, new ArrayList<MentionedWho>());
        return this;
    }
}
