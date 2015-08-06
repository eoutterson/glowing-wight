// if (!("a" in window)){
//   var a = 21;
// }
// console.log(a);

// "use strict";

// // Assignment to a non-writable property
// var obj1 = {};
// Object.defineProperty(obj1, "x", { value: 42, writable: false });
// obj1.x = 9; // throws a TypeError

// "use strict";
// var o = { p: 1, p: 2 }; // !!! syntax error

// function sum(a, a, c){ // !!! syntax error
//   "use strict";
//   return a + b + c; // wrong if this code ran
// }

// eval()
// var x = 17;
// var evalX = eval("'use strict'; var x = 42; x");
// console.log(x);//17
// console.log(evalX);//42
// eval = 17;
// arguments++;
// ++eval;
// var obj = { set p(arguments) { } };
// var eval;
// try { } catch (arguments) { }
// function x(eval) { }
// function arguments() { }
// var y = function eval() { };
// var f = new Function("arguments", "'use strict'; return 17;");

// function f(a){
//   "use strict";
//   a = 42;
//   console.log(arguments);
//   return [a, arguments[0]];
// }
// var pair = f(17);
// console.log(pair);//[17,42]
// console.assert(pair[0] === 42);
// console.assert(pair[1] === 17);
console.log("TEST");
function test(){
  console.log("WOOO",arguments.callee.caller);
  console.log(arguments.callee.caller.caller);
}
function returnTest(){
  return test();
}

function rReturnTest(){
  return returnTest();
}
rReturnTest();

implements, interface,let, package, private, protected, public, static, yield
// 800 201 3318
// 4259 0720 3400 8457
// 496
// july 2019
// eric d outterson

Concurrent and parallel are effectively the same principle as you correctly surmise, both are related to 
tasks being executes simultaneously although I would say that parallel tasks should be truly multitasking,
executed "at the same time" whereas concurrent could mean that the tasks are sharing the execution 
thread while still appearing to be executing in parallel.

Asynchronous methods aren't directly related to the previous two concepts, asynchrony is used to 
present the impression of concurrent or parallel tasking but effectively an asynchronous method call
is normally used for a process that needs to do work away from the current application and we don't
want to wait and block our application awaiting the response.




// console.log(b);

// var a;
// if (!("a" in window)){
//   a = 21;
// }
// console.log(a);


// // var x = 3
// // var foo = {
// //   x:2,
// //   baz:{
// //     x:1,
// //     bar:function(){
// //       return this.x;
// //     }
// //   }
// // }
// // var go = foo.baz.bar;
// // console.log(go());

// var foo = 

// var context = this;

