package com.example.chatapp.messageAdapter;

public class MessageList {
    private String name, mobile, email, lastMessage;
    private int unSeenMessage;

    public MessageList(String name, String mobile, String email, String lastMessage, int unSeenMessage) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.lastMessage = lastMessage;
        this.unSeenMessage = unSeenMessage;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getUnSeenMessage() {
        return unSeenMessage;
    }
}
