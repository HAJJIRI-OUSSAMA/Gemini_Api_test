package org.oussama.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Scanner;

@Service
public class RagService {

    private final GeminiService geminiService;

    public RagService(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    public String generateResponse(String query) {
        String context = retrieveContext(query);
        String prompt = "Context: " + context + "\n\nQuery: " + query;
        return geminiService.generateResponse(prompt);
    }

    public String processPdfAndGenerateResponse(MultipartFile pdfFile, String query) throws IOException {
        String pdfContent = extractPdfContent(pdfFile);
        String prompt = "PDF Content: " + pdfContent + "\n\nQuery: " + query;
        return geminiService.generateResponse(prompt);
    }

    private String extractPdfContent(MultipartFile pdfFile) throws IOException {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(pdfFile.getInputStream())) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }

    private String retrieveContext(String query) {
        return "This is a sample context for the query: " + query;
    }
}
