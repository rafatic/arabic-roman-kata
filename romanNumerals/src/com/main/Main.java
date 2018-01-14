package com.main;


/**
 * Created by raphael on 12/01/2018.
 */


public class Main {

    public static void main(String[] args)
    {
        RomanStringBuilder romanSB = new RomanStringBuilder(35);
        romanSB.ParseArabicToRoman();

        System.out.println("Result : " + romanSB.GetRoman());
    }
}
