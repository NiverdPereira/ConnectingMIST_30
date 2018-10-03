package e.par.connectingmist_30.Club_activity;

public class Events {
    String headline,date,content;

    public Events() {
    }

    public Events(String date, String headline, String content) {

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
