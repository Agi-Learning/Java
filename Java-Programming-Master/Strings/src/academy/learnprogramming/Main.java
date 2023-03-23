package academy.learnprogramming;
//String
//
//The String is a datatype in Java, which is not primitive type. It's actually a Class, but it enjoys a bit of favoritism in Java to make it easier to use than a regular class.
//
//A String is a sequence of characters. In the case of the char which you can see above which discussed in the previous video, it could contain a single character only (regular character or Unicode character).
//
//A string can contain a sequence of characters. A large number of characters. Technically it's limited by memory or the MAX_VALUE of an int which was 2.14 Billion. That's a lot of characters.


public class Main {
    public static void main(String[] args) {
        String myString = "This is a string";
        System.out.println("myString is equal to " + myString);
        myString = myString + ", and this is equal to ";
        System.out.println("myString is equal to " + myString);
        myString = myString + "\u00A9 2019";
        System.out.println("myString is equal to " + myString);
        // it got versility in the regular and unicode characters, and also amount char significant amount of characters if we like
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println(numberString);
        int myInt = 50;
        String lastString = "10";
        lastString = lastString + myInt;
        // integer add end of the string, the apply to last integer string to configure setup as a string,
        // What java is doing, convert content of myInt, and converts the value 50 to a string then appends that to the 10

//        Strings in Java are Immutable
//        When I said you can delete characters out of a Strings, that's not strictly true. Because Strings in Java are immutable. That means you can't change String after its created. Instead, what happens is a new String is created.
//
//        So in the case of this code, lastString doesn't get appended the value "120.47" instead a new String is created which consists of the previous value of lastString plus a text representation of the double value 120.47.
//
//        The net result is the same, lastString has the right values, however, a new String got created and the old one got discarded.
//
//        Don't worry if this makes on sense, it will later in the course. For now, I just wanted to point out that String are immutable.
        System.out.println("LastString is equal to " + lastString);
        double doubleNumber = 120.47d;
        lastString = lastString + doubleNumber;
        System.out.println("LastString is equal to " + lastString);

//        The Code We Used To Append Strings Was Inefficient
//
//        As a result of a String being created, appending values like this is inefficient and not recommended. I'll show you a better way of doing it in a future video where we discuss something called a StringBuffer which can be changed.
//
//        We need an understanding of classes before we tackle StringBuffer, and also you will come across code written in the style i've used in this lecture so it's still useful for you to know how to do things this way.

    }
}