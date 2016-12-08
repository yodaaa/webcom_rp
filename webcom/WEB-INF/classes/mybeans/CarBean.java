// File : mybeans/CarBean.java
package mybeans; // Package declaration.
import java.io.*;
public class CarBean implements Serializable{
   private String carname;
   private String cardata;
   public CarBean( ){ // Constructor with no args.
      carname = null;
      cardata = null;
   }
   public void setCarname(String cn){
      if(cn != null){
         carname = cn;
	  }
   }
   public String getCardata( ){
      return cardata;
   }
   public void makeCardata( ){
      cardata = "車種: " + carname;
   }
}
