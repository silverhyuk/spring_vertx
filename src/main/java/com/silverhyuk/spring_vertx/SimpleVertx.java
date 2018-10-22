package com.silverhyuk.spring_vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleVertx extends AbstractVerticle{

   @Autowired
    private ApplicationConfiguration configuration;

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        // Serve the static pages
        router.route().handler(StaticHandler.create());

        vertx.createHttpServer().requestHandler(router::accept).listen(configuration.httpPort());
    }

}
