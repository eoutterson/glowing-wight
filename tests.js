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

console.log(countingSort([1,2,30,2,2,2]));

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
console.log(stockPrices([1,2,3,-40,5,-80,10]));