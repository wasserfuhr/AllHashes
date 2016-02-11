(println "[")

(doall
 (map
  (fn [l]
   (let [
     h (second (.split l " "))
     f (slurp (str "/home/rawa/SpaceDrive/1220" h ".news"))]
   (println {:t "a" :i "i"})))
  (line-seq (java.io.BufferedReader. *in*))))

(println "]")