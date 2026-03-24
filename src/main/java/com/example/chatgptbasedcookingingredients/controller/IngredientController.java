package com.example.chatgptbasedcookingingredients.controller;


import com.example.chatgptbasedcookingingredients.model.OpenAIResponse;
import com.example.chatgptbasedcookingingredients.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;

    @PostMapping
    String categorizeIngredient(@RequestBody String ingredient) {

        OpenAIResponse response = service.categorizeIngredient(ingredient);

        return response.text();
    }

    @PostMapping("/compare")
    String compareIngredients(@RequestBody List<String> ingredients){
        OpenAIResponse response = service.compareIngredients(ingredients);

        return response.text();
    }

    @PostMapping("/recipe")
    String getARecipeClean(@RequestBody List<String> ingredients){
        OpenAIResponse response = service.getARecipeClean(ingredients);

        return response.text();
    }

    @PostMapping("/recipe2")
    String getARecipeDirty(@RequestBody List<String> ingredients){
        OpenAIResponse response = service.getARecipeDirty(ingredients);

        return response.text();
    }

}
