/*
############################################################
File: "CarDBBean10.java".
On nepi15 : (*home-common="h:/home2/"):
(concat "c:/apache/tomcat6_32/webapps/MyServlets/WEB-INF/classes/mybeans/"
  "CarDBBean10.java")
By Horita.
On (2011 Dec 11).
############################################################
SOURCE:
*/
package mybeans;
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
import java.util.*;
import java.io.*;
import java.sql.*;
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
/*
  Declass CarDBBean10.
*/
public class CarDBBean10 implements Serializable{//<1
   private Vector<String> colNames;
   private Vector<Vector<String>> tableData;//<@1>
   //************************************************************
   public CarDBBean10(){
      super();
   }
   //************************************************************
   /*
     Decstr CarDBBean10().
    */
   public CarDBBean10(
                      String password,
                      String database,
                      String table
                     ){//<2
      try{//<3
         //v 接続の準備.
         String drv = "com.mysql.jdbc.Driver";
         String url = "jdbc:mysql:///" + database;
         String usr = "root";
         //v データベースへの接続.
         Class.forName(drv);
         Connection cn =
           DriverManager.getConnection(url, usr, password);
         //v 問い合わせの準備.
         Statement st = cn.createStatement();
         String qry = "SELECT * FROM " + table;
         System.out.println("--`CarDBBean10()'#3:qry = "+ qry);
         //v 問い合わせ.
         ResultSet resSet = st.executeQuery(qry);
         //v 列数の取得.
         ResultSetMetaData rm = resSet.getMetaData();
         int colNum = rm.getColumnCount();
         colNames = new Vector<String>(colNum);
         //v 列名の取得.
         for(int i = 1; i <= colNum; i++){//<4
            colNames.addElement(rm.getColumnName(i).toString());
         }//4>
         //v 行の取得.
         tableData = new Vector<Vector<String>>();//<@1>
         while(resSet.next()){//<4._________________________BGN <LOOP.1>
            Vector<String> rowData = new Vector<String>();
            for(int i=1; i <= colNum; i++){//<5
               String str1 = resSet.getObject(i).toString();
               rowData.addElement(str1);
            }//5>
            tableData.addElement(rowData);
         }//4>._____________________________________________END <LOOP.1>
         //v 接続のクローズ.
         resSet.close(); st.close(); cn.close();
      }//3>
      catch(Exception e){//<3
        e.printStackTrace();
      }//3>
   }//2>
   //************************************************************
   public Vector<Vector<String>> getData(){//<2
      return tableData;
   }//2>
   //************************************************************
   /*
     De-meth setTableData().
    */
   void setTableData(Vector<Vector<String>> tableData){
      this.tableData = tableData;
   }
   //************************************************************
   public Vector<String> getColnames(){//<2
      return colNames;
   }//2>
   //************************************************************
   /*
     De-meth setColNames().
    */
   void setColNames(Vector<String> colNames){
      this.colNames = colNames;
   }
   //************************************************************
}//1>
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
