package com;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;

/**
 * Created by Nicholas on 11/18/2015.
 */
public class SelfServer extends TheArchiveServer {
    @Override
    public boolean getFileCacheEnabled(){
        return true;
    }

    @Override
    public HttpHandler getHttpHandler(){
        return new CLStaticHttpHandler(SelfServer.class.getClassLoader(), "webapp/");
    }
}
