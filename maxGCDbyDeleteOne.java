/*
Problem Description
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
Find the maximum value of GCD.
*/
public class Solution {
  public static int GCD(int A, int B){
    if(B==0){
      return A;
    }
    return GCD(B, A%B);
  }
    public int solve(int[] A) {
      int n = A.length;
      int ans = 0;
      //prepare prefixGCD Array
      int[] prefixGCD = new int[n];
      prefixGCD[0] = A[0];
      for(int i=1; i<n; i++){
        prefixGCD[i] = GCD(prefixGCD[i-1], A[i]);
      }

      //suffixGCD Array
      int[] suffixGCD = new int[n];
      suffixGCD[n-1] = A[n-1];
      for(int i=n-2; i>=0; i--){
        suffixGCD[i] = GCD(suffixGCD[i+1], A[i]);
      }

      //check if deleting first and last eleemnts and get their max GCD
      ans = Math.max(prefixGCD[n-2], suffixGCD[1]);

      // find the max GCD by deleting rest all elements
      for(int i=1; i<n-1; i++){
        int left = prefixGCD[i-1];
        int right = suffixGCD[i+1];
        int temp = GCD(left, right);
        ans = Math.max(ans, temp);
      }
      return ans;
    }
}
