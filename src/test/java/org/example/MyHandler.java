package org.example;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;

import java.io.IOException;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseBody = "HelloWorld";
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "application/text");

        exchange.getResponseBody().write(responseBody.getBytes());
        exchange.close();
    }
}
