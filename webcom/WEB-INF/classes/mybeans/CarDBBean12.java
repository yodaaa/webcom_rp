/*
############################################################
File: "CarDBBean12.java".
On nepi15 : (*home-common="d:/home2/"):
(concat "c:/apache/tomcat7_42/webapps/MyServlets/WEB-INF/classes/mybeans/"
  "CarDBBean12.java")
By Horita.
On (2013 Nov 29).
############################################################
GENEALOGY:

<-File: "CarDBBean12.java".
On nepi15 : (*home-common="h:/home2/"):
(concat "c:/apache/tomcat6_32/webapps/MyServlets/WEB-INF/classes/mybeanss/"
  "CarDBBean12.java")
By Horita.
On (2011 Dec 15).

<-File: "CarDBBean11.java".
On nepi15 : (*home-common="h:/home2/"):
(concat "c:/apache/tomcat6_32/webapps/MyServlets/WEB-INF/classes/mybeans/"
  "CarDBBean11.java")
By Horita.
On (2011 Dec 15).
-- @(2011 Dec 15 + 12:54:04), on "nepi15".

<-File: "CarDBBean10.java".
On nepi15 : (*home-common="h:/home2/"):
(concat "c:/apache/tomcat6_32/webapps/MyServlets/WEB-INF/classes/mybeans/"
  "CarDBBean10.java")
By Horita.
On (2011 Dec 11).
-- @(2011 Dec 15 + 11:50:21), on "nepi15".
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
  De-class CarDBBean12.
*/
public class CarDBBean12 extends CarDBBean10 implements Serializable{//<1
   //************************************************************
   /*
     De-cstr CarDBBean12().
   */
   public CarDBBean12(
                      String password,
                      String database,
                      int code,
                      String qry
                     ){//<2
      try{//<3
         //v Preparing a connection.
         String drv = "com.mysql.jdbc.Driver";
         String url = "jdbc:mysql:///" + database;
         String usr = "root";
         //v  Connecting to the database.
         Class.forName(drv);
         Connection cn =
           DriverManager.getConnection(url, usr, password);
         //v Preparing a query.
         Statement st = cn.createStatement();
         System.out.println("--`CarDBBean12()'#3:qry = "+ qry);
         if(code == 1){//<4
            //v Executing query.
            ResultSet resSet = st.executeQuery(qry);
            //v Getting the count of columns.
            ResultSetMetaData rm = resSet.getMetaData();
            int colNum = rm.getColumnCount();
            setColNames(new Vector<String>(colNum));//<@1>
            //v Getting the column names.
            for(int i = 1; i <= colNum; i++){//<4
               getColnames().addElement(rm.getColumnName(i).toString());//<@1>
            }//4>
            //v Getting records.
            setTableData(new Vector<Vector<String>>());//<@1>
            while(resSet.next()){//<5.________________________________BGN <LOOP.1>
               Vector<String> rowData = new Vector<String>();
               for(int i=1; i <= colNum; i++){//<6.___________________BGN <LOOP.2>
                   String str1 = resSet.getObject(i).toString();
                   rowData.addElement(str1);
               }//6>._________________________________________________END <LOOP.2>
               getData().addElement(rowData);
            }//5>.____________________________________________________END <LOOP.1>
            //v Closing the connection etc.
            resSet.close(); st.close(); cn.close();
         }//4>
         else if(code == 2){//<4
           st.executeUpdate(qry);
           st.close(); cn.close();
         }//4>
      }//3>
      catch(Exception e){//<3
        e.printStackTrace();
      }//3>
   }//2>
   //************************************************************
}//1>
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
