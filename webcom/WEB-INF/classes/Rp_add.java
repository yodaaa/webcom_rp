/* report add*/
import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Rp_add extends HttpServlet{
  public void doGet(
                    HttpServletRequest request,
                    HttpServletResponse response
                    )
  throws ServletException{
  ServletContext sc = getServletContext();
    try{//<3
       request.setCharacterEncoding("UTF-8");//<@2>
       //v (1) Getting form-data.
       String dateStr = request.getParameter("date");
       String priceStr = request.getParameter("price");
       String itemStr = request.getParameter("item");
       String shopStr = request.getParameter("shop");
       String qry
          = String.format("insert into money_table(date, price, item, shop) values('%s', %s, '%s', '%s')",  dateStr, priceStr, itemStr, shopStr);
       //v (2) Creating beans.
       CarDBBean12 cBean =
          new CarDBBean12(
                          mybeans.Config.password,
                          "rpdb",
                          2,
                          qry
                          );
       sc.getRequestDispatcher("/rp_thanks.html")
          .forward(request, response);
        }
        catch(Exception e){
          e.printStackTrace();
          try{
            sc.getRequestDispatcher("/rp_error.html")
               .forward(request, response);
          }
           catch(Exception e1){
                      //Ignore it.
          }
        }
  }
}
