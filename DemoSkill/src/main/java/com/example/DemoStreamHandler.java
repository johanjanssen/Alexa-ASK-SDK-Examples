package com.example;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class DemoStreamHandler extends SkillStreamHandler {
    @SuppressWarnings("unchecked")
	private static Skill getSkill() {
        return Skills.standard().addRequestHandlers(
        		new HelloWorldRequestHandler(), 
        		new CancelandStopRequestHandler(),  
        		new HelloNameRequestHandler(), 
        		new ColorRequestHandler())
        		// Enter the skill's id below to make sure nobody else can use the AWS Lambda function
        		//.withSkillId("")
				.build();
    }

    public DemoStreamHandler() {
        super(getSkill());
    }

}