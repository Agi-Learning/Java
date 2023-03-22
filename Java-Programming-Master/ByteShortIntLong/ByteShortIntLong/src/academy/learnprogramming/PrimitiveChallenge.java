package academy.learnprogramming;

public class PrimitiveChallenge {
    public static void main(String[] arg){
        byte byteValue = 10;
        short shortValue = 20;
        int intValue = 50;

        long longTotal = 50000L + 10L * (byteValue +  shortValue + intValue);
        System.out.println(longTotal);

        short shortTotal = (short)(1000 + 10 *
                (byteValue + shortValue + intValue));
    }
}
