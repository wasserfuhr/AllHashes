(fn[rq rs](let[c(.getAttribute rq"c")]
 ((:ht c)[:head
 [:title"SingularTime"]
 [:link{:rel"canonical":href"http://time.sl4.eu/"}]
 [:script"
var zoomLevel=0;

function twoDigits(d){
 return d>9?d:'0'+d;}

function tick(){
 ctx=document.getElementById('time').getContext('2d');
 ctx.font='12px Arial';
 ctx.fillStyle='#fff';
 ctx.fillRect(0,0,1024,512);
 var now=new Date();
 var t0=Math.floor(now.getTime()/1000);
 t16=t0.toString(16);
 document.getElementById('st').innerHTML='st'+t16;
 for(var i=0;i<32;i++){
  var l0=Math.pow(2,i);
  if(i<zoomLevel){
   ctx.fillStyle='#eee';
   ctx.fillRect(0,512-(i+1)*16,1024,16);}
  else{
   var l=Math.pow(2,i-zoomLevel);
   for(var j=-512;j<=512;j+=l){
    var t=(t0+j*Math.pow(2,zoomLevel));
    var t1=t-t%l0;
    ctx.fillStyle=t1&l?'#ddd':'#fff';
    ctx.fillRect(512+t1-t0,512-(i+1)*16,l,16);}}
  ctx.fillStyle='#d8d8d8';
  ctx.fillRect(0,512-(i+1)*16,1024,1);}

 //ToDo: var units=[{m:60}];
 
 ctx.fillStyle='#ccc';

 ctx.textAlign='center';
 var pixelPerUnit=60/Math.pow(2,zoomLevel);
 if(pixelPerUnit>15){
  for(var j=-1024;j<1024;j+=pixelPerUnit){
   var tn=now.getTime()+j*1000/Math.pow(2,zoomLevel);
   var tb=tn-tn%60000;
   if(512+j-(tn-tb)/1000<512){
    ctx.fillRect(512+j-(tn-tb)/1000,0,1,512);}
   var m=new Date(tn).getMinutes();
   if(512+j-(tn-tb)/1000+pixelPerUnit/2<500)
    ctx.fillText(twoDigits(m),512+j-(tn-tb)/1000+pixelPerUnit/2,126);}}

 var pixelPerUnit=60*60/Math.pow(2,zoomLevel);
 if(pixelPerUnit>16){
  for(var j=-1024;j<1024;j+=pixelPerUnit){
   ctx.fillRect(512+j-t0%3600/Math.pow(2,zoomLevel),0,1,512);
   var m=new Date(now.getTime()+j*1000/Math.pow(2,zoomLevel)).getHours();
   ctx.fillText(m,508+j-t0%3600/Math.pow(2,zoomLevel)+pixelPerUnit/2,100);}}

 var pixelPerUnit=365*24*60*60/Math.pow(2,zoomLevel);
 if(pixelPerUnit>100){
  for(var j=-1024;j<1024;j+=pixelPerUnit)
   ctx.fillRect(512+j,0,1,512);}

 ctx.fillStyle='#888';
 ctx.textAlign='end';

 ctx.font='10px Arial';
 ctx.fillText(twoDigits(now.getSeconds()),509,141);
 ctx.font='12px Arial';
 var min=now.getMinutes();
 ctx.fillText(twoDigits(now.getMinutes()),509,126);
 ctx.font='14px Arial';
 ctx.fillText(twoDigits(now.getHours()),510,110);
 ctx.font='16px Arial';
 ctx.fillText(twoDigits(now.getDate()),509,86);
 ctx.font='24px Arial';
 ctx.fillText(twoDigits(now.getMonth()+1),510,65);
 ctx.font='28px Arial';
 ctx.fillText(now.getFullYear(),510,34);
 ctx.fillStyle='#f00';
 ctx.fillRect(512,0,1,512);

 ctx.font='bold 11px Courier';
 ctx.textAlign='center';
 for(var i=0;i<32;i++){
  var l0=Math.pow(2,i);
  ctx.fillStyle='#000';
  ctx.fillText(t0&l0?'1':'0',518,508-i*16);}
 ctx.fillStyle='#aaa';
 for(var i=4;i<32;i+=4){
  ctx.fillRect(0,i*16,1024,1);}
 ctx.fillStyle='#777';
 ctx.font='bold 28px Courier';
 for(var i=0;i<8;i++){
  ctx.fillText(t16.substring(i,i+1),538,41+i*64);}}
setInterval(tick,1000);"]]
    [:body{:style"font-family:Arial"}
     [:h1{:style"text-align:center;color:#aaa;margin-bottom:0px"}
      "SingularTime"
      ((:pageEdit(.getAttribute rq"vars"))"/t""Edit SingularTime"10)]
     [:h2#st{:style"text-align:center;font-family:monospace"}
      "st54280000"]
     [:p{:style"text-align:center"}
      [:canvas#time{:style"border:1px solid #aaa":width 1024 :height 512}]]])))
;   <!-- ToDo: button onclick="zoomLevel++;tick()">+</button
;    button onclick="zoomLevel--;tick()">-</button-->
