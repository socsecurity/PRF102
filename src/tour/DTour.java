/*

    String tourcode;
    String tourtitle;
    double tourprice;
    String transport;
    Date sdate,edate;
*/

package tour;

import java.util.Date;

public class DTour extends TourFile {
    private double tourtip;

    public DTour(String code, String title, double price, String transport, Date sdate, Date edate, double tourtip){
        super(code, title, price, transport, sdate, edate);
        this.tourtip = tourtip;
    }

    public double getTourtip() {
        return tourtip;
    }

    public void setTourtip(double tourtip) {
        this.tourtip = tourtip;
    }
    
    @Override
    public double surcharge(){
        return tourtip*numDays() + this.tourprice;
    }
}
