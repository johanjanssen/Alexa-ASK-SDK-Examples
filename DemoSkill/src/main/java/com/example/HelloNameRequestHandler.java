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
import com.amazon.ask.model.services.ApiClientRequest;
import com.amazon.ask.model.services.ApiClientResponse;
import com.amazon.ask.services.ApacheHttpApiClient;


public class HelloNameRequestHandler implements RequestHandler {
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("HelloNameIntent"));
	}

	// Use for instance: Alexa tell demo the name is Peter
	@Override
	public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot nameSlot = slots.get("Query");
        String name = nameSlot.getValue();		
		
		String url = "[Invoke URL from the AWS API Gateway]/hello?name=" + name;
		ApacheHttpApiClient apacheHttpApiClient = ApacheHttpApiClient.standard();
		ApiClientRequest apiClientRequest = new ApiClientRequest();
		apiClientRequest.setUrl(url);
		apiClientRequest.setMethod("GET");
		ApiClientResponse apiClientResponse = apacheHttpApiClient.invoke(apiClientRequest);
		
		String cardText = apiClientResponse.getBody();
		
		String speechText = "Skill " + cardText;
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard("Hello name", cardText)
				.build();
	}
}
