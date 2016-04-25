(doall(map
 (fn[l](println(subs l 0 64)))
 (.split(slurp"OneToTwo.txt")"\n")))
