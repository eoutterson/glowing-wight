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