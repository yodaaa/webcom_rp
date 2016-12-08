/*
############################################################
File: "C8Sample5D.java".
On nepi10 : (*home-common="i:/home2/"):
(concat "c:/Apache_Software_Foundation/Tomcat6_0_14/webapps/"
  "MyServlets/WEB-INF/classes/"
  "C8Sample5D.java")
By Horita.
On (2010 Nov 7).
############################################################
SOURCE:
*/
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
public class C8Sample5D extends HttpServlet{//<1
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException{//<2
    try{//<3
      //v Bean の取得.
      mybeans.CarDBBean10 cb =
        (mybeans.CarDBBean10)request.getAttribute("cb");
      Vector<String> colNames = (Vector<String>)cb.getColnames();//<@1>,<@2>
      Vector<Vector<String>> tableData = cb.getData();//<@1>
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter pw = response.getWriter();
      pw.println(//<4
        "<html>\n"+
        "<head>\n"+
        "<title>C8Sample5</title>\n"+
        "<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\n"+
        "<script src=\"../js/bootstrap.min.js\"></script>"+
        "</head>\n"+
        "<body>\n"+
        "<div class=\"container\">"+
        "<div class=\"col-sm-10 col-md-10\">\n"+
        "<h2>money_table 一覧</h2>"+
        "<hr>\n"+
        "<a href=\"../rp.html\" class=\"btn btn-default btn-lg \">HOME</a>"+
        "<div class=\"table-responsive\"><br>"+
        "<table border=\"1\" class=\"table table-striped table-bordered table-hover\">\n" +
        "<tr>\n"
      );//4>
      int size1 = colNames.size();
      for(int column=0; column < size1; column++){//<5
        pw.println("<th>\n");
        pw.println(colNames.elementAt(column));//<@1>
        pw.println("</th>\n");
      }//5>
      pw.println("</tr>\n");
      int size2 = tableData.size();
      for(int row = 0; row < size2; row++){//<5
        pw.println("<tr>\n");
        Vector<String> rowdata = tableData.elementAt(row);
        int size3 = rowdata.size();
        for(int column=0; column < size3; column++){//<6
          pw.println("<td>\n");
          pw.println(rowdata.elementAt(column));
          pw.println("</td>\n");
        }//6>
        pw.println("</tr>\n");
      }//5>
      pw.println(
        "</table>\n"+
        "</div>\n"+
        "<p id=\"pageTop\"><a href=\"#\" class=\"btn btn-default btn-lg\">page top</a></p>"+
        "</div>\n"+
        "</div>\n"+
        "</body>\n"+
        "</html>\n"
      );
    }//3>
    catch(Exception e){//<3
      e.printStackTrace();
    }//3>
  }//2>
  //************************************************************
}//1>
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
