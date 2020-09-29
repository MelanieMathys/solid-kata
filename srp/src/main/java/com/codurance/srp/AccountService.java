package com.codurance.srp;

public class AccountService {

    private final TransactionRepository transactionRepository;
    private final Clock clock;
    private final Console console;
    private final TransactionPrinter transactionPrinter = new TransactionPrinter();

    public AccountService(TransactionRepository transactionRepository, Clock clock, Console console) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.console = console;
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }

    public void printStatement() {
        transactionPrinter.printTransactions(transactionRepository, console);
    }

}
