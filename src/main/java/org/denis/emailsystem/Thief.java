package org.denis.emailsystem;

public class Thief implements MailService {

    private int minPrice = 0;
    private int stolenValue = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return this.stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package aPackage = mailPackage.getContent();
            if (aPackage.getPrice() >= this.minPrice) {
                this.stolenValue += aPackage.getPrice();
                Package newPackage = new Package("stones instead of " + aPackage.getContent(),0);
                mail = new MailPackage(mail.getFrom(), mail.getTo(), newPackage);

                return mail;

            }

        }
        return mail;
    }
}
