; mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure::data.xml:0.0.8
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar -cp ~/.m2/repository/org/clojure/data.xml/0.0.8/data.xml-0.0.8.jar:. news.clj

;http://www.tagesschau.de/infoservices/rssfeeds/index.html
;('clojure.xml/parse "http://www.tagesschau.de/newsticker.rdf")

;http://www.tagesschau.de/newsticker.rdf :
; title
; link
; pubDate
; content:encoded
; description
; guid

;http://www.tagesschau.de/xml/rss2 :
; title
; link
; description
; guid
; category

(require '[clojure.xml :as xml])

(defn h [m] ; https://gist.github.com/kisom/1698245
 (let [h (java.security.MessageDigest/getInstance "SHA-256")]
  (. h update m)
  (.digest h)))

(defn hh [m] (apply str (map #(format "%02x" %) m)))

;(/(-
; (.getTime
;  (.parse
;   (java.text.SimpleDateFormat. "EEE, dd MMM yyyy HH:mm:ss zzz"
;     java.util.Locale/ENGLISH)
;   "Sun, 07 Feb 2016 04:56:23 +0100")) ;VerunsicherteRepublik
; 1443408427000) 86400)

(println (apply str (map
 (fn [x]
  (if (= :item (:tag x))
   (str
    (first (:content (get (:content x) 1))) "\n ";link
    (first (:content (get (:content x) 2))) "\n " ;title
    (first (:content (get (:content x) 0))) "\n " ;pubDate
    (first (:content (get (:content x) 4))) "\n"))) ;description
; (:content (first (:content (xml/parse "http://www.tagesschau.de/xml/rss2")))))))
 (:content (first (:content (xml/parse "https://www.tagesschau.de/newsticker.rdf")))))))