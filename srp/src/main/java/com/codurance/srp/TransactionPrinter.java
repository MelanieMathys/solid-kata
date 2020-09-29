package com.codurance.srp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class TransactionPrinter {

    private TransactionPrintFormat transactionPrintFormat = new TransactionPrintFormat();

    public void printTransactions(TransactionRepository transactionRepository, Console console) {
        printHeader(console);
        List<Transaction> transactions = transactionRepository.all();
        final AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(line -> printLine(line, console));
    }

    private String statementLine(Transaction transaction, int balance) {
        return transactionPrintFormat.statementLine(transaction, balance);
    }

    private void printLine(String line, Console console) {
        console.printLine(line);
    }

    private void printHeader(Console console) {
        printLine(transactionPrintFormat.getStatementHeader(), console);
    }

    public void setPrinterFormat(TransactionPrintFormat transactionPrintFormat) {
        this.transactionPrintFormat = transactionPrintFormat;
    }

}

