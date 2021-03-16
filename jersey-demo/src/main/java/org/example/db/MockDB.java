package org.example.db;

import org.example.model.Message;

import java.util.HashMap;
import java.util.Map;

public class MockDB {
    private static Map<Long, Message> messageMap = new HashMap<>();

    public static Map<Long,Message> getMessages(){
        return messageMap;
    }
}
