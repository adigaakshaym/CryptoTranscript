function getBlock(Number)
{
  if((document.getElementById('block'+Number).style.backgroundColor!='green') && (document.getElementById('block'+Number).style.backgroundColor!='red'))

{  var requestOptions = {
  method: 'GET',
  redirect: 'follow'

};
// alert(Number);
var container = document.getElementById('container');
   var block = document.createElement('div');
  block.setAttribute('class','block');
  var blocknumber='block'+(Number+1);
  block.setAttribute('id',blocknumber);
  container.appendChild(block);

  var file = document.createElement('div');
  file.setAttribute('class','file');
  var input = document.createElement('input');
  input.setAttribute('type', 'file');
  input.setAttribute('accept','pdf');
  file.appendChild(input);
 
  block.appendChild( file );

 var shaparent = document.createElement('div');
 var parentid='shaparent'+(Number+1);
 shaparent.setAttribute('class','shaparent');
 shaparent.setAttribute('id',parentid);

  block.appendChild(shaparent);

  var shacurrent= document.createElement('div');
  var selfid='shacurrent'+(Number+1);
  shacurrent.setAttribute('class','shacurrent');
  shacurrent.setAttribute('id',selfid);
  
  block.appendChild( shacurrent );

  var minebutton= document.createElement('button');
  var buttonid='minebutton'+(Number+1);
  minebutton.setAttribute('id',buttonid);
  minebutton.innerHTML="Mine";
  block.appendChild(minebutton);
  document.getElementById(buttonid).addEventListener('click', function (){
   mineBlock(Number+1);getBlock(Number+1);

   
});
 
}
  /*

fetch('http://localhost:4444/getTranscriptBlocks', requestOptions)
 .then(
 function(response){
response.json().then(function(data){
 console.log(data);
//alert(data);
var blocks=JSON.parse(JSON.stringify(data));
var blocknum = 1;
for(i = 0 ; i<Object.keys(blocks).length;i++){
var container = document.getElementById('container');
   var block = document.createElement('div');
  block.setAttribute('class','block');
  block.setAttribute('id','block1');
  container.appendChild(block);

  var file = document.createElement('div');
  file.setAttribute('class','file');
  var input = document.createElement('input');
  input.setAttribute('type', 'file');
  input.setAttribute('accept','pdf');
  file.appendChild(input);
 // file.innerHTML = blocks[i].transcriptData;
  block.appendChild( file );

 var shaparent = document.createElement('div');
 shaparent.setAttribute('class','shaparent');
  shaparent.innerHTML = blocks[i].previousHash;
  block.appendChild(shaparent);

  var shacurrent= document.createElement('div');
  shacurrent.setAttribute('class','shacurrent');
  shacurrent.innerHTML = blocks[i].hash;
  block.appendChild( shacurrent );

  var minebutton= document.createElement('button');
  minebutton.setAttribute('id','minebutton');
  minebutton.innerHTML="Mine";
  block.appendChild(minebutton);
}

});
 }
 )
.catch(error => console.log('error', error))
*/
}