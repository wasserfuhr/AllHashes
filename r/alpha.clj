(fn[rq rs](do(.setCharacterEncoding rs"UTF-8")
 (hiccup.core/html"<!DOCTYPE html>"[:html[:head
  [:title"α"]
  [:meta{:http-equiv"Content-Type":content"text/html;charset=utf-8"}]
  [:meta{:name"viewport":content"width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no"}]
  [:link{:rel"stylesheet":type"text/css":href"/css"}]
  [:style"p{color:#fff}a{color:#fff;font-variant:normal}"]]
 [:body
  [:div#alpha"α"]
  [:div{:style"z-index:1;position:absolute;font-family:monospace;line-height:24px"}
   "we »"(slurp"http://planet.sl4.eu/RootHandler.jsp?p=think")"«"[:br][:br](map
    #(let[v(str"/"%)][:span[:a{:href v}v]" "])
    (.split"join listen love share shine time watch"" "))
   [:br][:br](map
    #(let[v(str"/"%)][:span[:a{:href v}v]" "])
    (.split"chat crush drink eat edit join listen play read"" "))
   [:br][:br][:small(map
    (fn[t][:span[:a{:href(str"/"t)}(str"/"t)]" "])
    (.split"admin base blog branch buy code flirt follow grow hack hoo like listen mark plus quicken rain sit test think "" "))]]]])))
    ;chain come cook craft drop film flow learn operate pay plant prove re shop sieve teil work zip