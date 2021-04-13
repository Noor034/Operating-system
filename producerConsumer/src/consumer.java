
public class consumer extends Thread {
    
   private producer producer;

    public consumer(producer producer) {
        this.producer = producer;
      
    }
   @Override
   public void run(){
       try{
         while(true)
         {
 
             String data=producer.consume();
           
             
             System.out.println("Consumed by:"+Thread.currentThread().getName());
             
         }
       }catch(Exception exp){
           
       }
   }
}
