(let[h
0x6539f bx"04144604f2da0a12ddb6d823401531c1a270dd496d369caf"
 a(atom h)n(atom (str"0000000000000000"bx))]
 (while(> @a 0x6538d)
; (while(> @a 0x65259)
; (while(> @a 0x65157)
  (let[ah(format"%x"@a)
    s0(slurp(str
"/Volumes/SPACEDRIVE1/btc/b"ah".hex"))
    sl(subs s0 0 160)
    s(subs sl 8 72)]
   (do
    (reset! n(apply str
     (map(fn[i](str
      (.charAt s(* 2 (- 31 i)))
      (.charAt s(+(* 2 (- 31 i))1))))
     (range 32))))
;    (spit(str "btc/b"ah".hex")s0)
 (.println *err* ah) 
    (println ah @n)
    (swap! a dec)
    (Thread/sleep 1000))))))