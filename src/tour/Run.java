/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

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
              }
              case 2: {
                  t.Dlist();
              }
              case 3: {
                  t.InterAverageTour();
              }
              case 4: {
                  System.out.print("Enter code you want to search: ");
                  String co = in.next();
                  t.searchcode(co);
              }
              case 5: {
                  System.out.print("Enter title you want to search: ");
                  String ti = in.next();
                  t.searchtitle(ti);
              }
              case 6: {
                  System.out.print("Enter date you want to search: ");
                  Date da = in.nextDate();
                  t.searchdate(da);
              }
              case 7: {
                  System.out.print("Enter transport you want to search: ");
                  String str = in.next();
                  t.searchtransport(str);
              }
              case 8: {
                  t.FirstMiniToCharge();
              }
              case 9: {
                  System.out.print("Enter code tour you want to remove: ");
                  String co = in.next();
                  t.removeCode(co);
              }
              case 10: {
                  System.out.print("Enter start date tour you want to remove:");
                  Date sda = in.nextDate();
                  t.ResdateASpe(sda);
              }
              case 11: {
                  t.sortTour();
              }
              case 12: {
                  t.update();
              }
              case 13: {
                  t.SLFile();
              }
              default: System.out.print("Please enter again!");
                  
          }
          }
          while(c>=1 && c<=12);
      } 
}
