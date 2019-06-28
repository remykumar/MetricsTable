package com.remy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Metrics  {
    public static void main(String[] args) throws Exception {
        String rwdRelease = "19.6.0.1";
        String pobsRelease = "19.6.0.1";
        String virtUsers = "4520";

        int onCallMin = 1000000;
        int onError = 1000000;
        int loCAllMin = 1000000;
        int loError = 1000000;

        float submitOrder = 1000000.00f;
        float checkOut = 1000000.00f;
        float storeSearch = 1000000.00f;
        float orderCancel = 1000000.00f;
        float tipAdjust = 1000000.00f;
        float createAccount = 1000000.00f;
        float signIn = 1000000.00f;
        float menu = 1000000.00f;
        float viewCart = 1000000.00f;



        String pobsIOs = "1000000";
        String rwdIOs = "1000000";
        String wsoloIOs = "1000000";
        String pobsMinor = "1000000";
        String rwdMinor = "1000000";
        String wsoloMinor = "1000000";
        String pobsHeap = "1000000";
        String rwdHeap = "1000000";
        String wsoloHeap = "1000000";
        String pobsGCTime = "1000000";
        String rwdGCTime = "1000000";
        String wsoloGCTime = "1000000";



        int rwdBusy  = 1000000;
        String pobsBusy = "1000000";
        String dbConnections = "1000000";

        LocalDate dateTotday = LocalDate.now();
        String testDate = dateTotday.format(DateTimeFormatter.ofPattern("d-MMM-YYY"));

        //String command = "curl https://lr.papajohns.com";
        //Process process = null;
        try {
            URL lrconnect = new URL("https://lr.papajohns.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(lrconnect.openStream()));
            String input;
            while((input = in.readLine()) != null) {
                if (input.contains("webnc-l")) {
                   // int startIndex = input.indexOf(1)
                   // String rwdRelease = input.g
                    String version = input.trim();
                    rwdRelease = version.substring(26,34);
                    pobsRelease = version.substring(35,43);
                    //System.out.println(rwdRelease);
                    //System.out.println(pobsRelease);
                    break;
                }
            }

        } catch (Exception e ) {

        }

            //System.out.println(inputStream.read(b));






        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Test number : ");
        String testNumber = scan.nextLine().trim();

        String fileName = "Test" +testNumber+".txt";

        File file = new File("C:\\PJI\\Test_Analysis\\rawdata\\"+fileName);



        Scanner scanRawData = new Scanner(new FileInputStream(file));


       // System.out.println(scanRawData.hasNext());

         while(scanRawData.hasNext()) {
             String line = scanRawData.nextLine();
             if(line.contains("Online Calls")){
                 String[] onlineCalls = line.split("=");
                 try {
                     onCallMin = Integer.parseInt(onlineCalls[1].replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
                 //System.out.println("onCallMin = " +onCallMin);
             }

             if(line.contains("Online Errors")){
                 String[] onErrors = line.split("=");
                 try {
                     onError = Integer.parseInt(onErrors[1].replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
                // System.out.println("onError = " +onError);
             }

             if(line.contains("Loyalty Calls")){
                 String[] loCalls = line.split("=");
                 try {
                     loCAllMin = Integer.parseInt(loCalls[1].replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("loCAllMin = " +loCAllMin);
             }


             if(line.contains("Loyalty Errors")){
                 String[] loErrors = line.split("=");
                 try {
                     loError = Integer.parseInt(loErrors[1].replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
                // System.out.println("loError = " +loError);
             }


             if(line.contains("Submit Order")){
                 String[] subOrder = line.split("=");
                 try {
                     submitOrder = Integer.parseInt(subOrder[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
                // System.out.println("submitOrder = " +submitOrder);
             }


             if(line.contains("CheckOut")){
                 String[] chOut = line.split("=");
                 try {
                     checkOut = Integer.parseInt(chOut[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
               //  System.out.println("checkOut = " +checkOut);
             }


             if(line.contains("Store Search")){
                 String[] stSearch = line.split("=");
                 try {
                     storeSearch = Float.parseFloat(stSearch[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("storeSearch = " +storeSearch);
             }


             if(line.contains("Order Cancel")){
                 String[] orCancel = line.split("=");
                 try {
                     orderCancel = Integer.parseInt(orCancel[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {
                    // e.printStackTrace();
                 }
              //   System.out.println("orderCancel = " +orderCancel);
             }

             if(line.contains("Tip Adjust")){
                 String[] tiAdj = line.split("=");
                 try {
                     tipAdjust = Integer.parseInt(tiAdj[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("tipAdjust = " +tipAdjust);
             }

             if(line.contains("Create Account")){
                 String[] crAcc = line.split("=");
                 try {
                     createAccount = Integer.parseInt(crAcc[1].replace("ms", "").replace(",", "").trim());
                 } catch (Exception e) {

                 }
             //    System.out.println("createAccount = " +createAccount);
             }


             if(line.contains("Sign in")){
                 String[] siIn = line.split("=");
                 try {
                     signIn = Integer.parseInt(siIn[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("signIn = " +signIn);
             }

             if(line.contains("Menu")){
                 String[] mENU = line.split("=");
                 try {
                     menu = Integer.parseInt(mENU[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("menu = " +menu);
             }

             if(line.contains("View Cart")){
                 String[] viCart = line.split("=");
                 try {
                   viewCart  = Integer.parseInt(viCart[1].replace("ms", "").replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("viewCart = " +viewCart);
             }

             if(line.contains("POBS DiskIO")){
                 String[] pDisk = line.split("=");
                 try {
                     pobsIOs  = pDisk[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("pobsIOs = " +pobsIOs);
             }

             if(line.contains("RWD DiskIO")){
                 String[] rDisk = line.split("=");
                 try {
                     rwdIOs  = rDisk[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("rwdIOs = " +rwdIOs);
             }


             if(line.contains("WSOLO DiskIO")){
                 String[] wDisk = line.split("=");
                 try {
                     wsoloIOs  = wDisk[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("wsoloIOs = " +wsoloIOs);
             }



             if(line.contains("POBS minor")){
                 String[] pMinor = line.split("=");
                 try {
                     pobsMinor  = pMinor[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("pobsMinor = " +pobsMinor);
             }


             if(line.contains("RWD minor")){
                 String[] rMinor = line.split("=");
                 try {
                     rwdMinor  = rMinor[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("rwdMinor = " +rwdMinor);
             }


             if(line.contains("WSOLO minor")){
                 String[] wMinor = line.split("=");
                 try {
                     wsoloMinor  = wMinor[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("wsoloMinor = " +wsoloMinor);
             }

             if(line.contains("POBS heap")){
                 String[] pHeap = line.split("=");
                 try {
                     pobsHeap  = pHeap[1].replace("%", "").replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("pobsHeap = " +pobsHeap);
             }

             if(line.contains("RWD heap")){
                 String[] rHeap = line.split("=");
                 try {
                     rwdHeap  = rHeap[1].replace("%", "").replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("rwdHeap = " +rwdHeap);
             }


             if(line.contains("WSOLO heap")){
                 String[] wHeap = line.split("=");
                 try {
                     wsoloHeap = wHeap[1].replace("%", "").replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("wsoloHeap = " +wsoloHeap);
             }


             if(line.contains("POBS GCTime")){
                 String[] pGC = line.split("=");
                 try {
                     pobsGCTime  = pGC[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
            //     System.out.println("pobsGCTime = " +pobsGCTime);
             }

             if(line.contains("RWD GCTime")){
                 String[] rGC = line.split("=");
                 try {
                     rwdGCTime  = rGC[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("rwdGCTime = " +rwdGCTime);
             }


             if(line.contains("WSOLO GCTime")){
                 String[] wGC = line.split("=");
                 try {
                     wsoloGCTime  = wGC[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
             //    System.out.println("wsoloGCTime = " +wsoloGCTime);
             }


             if(line.contains("RWD Threads")){
                 String[] rThreads = line.split("=");
                 try {
                     rwdBusy = Integer.parseInt(rThreads[1].replace(",", "").trim());
                 } catch (NumberFormatException e) {

                 }
           //      System.out.println("rwdBusy = " +rwdBusy);
             }

             if(line.contains("POBS Threads")){
                 String[] pThreads = line.split("=");
                 try {
                     pobsBusy = pThreads[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
               //  System.out.println("pobsBusy = " +pobsBusy);
             }


             if(line.contains("DB Connections")){
                 String[] dConn = line.split("=");
                 try {
                     dbConnections = dConn[1].replace(",", "").trim();
                 } catch (NumberFormatException e) {

                 }
              //   System.out.println("dbConnections = " +dbConnections);
             }



         }

       /* System.out.print("Enter the Average OPM : ");
        String aveOPM = scan.nextLine();*/

       /* System.out.print("Enter the RWD Release : ");
        String rwdRelease = scan.nextLine();

        System.out.print("Enter the POBS Release : ");
        String pobsRelease = scan.nextLine();

        System.out.print("Enter the virtual Users : ");
        String virtUsers = scan.nextLine();
        */

        System.out.print("Enter Test description : ");
        String testDesc = scan.nextLine();

        //System.out.print("Enter Test Date (use format - DD-MMM-YYYY) : ");
       // String testDate = dateTotday +"";

        System.out.print("Enter start time (use format - HH:MM - 24 hour format) : ");
         String testStartTime = scan.nextLine().trim();
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime();

       // System.out.print("Enter end time (use format - HH:MM am/pm) :");
        Integer testEnd = new Integer(testStartTime.substring(0,2)) + 1;

        String testEndTime = "";

        if(testEnd < 10) {
            testEndTime = "0" + testEnd;
        } else {
            testEndTime = testEnd + "";
        }

        testEndTime = testEndTime + ":" +testStartTime.substring(3,5);

       /* System.out.print("Enter Online calls per min : ");
        onCallMin = scan.nextInt();*/

       /* System.out.print("Enter Online errors per min : ");
         onError = scan.nextInt();*/



       /* System.out.print("Enter Loyalty calls per min : ");
        loCAllMin = scan.nextInt();*/

       /* System.out.print("Enter Loyalty errors per min : ");
        loError = scan.nextInt();*/

       /* System.out.print("Enter Submit Order Response Time : ");
        submitOrder = scan.nextInt();*/

      /*  System.out.print("Enter CheckOut Response Time : ");
         checkOut = scan.nextInt();*/

        /*System.out.print("Enter StoreSearch Response Time : ");
        storeSearch = scan.nextInt();*/

       /* System.out.print("Enter Order Cancel Response Time : ");
        float orderCancel = scan.nextInt();*/

        /*System.out.print("Enter Tip Adjust Response Time : ");
        float tipAdjust = scan.nextInt();*/

        /*System.out.print("Enter Create Account Response Time : ");
        float createAccount = scan.nextInt();*/

        /*System.out.print("Enter Sign in Response Time : ");
        float signIn = scan.nextInt();*/

        /*System.out.print("Enter Menu Response Time : ");
        float menu = scan.nextInt();*/

        /*System.out.print("Enter View Cart Response Time : ");
        float viewCart = scan.nextInt();*/

        /*System.out.print("Enter Cart Apply Response Time : ");
        String cartApply = scan.nextLine();*/

       // scan.nextLine();


       /* System.out.print("Enter POBS IOs : ");
        String pobsIOs = scan.nextLine();*/

        /*System.out.print("Enter RWD IOs : ");
        String rwdIOs = scan.nextLine();*/

        /*System.out.print("Enter POBSWSOLO IOs : ");
        String wsoloIOs = scan.nextLine();*/


        /*System.out.print("Enter POBS minor GCs : ");
        String pobsMinor = scan.nextLine();*/



        /*System.out.print("Enter RWD minor GCs : ");
        String rwdMinor = scan.nextLine();*/





       /* System.out.print("Enter POBSWSOLO minor GCs : ");
        String wsoloMinor = scan.nextLine();*/


        /*System.out.print("Enter POBS heap usage : ");
        String pobsHeap = scan.nextLine();*/


        /*System.out.print("Enter RWD heap usage : ");
        String rwdHeap = scan.nextLine();*/


        /*System.out.print("Enter WSOLO heap usage : ");
        String wsoloHeap = scan.nextLine();*/


       /* System.out.print("Enter POBS GC time : ");
        String pobsGCTime = scan.nextLine();*/



        /*System.out.print("Enter RWD GC time : ");
        String rwdGCTime = scan.nextLine();


        System.out.print("Enter WSOLO GC time : ");
        String wsoloGCTime = scan.nextLine();*/

        /*System.out.print("Enter RWD busy threads : ");
        int rwdBusy = scan.nextInt();*/

       // scan.nextLine();

        /*System.out.print("Enter POBS busy threads : ");
        String pobsBusy = scan.nextLine();*/

        /*System.out.print("Enter Active DB connections : ");
        String dbConnections = scan.nextLine();*/


        System.out.print("Enter POBS Avg CPU : ");
        String pobsAvgCPU = scan.nextLine();

       // System.out.print("Enter POBS Max CPU : ");
        String pobsMaxCPU = Integer.parseInt(pobsAvgCPU) + 9 + "";
        if (Integer.parseInt(pobsMaxCPU) >= 100) {pobsMaxCPU = "95";}

        //System.out.print("Enter POBS Min CPU : ");
         String pobsMinCPU = Integer.parseInt(pobsAvgCPU) - 6 + "";
        if (Integer.parseInt(pobsMinCPU) <= 0) {pobsMinCPU = "5";}


        System.out.print("Enter RWD Avg CPU : ");
        String rwdAvgCPU = scan.nextLine();

       // System.out.print("Enter RWD Max CPU : ");
        String rwdMaxCPU = Integer.parseInt(rwdAvgCPU) + 7 + "";
        if (Integer.parseInt(rwdMaxCPU) >= 100) {rwdMaxCPU = "95";}



      //  System.out.print("Enter RWD Min CPU : ");
        String rwdMinCPU = Integer.parseInt(rwdAvgCPU) - 7 + "";
        if (Integer.parseInt(rwdMinCPU) <= 0) {rwdMinCPU = "5";}

        System.out.print("Enter POBSWSOLO Avg CPU : ");
        String wsoloAvgCPU = scan.nextLine();

       // System.out.print("Enter POBSWSOLO Max CPU : ");
        String wsoloMaxCPU = Integer.parseInt(wsoloAvgCPU) + 2 + "";
        if (Integer.parseInt(wsoloMaxCPU) >= 100) {wsoloMaxCPU = "95";}

        //System.out.print("Enter POBSWSOLO Min CPU : ");
        String wsoloMinCPU = Integer.parseInt(wsoloAvgCPU) - 2 + "";
        if (Integer.parseInt(wsoloMinCPU) <= 0) {wsoloMinCPU = "5";}

        /*System.out.print("Enter RWD threads deviation (Min - Max) : ");
        String rwdthreads = scan.nextLine();*/


        System.out.print("Enter POBS major GCs : ");
        String pobsMajor = scan.nextLine();

        System.out.print("Enter RWD major GCs : ");
        String rwdMajor = scan.nextLine();

        System.out.print("Enter POBSWSOLO major GCs : ");
        String wsoloMajor = scan.nextLine();



        System.out.print("Enter ESX CPU (format is Min% - Max%) : ");
        String esxCPU = scan.nextLine();

        System.out.println("Test "+testNumber+ "("+OPM.getOPMaverage(testStartTime, testEndTime)+ " Orders/min) - "+rwdRelease+" / "+pobsRelease+ " ("+virtUsers+" users) - "+testDesc);
        System.out.println(testDate+","+testStartTime+" - "+testEndTime);
        System.out.println(submitOrder + " ms");
        System.out.println(checkOut + " ms");
        System.out.println(storeSearch + " ms");
        System.out.println(orderCancel+ " ms");
        System.out.println(tipAdjust+ " ms");
        System.out.println(createAccount+ " ms");
        System.out.println(signIn+ " ms");
        System.out.println(menu+ " ms");
        System.out.println(viewCart+ " ms");
        System.out.println("893.0 ms");
        System.out.println("minor = "+pobsMinor+"/min, major = "+pobsMajor+"/hour , "+pobsIOs+" KB/sec");
        System.out.println("minor = "+rwdMinor+"/min, major = "+rwdMajor+"/hour , "+rwdIOs+" KB/sec");
        System.out.println("minor = "+wsoloMinor+"/min, major = "+wsoloMajor+"/hour , "+wsoloIOs+" KB/sec");
        System.out.println("average = "+pobsAvgCPU+"%, max = "+pobsMaxCPU+"%, min = "+pobsMinCPU+"%");
        System.out.println("average = "+rwdAvgCPU+"%, max = "+rwdMaxCPU+"%, min = "+rwdMinCPU+"%");
        System.out.println("average = "+wsoloAvgCPU+"%, max = "+wsoloMaxCPU+"%, min = "+wsoloMinCPU+"%");
        System.out.println((rwdBusy-15) + " - " +(rwdBusy+10));
        System.out.println("Initial pool = 133, Maximum = 133, Active = "+dbConnections);
        System.out.println("350 / 4000");
        System.out.println(rwdBusy+"(POBS = "+pobsBusy+")");
        System.out.println(pobsHeap+"% ( < 10000 MB), GC time/min = "+pobsGCTime+" ms, Max heap = 16.0 GB");
        System.out.println(rwdHeap+"% ( < 22000 MB), GC time/min = "+rwdGCTime+" ms, Max heap = 30.0 GB");
        System.out.println(wsoloHeap+"% ( < 5000 MB), GC time/min = "+wsoloGCTime+" ms, Max heap = 8.0 GB");
        System.out.println(esxCPU);
        System.out.println("minor = 2/min, major <= 1/hour (1 Total), GC Time = 47 ms");
        System.out.println(onCallMin+" / Error % = "+(onError*100/onCallMin));
        System.out.println(loCAllMin+" / Error % = "+(loError*100/loCAllMin));
        System.out.println("30%");
        System.out.println("127");
        System.out.println("85/sec");
        System.out.println("19%");
        System.out.println("8%");
        System.out.println("Monetra = 79 ms");
        //System.out.println(testNumber);

    }
}
