
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class reader extends Thread {
     String data=LocalDateTime.now().toString();
     String data1=LocalDateTime.now().toString(); 
     
    private final List<String> messages =new ArrayList<>();
    
     int rc=0;
     int wc=0;
    
     
     Semaphore sem =new Semaphore(1);
     Semaphore sem1 =new Semaphore(1);
    
     
     @Override
 public void run(){
     try{
         while(true){
             read();
         }
     }catch(Exception exp){
         
     }
 }




private synchronized void read() throws Exception{
    
 
    sem.acquire();
    
    messages.add(data);
    
    rc++;
    
    
    System.out.println("Reader reading .Total number of reader: " + rc);
    
    Thread.sleep(500);
    
    if(rc==1)
    {
        sem1.acquire();
    }
 
    sem.release();
    
    Thread.sleep(500);
    data=messages.get(0);
    
    sem.acquire();
         
        
    messages.remove(data);
        
    rc--;
    
    System.out.println("Reader Removed.Total number of Writer: " +rc);
            
            
            
    
    if(rc==0)
    {
     System.out.println("All Reader Removed");  
     
        sem1.release();
    }
        
    sem.release();
            
    
} 



public synchronized String write() throws Exception{
    
 
   
  
  sem1.acquire();
  if(wc==0 && rc==0)
  {
   
  messages.add(data1); 
  
  wc++;
  
  System.out.println("Writer arrived");
  
  Thread.sleep(1000);
  
  wc--;
  
  System.out.println("Writer gone");
  
  sem1.release();
  
  
  } 
     
        return data1;
  
}

}
