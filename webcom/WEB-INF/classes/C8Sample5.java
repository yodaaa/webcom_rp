/*
############################################################
File: "C8Sample5.java".
On nepi15 : (*home-common="d:/home2/"):
(concat "c:/apache/tomcat7_42/webapps/MyServlets/WEB-INF/classes/"
  "C8Sample5.java")
By Horita.
On (2013 Nov 21).
############################################################
GENEALOGY:

<-File: "C8Sample5.java".
On nepi15 : (*home-common="h:/home2/"):
(concat "c:/apache/tomcat6_32/webapps/MyServlets/WEB-INF/classes/"
  "C8Sample5.java")
By Horita.
On (2011 Dec 11).
-- @2013_11_21_14_57_24_465, on nepi15.

<-File: "C8Sample5.java".
On nepi10 : (*home-common="i:/home2/"):
(concat "c:/Apache_Software_Foundation/Tomcat6_0_14/webapps/"
  "MyServlets/WEB-INF/classes/"
  "C8Sample5.java")
By Horita.
On (2010 Nov 7).
-- @(2011 Dec 11 + 20:48:54), on "nepi15".
############################################################
SOURCE:
*/
import mybeans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
/*
  Declass C8Sample5.
  @(2011 Dec 11 + 21:46:19), on "nepi15".
*/
public class C8Sample5 extends HttpServlet{//<1
   //************************************************************
   /*
     Demeth doGet().
     @(2011 Dec 11 + 21:46:05), on "nepi15".
   */
   public void doGet(
                     HttpServletRequest request1,
                     HttpServletResponse response1
                    )
   throws ServletException{//<2
      try{//<3
         //v サーブレットコンテキストの取得.
         ServletContext srvCxt = getServletContext();
         //v Beanの作成.
         CarDBBean10 carDBBean1 =
            new CarDBBean10(
                            mybeans.Config.password,
                            "cardb",
                            "car_table"
                           );
         //v  request1 に, Bean carDBBean1 を設定.
         request1.setAttribute("cb", carDBBean1);
         //v リクエストの転送.
         srvCxt.getRequestDispatcher("/servlet/C8Sample5D")
            .forward(request1, response1);
      }
      catch(Exception e){//3><3
         e.printStackTrace();
      }//3>
   }//2>
   //************************************************************
}//1>
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
