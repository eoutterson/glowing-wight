// void replaceSpaces(char[] str, int length) {
//   int spaceCount = 0, index, i = 0;
//   for (i = 0; i < length; i++) {
//     if (str[i] == ' ') {
//       spaceCount++;
//     }
//   }
//   index = length + spaceCount * 2;
//   str[index] = '\0';
//   for (i = length - 1; i >= 0; i--) {
//     if (str[i] == ' ') {
//       str[index - 1] = '0';
//       str[index - 2] = '2';
//       str[index - 3] = '%';
//       index = index - 3;
//     } else {
//       str[index - 1] = str[i];
//       index--;
//     }
//   }
// }


// boolean oneEditReplace(String s1, String s2) {
//   boolean foundDifference = false;
//   for (int i = 0; i < s1.length(); i++) {
//     if (s1.charAt(i) != s2.charAt(i)) {
//       if (foundDifference) {
//         return false;
//       }

//       foundDifference = true;
//     }
//   }
//   return true;
// }

// /* Check if you can insert a character into s1 to make s2. */
// boolean oneEditInsert(String s1, String s2) {
//   int index1 = 0;
//   int index2 = 0;
//   while (index2 < s2.length() && index1 < s1.length()) {
//     if (s1.charAt(index1) != s2.charAt(index2)) {
//       if (index1 != index2) {
//         return false;
//       }   
//       index2++;
//     } else {
//       index1++;
//       index2++;
//     }
//   }
//   return true;
// } 

// boolean oneEditAway(String first, String second) {
//   if (first.length() == second.length()) {
//     return oneEditReplace(first, second);
//   } else if (first.length() + 1 == second.length()) {
//     return oneEditInsert(first, second);
//   } else if (first.length() - 1 == second.length()) {
//     return oneEditInsert(second, first);
//   } 
//   return false;
// }


// String compress(String str) {
//   String compressedString = "";
//   int countConsecutive = 0;
//   for (int i = 0; i < str.length(); i++) {
//     countConsecutive++;

//     /* If next character is different than current, append this char to result.*/
//     if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
//       compressedString += "" + str.charAt(i) + countConsecutive;
//       countConsecutive = 0;
//     }
//   }
//   return compressedString.length() < str.length() ? compressedString : str;
// }

// void rotate(int[][] matrix, int n) {
//   for (int layer = 0; layer < n / 2; ++layer) {
//     int first = layer;
//     int last = n - 1 - layer;
//     for(int i = first; i < last; ++i) {
//       int offset = i - first;
//       int top = matrix[first][i]; // save top
//       // left -> top
//       matrix[first][i] = matrix[last-offset][first];      
//       // bottom -> left
//       matrix[last-offset][first] = matrix[last][last - offset]; 
//       // right -> bottom
//       matrix[last][last - offset] = matrix[i][last]; 
//       // top -> right
//       matrix[i][last] = top; // right <- saved top
//     }
//   }
// }



// void setZeros(int[][] matrix) {
//   boolean[] row = new boolean[matrix.length]; 
//   boolean[] column = new boolean[matrix[0].length];
// // Store the row and column index with value 0
//   for (int i = 0; i < matrix.length; i++) {
//     for (int j = 0; j < matrix[0].length;j++) {
//       if (matrix[i][j] == 0) {
//         row[i] = true; 
//         column[j] = true;
//       }
//     }
//   }
// // Nullify rows
//   for (int i = 0; i < row.length; i++) {
//     if (row[i]) {
//       nullifyRow(matrix, i);
//     }
//   }
// // Nullify columns
//   for (int j = 0; j < column.length; j++) {
//     if (column[j]) {
//       nullifyColumn(matrix, j);
//     }
//   }
// } 

// void nullifyRow(int[][] matrix, int row) {
//   for (int j = 0; j < matrix[0].length; j++) {
//     matrix[row][j] = 0;
//   }   
// }

// void nullifyColumn(int[][] matrix, int col) {
//   for (int i = 0; i < matrix.length; i++) {
//     matrix[i][col] = 0;
//   }   
// } 


boolean isRotation(String s1, String s2) {
  int len = s1.length();
  /* check that s1 and s2 are equal length and not empty */
  if (len == s2.length() && len > 0) { 
    /* concatenate s1 and s1 within new buffer */
    String s1s1 = s1 + s1;
    return isSubstring(s1s1, s2);
  }
  return false;
}