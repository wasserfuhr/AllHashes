; ~/Desktop/apache-maven-3.2.5/bin/mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; ~/Desktop/apache-maven-3.2.5/bin/mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure::data.xml:0.0.8
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar -cp ~/.m2/repository/org/clojure/data.xml/0.0.8/data.xml-0.0.8.jar:. news.clj

;(clojure.xml/parse "http://www.tagesschau.de/newsticker.rdf")

(require '[clojure.xml :as xml])



(println (apply str (map
 (fn [x]
  (if (= :item (:tag x))
   (str "x " (:content x))))
 (:content (first (:content (xml/parse "http://www.tagesschau.de/newsticker.rdf"))))))
)

(println "->" (.length (:content (first (:content (xml/parse "http://www.tagesschau.de/newsticker.rdf"))))))

(println "->" (type (:content (first (:content (xml/parse "http://www.tagesschau.de/newsticker.rdf"))))))