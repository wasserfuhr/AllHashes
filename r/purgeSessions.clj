(fn [request response]
 (do
  (.setCharacterEncoding response "UTF-8")
  (let [
    AppVars (.getAttribute request "vars")
    appId (:appId AppVars)
    userService (:userService AppVars)
    currUser (.getCurrentUser userService)
    service (:datastoreService AppVars)
    limit (.getParameter request "limit")
    limitL (if limit (Long. limit) 1024)
    query 
     (doto
      (com.google.appengine.api.datastore.Query. "_ah_SESSION")
      (.addSort "_expires" (:sortDirAsc AppVars)))
    limit ((:queryLimit AppVars) limitL)
    recentList (.asIterable (.prepare service query) limit)]
   (hiccup.core/html "<!DOCTYPE html>"
    [:html
     [:body
      [:a {:href "/edit/purgeSessions"}]
      (if
       (or
        (.isUserLoggedIn userService)
        (.startsWith
         (.getHeader request "User-Agent")
         "AppEngine-Google"))
       (map
          (fn [e]
           (do           
            (.delete service (list (.getKey e)))
            (.getKey e)))
          recentList)
       [:p "please LogOn"])]])))))