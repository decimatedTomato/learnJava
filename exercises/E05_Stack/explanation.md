# Stack Tasks

1. Start by implementing a simpleStack as an (not resizable) array and a current stack index int, let's do an array of a generic type right away. Add a type parameter to the stack class definition. I wrote an interface that the stack should follow (You can expand the interface with your own ideas).

    Because of java awkwardness you might have to use `Object[]` and typecast the result to `T` such as `(T)data[0]`

    You might be wondering why java has so many stupid design choices. That is because it added features over time and it was too popular to change its interface over time so it had to keep the old outdated version of things for legacy reasons. A good reminder that your interface cannot change as often as your implementation. Thanks for the reminder Oracle :P
1. A static stack is good for a lot of cases, but what if we want to be handle a dynamic amount of data. Make use of an existing java class as the underlying data, but keep only the stack interface accessible to users of your class. That's right, our stack is just a wrapper around someone else's hard work. If you wanted to write your own code go back to c.
1. As you have been working you have probably been using one or two cases to test each solution you wrote. This time write many tests, then if the results are as expected, change the underlying data structure of the stack and then run the tests again to see if the use of the stack is decoupled from the implementation.