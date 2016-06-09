(doall(map(fn[l](println(str
(Integer/parseInt (subs l 0 5) 16) )))
 (.split(slurp *in*)"\n")))