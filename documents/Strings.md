# Strings
### Useful methods of the String Class
```Java
String s = "Hello World!"
//  alternatively, input the String with the next 
//  method of the Scanner class.

s.subString(0, 5); 
//  this returns the substring of String s that starts with the index
//  x and takes y characters.
//  For example, the code above returns "Hello"
//  Note that this does not change the String s object itself and only
//  returns the substring. You will need to store it in another variable
//  if you want to use it somewhere else.

s.indexOf(".");
//  the indexOf method returns the first index of the character/string

s.lastIndexOf(".");
//  the lastIndexOf method returns the last index of the character/string

s.contains("ello");
// the contains method 
```
### Further String manipulation
Strings in Java suck. To use them effectively we have to change them to StringBuilders or char Arrays.
### The StringBuilder Class
The String Builder Class is a Class that is basically a mutable version of the String.
```Java
String s = "Hello World!";
StringBuilder sb = new StringBuilder(s);
// This initilizes an object, sb, of the StringBuilder Class with
// the String "Hello World!"
sb.setCharAt(6, 'w');
// This sets the 6th index of the sb into 'h'.
// therefore, the content of sb would be "Hello world!"
sb.append("!!");
// You can add characters and Strings 
// and ints (and almost every data type)
// to the end of the sb with the append method.
// Therefore, the content of sb would be "Hello world!!!"
sb.delete(6, 13);
// You can delete parts of the sb with the delete method.
// sb would become "Hello" after this line. You can also
// delete a specific character with 
sb.deleteCharAt(4);
// this would make sb "Hell"
```
StringBuiders can also use most of the methods that the Strings can use.
Therefore, it can still use sb.length() or sb.charAt(i). You can also convert
StringBuilders back to Strings.
```Java
s = sb.toString();
// Now the String that once was "Hello World" is now "hell".
```
It's important to note that Strings in Java are reference data types because they are objects of the String class. 
Strings are immutable, meaning that once a String object, such as "Hello World", is created, its value cannot be changed. 
When you perform operations that modify a string - like concatenation or replacement - a new String instance with the updated 
content is created and stored separately, leaving the original string unchanged.  

Additionally, Java maintains a special area of memory called the String Pool (or Intern Pool). When you create a string 
literal (e.g., String s = "Hello World";), Java checks the String Pool to see if an identical String already exists. 
If it does, Java reuses the existing instance instead of creating a new one, optimizing memory usage. You can learn more
about it [here](https://www.youtube.com/watch?v=Bj9Mx_Lx3q4).

On the other hand, StringBuilder objects are mutable, allowing you to modify the sequence of characters they contain 
without creating new instances. This makes StringBuilder more efficient for scenarios involving frequent or extensive 
string modifications, such as within loops or complex string manipulations.