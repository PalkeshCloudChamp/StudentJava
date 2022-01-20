package com.lambda.LambdaTest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Hello world!
 *
 */
public class App implements RequestHandler<Object, Object> 
{
	@Override
	public Object handleRequest(Object input, Context context) {
		// TODO Auto-generated method stub
		Object name = "Palkesh Goyal";
		return name;
	}
}
