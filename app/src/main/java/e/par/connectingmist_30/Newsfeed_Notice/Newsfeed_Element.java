package e.par.connectingmist_30.Newsfeed_Notice;

public class Newsfeed_Element {
    String headline,date,author,content;

    public Newsfeed_Element() {
    }

    public Newsfeed_Element(String date, String author, String headline, String content) {

        this.date = date;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
