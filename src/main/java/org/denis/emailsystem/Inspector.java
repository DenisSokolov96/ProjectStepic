package org.denis.emailsystem;

class IllegalPackageException extends Error {}
class StolenPackageException extends Error {}

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package aPackage = mailPackage.getContent();

            if (aPackage.getContent().indexOf("stones") == 0)
                throw new StolenPackageException();
            else if (aPackage.getContent().equals("weapons") || aPackage.getContent().equals("banned substance"))
                throw new IllegalPackageException();




        }
        return mail;
    }
}
