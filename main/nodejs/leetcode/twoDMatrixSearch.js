/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    // return (matrix.length===0) ? false : (matrix.length==1) ? searchMatrixRow(matrix[0],0,matrix[0].length) : searchMatrixSection(matrix, target, 0, matrix.length);
  return (matrix.length===0) ? false : searchMatrixLinear(matrix, target, 0, matrix.length* matrix[0].length);
};

const searchMatrixLinear = function(matrix, target, startIn, endEx){
  if(endEx===startIn) return false;
  const s = getVal(matrix, startIn);
  if(endEx-startIn===1) return s===target;
  const e = getVal(matrix, endEx-1);
  if(target<s || target>e) return false;
  const mIndex = Math.floor((endEx+startIn) / 2);
  const m = getVal(matrix, mIndex);
  return target<m ? searchMatrixLinear(matrix, target, startIn, mIndex) : searchMatrixLinear(matrix, target, mIndex, endEx);
}

const getVal = function(matrix, index){
  const row = Math.floor(index / matrix[0].length);
  const col = index % matrix[0].length;
  return matrix[row][col];
}

console.log(searchMatrix([[1,2,3],[4,5,6]], 3));
console.log(searchMatrix([[1,2,4],[5,6,7]], 3));
console.log(searchMatrix([[1,2,3]], 3));
console.log(searchMatrix([[1],[2]], 2));


let searchMatrixSection = function(matrix, target, startIn, endEx){
  const first = matrix[startIn][0];
  const lastRow = matrix[endEx-1]
  const last = lastRow[lastRow.length-1]
  if(target<first || target > last) return false;
  const middleIndex = (endEx+startIn)/2;
  const middleRow = matrix[middleIndex];
  if(target<middleRow[0]){
    return searchMatrixSection(matrix, target, startIn, middleRow);
  }else{
    return searchMatrixSection(matrix, target, middleRow, endEx);
  }
}