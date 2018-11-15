package com.example;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

public class ColorRequestHandler implements RequestHandler {
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("ColorIntent"));
	}

	// Use for instance: 
	// Alexa tell demo the color is red [wait for response]
	// the color is green [wait for response]
	// stop
	@Override
	public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot nameSlot = slots.get("Color");
        String color = nameSlot.getValue();
		
		String speechText = "You picked the color: " + color;
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard("Color", speechText).withShouldEndSession(false)
				.build();
	}
}
