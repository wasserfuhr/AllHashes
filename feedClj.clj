(println "[")
(doall
 (map
  (fn [l]
   (let [
     s (.split l " ")
     h (second s)
     f (.split (slurp (str "/home/rawa/SpaceDrive/1220" h ".news")) "\n")]
   (println {:id (str "\"" h "\"") :t (first s) :link (str "\"" (second f) "\"")
    :title (str "\"" (.replaceAll (get f 2) "\"" "\\\\\"") "\"")
    :more (str "\"" (.replaceAll (.replaceAll (get f 3) "\\\\" "") "\"" "\\\\\"") "\"")})))
  (line-seq (java.io.BufferedReader. *in*))))
(println "{:t 0 :title \"Hi HiPo EtAi!\" :link \"/\"}")
(println "]")