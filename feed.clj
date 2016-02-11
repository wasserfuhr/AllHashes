(doall
 (map
  (fn [l]
   (println (first (.split (slurp (str "/home/rawa/SpaceDrive/1220" l ".news")) "\n")) l))
  (line-seq (java.io.BufferedReader. *in*))))