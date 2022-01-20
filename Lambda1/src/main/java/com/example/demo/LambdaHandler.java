package com.example.demo;
import com.amazonaws.services.lambda.runtime.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaHandler implements RequestHandler<Object, Object>{
	@Override
	public Object handleRequest(Object input, Context context) {
		// TODO Auto-generated method stub
		return "Palkesh";
	}
}