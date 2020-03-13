package org.denis.mailMap;

import java.util.*;
import java.util.function.Consumer;

public /*static*/ class MailService<T> implements Consumer<IRequest<T>> {

    private Map<String, List<T>> mailBox ;

    public MailService(){
        mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                List<T> temp = super.get(key);
                try {
                    if (temp == null) temp = (List<T>)Collections.emptyList();
                } catch (ClassCastException e) {}
                return temp;
            }
        };
    }


    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(IRequest<T> tiRequest) {
        if(mailBox.containsKey(tiRequest.getTo())) {
            List<T> val;
            val = mailBox.get(tiRequest.getTo());
            val.add(tiRequest.getContent());
            mailBox.put(tiRequest.getTo(), val);
        } else {
            List<T> val;
            val = new LinkedList<>();
            val.add(tiRequest.getContent());
            mailBox.put(tiRequest.getTo(), val);
        }
    }
}
