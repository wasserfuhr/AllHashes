; ~/Desktop/apache-maven-3.2.5/bin/mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; ~/Desktop/apache-maven-3.2.5/bin/mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure::data.xml:0.0.8
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar -cp ~/.m2/repository/org/clojure/data.xml/0.0.8/data.xml-0.0.8.jar:. news.clj
(require '[clojure.xml :as xml]
         '[clojure.zip :as zip])
(print (xml/parse "http://www.tagesschau.de/newsticker.rdf"))
;(clojure.data.xml/parse "http://www.tagesschau.de/newsticker.rdf")