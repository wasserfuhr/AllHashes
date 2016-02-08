; mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure::data.xml:0.0.8
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar -cp ~/.m2/repository/org/clojure/data.xml/0.0.8/data.xml-0.0.8.jar:. news.clj

;http://www.tagesschau.de/infoservices/rssfeeds/index.html
;('clojure.xml/parse "http://www.tagesschau.de/newsticker.rdf")

/*
http://www.tagesschau.de/newsticker.rdf :
title
link
pubDate
content:encoded
description
guid

http://www.tagesschau.de/xml/rss2 :
title
link
description
guid
category
*/

(require '[clojure.xml :as xml])

(println (apply str (map
 (fn [x]
  (if (= :item (:tag x))
   (str
    (first (:content (second (:content x)))) "\n" ;link
    " " (first (:content (get (:content x) 2))) "\n" ;title
    " " (first (:content (first (:content x)))) "\n" ;pubDate
    " " (first (:content (get (:content x) 4))) "\n"))) ;description
 (:content (first (:content (xml/parse "http://www.tagesschau.de/xml/rss2")))))))
; (:content (first (:content (xml/parse "http://www.tagesschau.de/newsticker.rdf")))))))
