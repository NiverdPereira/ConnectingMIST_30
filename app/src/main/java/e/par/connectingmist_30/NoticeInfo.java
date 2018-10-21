package e.par.connectingmist_30;

public class NoticeInfo {
    String details,date,headline;

    public NoticeInfo(String date, String details,String headline) {
        this.details = details;
        this.date = date;
        this.headline=headline;
    }

    public NoticeInfo() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
