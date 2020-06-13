interface AccountService {
    /**
     * It finds an account by owner id
     *
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);

    /**
     * It count the number of account with balance > the given value
     *
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);

}

class AccountServiceImpl implements AccountService {
    private Account[] accounts;

    public AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts.clone();
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        Account account = null;
        for (Account a : accounts) {
            if (a.getOwner().getId() == id) {
                account = a;
            }
        }
        return account;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        int counter = 0;
        for (Account a : accounts) {
            if (a.getBalance() > value) {
                counter++;
            }
        }
        return counter;
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}