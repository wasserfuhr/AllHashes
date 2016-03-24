(fn[rq rs](let[c(.getAttribute rq"c")]((:ht c)[:head
 [:title"BitCrush « α"]
 [:link{:rel"canonical":href"http://crush.sl4.eu/"}]
 (:css c)
 [:style"#v{font-family:monospace;font-size:200%;text-align:center}"]]
[:body
 [:table
  [:tr[:td#v""]]
  [:tr[:td[:input#i3{:type"checkbox"}][:input#i2{:type"checkbox"}]]]
  [:tr[:td[:input#i1{:type"checkbox"}][:input#i0{:type"checkbox"}]]]]
  [:script"
function t(){v=0;
 for(i=0;i<4;i++){
  if(document.getElementById('i'+i).checked){
   v+=1<<i;}}
 document.getElementById('v').innerHTML='0123456789abcdef'.substring(v,v+1);}
setInterval(t,250);"]])))