package e.par.connectingmist_30;

public class NoticeInfo {
    String notice,date;

    public NoticeInfo(String notice, String date) {
        this.notice = notice;
        this.date = date;
    }

    public NoticeInfo() {
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
