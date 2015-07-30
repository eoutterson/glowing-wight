//Ex1 in book Ex6 in github
public static void foo(int[] array) {
  int sum = 0;
  int product = 1;
  for (int i = 0; i < array.length; i++) {
    sum += array[i];
  }
  for (int i = 0; i < array.length; i++) {
    product *= array[i];
  } 
  System.out.println(sum + ", " + product);
}

//Ex2
public static void printPairs(int[] array) {
  for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array.length; j++) {
      System.out.println(array[i] + "," + array[j]);
    }
  }
}

//Ex3
public static void printUnorderedPairs(int[] array) {
  for (int i = 0; i < array.length; i++) {
    for (int j = i; j < array.length; j++) {
      System.out.println(array[i] + "," + array[j]);
    }
  }
}

//Ex4
public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
  for (int i = 0; i < arrayA.length; i++) {
    for (int j = 0; j < arrayB.length; j++) {
      if (arrayA[i] < arrayB[j]) {
        System.out.println(arrayA[i] + "," + arrayB[j]);
      }
    }
  }
}

public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
  for (int i = 0; i < arrayA.length; i++) {
    for (int j = 0; j < arrayB.length; j++) {
      //constant time work
    }
  }
}

//Ex5
public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
  for (int i = 0; i < arrayA.length; i++) {
    for (int j = 0; j < arrayB.length; j++) {
      for (int k = 0; k < 1000; k++) {
        System.out.println(arrayA[i] + "," + arrayB[j]);
      }
    }
  }
}

//Ex6
public static void reverse(int[] array) {
  for (int i = 0; i < array.length / 2; i++) {
    int other = array.length - i - 1;
    int temp = array[i];
    array[i] = array[other];
    array[other] = temp;
  }
}

int sum(Node node){
  if (node == null){
    return 0;
  }
  return sum(node.left) + node.value + sum(node.right);
}


boolean isPrime(int n) {
  for (int x = 2; x * x <= n; x++) {
    if (n % x == 0) {
      return false;
    }
  }
  return true;
}

int factorial(int n) {
  if (n < 0) {
    return -1;
  } else if (n == 0) {
    return 1;
  } else {
    return n * factorial(n - 1);
  }
}


void permutation(String str) {
  permutation(str, "");
}

void permutation(String str, String prefix) {
  if (str.length() == 0) {
    System.out.println(prefix);
  } else {
    for (int i = 0; i < str.length(); i++) {
      String rem = str.substring(0, i) + str.substring(i + 1);
      permutation(rem, prefix + str.charAt(i));
    }
  }
}

int fib(int n) {
  if (n <= 0) return 0;
  else if (n == 1) return 1;    
  return fib(n - 1) + fib(n - 2);
}

void allFib(int n) {
  for (int i = 0; i < n; i++) {
    System.out.println(i + ": " + fib(i));
  }
}

int fib(int n) {
  if (n <= 0) return 0;
  else if (n == 1) return 1;    
  return fib(n - 1) + fib(n - 2);
}


public static void allFib(int n) {
    int[] memo = new int[n + 1];
    for (int i = 0; i < n; i++) {
      System.out.println(i + ": " + fib(i, memo));
    }
  } 
  
  public static int fib(int n, int[] memo) {
      if (n <= 0) return 0;
      else if (n == 1) return 1;
      else if (memo[n] > 0) return memo[n];
      
      memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
      return memo[n];
  }