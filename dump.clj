; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar dump.clj
(println
 (map
  (fn [l] (str ">" l))
  (.split (slurp "BootStrapDresdenLabsLd428d.txt") "\n")))