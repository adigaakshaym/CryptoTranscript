
// window.onload = addBlock;

var flag = 1;
function mineBlock(){

if (flag == 1)
{
 document.getElementById('block1').style.backgroundColor='green';
addBlock();
}
}

function addBlock(){

var blocknum = 2;
   var container = document.getElementById('container');
   var block = document.createElement('div');
  block.setAttribute('class','block');
  block.setAttribute('id','block'+blocknum);
  container.appendChild( block );

  var file = document.createElement('div');
  file.setAttribute('class','file');
  var input = document.createElement('input');
  input.setAttribute('type', 'file');
  input.setAttribute('accept','pdf');
  file.appendChild(input);
  block.appendChild( file );

 var shaparent = document.createElement('div');
 shaparent.setAttribute('class','shaparent');
  shaparent.innerHTML = "shaparent";
  block.appendChild(shaparent);

  var shacurrent= document.createElement('div');
  shacurrent.setAttribute('class','shacurrent');
  shacurrent.innerHTML = "shacurrent";
  block.appendChild( shacurrent );

  var minebutton= document.createElement('button');
  minebutton.setAttribute('id','minebutton');
  minebutton.innerHTML="Mine";
  block.appendChild(minebutton);
}

// var mineblock_script = document.createElement("script");
// mineblock_script.src = "mineblock.js";
// document.head.appendChild(mineblock_script);
