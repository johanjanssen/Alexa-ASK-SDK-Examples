package com.example;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

public class HelloWorldRequestHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("HelloWorldIntent"));
	}

	// Use for instance: Alexa tell hello to say hello
	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Hello world from my first skill";
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard("HelloWorld", speechText)
				.build();
	}
}
