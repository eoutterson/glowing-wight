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


void allFib(int n) {
  int[] memo = new int[n + 1];
  for (int i = 0; i < n; i++) {
    System.out.println(i + ": " + fib(i, memo));
  }
} 

int fib(int n, int[] memo) {
  if (n <= 0) return 0;
  else if (n == 1) return 1;
  else if (memo[n] > 0) return memo[n];

  memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
  return memo[n];
}


int powersOf2(int n) {
  if (n == 1) {
    System.out.println(1);
    return 1;
  } else {
    int prev = powersOf2(n / 2);
    int curr = prev * 2;
    System.out.println(curr);
    return curr;
  }
}

// powersOf2(50)
//   →powersOf2(25)
//     →powersOf2(12)
//       →powersOf2(6)
//         →powersOf2(3)
//           →powersOf2(1)
//             →print and return 1
//           print and return 2
//         print and return 4
//       print and return 8
//     print and return 16
//   print and return 32


int product(int a, int b) {
  int sum = 0;
  for (int i = 0; i < b; i++) {
    sum += a;
  }
  return sum;
}

int power(int a, int b) {
  if (b < 0) {
    return 0; // error
  } else if (b == 0) {
    return 1; 
  } else {
    return a * power(a, b - 1);
  }
}

int mod(int a, int b) {
  if (b <= 0) {
    return -1;
  }
  int div = a / b;
  return a - div * b;
}




public class Q_04 {

  public static int div(int a, int b) {
    int count = 0;
    int sum = b;
    while (sum <= a) {
      sum += b;
      count++;
    }
    return count;
  }
  
  public static void main(String[] args) {
    System.out.println(div(12, 4));
  }

}

int sqrt(int n) {
  return sqrt_helper(n, 1, n);
} 

int sqrt_helper(int n, int min, int max) {
  if (max < min) return -1; // no square root
  int guess = (min + max) / 2;
  if (guess * guess == n) { // found it!
    return guess;
  } else if (guess * guess < n) { // too low
    return sqrt_helper(n, guess + 1, max); // try higher
  } else { // too high
    return sqrt_helper(n, 1, guess - 1); // try lower
  }
}



public class Q_05 {

  public static int sqrt(int n) {
    return sqrt_helper(n, 1, n);
  } 
  
  public static int sqrt_helper(int n, int min, int max) {
      if (max < min) return -1; // no square root
      
      int guess = (min + max) / 2;
      if (guess * guess == n) { // found it!
        return guess;
      } else if (guess * guess < n) { // too low
          return sqrt_helper(n, guess + 1, max); // try higher
      } else { // too high
          return sqrt_helper(n, 1, guess - 1); // try lower
        }
      }




      public static void main(String[] args) {
        System.out.println(sqrt(26));
      }

    }


    int sqrt(int n) {
      for (int guess = 1; guess * guess <= n; guess++) {
        if (guess * guess == n) {
          return guess;
        }
      }
      return -1;
    }


    }

    public class Q_06 {

      public static int sqrt(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
          if (guess * guess == n) {
            return guess;
          }
        }
        return -1;
      }

      public static void main(String[] args) {
        System.out.println(sqrt(26));
      }

    }

    public class Q_09 {

      public static int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
          copy = appendToNew(copy, value);
        }
        return copy;
      }

      public static int[] appendToNew(int[] array, int value) {
    // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
          bigger[i] = array[i];
        }

    // add new element
        bigger[bigger.length - 1] = value;
        return bigger;
      }

      public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] copy = copyArray(array);
        for (int x : copy) {
          System.out.println(x);
        }
      }
    }

    public class Q_10 {

      public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
          sum += n % 10;
          n /= 10;
        }
        return sum;
      }

      public static void main(String[] args) {
        System.out.println(sumDigits(1252));
      }
    }

    public class Q_11 {

      public static int numChars = 26;

      public static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
      }

      public static void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
          System.out.println(prefix);
        } else {
          for (int i = 0; i < numChars; i++) {
            char c = ithLetter(i);
            printSortedStrings(remaining - 1, prefix + c);
          }
        }
      }

      public static boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
          int prev = ithLetter(s.charAt(i - 1));
          int curr = ithLetter(s.charAt(i));
          if (prev > curr) {
            return false;
          }
        }
        return true;
      }

      public static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
      }

      public static void main(String[] args) {
        printSortedStrings(3);
      }
    }

    public class Q_12 {

      public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
          mid = (low + high) / 2;
          if (a[mid] < x) {
            low = mid + 1;
          } else if (a[mid] > x) {
            high = mid - 1;
          } else {
            return mid;
          }
        }
        return -1;
      }

      public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
      }

      public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
          int middle = (low + high) / 2;
      mergesort(array, helper, low, middle); // Sort left half
      mergesort(array, helper, middle+1, high); // Sort right half
      merge(array, helper, low, middle, high); // Merge them
    }
  }

  public static void merge(int[] array, int[] helper, int low, int middle, int high) {
    /* Copy both halves into a helper array */
    for (int i = low; i <= high; i++) {
      helper[i] = array[i];
    }

    int helperLeft = low;
    int helperRight = middle + 1;
    int current = low;

    /* Iterate through helper array. Compare the left and right
     * half, copying back the smaller element from the two halves
     * into the original array. */
    while (helperLeft <= middle && helperRight <= high) {
      if (helper[helperLeft] <= helper[helperRight]) {
        array[current] = helper[helperLeft];
        helperLeft++;
      } else { // If right element is smaller than left element
        array[current] = helper[helperRight];
        helperRight++;
      }
      current++;
    }

    /* Copy the rest of the left side of the array into the
     * target array */
    int remaining = middle - helperLeft;
    for (int i = 0; i <= remaining; i++) {
      array[current + i] = helper[helperLeft + i];
    }
  } 
  
  public static int intersection(int[] a, int[] b) {
    mergesort(b);
    int intersect = 0;
    
    for (int x : a) {
      if (binarySearch(b, x) >= 0) {
        intersect++;
      }
    }
    
    return intersect;
  }
  
  public static void main(String[] args) {
    int[] a = {1, 3, 5, 7};
    int[] b = {1, 9, 2, 7};
    int x = intersection(a, b);
    System.out.println(x);
  }
}



void deleteDups(LinkedListNode n) {
  HashSet<Integer> set = new HashSet<Integer>();
  LinkedListNode previous = null;
  while (n != null) {
    if (set.contains(n.data)) {
      previous.next = n.next;
    } else {
      set.add(n.data);
      previous = n;
    }
    n = n.next;
  }
}

void deleteDups(LinkedListNode head) {
  LinkedListNode current = head;
  while (current != null) {
    /* Remove all future nodes that have the same value */
    LinkedListNode runner = current;
    while (runner.next != null) { 
      if (runner.next.data == current.data) {
        runner.next = runner.next.next;
      } else {
        runner = runner.next;
      }
    }
    current = current.next;
  }
}