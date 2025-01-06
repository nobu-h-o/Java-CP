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
### Example Problems
[ABC344-A](https://atcoder.jp/contests/abc344/tasks/abc344_a)  
<details>
<summary>Solution</summary>
We find the first index of '|' and the second index of '|' and print the substrings that are not between these 2 indexes.
    
```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int index1 = s.indexOf('|');
        int index2 = s.lastIndexOf('|');
        System.out.println(s.substring(0, index1) + s.substring(index2 + 1));
    }
}
```
</details>

[ABC357-B](https://atcoder.jp/contests/abc357/tasks/abc357_b)
<details>
<summary>Solution</summary>
We increment a counter when there is a uppercase character and decrement otherwise. Use the toLowerCase or toUpperCase method for conversion.
    
```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int countCapital = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)>='A' && s.charAt(i)<='Z') countCapital++;
            else countCapital--;
        }
        if(countCapital>0) System.out.println(s.toUpperCase());
        else System.out.println(s.toLowerCase());
    }
}

```
</details>

[ABC372-A](https://atcoder.jp/contests/abc372/tasks/abc372_a)  
<details>
<summary>Solution</summary>
We can write exactly what is being told by deleting every instance of '.' that the string contains. Unfortunately, StringBuilder doesn't have the contains method, 
so we have to convert sb to s and check it every loop.

```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        StringBuilder sb = new StringBuilder(s);

        while(s.contains(".")){
            int index = sb.indexOf(".");
            sb.deleteCharAt(index);
            s = sb.toString();
        }

        System.out.println(s);
    }
}

```
Another way is to append each character from the string that isn't '.' to the stringbuilder.

```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='.') sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}
```
We can also skip using StringBuilders entirely.

```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!='.') System.out.print(s.charAt(i));
        }
        System.out.println();
    }
}

```
</details>

[ABC384-A](https://atcoder.jp/contests/abc384/tasks/abc384_a) 
<details>
<summary>Solution</summary>
The Scanner class doesn't accept char inputs so we have to use the input as a string and use its first index.

```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);
        String s = sc.next();
        sc.close();

        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=c1) sb.setCharAt(i,c2);
        }
        
        System.out.println(sb);
    }
}
```

Of course, you can input the StringBuilder like this to be a little bit faster.
```Java
StringBuilder sb = new StringBuilder(sc.next());
```
</details>

[ABC386-B](https://atcoder.jp/contests/abc386/tasks/abc386_b) 
<details>
<summary>Solution</summary>
The idea here is to delete 2 characters at the front of the sb when there are 2 consecutive '0's and to delete 1 character at the front when there aren't, 
while counting how many times we delete the characters. We have to be careful around deleting characters in a sb as the indexes would move to account for
the loss. This problem was also featured on [ABC283](https://atcoder.jp/contests/abc283/tasks/abc283_c) as problem C. So, if you were able to solve this, congrats! You just solved a C problem!
    
```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        StringBuilder sb = new StringBuilder(s);
        int count=0;
        
        while(sb.length()>0){
            if(sb.length()>1 && sb.charAt(0)=='0' && sb.charAt(1)=='0'){
                sb.delete(0, 2);
            }else{
                sb.deleteCharAt(0);
            }
            count++;
        }
        
        System.out.println(count);
    }
}
```
</details>

### Extra
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
