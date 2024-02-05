# StringBuilder Tasks

1. Write a class called myStringBuilder
    (why not just StringBuilder, well there would be a name collision with the standard library's StringBuilder and you might want to check that for inspiration at some point idk so better keep the name free)
    
    The new class should have a single constructor that determines the initial string of the StringBuilder

    The class should keep its underlying data structure private but have at least two public methods

    The methods should implement the interface:

    `public void append(String str)` a method which adds a new string to the final product

    `public String toString()` a method which returns the string created by combining all of the strings in the string builder

    As for the underlying data structure, I recommend using the `LinkedList<String>`. There are other possibilities too but trust me.
1. Add a couple more constructors like one that takes in an array of strings and adds all of them, or one that takes in a number and converts it to a String before storing it
1. Add some more important methods like `length()` and `remove(int pos)`
1. Why not add a second toString method that uses a delimeter like this
    ```java
    public String toString(String delimeter);

    StringBuilder sb = new StringBuilder("");
    sb.append("abel");
    sb.append("cain");
    System.out.println(sb.toString(","));   // abel,cain
    ```
1. How about a silly method like `toCapitalizedString()` but instead of capitalizing the whole output it just returns only the capitalized letters in the stored strings.

<p>...</p>

6. Ok I admit it, this whole exercise is a sham, if we don't make use of a resizable array as the underlying data structure then this will not actually be much more performant than repeatedly using the  `+` operator.

    The problem is that java would rather be able to handle all kinds of alphabets so it uses `CharSequence` which is some kind of weird implementation of Unicode characters.

    As it turns out text is more complicated than you might think, its not as simple as 1-byte ascii text like when you are taught c.

    How about for your final exercise you skim through the implementaiton of java.lang.AbstractStringBuilder to see how a good performant StringBuffer would be written.

    Hopefully you learned about the methods that LinkedList offers, and how handy it is to have a resizable data structure.