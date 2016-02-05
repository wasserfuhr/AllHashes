; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar dump.clj

;  (.split (slurp "BootStrapDresdenLabsLd428d.txt") "\n")))

 (println (str ">" "l"))

;(doseq
(doall
 (map
  (fn [l] (println (str ">" l)))
  (line-seq (java.io.BufferedReader. *in*))))