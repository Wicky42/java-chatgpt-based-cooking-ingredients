package com.example.chatgptbasedcookingingredients.model;

/*
{
        "role": "developer",
        "content": "You are a helpful assistant."
      },
 */
public record OpenAIMessage(String role,
                            String content) {
}
