(let[h 0x64f37 bx"054b355269379e17f460069efee72f2b739fad76a0ee29ad"
 a(atom h)n(atom (str"0000000000000000"bx))]
 (while(> @a 0x64f33)
  (let[sl(subs(slurp(str"http://webbtc.com/block/"@n".hex"))0 160)
    s(subs sl 8 72)]
   (do(println @a" "s)
    (reset! n(apply str
     (map(fn[i](str
      (.charAt s(* 2 (- 31 i)))
      (.charAt s(+(* 2 (- 31 i))1))))
     (range 32))))
    (swap! a dec)))))