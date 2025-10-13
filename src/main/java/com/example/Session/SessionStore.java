package com.example.Session;

import java.util.concurrent.ConcurrentHashMap;

import com.example.model.User;

public class SessionStore {

    private static ConcurrentHashMap<String, User> sessions = new ConcurrentHashMap<>();

  
    public static void addSession(String sessionId, User user) {
        sessions.put(sessionId, user);
    }

   
    public static User getUser(String sessionId) {
        return sessions.get(sessionId);
    }

   
    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Check if session exists
    public static boolean isValid(String sessionId) {
        return sessions.containsKey(sessionId);
    }

}
