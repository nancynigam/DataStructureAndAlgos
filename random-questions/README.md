Basic functions :

String APIs to know :
1) trim() : To remove leading & trailing spaces from a string. 
   str = str.trim();
   Input :  str = "      Hey  there    Joey!!!      "
   Output : str = "Hey  there    Joey!!!"
   By calling the trim() method, a new String object is returned. It doesn’t replace the value of String object. Therefore if    we want the access to the new String object, we just need to reassign it to the old String or assign it to a new variable.

2) String substring(int beginIndex), String substring(int beginIndex,int endIndex)

3) boolean contains(CharSequence s)

4) boolean equals(String another), static String equalsIgnoreCase(String another) ; Remember to always compare strings using equals & not == as == checks equality with object while equals check equality with string characters.

5) String replace(CharSequence old, CharSequence new)	

6) String[] split(String regex), 	String[] split(String regex, int limit)

7) int indexOf(int ch), int indexOf(String substring)

8) static String valueOf(int value) // overloaded method; converts given type into string.

Sliding Window :
A sliding window is an abstract concept commonly used in array/string problems. A window is a range of elements in the array/string which 
usually defined by the start and end indices, i.e. [i, j)[i,j). A sliding window is a window "slides" its two 
boundaries to the certain direction. For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1).
