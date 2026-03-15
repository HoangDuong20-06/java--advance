package Bai6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        CinemaManager manager=new CinemaManager();

        Scanner sc=new Scanner(System.in);

        while(true){

            System.out.println("1.Start");
            System.out.println("2.Stats");
            System.out.println("3.Exit");

            int choice=sc.nextInt();

            if(choice==1)
                manager.start();

            if(choice==2)
                manager.showStats();

            if(choice==3)
                break;
        }
    }
}
