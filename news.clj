; ~/Desktop/apache-maven-3.2.5/bin/mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar news.clj
(println (slurp "http://www.tagesschau.de/newsticker.rdf"))
