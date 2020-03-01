package org.denis.emailsystem;

import java.util.logging.Logger;

public class Spy implements MailService {

    public Logger loger = null;
    public Spy(Logger loger) {
        this.loger = loger;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail.getClass() == MailMessage.class) {
            MailMessage mailMessage = (MailMessage) mail;
            String from = mailMessage.getFrom();
            String to = mailMessage.getTo();
            if (from.equals("AUSTIN_POWERS") || to.equals("AUSTIN_POWERS")) {
                loger.warning("Detected target mail correspondence: from " + from + " to " + to + " \"" + mailMessage.getMessage() + "\"");
            } else {
                loger.info("Usual correspondence: from " + from + " to " + to);
            }

        }

        return null;
    }
}
