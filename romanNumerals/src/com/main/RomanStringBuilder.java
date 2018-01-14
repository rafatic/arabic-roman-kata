package com.main;

/**
 * Created by raphael on 12/01/2018.
 */


public class RomanStringBuilder
{
    private int arabic;
    private StringBuilder roman;
    private static String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};
    private static int[] values = {1000, 500, 100, 50, 10, 5, 1};

    public RomanStringBuilder(int arabic)
    {
        this.arabic = arabic;
        roman = new StringBuilder();
    }

    public StringBuilder GetRoman()
    {
        return this.roman;
    }

    private void addSymbol()
    {
        String symbolToAdd = "";
        int numberOfSymbolsToAdd = 0, i = 0;
        boolean found = false;

        while(!found && i < values.length)
        {
            if(arabic >= values[i])
            {
                found = true;
                symbolToAdd = symbols[i];
                numberOfSymbolsToAdd = arabic / values[i];
                arabic -= values[i] * numberOfSymbolsToAdd;
            }
            else
            {
                i++;
            }
        }
        for (int j = 0; j < numberOfSymbolsToAdd; j++)
        {
            roman.append(symbolToAdd);

        }
        checkAndCorrectSyntax(symbolToAdd, numberOfSymbolsToAdd, i);
    }

    private void checkAndCorrectSyntax(String symbolAdded, int numberOfSymbolsAdded, int symbolIndex)
    {
        String replacementString = "";
        if(symbolIndex != 0 && numberOfSymbolsAdded >= 4)
        {
            replacementString = symbolAdded + symbols[symbolIndex - 1];
            roman.replace(roman.length() - numberOfSymbolsAdded, roman.length(), replacementString);

            if(roman.length() >= 3)
            {
                if(roman.charAt(roman.length() - 3) == roman.charAt(roman.length() - 1))
                {
                    if(symbolIndex > 1)
                    {
                        replacementString = roman.charAt(roman.length() - 2) + symbols[symbolIndex - 2];
                    }
                    else
                    {
                        replacementString = roman.charAt(roman.length() - 2) + symbols[0];
                    }
                    roman.replace(roman.length() - 3, roman.length(), replacementString);
                }
            }

        }
    }

    public void ParseArabicToRoman()
    {
        while(arabic != 0)
        {
            addSymbol();
        }
    }
}
