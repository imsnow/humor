package com.elegant.humor.model;

/***
 * Created by Mike on 05.05.2016.
 */
public class Joke {

    public String site;
    public String desc;
    public String elementPureHtml;

    @Override
    public String toString() {
        return "Joke{" +
                "desc='" + desc + '\'' +
                ", site='" + site + '\'' +
                ", elementPureHtml='" + elementPureHtml + '\'' +
                '}';
    }
}
