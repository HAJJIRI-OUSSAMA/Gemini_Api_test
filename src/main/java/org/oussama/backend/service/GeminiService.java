package org.oussama.backend.service;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    private static final String API_KEY = "AIzaSyCcIF8mTHwH2G21EHbWEKQg5kCln2M2RnY";
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + API_KEY;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String generateResponse(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Construct the JSON payload dynamically
        ObjectNode requestBody = objectMapper.createObjectNode();
        ObjectNode content = objectMapper.createObjectNode();
        ObjectNode part = objectMapper.createObjectNode();
        part.put("text", prompt);
        content.set("parts", objectMapper.createArrayNode().add(part));
        requestBody.set("contents", objectMapper.createArrayNode().add(content));

        // Send request
        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
        String response = restTemplate.postForObject(API_URL, entity, String.class);

        // Parse the response and extract the text value
        try {
            JsonNode rootNode = objectMapper.readTree(response);
            return rootNode
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Gemini API response", e);
        }}
}