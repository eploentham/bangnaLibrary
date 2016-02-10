package bangnaLibrary;

//import com.hospital_os.utility.*;

import com.bangna.usecase.connection.Persistent;


public class Contract extends Persistent {
        public String contract_id="";
        public String description="";
        public String method="";
   
   /**
    * @roseuid 3F658BBB036E
    */
   public Contract() {
    
   }
   public void initial(){
        contract_id="";
        description="";
        String method="";
   }

   public String getCode() {
       return getObjectId();
   }
   
   public String getName() {
       return description;
   }
   public String toString(){
       return description;
   }
   
}
