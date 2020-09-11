package lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleSpinningLock {
    private AtomicReference<Thread> ref = new AtomicReference<>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        while(!ref.compareAndSet(null, currentThread)){
            System.out.println("waiting..."+ref.get().getId());
        }
        System.out.println("waiting...expect :"+ref.get().getId());
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        if(ref.get() != cur) {
            System.out.println("not equal...ref: "+ref.get().getId()+ ", cur:"+cur.getId());
        }
        ref.set(null);

    }

    static int count  = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        SimpleSpinningLock simpleSpinningLock = new SimpleSpinningLock();
        for (int i = 0 ; i < 100 ; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    simpleSpinningLock.lock();
                    ++count;
                    simpleSpinningLock.unLock();
                    countDownLatch.countDown();
                }
            });

        }
        countDownLatch.await();
        System.out.println(count);
    }
}

