import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.transactionMap.size();
    }

    @Override
    public void add(Transaction transaction) {

        if (contains(transaction.getId())) {
            throw new IllegalArgumentException("Transaction with same ID already exist!");
        }

        this.transactionMap.put(transaction.getId(), transaction);

    }

    @Override
    public boolean contains(Transaction transaction) {
        return transactionMap.containsValue(transaction);
    }

    @Override
    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {

        if (!contains(id)) {
            throw new IllegalArgumentException(String.format("Transaction with ID: %d does not exist!", id));
        }

        Transaction transaction = getById(id);
        transaction.setStatus(newStatus);

    }

    @Override
    public void removeTransactionById(int id) {

        if (!contains(id)) {
            throw new IllegalArgumentException(String.format("Transaction with ID: %d does not exist!", id));
        }

        transactionMap.remove(id);

    }

    @Override
    public Transaction getById(int id) {

        if (!contains(id)) {
            throw new IllegalArgumentException(String.format("Transaction with ID: %d does not exist!", id));
        }

        return this.transactionMap.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {

        List<Transaction> sortedTransactions = getSortedTransactionsByStatus(status);


        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("Invalid status!");
        }

        return sortedTransactions;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {

        List<Transaction> sortedTransactions = getSortedTransactionsByStatus(status);

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("Invalid status!");
        }

        return sortedTransactions.stream()
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {

        List<Transaction> sortedTransactions = getSortedTransactionsByStatus(status);

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("Invalid status!");
        }

        return sortedTransactions.stream()
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {

        List<Transaction> sortedTransactions = transactionMap.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("TODO");
        }
        return sortedTransactions;
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        List<Transaction> sortedTransactions = transactionMap.values()
                .stream()
                .filter(e -> e.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("TODO");
        }

        return sortedTransactions;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {

        List<Transaction> sortedTransactions = transactionMap.values()
                .stream()
                .filter(e -> e.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("TODO");
        }

        return sortedTransactions;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {

        return transactionMap.values()
                .stream()
                .filter(e -> e.getStatus().equals(status) && e.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {

        List<Transaction> sortedTransactions = transactionMap.values()
                .stream()
                .filter(e -> e.getFrom().equals(sender) && e.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("TODO");
        }

        return sortedTransactions;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {

        List<Transaction> sortedTransactions = transactionMap.values()
                .stream()
                .filter(e -> e.getTo().equals(receiver) && e.getAmount() >= lo && e.getAmount() < hi)
                .collect(Collectors.toList());

        if (sortedTransactions.isEmpty()) {
            throw new IllegalArgumentException("TODO");
        }

        return sortedTransactions;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {

        return transactionMap.values()
                .stream()
                .filter(e -> e.getAmount() >= lo && e.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Transaction> iterator() {
        return transactionMap.values().iterator();
    }

    private List<Transaction> getSortedTransactionsByStatus(TransactionStatus status) {
        return transactionMap.values()
                .stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }
}
