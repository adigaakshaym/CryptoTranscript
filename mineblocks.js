function mineBlock(Number)
{
  if(document.getElementById('block'+Number).style.backgroundColor!='green' && document.getElementById('block'+Number).style.backgroundColor!='red'){
var myHeaders = new Headers();
myHeaders.append("Content-Type", "text/plain");



var file = new FormData();
file.append("file",document.getElementById('blockfile').files[0]);



var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: file,
  redirect: 'follow'
};

/*fetch('http://localhost:4444/transcriptBlocks/mine', requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
*/


fetch('http://localhost:4444/transcriptBlocks/mine', requestOptions)
 .then(
 function(response){
response.json().then(function(data){
 console.log(data);

var blocks=JSON.parse(JSON.stringify(data));

var blocknum = 1;
var parenthash='shaparent'+Number;
var currenthash='shacurrent'+Number;
document.getElementById(parenthash).innerHTML=blocks.previousHash;
document.getElementById(currenthash).innerHTML=blocks.hash;

document.getElementById('block'+Number).style.backgroundColor=blocks.flag;

});
 }
 )
.catch(error => console.log('error', error))

}
else  if(document.getElementById('block'+Number).style.backgroundColor=='green'){
 
  var myHeaders = new Headers();
myHeaders.append("Content-Type", "text/plain");



var file = new FormData();
file.append("file",document.getElementById('blockfile').files[0]);



var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: file,
  redirect: 'follow'
};


  fetch('http://localhost:4444/tamperBlocks?index='+(Number-1), requestOptions)
  .then(

  function(response){
 response.json().then(function(data){
  console.log(data);
 
 var blocks=JSON.parse(JSON.stringify(data));

 var parenthash='shaparent'+Number;
 var currenthash='shacurrent'+Number;
 document.getElementById(parenthash).innerHTML=blocks.previousHash;
 document.getElementById(currenthash).innerHTML=blocks.hash;
 
 document.getElementById('block'+Number).style.backgroundColor=blocks.flag;
 refresh();
 });
  }
  )
 .catch(error => console.log('error', error))
 
 

}

 else if(document.getElementById('block'+Number).style.backgroundColor=='red'){
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "text/plain");
  
  
  
  var file = new FormData();
  file.append("file",document.getElementById('blockfile').files[0]);
  
  
  
  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: file,
    redirect: 'follow'
  };
  
  /*fetch('http://localhost:4444/transcriptBlocks/mine', requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
  */
  
  
  fetch('http://localhost:4444/transcriptBlocks/mine?index='+(Number-1), requestOptions)
   .then(
   function(response){
  response.json().then(function(data){
   console.log(data);
  
  var blocks=JSON.parse(JSON.stringify(data));
  
  var blocknum = 1;
  var parenthash='shaparent'+Number;
  var currenthash='shacurrent'+Number;
  document.getElementById(parenthash).innerHTML=blocks.previousHash;
  document.getElementById(currenthash).innerHTML=blocks.hash;
  
  document.getElementById('block'+Number).style.backgroundColor=blocks.flag;
  
  });
   }
   )
  .catch(error => console.log('error', error))
  
  }

 

}