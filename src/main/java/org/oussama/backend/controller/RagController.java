package org.oussama.backend.controller;

import org.oussama.backend.service.RagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rag")
public class RagController {

    private final RagService ragService;

    // Use constructor-based dependency injection
    public RagController(RagService ragService) {
        this.ragService = ragService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String query) {
        try {
            String response = ragService.generateResponse(query);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return ResponseEntity.badRequest().body("Error generating response: " + e.getMessage());
        }
    }
}
