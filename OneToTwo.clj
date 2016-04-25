(doall(map
 (fn[l](println(str(subs l 0 64)" "(subs l 106))))
 (.split(slurp"OneToTwo.txt")"\n")))
