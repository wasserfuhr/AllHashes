import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
//http://www.eclipse.org/jetty/documentation/current/advanced-embedding.html :
public class HtTp extends AbstractHandler{
 public void handle(String t, Request br, HttpServletRequest rq, HttpServletResponse rs) throws Exception{
  rs.setContentType("text/html; charset=utf-8");
  rs.setStatus(HttpServletResponse.SC_OK);
  rs.getWriter().println("<h1>Hello World</h1>");
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