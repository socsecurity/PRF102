/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author xuanc
 */
public abstract class TourFile implements ITour {
    protected String tourcode;
    protected String tourtitle;
    protected double tourprice;
    protected String transport;
    Date sdate,edate;

    public TourFile(){

    }

    public TourFile(String code, String title, double price, String transport, Date sdate2,Date edate2){
        tourcode = code;
        tourtitle = title;
        tourprice = price;
        this.transport = transport;
        this.sdate = sdate2;
        this.edate = edate2;
    }

    public Date getEdate() {
        return edate;
    }
    public Date getSdate() {
        return sdate;
    }
    public String getTourcode() {
        return tourcode;
    }
    public double getTourprice() {
        return tourprice;
    }
    public String getTourtitle() {
        return tourtitle;
    }
    public String getTransport() {
        return transport;
    }
    public void setEdate(Date edate) {
        this.edate = edate;
    }
    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }
    public void setTourcode(String tourcode) {
        this.tourcode = tourcode;
    }
    public void setTourprice(int tourprice) {
        this.tourprice = tourprice;
    }
    public void setTourtitle(String tourtitle) {
        this.tourtitle = tourtitle;
    }
    public void setTransport(String transport) {
        this.transport = transport;
    }  

    public static Comparator<TourFile> cpprice = new Comparator<TourFile>() {

        public int compare(TourFile s1, TourFile s2) {
           double t1 = s1.getTourprice();
           double t2 = s2.getTourprice();
           if (t2>t1) return (int) (t2 - t1 + 1);
           else if (t2<t1) return (int) (t2 - t1 - 1);
           else {
                String a1 = s1.getTourtitle();
                String a2 = s2.getTourtitle();
                return a1.compareTo(a2);
           }
        }
    };
  
    
    @Override
    public String toString() {
        return "Tour's code: " + tourcode + "\nTour's Title: "  + tourtitle + "\nPrices: " + tourprice + " " + transport + "Start: " + sdate + ". End: " + edate;
    }

    public long numDays(){
        return (this.edate.getTime()-this.sdate.getTime())/1000/60/60/24;
    }
}
