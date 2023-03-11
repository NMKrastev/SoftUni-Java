import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private Chainblock database;
    Transaction transactionOne;
    Transaction transactionTwo;
    Transaction transactionThree;
    Transaction transactionFour;
    Transaction transactionFive;
    Transaction transactionSix;

    @Before
    public void setUp() {
        this.database = new ChainblockImpl();
        this.transactionOne = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Ivan", "Peter", 100);
        this.transactionTwo = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Ivan", "Peter", 200);
        this.transactionThree = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Peter", "Ivan", 300);
        this.transactionFour = new TransactionImpl(4, TransactionStatus.ABORTED, "Ivan", "Peter", 50);
        this.transactionFive = new TransactionImpl(5, TransactionStatus.FAILED, "Peter", "Ivan", 50);
        this.transactionSix = new TransactionImpl(6, TransactionStatus.FAILED, "Ivan", "Peter", 50);
    }

    @Test
    public void testAddShouldAddCorrectTransaction() {
        assertEquals(0, this.database.getCount());
        this.database.add(this.transactionOne);
        assertEquals(1, this.database.getCount());
        Transaction actualTransaction = this.database.getById(this.transactionOne.getId());
        assertEquals(this.transactionOne.getId(), actualTransaction.getId());
        assertTrue(this.database.contains(this.transactionOne));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfThereIsTransactionWithSameId() {
        assertEquals(0, this.database.getCount());
        this.database.add(this.transactionOne);
        assertEquals(1, this.database.getCount());
        assertTrue(this.database.contains(this.transactionOne.getId()));
        this.database.add(this.transactionOne);
        assertEquals(1, this.database.getCount());
    }

    @Test
    public void testChangeTransactionStatusShouldWork() {
        this.database.add(this.transactionOne);
        this.database.changeTransactionStatus(this.transactionOne.getId(), TransactionStatus.UNAUTHORIZED);
        assertEquals(TransactionStatus.UNAUTHORIZED, this.transactionOne.getStatus());
        Transaction actualTransaction = this.database.getById(this.transactionOne.getId());
        assertEquals(this.transactionOne, actualTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowIfTransactionIdDoesNotExist() {
        this.database.add(transactionOne);
        this.database.changeTransactionStatus(3, TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testRemoveTransactionByIdShouldWork() {
        this.database.add(this.transactionOne);
        this.database.add(this.transactionTwo);
        assertEquals(2, this.database.getCount());
        database.removeTransactionById(this.transactionTwo.getId());
        assertEquals(1, this.database.getCount());
        assertFalse(this.database.contains(transactionTwo));
    }

    @Test
    public void testGetByIdShouldWork() {
        this.database.add(this.transactionOne);
        assertEquals(transactionOne, this.database.getById(this.transactionOne.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowIfTransactionWithIdDoesNotExist() {
        this.database.add(this.transactionOne);
        this.database.getById(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowIfTransactionIdDoesNotExist() {
        this.database.add(this.transactionOne);
        this.database.add(this.transactionTwo);
        assertEquals(2, this.database.getCount());
        database.removeTransactionById(3);
        assertEquals(2, this.database.getCount());
    }

    @Test
    public void testGetByTransactionStatusShouldReturnAllTransactionsWithStatus() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());

        Iterable<Transaction> sortedTransactions = this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        List<Transaction> sortedTransactionsList = new ArrayList<>();
        sortedTransactions.forEach(sortedTransactionsList::add);

        assertEquals(3, sortedTransactionsList.size());
        sortedTransactionsList.forEach(e -> assertEquals(TransactionStatus.SUCCESSFUL, e.getStatus()));

        List<Transaction> expectedOrder = List.of(this.transactionThree, this.transactionTwo, this.transactionOne);
        assertEquals(expectedOrder, sortedTransactionsList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowIfStatusIsInvalid() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());

        Iterable<Transaction> sortedTransactions = this.database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldWork() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());

        Iterable<String> transactionsBySenders = this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> senders = new ArrayList<>();
        transactionsBySenders.forEach(senders::add);
        assertEquals(3, senders.size());

        List<String> expectedOrder = List.of("Peter", "Ivan", "Ivan");

        assertEquals(expectedOrder, senders);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowIfStatusIsInvalid() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());
        Iterable<String> transactionsByStatus = this.database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusShouldWork() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());

        Iterable<String> transactionsByReceivers = this.database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> receivers = new ArrayList<>();
        transactionsByReceivers.forEach(receivers::add);
        assertEquals(3, receivers.size());

        List<String> expectedOrder = List.of("Ivan", "Peter", "Peter");

        assertEquals(expectedOrder, receivers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrowIfStatusIsInvalid() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());
        Iterable<String> transactionsByStatus = this.database.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldWork() {
        addAllTransactionsToDataBase();
        assertEquals(6, this.database.getCount());

        Iterable<Transaction> getAll = this.database.getAllOrderedByAmountDescendingThenById();
        List<Transaction> allTransactionsSorted = new ArrayList<>();
        getAll.forEach(allTransactionsSorted::add);

        List<Transaction> expected = List.of(
                this.transactionFour,
                this.transactionFive,
                this.transactionSix,
                this.transactionOne,
                this.transactionTwo,
                this.transactionThree
        );

        assertEquals(expected, allTransactionsSorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllOrderedByAmountDescendingThenByIdShouldThrowIfThereAreNotTransactions() {
        Iterable<Transaction> getAll = this.database.getAllOrderedByAmountDescendingThenById();
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldWork() {
        addAllTransactionsToDataBase();
        Iterable<Transaction> getAll = this.database.getBySenderOrderedByAmountDescending("Ivan");
        List<Transaction> sorted = new ArrayList<>();
        getAll.forEach(sorted::add);

        List<Transaction> expected = List.of(
                this.transactionTwo,
                this.transactionOne,
                this.transactionFour,
                this.transactionSix
        );

        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowIfThereAreNoSuchTransactionsBySender() {
        Iterable<Transaction> getAll = this.database.getBySenderOrderedByAmountDescending("Alex");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdShouldWork() {
        addAllTransactionsToDataBase();
        Iterable<Transaction> getAll = this.database.getByReceiverOrderedByAmountThenById("Peter");
        List<Transaction> sorted = new ArrayList<>();
        getAll.forEach(sorted::add);

        List<Transaction> expected = List.of(
                this.transactionTwo,
                this.transactionOne,
                this.transactionFour,
                this.transactionSix
        );

        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowIfThereAreNoSuchTransactionsWithReceiver() {
        Iterable<Transaction> getAll = this.database.getByReceiverOrderedByAmountThenById("Alex");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldWork() {
        addAllTransactionsToDataBase();
        Iterable<Transaction> getAll = this.database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 299);
        List<Transaction> sorted = new ArrayList<>();
        getAll.forEach(sorted::add);

        List<Transaction> expected = List.of(
                this.transactionTwo,
                this.transactionOne
        );

        assertEquals(expected, sorted);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyListForAmount() {
        Iterable<Transaction> getAll = this.database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 5);
        List<Transaction> emptyExpected = new ArrayList<>();
        getAll.forEach(emptyExpected::add);
        List<Transaction> expected = new ArrayList<>();

        assertEquals(expected, emptyExpected);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyListForStatus() {
        Iterable<Transaction> getAll = this.database.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 300);
        List<Transaction> actualEmpty = new ArrayList<>();
        getAll.forEach(actualEmpty::add);
        List<Transaction> expectedEmpty = new ArrayList<>();

        assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldWork() {
        addAllTransactionsToDataBase();
        Iterable<Transaction> getAll = this.database.getBySenderAndMinimumAmountDescending("Ivan", 90);
        List<Transaction> sorted = new ArrayList<>();
        getAll.forEach(sorted::add);

        List<Transaction> expected = List.of(
                this.transactionTwo,
                this.transactionOne
        );

        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowIfNoSuchTransactions() {
        Iterable<Transaction> getAll = this.database.getBySenderAndMinimumAmountDescending("Alex", 100);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldWork() {
        addAllTransactionsToDataBase();
        Iterable<Transaction> getAll = this.database.getByReceiverAndAmountRange("Peter", 40, 90);
        List<Transaction> sorted = new ArrayList<>();
        getAll.forEach(sorted::add);

        List<Transaction> expected = List.of(
                this.transactionFour,
                this.transactionSix
        );

        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowIfNoSuchTransaction() {
        Iterable<Transaction> getAll = this.database.getByReceiverAndAmountRange("Alex", 100, 200);
    }

    @Test
    public void testGetAllInAmountRangeShouldWork() {
        addAllTransactionsToDataBase();
        Iterable<Transaction> getAll = this.database.getAllInAmountRange(40, 100);
        List<Transaction> sorted = new ArrayList<>();
        getAll.forEach(sorted::add);

        List<Transaction> expected = List.of(
                this.transactionOne,
                this.transactionFour,
                this.transactionFive,
                this.transactionSix
        );

        assertEquals(expected, sorted);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyListForRange() {
        Iterable<Transaction> getAll = this.database.getAllInAmountRange(400, 500);
        List<Transaction> actualEmpty = new ArrayList<>();
        getAll.forEach(actualEmpty::add);
        List<Transaction> expectedEmpty = new ArrayList<>();

        assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    public void testIteratorShouldWork() {
        addAllTransactionsToDataBase();
        Iterator<Transaction> iter = this.database.iterator();
        assertTrue(iter.hasNext());
    }

    private void addAllTransactionsToDataBase() {
        this.database.add(this.transactionOne);
        this.database.add(this.transactionTwo);
        this.database.add(this.transactionThree);
        this.database.add(this.transactionFour);
        this.database.add(this.transactionFive);
        this.database.add(this.transactionSix);
    }
}