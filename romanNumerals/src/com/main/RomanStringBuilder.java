package com.main;

/**
 * Created by raphael on 12/01/2018.
 *
 * This class manages the conversion of arabic number into roman numerals.
 */


public class RomanStringBuilder
{
    private int arabic;
    private StringBuilder roman;
    // Array of possible roman symbols sorted by descending value
    private static String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};
    // Array of corresponding arabic values
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

    // Builds the roman number
    private void addSymbol()
    {
        String symbolToAdd = "";
        int numberOfSymbolsToAdd = 0, i = 0;
        boolean found = false;

        // Adds one or several occurrences of the largest roman symbol possible
        // and subtracts the corresponding value from the arabic number
        while(!found && i < values.length)
        {
            // Finds the largest roman symbol we can use depending of the remainder
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
        // Appends the found symbol N times
        // This part acts as a "naive" builder. It can make mistakes such as adding 4 of the same numeral
        // Thus, the string will need to be corrected if there are any errors.
        for (int j = 0; j < numberOfSymbolsToAdd; j++)
        {
            roman.append(symbolToAdd);
        }

        // Once the symbol(s) have been appended, we check the validity of the roman numeral string
        checkAndCorrectSyntax(symbolToAdd, numberOfSymbolsToAdd, i);
    }

    // Checks and corrects a roman numeral string
    private void checkAndCorrectSyntax(String symbolAdded, int numberOfSymbolsAdded, int symbolIndex)
    {
        String replacementString;

        // The "naive" builder can add the same character four times (ex : IIII)
        // Since this pattern is not valid, we want to check its presence and correct it.
        // To correct this incorrect pattern, we need to check if the last four characters are equal
        // If so, we transform the pattern to its correct representation (ex : IIII gives IV)
        // note : the symbol "M" does not follow this rule
        if(symbolIndex != 0 && numberOfSymbolsAdded >= 4)
        {

            replacementString = symbolAdded + symbols[symbolIndex - 1];
            roman.replace(roman.length() - numberOfSymbolsAdded, roman.length(), replacementString);

            if(roman.length() >= 3)
            {
                // The previous correction can lead to a second false pattern.
                // Let A, B and C three symbols where C > B > A.
                // The said pattern is : BAB, this needs to be transformed as : AC
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
