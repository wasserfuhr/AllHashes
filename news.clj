; mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar news.clj
(require '[clojure.xml :as xml])

;http://www.tagesschau.de/infoservices/rssfeeds/index.html
;http://www.tagesschau.de/xml/rss2 :
; title
; link
; pubDate
; content:encoded
; description
; guid

;http://www.tagesschau.de/newsticker.rdf :
; title
; link
; description
; guid
; category

(defn h [m] ; https://gist.github.com/kisom/1698245
 (let [h (java.security.MessageDigest/getInstance "SHA-256")]
  (. h update m)
  (.digest h)))

(defn hh [m] (apply str (map #(format "%02x" %) m)))

(defn parsePubDate [s]
 ;http://stackoverflow.com/questions/2705548/parse-rss-pubdate-to-date-object-in-java
 (.parse
  (java.text.SimpleDateFormat. "EEE, dd MMM yyyy HH:mm:ss zzz"
   java.util.Locale/ENGLISH) s))
;test:
;(print (parsePubDate "Sun, 07 Feb 2016 04:56:23 +0100")) ;VerunsicherteRepublik

(defn starTime [d]
 (/ (- (.getTime d) 1443408427000) 1000))

(defn getTag [x n]
 (first (:content (get (:content x) n))))

(defn spitNews [s]
 (let [
   sl (slurp s)
   ss (hh (h (.getBytes sl)))
   sf (str "1220" ss ".xml")]
  (if (not (.exists (java.io.File. sf)))
   (spit sf sl))
  ss))

(println (apply str (map
 (fn [x]
  (if (= :item (:tag x))
   (let [
     s (str
      (starTime (parsePubDate (getTag x 2))) "\n" ;pubDate
      (getTag x 1) "\n";link
      (getTag x 0) "\n";title
      (getTag x 4))
     hs (hh (h (.getBytes s)))] ;description
    (do
     (spit (str "1220" hs ".news") s)
     (str hs "\n")))))
 (:content (first (:content (xml/parse 
  (str "1220" 
   (spitNews "https://www.tagesschau.de/xml/rss2")
   ".xml"))))))))

(spitNews "https://www.tagesschau.de/newsticker.rdf")