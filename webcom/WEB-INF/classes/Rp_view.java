import mybeans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Rp_view extends HttpServlet{//<1e
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
                            "rpdb",
                            "money_table"
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
}//1>
