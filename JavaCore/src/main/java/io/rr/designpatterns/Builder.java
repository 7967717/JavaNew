package io.rr.designpatterns;

import lombok.ToString;

public class Builder {
    public static void main(String[] args) {
        BankAccount account = new BankAccount
                .Builder(1L)
                .withOwner("John")
                .atBranch("NY")
                .openingBalance(10.00)
                .atRate(1.1)
                .build();
        System.out.println(account);
    }
}

@ToString
class BankAccount {

    public static class Builder {
        private long accountNumber; //This is important, so we'll pass it to the constructor.
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;
        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }
        public Builder withOwner(String owner){
            this.owner = owner;
            return this;  //By returning the builder each time, we can create a fluent interface.
        }
        public Builder atBranch(String branch){
            this.branch = branch;
            return this;
        }
        public Builder openingBalance(double balance){
            this.balance = balance;
            return this;
        }
        public Builder atRate(double interestRate){
            this.interestRate = interestRate;
            return this;
        }
        public BankAccount build(){
            BankAccount account = new BankAccount();
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;
            return account;
        }
    }

    private long accountNumber;
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    private BankAccount() {
    }
    //Getters and setters omitted for brevity.
}


