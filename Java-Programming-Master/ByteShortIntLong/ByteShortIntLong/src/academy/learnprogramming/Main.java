package academy.learnprogramming;
// 1. A package is a way to organize your java projects. For new, consider them as folders with learnprogramming in our example being a subfolder of academy. Companies use their domain names reversed.
public class Main {
    public static void main(String[] args){
        int myValue = 1000;
        // int is an integer it really helps to set the variable's value. Integer on the other hand is what's called a Wrapper class.
        // Java uses the concept of a Wrapper class for all eight primitive types - In the case of an int, we can use Integer, and by doing that it gives us ways to perform operations on an int.
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        // In this case, we are using the MIN_VALUE and MAX_VALUE to get Java to tell us the minimum and maximum ranges of numbers that can be stored.
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);
        System.out.println("Busted Max value = " + (myMaxIntValue + 2));
        // We assigned for maxi value +1 has turned into a minus number, to a negative number. This is called an overflow. We tried to put too large a number into the space allocated by the computer for an integer.
        // Will didn't fit, so the computer tried to fit it anyway. By doing it overflowed The reverse is also true here. So if I change that or actually add a new line.
        System.out.println("Busted MIN value = "+ (myMinIntValue - 1));
//        We've sort of cycled around to the maximum value. called underflow

        // If you try and put a value larger than the maximum value in Java, or a value smaller than the minimum value in java, then you will get an Overflow in the case of the maximum value or an underflow in the case of the minimum.
        // The computer just skips back to the minumum number and max  number. which is usually not what you want. it's an important concept to be aware of. it;s bad thing

        // But ultimate as a programmer, Its our responsibility to use the appropriate data type and ensure the range of numbers we're trying to store in that data type is within the range. In this case the min and max value.
//        int myMaxIntTest = 2147483648;
        // Because we take about literal value for an integer, and intelliJ can then figure out and know that okay, that number is clearly outside of the range of the maximum number that can be stored. and it flagged immediately unlike what happened with the code on line 13 and 14
        int myMaxIntTest = 2_147_483_647; // it will work java 7 higher
        System.out.println(myMaxIntTest);
        // 2. A Byte occupies 8 bits. A bit is not directly represented in a primitive type - 
        // A short can store a large range of numbers and occupies 16bits, and has a width of 16
        // An int, has a much larger range as we know, and occupies 32bits, and has a width of 32
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = "+ myMinByteValue);
        System.out.println("Byte Maximum Value = "+ myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = "+ myMinShortValue);
        System.out.println("Short Maximum Value = "+ myMaxShortValue);

        long myLongValue = 100L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value = "+ myMinLongValue);
        System.out.println("Long Maximum Value = "+ myMaxLongValue);
        // still treated this number as an integer, So We've put an L on the end there to treat it as a long,
        long bigLongLiteralValue = 2_147_483_647_234L;
        System.out.println(bigLongLiteralValue);

        // 3. Casting
        // Casting means to treat or convert a number from one type to another. We put the type we want the number to be in parenthesis like this;
        // (byte) (myMinByteValue /2)
        // Other languages have casting, this is not just a java thing.
        int myTotal = (myMinIntValue / 2);
        byte myNewByteValue = (byte)(myMinByteValue / 2);
        // because we tell to java the following the parentheses byte parentheses as a byte, and the error then disappears. this is a byte and treated as a byte instead of the default, which was an integer.

        short myNewShortValue = (short)(myMinByteValue / 2);
    }
}
