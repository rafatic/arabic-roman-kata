package com.main;


/**
 * Created by raphael on 12/01/2018.
 *
 * Main class to use as startup class
 */


public class Main {

    public static void main(String[] args)
    {
        // Example of execution
        RomanStringBuilder romanSB = new RomanStringBuilder(35);
        romanSB.ParseArabicToRoman();

        System.out.println("Result : " + romanSB.GetRoman());
    }
}
