package org.denis.inteface;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    abstract String[] getKeywords();

    abstract Label getLabel();

    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
