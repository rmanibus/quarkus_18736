package org.acme.mail;

import io.quarkus.mailer.MailTemplate;
import io.quarkus.qute.CheckedTemplate;

@CheckedTemplate
public class Templates {
  public static native MailTemplate.MailTemplateInstance success(String name);

  public static native MailTemplate.MailTemplateInstance error(String name);
}
