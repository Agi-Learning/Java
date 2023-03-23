package academy.learnprogramming;

//The Char and Boolean Primitive Types
//
//char relevant released in later 1990, i like fast computing that have got lots more memory, another use char could be store in a data in memory
//
//literally store single character in a single char variable, Now you might be looking at that thinking that, one char, it only occupy single byte in meory
//
//A char occupies 2 bytes of memory, or 16 bits and thus has a width of 16. The reason it's not just a single byte is that it allows you to store Unicode characters.
//
//Unicode is an international encoding standard for use with different languages and scripts, by which each letter, digit, or symbol is assigned a unique numeric value that applies across different platforms and programs.
//
//In the English alphabet, we have the letters A through Z. Meaning only 26 characters are needed in total to represent the entire English alphabet. But other languages need more characters, and often a lot more.
//
//Unicode allows us to represent these languages and the way it works is that by using a combination of the 2 bytes that a char takes up in memory it can represent and one of 65535 different types of characters.
//
//www.unicode-table.com
//
//
//Boolean Primitive Type
//
//A boolean value allows for 2 choices True of False, Yes or No, 1 or 0. In java terms we have a boolean primitive type and it can be set to 2 values only. true or false. They are actually pretty useful and you will use them a lot when programming.
public class Main {
    public static void main(String[] args) {
        // char literally string, only one char
        char myChar = 'D';
        char myUnicodeChar = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);
        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        boolean isCustomerOverTwentyOne = true;

        System.out.println(myTrueBooleanValue);

    }
}