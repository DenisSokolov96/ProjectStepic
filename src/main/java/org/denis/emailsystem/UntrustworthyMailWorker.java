package org.denis.emailsystem;

public class UntrustworthyMailWorker implements MailService {

    private final MailService realMailService = new RealMailService();
    private MailService[] mailServices;
    public UntrustworthyMailWorker(MailService[] mailServices){
        this.mailServices = mailServices;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        Sendable proc = mail;
        for (MailService mailService : mailServices) {
            proc = mailService.processMail(proc);
        }

        return realMailService.processMail(mail);
    }
}
