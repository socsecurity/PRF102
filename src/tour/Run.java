/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author xuanc
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TourList t = new TourList();
          System.out.println("Menu: ");
          System.out.println("1. Add new tours to the list.");
          System.out.println("2. List all domestic tours in the system.");
          System.out.println("3. Compute the average tour charge of all international tours.");
          System.out.println("4. Search tour by tour's code");
          System.out.println("5. Search tour by title.");
          System.out.println("6. Search tour by start date.");
          System.out.println("7. Search tour by transport.");
          System.out.println("8. Search the first occurrence of the tour having minimumtour charge.");
          System.out.println("9. Remove the tour having given code.");
          System.out.println("10. Remove tours with start date after the specified date.");
          System.out.println("11. Sort all tours of list by multiple levels in descending order of tour's price and then in ascending order of tour's title.");
          System.out.println("12. Update tour information.");
          System.out.println("13. Save/Load tours to/ from file.");
          int c;
          do{
              
          System.out.print("Enter your choice: ");
          c = in.nextInt();
          switch(c)
          {
              case 1: {
                  t.addTour();
                  break;
              }
              case 2: {
                  t.Dlist();
                  break;
              }
              case 3: {
                  t.InterAverageTour();
                  break;
              }
              case 4: {
                  System.out.print("Enter code you want to search: ");
                  String co = in.next();
                  t.searchCode(co);
                  break;
              }
              case 5: {
                  System.out.print("Enter title you want to search: ");
                  String ti = in.next();
                  t.searchtitle(ti);
                  break;
              }
              case 6: {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    System.out.println(t.searchdate(simpleDateFormat.parse(in.nextLine())));
                } catch (ParseException exp) {
                    exp.printStackTrace();
                }
                break;
              }
              case 7: {
                  System.out.print("Enter transport you want to search: ");
                  String str = in.next();
                  t.searchtransport(str);
                  break;
              }
              case 8: {
                  t.FirstMiniToCharge();
                  break;
              }
              case 9: {
                  System.out.print("Enter code tour you want to remove: ");
                  String co = in.next();
                  t.removeCode(co);
                  break;
              }
              case 10: {
                  System.out.print("Enter start date tour you want to remove:");
                  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                  String sda = in.nextLine();
                  System.out.println("-----------Delete list------------");
                  try {
                    System.out.println(t.searchdate(simpleDateFormat.parse(sda)));
                  } catch (ParseException e) {
                      e.printStackTrace();
                  }
                  try {
                      t.ResdateASpe(simpleDateFormat.parse(sda));
                  } catch (ParseException e) {
                      e.printStackTrace();
                  }
                  System.out.println("----Remove complete----");
                  break;
              }
              case 11: {
                  t.sortTour();
                  break;
              }
              case 12: {
                  t.update();
                  break;
              }
              case 13: {
                  t.SLFile();
                  break;
              }
              default: System.out.print("Please enter again!");
                  
          }
          }
          while(c>=1 && c<=12);
      } 
}
