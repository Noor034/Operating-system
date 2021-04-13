
public class ProducerConsumer {
    public static void main(String[]args){
        producer producer=new producer();
        producer.setName("Producer-1");
        producer.start();
        
    
        
        consumer consumer=new consumer(producer);
        consumer.setName("Consumer-1");
        consumer.start();
        
       
        
     
    }
}
