package e.par.connectingmist_30.Calender_view;

import java.util.ArrayList;

class HomeCollection {
    public String date="";
    public String head="";
    public String subject="";
    public String description="";


    public static ArrayList<HomeCollection> date_collection_arr;
    public HomeCollection(String date, String head, String description){

        this.date=date;
        this.head=head;
        this.subject=subject;
        this.description= description;

    }
}
