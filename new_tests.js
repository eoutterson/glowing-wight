for(var i = 0; i < 5; i++){
  setTimeout(function(){
    console.log(i);
  }, 500)
}
//What gets logged? (5, 5, 5, 5, 5)
//55

for(var i = 0; i < 5; i++){
  (function(i){
    setTimeout(function(){
      console.log(i);
    }, 500)
  })(i);
}

console.log("this is a test");
function reverse (str) {
  if (str === "") {
    return "";
  } else {
    return reverse(str.substr(1)) + str.charAt(0); 
  }
}

var replaced = str.split(' ').join('%20');
var replaced = str.replace(/ /g, '%20');

var hello = {
  name: 'you',
  talk: function() { 
    console.log('hello ' + this.name);
  }
}
hello.talk(); //logs 'hello you'
var hey = hello.talk.bind({name: 'everybody'});
hey(); //logs 'hello everybody'

Constants - (immutable variables)
  const PI = 3.14159;
Block Scoped variables - "let" allows you to declare variables that are limited in scope to the block, statement, or expression on which it is used

Block Scoped functions - with {}s you can block scope functions
Arrow Functions -  

Constants
Scoping
Block-Scoped Variables
Block-Scoped Functions
Arrow Functions
  function (v) { return v + 1; }
  v=>v+1
Expression Bodies
Statement Bodies
Lexical this
Extended Parameter Handling
Default Parameter Values
Rest Parameter
Spread Operator
Template Strings
String Interpolation
Custom Interpolation
Raw String Access
Extended Literals
Binary & Octal Literal
Unicode String & RegExp Literal
Enhanced Regular Expression
Regular Expression Sticky Matching
Enhanced Object Properties
Property Shorthand
Computed Property Names
Method Properties
Destructuring Assignment
Array Matching
Object Matching, Shorthand Notation
Object Matching, Deep Matching
Parameter Context Matching
Fail-Soft Destructuring
Modules
Symbol Export/Import
Default & Wildcard
Classes
Class Definition
Class Inheritance
Class Inheritance, From Expressions
Base Class Access
Static Members
Getter/Setter
Symbol Type
Symbol Type
Global Symbols
Iterators
Iterator & For-Of Operator
Generators
Generator Function, Iterator Protocol
Generator Function, Direct Use
Generator Matching
Generator Control-Flow
Map/Set & WeakMap/WeakSet
Set Data-Structure
Map Data-Structure
Weak-Link Data-Structures
Typed Arrays
Typed Arrays
New Built-In Methods
Object Property Assignment
Array Element Finding
String Repeating
String Searching
Number Type Checking
Number Safety Checking
Number Comparison
Number Truncation
Number Sign Determination
Promises
Promise Usage
Promise Combination
Meta-Programming
Proxying
Reflection


function add(a, b) {
  return a + b;
}

var curried = curry(add);
console.log( curried(1)(2) );