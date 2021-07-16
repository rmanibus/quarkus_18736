package org.acme;

import org.acme.services.MailerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.acme.mail.Templates.success;

@Path("/hello")
public class GreetingResource {

    @Inject
    MailerService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        service.send(success("The Name")
                .to("test@test.com")
                .subject("Error while generating report")
        );
        return "Hello RESTEasy";
    }
}