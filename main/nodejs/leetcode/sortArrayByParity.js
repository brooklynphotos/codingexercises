/**
 * https://leetcode.com/contest/weekly-contest-106/problems/sort-array-by-parity-ii/
 */

/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParityII = function(A) {
  let e = 0;
  let o = 0;
  const newA = [];
  for(const x of A){
    if(x%2==0){
      newA[(e++)*2] = x;
    }else{
      newA[(o++)*2 + 1] = x;
    }
  }
  return newA;
};

const arr = [1,2,3,4]
console.log(arr)
console.log(sortArrayByParityII(arr))