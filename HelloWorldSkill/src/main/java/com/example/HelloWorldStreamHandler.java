package com.example;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class HelloWorldStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard().addRequestHandler(new HelloWorldRequestHandler())
        		// Enter the skill's id below to make sure nobody else can use the AWS Lambda function
        		.withSkillId("amzn1.ask.skill.112117e1-c41e-4b85-a02e-28f67e4281de")
				.build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }

}