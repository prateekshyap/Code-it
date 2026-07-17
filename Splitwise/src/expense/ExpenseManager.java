package expense;

import account.User;
import account.Group;

public class ExpenseManager {
    int expenseCounter;
    User loggedInUser;

    public ExpenseManager() {
        this.loggedInUser = null;
        this.expenseCounter = 0;
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public boolean addExpense(Category category, long amount, User user, User payer) {
        Expense expense = new Expense(expenseCounter++);
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setUsers(user, loggedInUser);
        expense.setPayer(payer);
        expense.setSplitType(Split.EQUAL);
        boolean isValidSplit = expense.setSplitRatio(new int[]{50});
        if (!isValidSplit) return false;
        loggedInUser.addExpense(expense);
        user.addExpense(expense);
        return true;
    }

    public boolean addExpense(Category category, long amount, User user, User payer, int[] splitRatio) {
        Expense expense = new Expense(expenseCounter++);
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setUsers(user, loggedInUser);
        expense.setPayer(payer);
        expense.setSplitType(Split.RATIO);
        boolean isValidSplit = expense.setSplitRatio(splitRatio);
        if (!isValidSplit) return false;
        loggedInUser.addExpense(expense);
        user.addExpense(expense);
        return true;
    }
}
