package academy.learnprogramming;

//Floating Point Numbers
//
//Unlike whole numbers, floating point numbers have fractional parts that we express with a decimal point 3.14159 in an example
//
//Floating point numbers are also known as real numbers. We use a floating point number when we need more precision in calculations.
//
//So 2 primitive types in java for expressing floating point numbers
//float -> single precision number
//double -> double precision number
//
//Single and Double Precision
//
// refers to the format and amount of space occupied by the type. Single precision occupies 32 bits (so has a width of 32) and a Double precision occupies 64 bits (and thus has a width of 64).
//
//As a result the float has a range from 1.4E-45 to 3.4028235E+38 and the double is much more precise with a range from 4.9E-324 to 1.7976931348623157E+308.
public class Main {
    public static void main(String[] args) {
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value = " + myMinFloatValue);
        System.out.println("Float maximum value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value = " + myMinDoubleValue);
        System.out.println("Double maximum value = " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        float myFloatValue = (float) 5 / 3f;
        // float precision the 7 numbers after the floating point double
        // type casting indicates double, we have to specify float
        // double myDoubleValue = 5d / 3d;
        double myDoubleValue = 5.00 / 3.00; // java automatically taking as double. double precision number is recommended
        // java treated as double default floating point numbers.
        // the double precision the 16 numbers after the decimal, lot more precision than the float.
        System.out.println("MyIntValue= " + myIntValue);
        System.out.println("MyFloatValue= " + myFloatValue);
        System.out.println("MyDoubleValue= " + myDoubleValue);

        double numberOfPounds = 200d;
        double convertedKilograms = numberOfPounds * 0.45359237d;
        System.out.println("Converted Kilograms: " + convertedKilograms);
//
//        Convert a given number of pounds to kilograms.
//
//        STEPS:
//        1. Create a variable with the appropriate type to store the number of pounds to be converted to kilograms
//        2. Calculate the result i.e. the number of kilograms based on the contents of the variable above and store the result in a 2nd appropriate variable.
//        3. print out the result.
//
//        HINT 1 pound is equal to 0.45359237 of a kilogram. This should help you perform the calculation.
//
//                In general float and double are great for general floating point operations. But both are not great to use where precise calculations are required - this is due to a limitation with how floating point numbers are stored, and not a java problem as such.
//
//        Java has a class called BigDecimal that overcomes this. For now just keep in the back of your mind that when precise calculations are necessary, such as when performing currency calculations, floating-point types should not be used.
//
//                But for general calculations float and double are fine.
        double pi = 3.1415927d;
        double anotherNumber = 3_000_000.4_567_890d;
        System.out.println(pi);
        System.out.println(anotherNumber);
    }
}