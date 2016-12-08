/* report del*/
import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Rp_del extends HttpServlet{
   public void doGet(
                     HttpServletRequest request,
                     HttpServletResponse response
                    )
      throws ServletException{
      ServletContext sc = getServletContext();
      try{
         request.setCharacterEncoding("UTF-8");//<@2>
         //v (1) Getting form-data.
         String idStr = request.getParameter("delid");
         String qry
            = String.format("delete from money_table where id = %s",
                            idStr );
         //v (2) Creating a bean.
         CarDBBean12 cBean =
            new CarDBBean12(
                            mybeans.Config.password,
                            "rpdb",
                            2,
                            qry
                            );

         sc.getRequestDispatcher("/rp_thanks.html")
            .forward(request, response);
      }//3>
      catch(Exception e){//<3
         e.printStackTrace();
         try{
            sc.getRequestDispatcher("/rp_error.html")
               .forward(request, response);
         }
         catch(Exception e1){
            //Ignore it.
         }
      }//3>
   }//2>
   //************************************************************
}//1>
