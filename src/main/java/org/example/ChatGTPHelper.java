package org.example;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ChatGTPHelper {
    OpenAiService service;
    public ChatGTPHelper(){
//        service = new OpenAiService("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");

        service = new OpenAiService("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");

    }
     public String getBreakfastIdea(List<String>products){
        String allProducts = String.join(", ", products);
        String question = "Mam w lodówce " + allProducts + ". Co mogę zjeśc na śniadanie? Podaj mi 2 pomysły";

         ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                 .messages(List.of(new ChatMessage("user", question)))
                 .model("gpt-3.5-turbo-1106")
                 .build();
         List<ChatCompletionChoice> choices = service.createChatCompletion(completionRequest).getChoices();

         StringBuilder stringBuilder = new StringBuilder();
         choices.stream()
                 .map(ChatCompletionChoice::getMessage)
                 .map(ChatMessage::getContent)
                 .forEach(stringBuilder::append);


         return stringBuilder.toString();
     }
}
