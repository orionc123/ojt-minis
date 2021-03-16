package org.example.service;

import org.example.db.MockDB;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<Long,Message> messageMap = MockDB.getMessages();


    public MessageService(){
        messageMap.put(1L,new Message(1,"first message", new Date(),"Orion"));
        messageMap.put(2L,new Message(2,"second message", new Date(),"Orion C"));
    }

    public List<Message> getMessages(){
        return new ArrayList<>(messageMap.values());
    }

    public Message getMessage(long id){
        return messageMap.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messageMap.size()+1);
        messageMap.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message){
        if(message.getId()<1) return null;
        messageMap.put(message.getId(), message);
        return message;
    }

    public Message deleteMessage(long id){
        return messageMap.remove(id);
    }
}
