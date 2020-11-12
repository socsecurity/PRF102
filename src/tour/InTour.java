package tour;

import java.util.Date;

public class InTour extends TourFile {
    private double tax, fee;
    
    public InTour(String code, String title, double price, String transport, Date sdate, Date edate, double tax, double fee){
        super(code, title, price, transport, sdate, edate);
        this.tax = tax;
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }
    public double getTax() {
        return tax;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public double surcharge(){
        return (tax + fee ) +  this.tourprice;
    }
}
