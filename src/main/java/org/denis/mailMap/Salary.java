package org.denis.mailMap;

public /*static*/ class Salary implements IRequest<Integer> {

    private String mesFrom;
    private String mesTo;
    private int summa;

    public Salary(String from, String to, int summ) {
        this.mesFrom = from;
        this.mesTo = to;
        this.summa = summ;
    }

    @Override
    public String getFrom() {
        return this.mesFrom;
    }

    public String getTo() {
        return this.mesTo;
    }

    @Override
    public Integer getContent() {
        return this.summa;
    }

}
