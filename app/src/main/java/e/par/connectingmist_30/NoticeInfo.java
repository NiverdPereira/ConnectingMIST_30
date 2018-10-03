package e.par.connectingmist_30;

public class NoticeInfo {
    String details,date;

    public NoticeInfo(String notice, String date) {
        this.details = notice;
        this.date = date;
    }

    public NoticeInfo() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String notice) {
        this.details = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
