package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    private static final Logger log = Logger.getLogger(MyReactiveMessagingApplication.class);

    @Incoming("quarkuslistener")
    public void processMessage(String message) {
        log.info(message);
    }

}
