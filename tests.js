function twoEggDrop(floors){
  //solve for n
  //n^2+n-2*buildingfloors
  var answerOne = (-1+Math.sqrt(1-4*(-2*floors)))/2;
  var answerTwo = (-1-Math.sqrt(1-4*(-2*floors)))/2;
  return Math.ceil(Math.max(answerOne,answerTwo));
}