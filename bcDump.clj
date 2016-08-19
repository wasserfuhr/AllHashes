(let[h ;0x64f37 bx"054b355269379e17f460069efee72f2b739fad76a0ee29ad"
;0x64fb5 bx"02c0ec6629d9ce89e77bbd5ff530e04e690b5a8697e47d0e"
;0x62902 bx"01ddcf03e442ad707218ddb3fe45611700980514399e5a7f"
;0x5e469 bx"0936c69fb727394141787c32ce6a16e2a9e6a328b2401fed" ;502 Bad Gateway
;0x65049 bx"045d9003d09f64af5a263fd21ea691d5d6dc19907e594e31"
;0x65157 bx"0378aa86c50d9b4270b7cad11e13ded6b21aa0171708961c"
;0x65107 bx"04e1f222edf916d37fd6f322cf3e96db87b1e832005c834a"
;0x6525a bx"02b486b6ab1364c21a7b15681fcdc927a6934a0b322d4961"
;0x64847 bx"043b58e1e6a801ef7951d2e92727fdfc5caede6c36e7ffc3"
;0x63f1a bx"00ef26364ac2cd96d688bca642c2639d480955f855d45743"
;0x631af bx"03b0f4768c4f2000e6bcefb63db565c1d0dd98cffd4090f6"
;0x6538d bx"01d36823a26028a49a045293e305f3c961ffa932923d086b"
;0x652be bx"039945e71f68b114976022bf41477e87ffe9e287bcb3fb89"
;0x6539f bx"04144604f2da0a12ddb6d823401531c1a270dd496d369caf"
0x65958 bx"0342d9166403bb218f4796c3bc2b9d4d19cd7e54814bfbe2"
 a(atom h)n(atom (str"0000000000000000"bx))]
 (while(> @a 0x6538d)
; (while(> @a 0x65259)
; (while(> @a 0x65157)
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
    (Thread/sleep 1000))))))