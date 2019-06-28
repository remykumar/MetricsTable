package com.remy;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Remy_Arumugham
 */
public class OPM {
   static ArrayList<Integer> opm_total = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //   URL lrconnect = new URL("http://lrviewer.papajohns.com:8080/onlineviewer/hour_minutes.jsp?a=-1&date=01/16/2017&hourno=13");
        getOPMaverage("12:40", "13:40");
    }

    public static int getOPMaverage(String starttime, String endtime) throws Exception {
        int startHour = Integer.parseInt(starttime.substring(0, 2));
        int startMinute = Integer.parseInt(starttime.substring(3, 5));

        int endHour = Integer.parseInt(endtime.substring(0, 2));
        int endMinute = Integer.parseInt(endtime.substring(3, 5));
        int count = 60;

        for (int k = startHour; k <= endHour; k++) {
            //int hourno =
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            //System.out.println(dateFormat.format(date));
            //  System.out.println(l);

            // System.out.println(dateFormat.format(date));



                String formURL = "http://lrviewer.papajohns.com:8080/onlineviewer/hour_minutes.jsp?a=-1&date=" + dateFormat.format(date) + "&hourno=" + k;
                // System.out.println(formURL);
            BufferedReader in = null;
            try {
                URL lrconnect = new URL(formURL);
                // URL lrconnect = new URL("http://lrviewer.papajohns.com:8080/onlineviewer/hour_minutes.jsp?a=-1&date=06/21/2019&hourno=10");
                in = new BufferedReader(new InputStreamReader(lrconnect.openStream()));
            } catch (Exception e) {
               // e.printStackTrace();
                return 1200;

            }

            String inputLine;
                ArrayList<String> list = new ArrayList<>();
                int maxopm = 0;
                int minopm = 3000;
                int totalopm = 0;
                float averageopm;

                ArrayList<String> allOPMLines = new ArrayList<>();


                while ((inputLine = in.readLine()) != null) {

                    if (inputLine.contains("<td bgcolor=\"#ccffff\" valign=bottom align=right style=\"font-weight: bold;\">")) {
                        allOPMLines.add(inputLine);
                    }


                }


                ArrayList<String> onlyOrders = new ArrayList<>();
                ArrayList<String> ordered = new ArrayList<>();
                ArrayList<Integer> finalOPM = new ArrayList<>();


                for (int i = 0; i < allOPMLines.size(); i = i + 3) {
                    //System.out.println(allOPMLines.get(i));
                    onlyOrders.add(allOPMLines.get(i));
                }

                for (int i = 0; i <= 55; i = i + 5) {
                    ordered.add(onlyOrders.get(i));
                }

                for (int i = 1; i <= 56; i = i + 5) {
                    ordered.add(onlyOrders.get(i));
                }

                for (int i = 2; i <= 57; i = i + 5) {
                    ordered.add(onlyOrders.get(i));
                }


                for (int i = 3; i <= 58; i = i + 5) {
                    ordered.add(onlyOrders.get(i));
                }

                for (int i = 4; i <= 59; i = i + 5) {
                    ordered.add(onlyOrders.get(i));
                }


                //  System.out.println(onlyOrders.get(5));

                for (String a : ordered) {
                    int startIndex = 77;
                    int endIndex = a.indexOf("</td>");
                    String parseOPM = a.substring(startIndex, endIndex).trim().replace(",", "");

                    finalOPM.add(Integer.parseInt(parseOPM));
                    // System.out.println(parseOPM);
                }

           /* for (int i : finalOPM) {
                System.out.println(i);
            }*/

                if (k == startHour) {
                    for (int i = startMinute; i < 60; i++) {
                        //System.out.println(finalOPM.get(i));
                        opm_total.add(finalOPM.get(i));
                    }
                }

                if (k == endHour) {
                    for (int i = endMinute; i >= 0; i--) {
                        //System.out.println(finalOPM.get(i));
                        opm_total.add(finalOPM.get(i));
                    }
                }


            }


            return getAverage(opm_total);
        }


    public static int getAverage(ArrayList<Integer> opm_total) {
        int average = 0;
        for(int a : opm_total) {
       //     System.out.println(a);
            average +=  a ;
        }
       //System.out.println(average/61);
        return average/61;
    }
}

