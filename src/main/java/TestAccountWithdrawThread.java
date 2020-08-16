import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAccountWithdrawThread {

    public static void main(String[] args) {
        Account account = new Account();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new WithdrawTask(account));
        executor.execute(new CreditTask(account));
        executor.shutdown();
    }
}

      class Account {
        private int balance = 100;
        private Lock lock = new ReentrantLock(true);
        private Condition withdrawCondition = lock.newCondition();


        public int withDraw(int amount) {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("insufficient balance!!");
                    withdrawCondition.await();

                }
                    System.out.println("sufficient balance!!");
                    balance -= amount;
                    System.out.println("balance after debit" + balance);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return balance;
        }

        public int creditAmount(int amount) {
            lock.lock();
            try {
                System.out.println("inside credit!!");

                balance += amount;
                System.out.println("balance after credit" + balance);
                withdrawCondition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return balance;
        }
    }

      class WithdrawTask implements Runnable {
        private  Account account;
        public  WithdrawTask(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.withDraw(200);
        }
    }

      class CreditTask implements Runnable {
        private  Account account;
        public  CreditTask(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.creditAmount(200);
        }
    }




