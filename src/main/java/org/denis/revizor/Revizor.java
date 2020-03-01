package org.denis.revizor;

public class Revizor {

    public static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {

        String[] roles = new String[] {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = new String[] {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(roles,textLines));
    }

    private static StringBuilder printTextPerRole(String[] roles, String[] textLines) {

        for(String name: roles) {

            str.append(name+":\n");

            for (int i = 0 ; i < textLines.length; i++) {
                if (textLines[i].startsWith(name+":"))
                    str.append(i+1+")" + textLines[i].substring(name.length()+1) +"\n");
            }

            str.append("\n");

        }

        return str;
    }


}
/*
Городничий:
1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
/n
Аммос Федорович:
2) Как ревизор?
5) Вот те на!
/n
Артемий Филиппович:
3) Как ревизор?
6) Вот не было заботы, так подай!
/n
Лука Лукич:
7) Господи боже! еще и с секретным предписаньем!
 */