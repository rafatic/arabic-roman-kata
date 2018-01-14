package com.test;

import com.main.RomanStringBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by raphael on 13/01/2018.
 */
public class RomanStringBuilderTest {

    // Note : this unit test is not correct, it will stop on the first false assertion. We'd like it to continue and report every false assertion.
    @Test
    public void parseArabicToRoman() throws Exception {
        // Correct sequence of roman numerals and their arabic equivalents
        // (found on : https://www.calculateme.com/cRomanNumerals/ArabicNumeralsToRoman.htm)
        int[] inputs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 1900, 1901, 1902, 1903, 1904, 1905, 1906, 1907, 1908, 1909, 1910, 1911, 1912, 1913, 1914, 1915, 1916, 1917, 1918, 1919, 1920, 1921, 1922, 1923, 1924, 1925, 1926, 1927, 1928, 1929, 1930, 1931, 1932, 1933, 1934, 1935, 1936, 1937, 1938, 1939, 1940, 1941, 1942, 1943, 1944, 1945, 1946, 1947, 1948, 1949, 1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983};
        String[] expectedResults = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C","CI","CII","CIII","CIV","CV","CVI","CVII","CVIII","CIX","CX","CXI","CXII","CXIII","CXIV","CXV","CXVI","CXVII","CXVIII","CXIX","CXX","CXXI","CXXII","CXXIII","CXXIV","CXXV","CXXVI","CXXVII","CXXVIII","CXXIX","CXXX","CXXXI","CXXXII","CXXXIII","CXXXIV","CXXXV","CXXXVI","CXXXVII","CXXXVIII","CXXXIX","CXL","CXLI","CXLII","CXLIII","CXLIV","CXLV","CXLVI","CXLVII","CXLVIII","CXLIX","CL","CLI","CLII","CLIII","CLIV","CLV","CLVI","CLVII","CLVIII","CLIX","CLX","CLXI","CLXII","CLXIII","CLXIV","CLXV","CLXVI","CLXVII","CLXVIII","CLXIX","CLXX","CLXXI","CLXXII","CLXXIII","CLXXIV","CLXXV","CLXXVI","CLXXVII","CLXXVIII","CLXXIX","CLXXX","CLXXXI","CLXXXII","CLXXXIII","CLXXXIV","CLXXXV","CLXXXVI","CLXXXVII","CLXXXVIII","CLXXXIX","CXC","CXCI","CXCII","CXCIII","CXCIV","CXCV","CXCVI","CXCVII","CXCVIII","CXCIX","CC","MCM","MCMI","MCMII","MCMIII","MCMIV","MCMV","MCMVI","MCMVII","MCMVIII","MCMIX","MCMX","MCMXI","MCMXII","MCMXIII","MCMXIV","MCMXV","MCMXVI","MCMXVII","MCMXVIII","MCMXIX","MCMXX","MCMXXI","MCMXXII","MCMXXIII","MCMXXIV","MCMXXV","MCMXXVI","MCMXXVII","MCMXXVIII","MCMXXIX","MCMXXX","MCMXXXI","MCMXXXII","MCMXXXIII","MCMXXXIV","MCMXXXV","MCMXXXVI","MCMXXXVII","MCMXXXVIII","MCMXXXIX","MCMXL","MCMXLI","MCMXLII","MCMXLIII","MCMXLIV","MCMXLV","MCMXLVI","MCMXLVII","MCMXLVIII","MCMXLIX","MCML","MCMLI","MCMLII","MCMLIII","MCMLIV","MCMLV","MCMLVI","MCMLVII","MCMLVIII","MCMLIX","MCMLX","MCMLXI","MCMLXII","MCMLXIII","MCMLXIV","MCMLXV","MCMLXVI","MCMLXVII","MCMLXVIII","MCMLXIX","MCMLXX","MCMLXXI","MCMLXXII","MCMLXXIII","MCMLXXIV","MCMLXXV","MCMLXXVI","MCMLXXVII","MCMLXXVIII","MCMLXXIX","MCMLXXX","MCMLXXXI","MCMLXXXII","MCMLXXXIII"};

        // Tests every inputs.
        for (int i = 0; i < inputs.length; i++) {
            RomanStringBuilder rsb = new RomanStringBuilder(inputs[i]);
            rsb.ParseArabicToRoman();

            if(!expectedResults[i].equals(rsb.GetRoman().toString()))
            {
                assertFalse("[" + inputs[i] + "]" + " Expected : " + expectedResults[i] + " - got : " + rsb.GetRoman().toString(), true);
            }
        }
        assertTrue(true);
    }



}