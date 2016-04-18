import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
import clojure.lang.*;
//http://www.eclipse.org/jetty/documentation/current/advanced-embedding.html :
public class HtTp extends AbstractHandler{
 public void handle(String t, Request br, HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException{
  try{
   RT.loadResourceScript("hiccup/core.clj");
   //RT.loadResourceScript("clojure/data/json.clj");
   String c="(fn[rq rs]((eval(read-string(slurp\"https://knot-net.appspot.com/jboot\")))rq rs))";
   PushbackReader pr=new PushbackReader(new StringReader(c));
   Object rootHandlerExpr=LispReader.read(pr,true,null,false);
   IFn rootHandlerFn=(IFn)clojure.lang.Compiler.eval(rootHandlerExpr);
   rootHandlerFn.invoke(rq,rs);
  } finally { }
  br.setHandled(true);}
 public static void main(String[] a)throws Exception{
  Server s = new Server(8028);
  s.setHandler(new HtTp());
  s.start();
  s.join();
  long lastSec=0;
  while(true){
   long c=System.currentTimeMillis();
   if(c/1000>lastSec){
    System.out.println(c);
    Runtime.getRuntime().exec("/home/rawa/git/AllHashes/job.sh");
    lastSec=c/1000;}}}}