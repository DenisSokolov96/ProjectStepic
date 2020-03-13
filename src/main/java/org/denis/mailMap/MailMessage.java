package org.denis.mailMap;

public /*static*/ class MailMessage implements IRequest<String> {

    private String mesFrom;
    private String mesTo;
    private String message;

    public MailMessage(String from, String to, String mess) {
        this.mesFrom = from;
        this.mesTo = to;
        this.message = mess;
    }

    @Override
    public String getFrom() {
        return this.mesFrom;
    }

    @Override
    public String getTo() {
        return this.mesTo;
    }

    @Override
    public String getContent() {
        return this.message;
    }
}
