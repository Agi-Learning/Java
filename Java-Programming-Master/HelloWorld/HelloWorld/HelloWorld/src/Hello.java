// 1. Java programs (and most other programming languages) have keywords. Each has a specific meaning, and sometimes they need to be used in specific orders.

// You Write Java programs by following a specific set of rules, using a combination of these keywords and other things you will see which collectively form a java program.

// NOTE keywords are case sensitive - public and Public and even PUBLIC are diff things.

// public and class are two java keywords - they have a specific meaning which we will find out more about moving  forword.
// The public Java keyword is an access modifier. An access modifier allows us to define the scope or how other parts of your code or even some else's code can access this code. More on that later.

// For now, we will use the public access modifier to give full access. we'll come back to access modifiers once we get further into the course.

// Defining a class. The class keyword is used to define a class with the name following the keyword - Hello in this case and left and right curly braces to define the class block.

// To define a class requires an optional access modifier, followed by class,

// The left and right curly braces are defining the class body - anything in between them is "part" of this class. We can have data and code as you will see as we progress.

public class Hello {

    // 2. What is a method? It's a collection of statements (one or more) that performs an operation. We'll be using a special method called the main method that java looks for when running a program. It's the entry point of any java code.
    // You can create your own methods as you will see later, but for now, let's create this main method.

    public static void main(String[] args){
        // public - is an access modifier
        // static is java keyword that needs an understanding of other concepts, for now know that we need to have static for java to find our method to run the code we are going to add.
        // void is yet another java keyword used to indicate that the method will not return anything more on that later.

        // The left and right parenthesis in a method declaration are mandatory and can optionally include one or more parameters - which is a way to pass information to a method. More on that later.
        // Now through to enable java to define the main method.

        // Code block: - A code block is used to define a block of code. It's mandatory to have one in a method declaration and it's here where we will be adding statements to perform certain tasks.
        System.out.println("Hello World");
        // Statement - This is a complete command to be executed and can include one or more expressions.

        // 3. Variables are a way to store information in our computer. Variables that we define in a program can be accessed by a name we give them, and the computer does the hard work of figuring out where they get stored in the computers random access memory (RAM).

        // A variable, as the name suggests can be changed, in other words, it's contents are variable.
        // what we have to do is tell the computer what type of inforamation we want to store in the variable, and then give it a name.
        // There are lots of different types of data we can define for our variables. Collectively these are known as Data types. As you may have guessed, data types are keywords in java.

        // lets start out by defining a variable of type int - int being and abbr for integer, a whole number (that is a number without any decimal points).

        // To define a variable we need to specify the data type, then give our variable a name, and optionally add an expression to initialize the variable with a value.

        int myFirstNumber = (10 + 5) + (2 * 10);
        // Declaration Statement Used to define a variable by indicating the data type, and the name, and optionally to set the variable to a certain value.

        // allocate a place in memory to store a single whole number, and we'll assign the myFirstName to that area of memory or more specifically assign that name where Java is storing the contents, to get access to it you don't refer to a memory location, you refer to a variable name,
        int mySecondNumber = 12;
        int myThirdNumber = 6;

        // instead of using a literal number , for assigning a value to our variables, let's use a variable name directly in the expression.
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
//        System.out.println(myFirstNumber);
        System.out.println(myTotal);
        // Any sequence of characters surrounded by double quotes is a String literal in java. It's value cannot be changed, unlike a variable.
        // Java operators or just operators perform an operation (hence the word) on a variable or value. +,-,/ and * are four common ones that I feel sure you are familiar with
    }
}




