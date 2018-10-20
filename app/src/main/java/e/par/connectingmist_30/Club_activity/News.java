package e.par.connectingmist_30.Club_activity;

import java.io.Serializable;

public class News implements Serializable {
    String headline,date,content;

    public News() {
    }

    public News(String date, String headline, String content) {

        this.date = date;
        this.headline = headline;
        this.content = content;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
