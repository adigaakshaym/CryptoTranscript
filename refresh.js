function refresh()
{
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      
      };
fetch('http://localhost:4444/getTranscriptBlocks', requestOptions)
 .then(
 function(response){
response.json().then(function(data){
 console.log(data);

var blocks=JSON.parse(JSON.stringify(data));

for(i = 0 ; i<Object.keys(blocks).length;i++){


if(i==blocks[i].index){
    
    document.getElementById('block'+(i+1)).style.backgroundColor=blocks[i].flag;
    document.getElementById('shaparent'+(i+1)).innerHTML=blocks[i].previousHash;
    document.getElementById('shacurrent'+(i+1)).innerHTML=blocks[i].hash;
}

}

});
 }
 )
.catch(error => console.log('error', error))

}