import java.util.concurrent.Semaphore;

class ReaderWritersProblem {

    static Semaphore rl = new Semaphore(1);
    static Semaphore wl = new Semaphore(1);
    static int readercount = 0;
    static int reader[] = {1,5,6,7};
    static int i = 0;
    
    static class Read implements Runnable {
        @Override
        public void run() {
               
            try {
                rl.acquire();
                readercount++;
                if (readercount==1) {
                    wl.acquire();
                }
               System.out.println("Thread "+Thread.currentThread().getName() + " is READING: " + reader[i++]);
                rl.release();

                Thread.sleep(4000);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");

                rl.acquire();
                readercount--;
                if(readercount==0) {
                    wl.release();
                }
               rl.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            }
        
    }
static class Write implements Runnable {
        @Override
        public void run() {
         
               
            try {
                wl.acquire();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
                wl.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            }
        
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Inputs are : ");
        
        for (int element:reader)
        {
            System.out.println(element);
        }
        Read read=new Read();
        Write write=new Write();
        Thread t1=new Thread(write);
        t1.setName("thread1");
        Thread t2=new Thread(read);
        t2.setName("thread2");
        Thread t3=new Thread(write);
        t3.setName("thread3");
        Thread t4=new Thread(read);
        t4.setName("thread4");
        Thread t5=new Thread(read);
        t5.setName("thread5");
        Thread t6=new Thread(write);
        t6.setName("thread6");
        Thread t7=new Thread(read);
        t7.setName("thread7");
        
        
        t1.start();
        t3.start();
        t2.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        
    }
}