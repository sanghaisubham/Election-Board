package service;

import java.util.Scanner;

public class ConsoleUtility {

    static Scanner sc = new Scanner(System.in);
    public static String inputText(){
       return sc.nextLine();
    }

    public static int inputNumber(){
        return Integer.parseInt(sc.nextLine());
    }

    public static void log(String log){
        System.out.println(log);
    }

}
