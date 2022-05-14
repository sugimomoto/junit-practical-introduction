package org.example;

import com.sun.net.httpserver.HttpServer;
import org.junit.rules.ExternalResource;

import java.net.InetSocketAddress;

public class ServerResource extends ExternalResource {

    HttpServer server;

    @Override
    protected void before() throws Throwable{
        server = HttpServer.create(new InetSocketAddress(8989),0);
        server.createContext("/",new MyHandler());
        server.start();
    }

    @Override
    protected void after() {
        server.stop(0);
    }
}
