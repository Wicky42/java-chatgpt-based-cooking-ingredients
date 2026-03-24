package com.example.chatgptbasedcookingingredients.model;

/*
{
      "index": 0,
      "message": {
        "role": "assistant",
        "content": "Hello! How can I assist you today?",
      }
    }
 */
public record OpenAIChoice(
        String index,
        OpenAIMessage message
) {
}
