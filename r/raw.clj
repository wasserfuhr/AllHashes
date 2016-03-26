(fn[rq rs](do(.setContentType rs"text/plain;charset=utf-8")(let[
 v(.getAttribute rq"vars")
 s(:datastoreService v)
 u(subs(.getRequestURI rq)1)
 p(.split u"/")
 i(Long.(second p))
 k(com.google.appengine.api.datastore.KeyFactory/createKey"BootStrap"i)]
(.getValue(.getProperty(.get s k)"content")))))