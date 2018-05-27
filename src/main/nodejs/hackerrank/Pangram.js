'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the pangrams function below.
function pangrams(str) {
    const charSet = new Set(Array.from(new Array(26),(val,index)=>String.fromCharCode(index+97)));
    const s = str.toLowerCase();
    for(var i=0;i<s.length && charSet.size>0;i++){
        charSet.delete(s.charAt(i));
    }
    if(charSet.size==0){
        console.log("pangram");
    }else{
        console.log("not pangram");
    }
}

function main() {
//    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = readLine();

    let result = pangrams(s);

//    ws.write(result + "\n");

//    ws.end();
}
