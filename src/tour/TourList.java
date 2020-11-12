package tour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class TourList {

    private ArrayList<TourFile> list = new ArrayList<>();

    public ArrayList<TourFile> getlist() {
        return list;
    }

    public TourFile getTour(int i) {
        return list.get(i);
    }

    public void addTour() {
        String code;
        String title;
        double price;
        String transport="";
        Date sdate=null;
        Date edate=null;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new tour... ");
        System.out.println("Which type of tour");
        System.out.println("\t1. Domestic Tour.\n\t2. International Tour.");
        int c;
        do {
            System.out.print("YOUR CHOICE: ");
            c = in.nextInt();
            in.nextLine();
        } while (c < 1 && c > 2);

        boolean existed = false;
        do {
            System.out.print("Tour code: ");
            code = in.nextLine();
            if (searchCode(code) != null) {
                System.out.println("The CODE is existed");
                existed = true;
            }
        } while (existed == true);
        
        System.out.print("Your title: ");
        title = in.nextLine();
        System.out.print("Prices: ");
        price = in.nextDouble();
        System.out.println("Transport: ");
        int tc;
        do {
            System.out.print("\t1. Aircraft.\n\t2. Car.\nYOUR CHOICE: ");
            tc = in.nextInt();
            if (tc == 1)
                transport = "Aircraft";
            else if (tc == 2)
                transport = "Car";
        } while (tc < 1 && tc > 2);
        in.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.print("Start Date(yyyy/MM/dd): ");
        try {
            sdate = simpleDateFormat.parse(in.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("End Date(yyyy/MM/dd): ");
        try {
            edate = simpleDateFormat.parse(in.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }           

        switch(c){
            case 1:           
                double tip;
                System.out.print("Your tip: ");
                tip = in.nextDouble();
                DTour dt = new DTour(code, title, price, transport, sdate, edate, tip);
                list.add(dt);
                break;
            case 2:
                double tax, fee;
                System.out.print("TAX: ");
                tax = in.nextDouble();
                System.out.print("FEE: ");
                fee = in.nextDouble();
                InTour it = new InTour(code, title, price, transport, sdate, edate, tax, fee);
                list.add(it);
                break;
        }
    }
    

    public ArrayList<TourFile> Dlist() {
        ArrayList<TourFile> m = new ArrayList<>();
        for (TourFile v : list) {
            if (v instanceof DTour){
                m.add(v);
                v.toString();
            }
                
        }
        return m;
    }

    public ArrayList<TourFile> Ilist() {
        ArrayList<TourFile> m = new ArrayList<>();
        for (TourFile v : list) {
            if (v instanceof InTour) {
            m.add(v);
            v.toString();
        }
        }
        return m;
    }

    public double InterAverageTour() {
        ArrayList<TourFile> m = new ArrayList<>();
        double averageTourCharge = 0.0;
        int count = 0;
        for (TourFile e : m) {
            if (e instanceof InTour) {
                averageTourCharge = averageTourCharge + e.surcharge();
                count++;
            }
        }
        if (count != 0)
            averageTourCharge /= (double) count;
        return averageTourCharge;
    }

    public TourFile searchCode(String id) {
        for (TourFile e : list) {
            if (id.equals(e.getTourcode()))
                return e;
        }
        return null;
    }

    public TourFile searchtitle(String tourtitle) {
        for (TourFile v : list)
            if (tourtitle.equals(v.getTourtitle()))
                return v;
        return null;
    }

    public ArrayList<TourFile> searchdate(Date sdate) {
        ArrayList<TourFile> m = new ArrayList<>();
        for (TourFile v : list)
            if (sdate.compareTo(v.getSdate()) <= 0)
                m.add(v);
        return list;
    }

    public ArrayList<TourFile> searchtransport(String transport) {
        ArrayList<TourFile> m = new ArrayList<>();
        for (TourFile v : list)
            if (transport.equals(v.getTransport()))
                m.add(v);
        return m;
    }

    public TourFile FirstMiniToCharge() { // search the first min price of tour charge
        double min = list.get(0).getTourprice();
        int index = 0;
        for (TourFile v : list) {
            if (min > v.getTourprice()) {
                min = v.getTourprice();
                index = list.indexOf(v);
            }
        }
        return list.get(index);
    }

    public void removeCode(String tourcode) {
        for (TourFile v : list)
            if (tourcode.equals(v.getTourcode()))
                list.remove(v);
    }

    public void ResdateASpe(Date sdate) {
        for (TourFile v : list)
            if (v.getSdate().compareTo(sdate) > 0)
                list.remove(v);
    }

    public void sortTour()
    {       
        Collections.sort(list, TourFile.cpprice );
        
    }
    public void update()
    {
        
    }
    public void SLFile()
    {
        
    }
}
