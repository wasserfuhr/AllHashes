(let[h ;0x64f37 bx"054b355269379e17f460069efee72f2b739fad76a0ee29ad"
;0x64fb5 bx"02c0ec6629d9ce89e77bbd5ff530e04e690b5a8697e47d0e"
;0x62902 bx"01ddcf03e442ad707218ddb3fe45611700980514399e5a7f"
;0x5e469 bx"0936c69fb727394141787c32ce6a16e2a9e6a328b2401fed" ;502 Bad Gateway
;0x65049 bx"045d9003d09f64af5a263fd21ea691d5d6dc19907e594e31"
;0x65157 bx"0378aa86c50d9b4270b7cad11e13ded6b21aa0171708961c"
0x65107 bx"04e1f222edf916d37fd6f322cf3e96db87b1e832005c834a"
 a(atom h)n(atom (str"0000000000000000"bx))]
 (while(> @a 0x61e25)
  (let[ah(format"%x"@a)
    s0(slurp(str"http://webbtc.com/block/"@n".hex"))
    sl(subs s0 0 160)
    s(subs sl 8 72)]
   (do
    (reset! n(apply str
     (map(fn[i](str
      (.charAt s(* 2 (- 31 i)))
      (.charAt s(+(* 2 (- 31 i))1))))
     (range 32))))
    (spit(str "btc/b"ah".hex")s0)
 (.println *err* ah) 
    (println ah @n)
    (swap! a dec)
    (Thread/sleep 4000)))))