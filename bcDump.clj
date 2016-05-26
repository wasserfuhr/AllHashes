(let[h 0x64f37 bx"054b355269379e17f460069efee72f2b739fad76a0ee29ad"
 a(atom h)h(atom 0)]
 (while(> @a 0x64f33)
  (do(println @a)(let[s(subs(slurp(str"http://webbtc.com/block/0000000000000000"bx".hex"))0 160)
  af31be8401dd6bfb350c923aca55833b0c554990a1e695040000000000000000
  (map 
(let[s"af31be8401dd6bfb350c923aca55833b0c554990a1e695040000000000000000"]
 (apply str
  (map(fn[i](str
               (.charAt s(* 2 (- 31 i)))
               (.charAt s(+(* 2 (- 31 i))1))
               ))(range 32))))
   (set! h 
af31be8401dd6bfb350c923aca55833b0c554990a1e695040000000000000000
   (println(subs(slurp(str"http://webbtc.com/block/0000000000000000"bx".hex"))0 160))
   (swap! a dec))))