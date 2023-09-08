package ru.vsk.auth;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthStorage {
    private final Map<String, String> credentialsMap = new HashMap<>();

    public AuthStorage() {
        credentialsMap.put("+79876543210", "testpass0");
        credentialsMap.put("+79876543211", "testpass1");
        credentialsMap.put("+79876543212", "testpass2");
        credentialsMap.put("+79876543213", "testpass3");
        credentialsMap.put("+79876543214", "testpass4");
    }

    public boolean isValidCredentials(String phone, String password) {
        if (credentialsMap.containsKey(phone))
            return credentialsMap.get(phone).equals(password);
        return false;
    }
}
