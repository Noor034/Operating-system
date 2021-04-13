
public class Writer extends Thread {
      private reader reader;
      
       public Writer(reader reader) {
        this.reader = reader;
      
    }

       
       @Override
   public void run(){
       try{
         while(true)
         {
 
             String data1=reader.write();
             
             
         }
       }catch(Exception exp){
           
       }
   }
      
      
    
}
