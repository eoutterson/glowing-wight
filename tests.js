function twoEggDrop(floors){
  //solve for n
  //n^2+n-2*buildingfloors
  var answerOne = (-1+Math.sqrt(1-4*(-2*floors)))/2;
  var answerTwo = (-1-Math.sqrt(1-4*(-2*floors)))/2;
  return Math.ceil(Math.max(answerOne,answerTwo));
}

function fisherYatesShuffle(arr){
  for (var i = 0; i < arr.length; i++){
    var randomPosition = Math.floor(Math.random()*(arr.length-i))+i;
    var temp;
    temp = arr[i];
    arr[i] = arr[randomPosition];
    arr[randomPosition]=temp;
  }
  return arr;
}


// console.log(fisherYatesShuffle([1,2,3,4,5]));

//A simple solution is to push everything to an object, but that's O(1) space complexity
//Another solution is checking each individual value across the entire array.
//While that's constant space, it is O(n^2) time complexity.
//we'll use a binary search approach over the values
function findRepeat(input){
  var floor = 1;
  var ceiling = input.length-1;
  while(floor<ceiling){
    //set up two ranges over which one could categorize the values in the array
    var midpoint = Math.floor(floor + (ceiling-floor)/2);
    var lowerRangeFloor = floor;
    var lowerRangeCeiling = midpoint;
    var upperRangeFloor = midpoint+1;
    var upperRangeCeiling = ceiling;

    //figure out the maximum number of unique integers that could fit in a range
    var lowerRangeMaxUniq = lowerRangeCeiling - lowerRangeFloor + 1;
    var lowerRangeCount = 0;
    //count how many are actually in the lower range
    for (var i = 0;i<input.length;i++){
      if (input[i] <= lowerRangeCeiling && input[i] >= lowerRangeFloor){
        lowerRangeCount++;
      } 
    }
    //if there were more than the uniq, we know the repeated value was in the lower half
    if(lowerRangeCount>lowerRangeMaxUniq){
      ceiling = lowerRangeCeiling;
      //otherwise it was the upper half
    }else{
      floor = upperRangeFloor;
    }
  }
  //return the number we've honed in on
  return floor;
}
//The solution is n(log(n)) for time, and O(1) for space

function findRepeatLinear(input){
  var n = input.length-1;
  var currentPosition = input.length;
  //Step 1: Get inside of a cycle, start at position n+1 and walk n steps to find a position guaranteed to be in a cycle
  for (var i = 0;i<input.length;i++){
    currentPosition = input[currentPosition-1];
  }
  //Step 2: Find the length of the cycle
  var oldPosition = currentPosition;
  var cycleLength = 0;
  do {
    oldPosition = input[oldPosition-1];
    cycleLength++;
  } while (oldPosition!=currentPosition);

  //Step 3: Use the stick method to find the first node in the cycle
  //move the end of the stick up the length of the cycle
  var stickEndPosition=input.length;
  var stickBeginPosition=input.length;
  for (var i = 0; i<cycleLength; i++){
    stickEndPosition=input[stickEndPosition-1];
  }
  //then move both forward until they both overlap
  while(stickEndPosition!=stickBeginPosition){
    stickEndPosition=input[stickEndPosition-1];
    stickBeginPosition=input[stickBeginPosition-1];
  }
  //they will overlap on the first item in the cycle, which will be a repeat
  return stickEndPosition
}

function countingSort(scoreList){
  var buckets = [];
  //count the number of scores by position
  for (var i = 0;i<scoreList.length;i++){
    if(!buckets[scoreList[i]]){
      buckets[scoreList[i]]=1;
    }else{
      buckets[scoreList[i]]++;
    }
  }
  var results = [];
  //cycle over the results
  for (var i = 0; i<buckets.length ; i++){
    for (var j = 0; j< buckets[i]; j++){
      results.push([i]);
    }
  }
  return results;
}

// console.log(countingSort([1,2,30,2,2,2]));

function stockPrices(stockPricesYesterday){
  var minPrice = stockPricesYesterday[0];
  var maxProfit = -Infinity;
  //skip the first time, since we don't want to allow simultaneous buying and selling
  for (var i = 1; i < stockPricesYesterday.length;i++){
    //update maxProfit if we can do better
    maxProfit = Math.max(stockPricesYesterday[i]-minPrice,maxProfit);
    //ensure minPrice is the lowest we've seen so far
    minPrice = Math.min(minPrice,stockPricesYesterday[i]);
  }
  return maxProfit;
}
// console.log(stockPrices([1,2,3,-40,5,-80,10]));

function getProductsExceptAtIndex(intArray){
  var results = [];
  results[0]=1;
  //loop over all of the values before each index
  for (var i = 1; i < intArray.length; i++){
    results[i]=results[i-1]*intArray[i-1];
  }
  var current = 1;
  //loop over all of the values after the index
  for (var i = intArray.length-2; i>-1 ;i--){
    current *= intArray[i+1]
    results[i]*=current;
  }
  return results;
}

// console.log(getProductsExceptAtIndex([1,7,3,4]));

function largestProductOfThree(arr){
  if(arr.length<3) return null;
  var largest = Math.max(arr[0],arr[1]);
  var smallest = Math.min(arr[0],arr[1]);
  var smallestProductOfTwo = arr[0]*arr[1];
  var largestProductOfTwo = arr[0]*arr[1];
  var largestProductOfThree = arr[0]*arr[1]*arr[2];
  for (var i = 2; i < arr.length; i ++){
    largestProductOfThree = Math.max(largestProductOfTwo*arr[i], smallestProductOfTwo*arr[i],largestProductOfThree);
    smallestProductOfTwo = Math.min(smallest * arr[i], smallestProductOfTwo);
    largestProductOfTwo = Math.max(largest * arr[i], largestProductOfTwo);
    if (arr[i]>largest) largest = arr[i];
    if (arr[i]<smallest) smallest = arr[i];
  }
  return largestProductOfThree;
}
// console.log(largestProductOfThree([1,2,3]))
// function(){}()
function isSingleRiffle(half1, half2, shuffledDeck){
  half1Index = 0;
  half2Index = 0;
  half1MaxIndex = half1.length - 1;
  half2MaxIndex = half2.length - 1;
  for (var i = 0; i < shuffledDeck.length;i++){
    //if we still have cards in half one, and the "top" card is the same as
    //the indexed card in the shuffled index
    if(half1Index <= half1MaxIndex && half1[half1Index] === shuffledDeck[i]){
      half1Index++;
    //if we still have cards in half two, and the "top" card is the same as
    //the indexed card in the shuffled index
    } else if(half2Index <= half2MaxIndex && half2[half2Index] === shuffledDeck[i]){
      half2Index++;
    } else {
    //if the "top" card in shuffled deck doesn't match either, then not a single riffle
      return false
    }
  }
  //All cards have been accounted for, so this is a true riffle
  return true;
}
// console.log(isSingleRiffle([1],[2],[2,1]));


function rand5(){
  return Math.ceil(Math.random()*5);
}

function rand7(){
  while(true){
    //do the die rolls
    var roll1=rand5();
    var roll2=rand5();
    //each die represents a value in the base 5 number system
    //so we get a value between 1 and 25
    var outcome = (roll1-1)*5+(roll2-1)+1;
    //for a uniform distribution, we ignore the range between
    //7*3 and 7*4 because 25 is between them
    if (outcome <= 21){
      return outcome%7+1;
    }
  }
}

function mergeMeetings(meetingArr){
  var mergedMeetings = [];
  //sort the meetings
  meetingArr.sort(function(a,b){return a[0]-b[0];});
  var startMeeting = meetingArr[0];
  for (var i = 1; i<meetingArr.length; i++){
    //if the current meeting overlaps with the next, combine them
    if (startMeeting[1]>=meetingArr[i][0]){
      startMeeting[1]=Math.max(meetingArr[i][1], startMeeting[1]);
    }else{
      //if the current meeting doesn't overlap, push it to our list
      mergedMeetings.push(startMeeting);
      startMeeting=meetingArr[i];
    }
  }
  mergedMeetings.push(startMeeting);
  return mergedMeetings;
}

console.log(mergeMeetings([[1,2],[2,3],[5,7],[5,8],[1,3],[0,4],[9,12]]));
// console.log(mergeMeetings([[1,2],[0,4]]));


// if ("a" in window){
//   var a = 21;
// }
// console.log(a);


// This doesn't work like you might think, because the value of `i` never
// gets locked in. Instead, every link, when clicked (well after the loop
// has finished executing), alerts the total number of elements, because
// that's what the value of `i` actually is at that point.

// var elems = document.getElementsByTagName( 'a' );
// for ( var i = 0; i < elems.length; i++ ) {
//   elems[ i ].addEventListener( 'click', function(e){
//     e.preventDefault();
//     alert( 'I am link #' + i );
//   }, 'false' );
// }

// This works, because inside the IIFE, the value of `i` is locked in as
// `lockedInIndex`. After the loop has finished executing, even though the
// value of `i` is the total number of elements, inside the IIFE the value
// of `lockedInIndex` is whatever the value passed into it (`i`) was when
// the function expression was invoked, so when a link is clicked, the
// correct value is alerted.

// var elems = document.getElementsByTagName( 'a' );
// for ( var i = 0; i < elems.length; i++ ) {
//   (function( lockedInIndex ){
//     elems[ i ].addEventListener( 'click', function(e){
//       e.preventDefault();
//       alert( 'I am link #' + lockedInIndex );
//     }, 'false' );
//   })( i );
// }


// Object:  'object'
// Array: 'object'
// Function:  'function'
// String:  'string'
// Number:  'number'
// Boolean: 'boolean'
// Symbol: 'symbol'
// null:  'object'
// undefined: 'undefined'

// Whole-script strict mode syntax
"use strict";
var v = "Hi!  I'm a strict mode script!";

function strict(){
  // Function-level strict mode syntax
  'use strict';
  function nested() { return "And so am I!"; }
  return "Hi!  I'm a strict mode function!  " + nested();
}
function notStrict() { return "I'm not strict."; }

function mergeSortedArrays(array1, array2){
  var resultArr = [];
  while(array1.length > 0 && array2.length > 0){
    if(array1[0] >= array2[0]){
      resultArr.push(array2.shift());
    }else{
      resultArr.push(array1.shift());
    }
  }
  return resultArr.concat(array1, array2);
}
var unknownbias = .000001;
function unfairCoin(){
  var coin;
  if (Math.random() > unknownbias){
    coin = "heads";
  }else{
    coin = "tails";
  }
  return coin;
}

function fairCoin(){
  var flipOne, flipTwo;
  do{
    flipOne = unfairCoin();
    flipTwo = unfairCoin();
  } while(flipOne===flipTwo)
  return flipOne;
}
console.log(fairCoin());

function car(){
  var gas = 10;

  return function driveCar(){
    gas--;
    console.log(gas);
  }

}