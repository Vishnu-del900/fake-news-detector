package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class FakeNewsController {

    @GetMapping("/check-news")
    public String checkNews(@RequestParam String content) {

        // check empty input
        if (content == null || content.trim().isEmpty()) {
            return "Please enter news content";
        }

        String text = content.toLowerCase();

        int score = 0;

        // suspicious keywords
        if (text.contains("shocking"))
            score += 30;
        if (text.contains("miracle"))
            score += 30;
        if (text.contains("urgent"))
            score += 20;
        if (text.contains("breaking"))
            score += 20;

        // result based on score
        if (score >= 50) {
            return "Fake Score: " + score + "% - Possibly Fake News";
        }

        return "Fake Score: " + score + "% - Looks Real";
    }
}
