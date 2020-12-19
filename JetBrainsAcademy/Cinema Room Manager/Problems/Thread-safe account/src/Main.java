class Account {

    private long balance = 0;

    public synchronized boolean withdraw(long amount) {
        if(amount > balance){
            return false;
        } else {
            balance = balance - amount;
            return true;
        }
    }

    public synchronized void deposit(long amount) {
        // do something useful
        balance = balance + amount;
    }

    public long getBalance() {
        return balance;
    }
}