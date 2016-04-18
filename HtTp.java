import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
import clojure.lang.*;
//http://www.eclipse.org/jetty/documentation/current/advanced-embedding.html :
public class HtTp extends AbstractHandler{
 public void handle(String t,Request br,HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
  try{
   RT.loadResourceScript("hiccup/core.clj");
   //RT.loadResourceScript("clojure/data/json.clj");
   String c="(fn[rq rs]((eval(read-string(slurp\"https://knot-net.appspot.com/jboot\")))rq rs))";
   PushbackReader pr=new PushbackReader(new StringReader(c));
   Object r=LispReader.read(pr,true,null,false);
   IFn rf=(IFn)clojure.lang.Compiler.eval(r);
   rs.getWriter().print(rf.invoke(rq,rs));
  }finally{}
  br.setHandled(true);}
 public static void main(String[] a)throws Exception{
  new Ur().start();
  Server s = new Server(8080);
  s.setHandler(new HtTp());
  s.start();
  s.join();}}