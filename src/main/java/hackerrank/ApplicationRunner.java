package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ApplicationRunner {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        List<Trader> invItem = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("traders.txt"));
            String fileRead = br.readLine();
            while(fileRead != null)
            {
                String[]tokenize = fileRead.split(":");
                String tempCName = tokenize [0];
                String tempLocation = tokenize [1];
                String tempServices = tokenize [2];
                int tempEmployees = Integer.parseInt(tokenize[3]);
                double tempRate = Double.parseDouble(tokenize[4]);
                String tempDesc = tokenize[5];

                Trader tempObj = new Trader (tempCName, tempLocation, tempServices, tempEmployees, tempRate, tempDesc);
                invItem.add(tempObj);
                fileRead = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("List Traders.......1");
        System.out.println("Select Trader......2");
        System.out.println("Search locations...3");
        System.out.println("Search Services....4");
        System.out.println("Exit...............0");
        System.out.print("Enter Choice:> ");

        char Ch = inputReader.findInLine(".").charAt(0);
     /*  if (Character.getNumericValue(Ch) == 1){            
           for (Trader each : invItem){
           System.out.println("-----------------------------------------------------------------");
           System.out.println("|ID| Company Name |Location | Services offered |");
           System.out.println(each);
           }
       }*/
        if (Character.getNumericValue(Ch) == 2){
            System.out.print("Enter Trader ID from list [0-24] :> ");
            int userChoice = inputReader.nextInt();
            System.out.println(invItem.get(userChoice));
        }
        else if (Character.getNumericValue(Ch) == 3){
            System.out.println("Enter a Location:>");
        }
        else if (Character.getNumericValue(Ch) == 4){
            System.out.println("Enter a Services:>");
        }
        else if (Character.getNumericValue(Ch) == 0){
            return;
        }

    }

}