package com.example.chatgptbasedcookingingredients.service;

import com.example.chatgptbasedcookingingredients.model.OpenAIRequest;
import com.example.chatgptbasedcookingingredients.model.OpenAIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class IngredientService {

    private final RestClient restClient;

    public IngredientService(RestClient.Builder restClientBuilder,
                             @Value("${API_KEY}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public OpenAIResponse categorizeIngredient(String ingredient) {
        return restClient.post()
                .body(new OpenAIRequest("Ist das Lebensmittel " + ingredient + " vegan, vegetarisch oder tierische Produkte enthaltend?"))
                .retrieve()
                .body(OpenAIResponse.class);
    }

    public OpenAIResponse compareIngredients(List<String> ingredients) {
        return restClient.post()
                .body(new OpenAIRequest("Vergleiche die Lebensmittel " + ingredients+ " nach Nährwertdichte und gib sie mir als Tabelle geordnet zurück, inkl. welcher Nährwerte und deren Dichte ( Kohenhydrate, Proteine und Fett)."))
                .retrieve()
                .body(OpenAIResponse.class);
    }

    public OpenAIResponse getARecipeClean(List<String> ingredients) {
        return restClient.post()
                .body(new OpenAIRequest("Erstelle mir aus den Lebensmitteln " + ingredients+ " ein gesundes und schnelles Rezept. Gib mir auch die Nährwerte an."))
                .retrieve()
                .body(OpenAIResponse.class);
    }

    public OpenAIResponse getARecipeDirty(List<String> ingredients) {
        return restClient.post()
                .body(new OpenAIRequest("Erstelle mir aus den Lebensmitteln " + ingredients+ " ein Rezept das meinen Heißhunger stillt. Es soll nicht unbedingt gesund sein, sondern fettig, geschmackvoll und kalorienreich! Gib mir auch die Nährwerte an."))
                .retrieve()
                .body(OpenAIResponse.class);
    }
}
