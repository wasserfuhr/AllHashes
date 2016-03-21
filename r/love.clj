(fn[rq rs](let[c(.getAttribute rq"c")
 u(.getRequestURI rq)
 h(subs u 6)
;:3b "FaedChen SchnuefffChen StuermChen PferdeFrau
 s(fn[h](slurp(str"http://s.sl4.eu/clj.jsp?p=sh&s="h)))
 f(fn[i]
  [:a{:href(str"/love/"i)}[:img{:src(str"http://s.sl4.eu/clj.jsp?p=img&h="(s i)):width(if(= h i)150 75)}]])
]((:ht c)[:head
 [:title"ArtRausch « α"]
 [:meta{:name"viewport":content"width=device-width,initial-scale=1.0"}]
 [:link{:rel"canonical":href(str"http://sl4.eu"u)}]
 [:link{:rel"stylesheet":type"text/css":href"/css"}]]
[:body[:h1(str"DoYouLove "h"?:")]
(f"99")(f"3b")[:br](f"1e")(f"4d")[:br][:a{:href"/sl4/"}"all"]])))
