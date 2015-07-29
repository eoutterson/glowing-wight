
//1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
You may want to start off with asking your interviewer if the string is an ASCII string or a Unicode string. This is an important question, and asking it will show an eye for detail and a deep understanding of Computer Science.
We'll assume for simplicity that the character set is ASCII. If not, we would need to increase the storage size, but the rest of the logic would be the same.
Given this, one simple optimization we can make to this problem is to automatically returnfalseifthelengthofthestringisgreaterthanthenumber ofuniquecharacters in the alphabet. After all, you can't have a string with 280 unique characters if there are only 256 possible unique characters.
Our first solution is to create an array of boolean values, where the flag at index i indi- cates whether character i in the alphabet is contained in the string. If you run across this character a second time, you can immediately return false.
The code below implements this algorithm.
public boolean isUniqueChars2(String str) {

if (str.lengthQ > 256)return false;
boolean[] char_set = new boolean[256]; for (int1 = 0; i < str.lengthQ; i++) {
int val = str.charAt(i);
if (char_set[val]) { // Already found this char in string
return false;
ivi char_set[val] = true; 11 }
return true;
}
// Thetime complexity for this code is0(n),where n isthe length of the string.Thespace complexity is 0(1).
// Wecanreduceour spaceusagebyafactorofeight byusingabit vector.Wewillassume, in the below code, that the string only uses the lowercase letters a through z. This will allow us to use just a single int.
public boolean isUniqueChars(String str) {
  int checker = 0;
  for(int 1=0; i <str.length(); i++) {
    int val = str.charAt(i) - 'a';
    if ((checker & (1 « val)) > 0) { 8 return -False;
    }
    checker |= (1 « val);
  }
  return true;
}




voidreverse(char*str){ char* end =str;
char tmp;
if (str){
while (*end) { /* find end of the string */ ++end;
}
--end; /* set one char back, since last char is null */
/* swap characters from start of string with the end of the * string, until the pointers meet in middle. */
while (str < end){ tmp = *str; *str++ = *end; *end-- =tmp;
8
9
10
11
12
13
14
15
16 } 17 } 18 }
Solutions to Chapter 1 | Arrays and Strings
if ((checker & (1 « val)) > 0) { 8 return -False;
9}
10 checker |= (1 « val);
11 }
12 return true; 13 }
Alternatively, we could do the following:
1. Compareeverycharacterofthestringtoeveryothercharacterofthestring.Thiswill takeO(n2) time and 0(1) space.
2. Ifweareallowed tomodifytheinputstring,wecouldsortthestringin0(n log(n)) time and then linearly check the string for neighboring characters that are identical. Careful, though: many sorting algorithms take up extra space.
These solutions are not as optimal in some respects, but might be better depending on the constraints of the problem.

//1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null- terminated string.
//1.3 Given two strings, write a method to decide if one is a permutation of the other.
//1.4 Write a method to replace all spaces in a string with'%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if imple- menting in Java, please use a character array so that you can perform this opera- tion in place.)
// EXAMPLE
// Input: "Mr John Smith Output: "Mr%20Dohn%20Smith"
// ^ __pg1?5
//1.5 Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the orig- inal string, your method should return the original string.
//1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
//1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
//1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s i and s2, write code to check if s2 is a rotation of si using only one call to isSubstring (e.g.,"waterbottle"is a rota- tion of "erbottlewat").
