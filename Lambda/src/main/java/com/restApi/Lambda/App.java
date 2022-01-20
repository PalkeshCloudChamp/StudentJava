package com.restApi.Lambda;

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
		System.out.println("Hello World");
		Object o = "Hello World";
		return o;
	}
}
