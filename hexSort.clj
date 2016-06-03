(doall(map(fn[l](println(str(subs l 0 6))))
 (.split(slurp *in*)"\n")))