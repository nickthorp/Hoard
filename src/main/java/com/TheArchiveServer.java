package com;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * Created by Nicholas on 10/31/2015.
 */
public class TheArchiveServer {

    public static final String BASE_API_URI = "http://localhost:8080/TheArchive/";

    public static void main(String[] args) throws Exception {
        TheArchiveServer server = new TheArchiveServer();
        HttpServer httpServer = server.startServer();
        System.in.read();
        httpServer.shutdown();
    }

    public HttpServer startServer(){
        ResourceConfig resourceConfig = new ResourceConfig().packages("com");
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_API_URI), resourceConfig);
        httpServer.getServerConfiguration().addHttpHandler(getHttpHandler(), "/page");
        return httpServer;
    }

    public HttpHandler getHttpHandler() {
        StaticHttpHandler handler = new StaticHttpHandler("src/main/resources/webapp/");
        handler.setFileCacheEnabled(getFileCacheEnabled());
        return handler;
    }

    private boolean getFileCacheEnabled() {
        return false;
    }
}
