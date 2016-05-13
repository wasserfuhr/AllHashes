; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar dump.clj
;BootStrapDresdenLabsLd428d.txt
;http://stackoverflow.com/questions/2034059/how-to-read-lines-from-stdin-in-in-clojure
(doall
 (map
  (fn [l]
   (spit (str l ".txt") (slurp (str "https://floatingboat2013.appspot.com/dump?id=" l)))
   (println "slurped" l))
  (line-seq (java.io.BufferedReader. *in*))))