/**
 * @param {number[][]} grid
 * @return {number}
 */
var numMagicSquaresInside = function(grid) {
  var count =0;
  for(var i=0;i+3<=grid.length;i++){
    for(var j=0;j+3<=grid[i].length;j++){
      const threeByThree = getGrid(grid,i,j);
      if(isMagic(threeByThree)){
        count++;
      }
    }
  }
  return count;
};

var getGrid = function(grid,row,column){
  const res = [];
  for(var i=row;i<row+3;i++){
    const row = grid[i];
    res.push(row.slice(column,column+3));
  }
  return res;
}

var summer = (acc, curVal) => acc + curVal;

var hasDistinct1to9 = function(grid){
  var numberSet = new Set();
  for(var i=0;i<grid.length;i++){
    for(var j=0;j<grid[i].length;j++){
      const v = grid[i][j];
      if(v<1 || v>9) return false;
      if(numberSet.has(v)) return false;
      numberSet.add(v);
    }
  }
  return true;
}

var isMagic = function(grid){
  if(!hasDistinct1to9(grid)) return false;
  var rsum = grid[0].reduce(summer);
  var thisRSum = 0;
  for(var i=1;i<3;i++){
    thisRSum = grid[i].reduce(summer);
    if(thisRSum !== rsum) return false;
  }
  //columns
  for(var j=0;j<3;j++){
    thisRSum = grid[0][j]+grid[1][j]+grid[2][j];
    if(thisRSum !== rsum) return false;
  }
  // diagonals
  thisRSum = grid[0][0] +grid[1][1] +grid[2][2];
  if(thisRSum !== rsum) return false;
  thisRSum = grid[0][2] +grid[1][1] +grid[2][0];
  if(thisRSum !== rsum) return false;

  return true;
}

// test
var testGrid = [
  [1,2,3,4],
  [5,6,7,8],
  [9,10,11,12],
  [13,14,15,16]
];

const testGetGrid = ()=>{
  const subgrid = getGrid(testGrid, 0,0);
  console.log(subgrid[2][2]);
  console.log(subgrid.length);
  console.log(subgrid[0].length);
}

const testNumMagicSquaresInside = ()=>{
  numMagicSquaresInside(testGrid);
}

const testIsMagic = ()=>{
  var testMagicGrid = [
    [4,3,8],
    [9,5,1],
    [2,7,6]
  ];
  console.log(isMagic(testMagicGrid));
}

const testIsNotMagic = ()=>{
  var testMagicGrid = [
    [4,1,8],
    [9,5,1],
    [2,7,6]
  ];
  console.log(isMagic(testMagicGrid));
}
// testNumMagicSquaresInside();
// testIsMagic();
// testIsNotMagic();


console.log(numMagicSquaresInside([[10,3,5],[1,6,11],[7,9,2]]));