package algoexpert.easy;

import java.util.*;

public class ProductSum {


    public static int productSum(List<Object> array) {
       return getProductSum(array,1);
    }

    private static int getProductSum(List<Object> arr, int depth) {
       int sum =0;
       for(Object o:arr){
           if(o instanceof ArrayList){
               System.out.println("arr");
               sum+= getProductSum((ArrayList) o,++depth);
           }
           else{
               System.out.println("int");
               sum+= (int) o;
           }
       }
       return sum * depth;
    }

}
