
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class producer extends Thread{
    private static final int MAX_SIZE=10 ;
    
    int p=0;
    
    private final List<String> messages =new ArrayList<>();
    Semaphore sem =new Semaphore(1);
    
 @Override
 public void run(){
     try{
         while(true){
             produce();
         }
     }catch(Exception exp){
         
     }
 }
private synchronized void produce() throws Exception{
    while(messages.size()==MAX_SIZE){
        System.out.println("Queue limit Reached.Waiting for consumer");
        wait();
        //System.out.println("Producer got notification from the consumer");
    }
     String data=LocalDateTime.now().toString();
    
    sem.acquire();
 
     messages.add(data);
    
     
     p++;
     
     System.out.println("Producere Produced data  " + "Value of count after production: " +p);
     
  
     
     sem.release();
     notify();
     
}
public synchronized String consume() throws Exception{
    
        notify();
        while(messages.isEmpty())
        {
            wait();
        }
        String data=messages.get(0);
        
         sem.acquire();
         
        
        messages.remove(data);
        
       
        p--;
        
        
        
        sem.release();
        
        System.out.println("Value of count will decrease for consumption : " +p);
        
        
        return data;
        
    }
}

