package academy.learnprogramming;
//What are Operators?
//
//Operators in java are special symbols that perform specific operations on one, two or three operands, and then return a result. As an example, we used the + (addition) operator to sum the value of two variables in a previous video
//
//What is an Operand?
//
//An operand is a term used to describe any object that is manipulated by an operator. if we consider the statment
//
//int myVar = 15 + 12;
//
//Then  + is the operator, and 15 and 12 are the operands. Variables used instead of literals are also operands.
//
//double mySalary = hoursWorked * hourlyRate;
//
//in the above line hoursWorked and hourlyRate are operands, and * (multiplication) is the operator.
//
//What is and Expression?
//
//An expression is formed by combining variables, literals, method return values (which we haven't covered yet) and operators.
//
//In the line below 15 + 12 is the expression which has (or returns) 27 in this case.
//
//int myValue = 15 + 12;
//
//In the statement below, hoursWorked*hourlyRate is the expression. If hoursWorked was 10.00 and hourlyRate was 20.00 then the expression would return 200.00;
//
//double mySalary = hoursWorked * hourlyRate;

public class Main {
    public static void main(String[] args) {
        int result = 1 + 2; // 1 + 2 = 3
        System.out.println("1 + 2 = " + result);
//        What is a Comment?
//
//        Comments are ignored by the computer and are added to a program to help describe something. Comments are there for humans.
//
//                We use // in front of any code, or on a blank line. Anything after the // right through to the end of the line is ignored by the computer.
//
//        Aside from describing something about a program, comments can be used to temporarily disable code.
        int previousResult = result;
        System.out.println("previousResult = " + previousResult);
        result = result - 1; // 3 - 1 = 2
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult = " + previousResult);

        result = result * 10; // 2 * 10 = 20
        System.out.println("2 * 10 = " + result);

        result = result / 5; // 20 / 5 = 4
        System.out.println("2 * 10 = " + result);

        result = result % 3; // the remainder of (4 % 3) = 1
        System.out.println("(4 % 3) = " + result);

        // result = result + 1;
        result++; // 1 + 1 =2;
        System.out.println("1 + 1 = " + result);

        // result = result - 1;
        result--; // 2 - 1 =1;
        System.out.println("2 - 1 = " + result);

        // result = result +2;
        result += 2; // 1 + 2 = 3;
        System.out.println("1 + 2 = " + result);

        // result = result * 10;
        result *= 10; // 3 * 10 = 30;
        System.out.println("3 * 10 = " + result);

        // result = result / 3;
        result /= 3; // 30 / 3 = 10;
        System.out.println("30 / 3 = " + result);

        // result = result - 5;
        result -= 5; // 10 - 5 = 5;
        System.out.println("10 - 5 = " + result);
    }
}