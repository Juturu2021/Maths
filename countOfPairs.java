/*
Q1. Pair Sum divisible by M
Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B
Since the answer may be large, return the answer modulo (10^9 + 7).
Note: Ensure to handle integer overflow when performing the calculations.
Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^6

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
*/

public class Solution {
    public int solve(int[] A, int B) {
      int n = A.length;
      int mod = 1000000007;
      long ans = 0;
      HashMap<Integer, Integer> hm = new HashMap<>();
      //initialize with 0's
      for(int i=0; i<B; i++){
        hm.put(i, 0);
      }
      //find the frequency of each element in the array
      for(int i=0; i<n; i++){
        int key = A[i]%B;
        if(hm.containsKey(key)){
          hm.put(key, hm.get(key)+1);
        }
        else{
          hm.put(key, 1);
        }
      }
      //check the edge case if the first element itself a pair
      int temp = hm.get(0);
      ans = (ans + ((long)temp) * (temp-1)/2)%mod;
      //check for even elements and apply formula for perfect number
      if(B%2 == 0){
        temp = hm.get(B/2);
        ans = (ans + ((long)temp) * (temp-1)/2)%mod;
      }
      for(int i=1; i<(B+1)/2; i++){
        ans = (ans + (long)(hm.get(i) * hm.get(B-i)))%mod;
      }
      return (int)ans;
    }
}
