package com.example;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelandStopRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.CancelIntent").or(intentName("AMAZON.StopIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	String text = "See you next time";
        return input.getResponseBuilder()
                .withSpeech(text)
                .withSimpleCard("End of session", text)
                .build();
    }
}