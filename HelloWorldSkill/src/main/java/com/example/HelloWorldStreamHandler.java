package com.example;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class HelloWorldStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard().addRequestHandler(new HelloWorldRequestHandler())
        		// Enter the skill's id below to make sure nobody else can use the AWS Lambda function
        		//.withSkillId("")
				.build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }

}