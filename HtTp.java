import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
//http://www.eclipse.org/jetty/documentation/current/advanced-embedding.html :
public class HtTp extends AbstractHandler{
 public void handle(String target, Request baseRequest, HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException{
  rs.setContentType("text/html; charset=utf-8");
  rs.setStatus(HttpServletResponse.SC_OK);
  rs.getWriter().println("<h1>Hello World</h1>");
  baseRequest.setHandled(true);}
 public static void main(String[] a)throws Exception{
  Server server = new Server(8028);
  server.setHandler(new HtTp());
  server.start();
  server.join();
  long lastSec=0;
  while(true){
   long c=System.currentTimeMillis();
   if(c/1000>lastSec){
    System.out.println(c);
    Runtime.getRuntime().exec("/home/rawa/git/AllHashes/job.sh");
    lastSec=c/1000;}}}}