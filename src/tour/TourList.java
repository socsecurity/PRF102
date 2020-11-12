package tour;

import java.util.ArrayList;
import java.util.Scanner;

public class TourList {
    private ArrayList<TourFile> m = new ArrayList<>();
    public ArrayList<TourFile> getlist()
    {
        return m;
    }
    public Tour getTour(int i)
    {
        return m.get(i);
    }
    public void addTour()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new tour: ");
        String a = in.nextLine();
        ArrayList<TourFile> list = new ArrayList<>();
        list.add(a);
    }
    public ArrayList<TourFile> Dlist()
    {
        ArrayList<TourFile> list = new ArrayList<>();
        for(TourFile v: m)
        {
            if(v instanceof DTour)
                list.add(v);
        }
        return list;
    }

    public ArrayList<TourFile> Ilist()
    {
        ArrayList<TourFile> list = new ArrayList<>();
        for(TourFile v: m)
        {
            if(v instanceof DTour)
                list.add(v);
        }
        return list;
    }

    public double InterAverageTour(double a)
    {
        return 0;
    }
    public TourFile searchcode(String tourcode)
    {
        for (TourFile v:m)
        if(tourcode.equals(v.getTourcode()))
            return v;
        return null;
    }
    public TourFile searchtitle(String tourtitle)
    {
        for(TourFile v:m)
            if(tourtitle.equals(v.getTourtitle()))
                return v;
        return null;
    }
    public ArrayList<TourFile> searchdate(Date sdate)
    {
        ArrayList<TourFile> list = new ArrayList<>();
        for(TourFile v:m)
            if(sdate.compareTo(v.getSdate())<=0)
                list.add(v);
        return list;
    }
    public ArrayList<TourFile> searchtransport(String transport)
    {
        for(TourFile v:m)
            if(transport.equals(v.getTransport()))
                return m;
        return null;
    }
    public TourFile FirstMiniToCharge()
    {
        
    }
    public void removeCode(String tourcode)
    {
        for(TourFile v:m)
            if(tourcode.equals(v.getTourcode()))
                m.remove(v);
    }
    public void ResdateASpe(Date sdate)
    {
        for(TourFile v:m)
            if(v.getSdate().compareTo(sdate)>0)
                m.remove(v);
    }
    public TourFile sortTour()
    {
        
    }
    public TourFile update()
    {
        
    }
    public SLFile()
    {
        
    }
}
