package org.denis.emailsystem;

import java.util.logging.Logger;

public class MainMail {

    private static StringBuilder stringBuilder = new StringBuilder();
    private static String strNew = "\n";
    private static Logger loggerMailMessage = Logger.getLogger(MailMessage.class.getName());

    public static void main(String[] args) {

        spyFunc();

        System.out.println(stringBuilder);
    }

    private static void spyFunc() {
        stringBuilder.append("Часть 2: Spy" + strNew);

        MailMessage message = new MailMessage("Denis","Maxim","Hello!");
        Spy spy = new Spy(loggerMailMessage);
        spy.processMail(message);
    }

}
