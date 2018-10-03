package e.par.connectingmist_30;

public class NewsInfo {


    String author,content,date,headline;

    public NewsInfo(String author, String content, String date, String headline) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.headline = headline;
    }

    public NewsInfo() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
