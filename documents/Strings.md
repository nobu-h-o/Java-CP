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

