package e.par.connectingmist_30.Newsfeed_Notice;

public class Notice_Element {
    String date,details;

    public Notice_Element() {
    }

    public Notice_Element(String date, String details) {
        this.date = date;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
