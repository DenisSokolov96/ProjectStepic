package org.denis.emailsystem;

import java.util.logging.Logger;

public class MainMail {

    private static StringBuilder stringBuilder = new StringBuilder();
    private static String strNew = "\n";
    private static Logger loggerMailMessage = Logger.getLogger(MailMessage.class.getName());

    public static void main(String[] args) {

        untrustworthyMailWorker();
        spyFunc();
        thief();
        // inspector();

        System.out.println(stringBuilder);
    }

    private static void untrustworthyMailWorker() {
        stringBuilder.append("Часть 1: UntrustworthyMailWorker" + strNew);

        MailService[] mailServices = {};
        MailMessage message = new MailMessage("Denis","Maxim","Hello!");

        UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(mailServices);
        untrustworthyMailWorker.processMail(message);
    }

    private static void spyFunc() {
        stringBuilder.append("Часть 2: Spy" + strNew);

        MailMessage message = new MailMessage("Denis","Maxim","Hello!");
        Spy spy = new Spy(loggerMailMessage);
        spy.processMail(message);
    }

    private static void thief() {
        stringBuilder.append("Часть 3: Theif" + strNew);

        Package aPackage = new Package("Auto!",50);
        MailPackage mailPackage = new MailPackage("Denis","Maxim",aPackage);
        Thief thief = new Thief(5);
        thief.processMail(mailPackage);
        stringBuilder.append(thief.getStolenValue() + strNew);

        thief.processMail(mailPackage);
        stringBuilder.append(thief.getStolenValue() + strNew);


        thief.processMail(mailPackage);
        stringBuilder.append(thief.getStolenValue() + strNew);
    }

    private static void inspector() {
        stringBuilder.append("Часть 4: Inspector" + strNew);
        Package aPackage = new Package("banned substance",50);
        MailPackage mailPackage = new MailPackage("Denis","Maxim",aPackage);
        Inspector inspector = new Inspector();
        inspector.processMail(mailPackage);
    }

}
