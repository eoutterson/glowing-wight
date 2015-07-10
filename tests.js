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

function wordCount()

console.log(inPlaceShuffle([1,2,3,4,5]));