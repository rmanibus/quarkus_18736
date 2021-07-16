package org.acme.services;

import io.quarkus.mailer.MailTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class MailerService {

  Logger log = LoggerFactory.getLogger(MailerService.class);

  @Inject
  @ConfigProperty(name = "quarkus.mailer.enabled")
  boolean enabled;

  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void send(MailTemplate.MailTemplateInstance instance) {
    if (enabled) {
      try {
        instance
          .send().await().indefinitely();
      } catch (Exception e) {
        log.error("failed to send email", e);
      }
    } else {
      log.warn("mailer is disabled");
    }
  }
}
