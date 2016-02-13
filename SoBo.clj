; mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get -Dartifact=org.clojure:clojure:1.8.0
; java -jar ~/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar bbc.clj
(require '[clojure.xml :as xml])

;(System/setProperty "http.agent" "AlphaNews (http://sl4.eu/news)")

;http://www.siggibecker.de/noj923yeah/feed/
; title
; link
; pubDate
; dc:creator
; category*
; guid
; description

(defn h [b] ; https://gist.github.com/kisom/1698245
 (let [h (java.security.MessageDigest/getInstance "SHA-256")]
  (. h update b)
  (.digest h)))

(defn hh [m] (apply str (map #(format "%02x" %) m)))

(defn parsePubDate [s]
 ;http://stackoverflow.com/questions/2705548/parse-rss-pubdate-to-date-object-in-java
 (.parse
  (java.text.SimpleDateFormat. "EEE, dd MMM yyyy HH:mm:ss zzz"
   java.util.Locale/ENGLISH) s))

(defn starTime [d]
 (/ (- (.getTime d) 1443408427000) 1000))

(defn starTimeD [d]
 (format "%f" (/ (- (.getTime d) 1443408427000) 1000.0)))

(defn findTag [x t]
 (first
  (map (fn [i]
   (if (= t (:tag i))
    (first (:content i)))
   (:content x)))))

(println
 (first (:content 
  (first (:content (xml/parse
   "1220e1c2deb2a06cef235f73f6b5548c1bb644009dbc9f3d83a807c7840697b99b6c.xml"))))))

;(println (xml/parse
 ; "1220e1c2deb2a06cef235f73f6b5548c1bb644009dbc9f3d83a807c7840697b99b6c.xml"))

(println (findTag 
 (first (:content 
  (first (:content (xml/parse
   "1220e1c2deb2a06cef235f73f6b5548c1bb644009dbc9f3d83a807c7840697b99b6c.xml")))
  )) :link
 ))



(ddd)

(defn getTag [x n]
 (first (:content (get (:content x) n))))

(defn spitNews [s]
 (let [
   sl (slurp s)
   ss (hh (h (.getBytes sl)))
   sf (str "1220" ss ".xml")]
  (if (not (.exists (java.io.File. sf)))
   (do
    (spit "FeedFetch.txt"
     (str (starTimeD (java.util.Date.))
      " " ss " " s "\n") :append true)
    (spit sf sl)))
  ss))

(println (apply str (map
 (fn [x]
  (if (= :item (:tag x))
   (let [
     t (parsePubDate (getTag x 2))
     s (str
      (starTime t) "\n";link
      (getTag x 2) "\n";link
      (getTag x 0) "\n";title
      "\n")
     hs (hh (h (.getBytes s)))]
    (do
     (println s)
     (spit (str "1220" hs ".news") s)
     (str hs "\n")))))
 (:content (first (:content (xml/parse
  (str "1220"
   (spitNews
    "http://www.siggibecker.de/noj923yeah/feed/")
   ".xml"))))))))