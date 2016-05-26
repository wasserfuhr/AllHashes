(let[h 0x64f37
 a(atom h)]
 (while(> @a 0x64f33)
  (do(print @a)
   (println(subs(slurp"http://webbtc.com/block/000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f.hex")160))
   (swap! a dec))))