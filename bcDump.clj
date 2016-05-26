(let[h 0x64f37 bx"054b355269379e17f460069efee72f2b739fad76a0ee29ad"
 a(atom h)]
 (while(> @a 0x64f33)
  (do(print @a)
   (println(subs(slurp(str"http://webbtc.com/block/0000000000000000"bx".hex"))160))
   (swap! a dec))))