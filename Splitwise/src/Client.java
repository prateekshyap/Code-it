import account.User;
import account.Group;

import expense.Category;
import expense.ExpenseManager;

public class Client {
    public static void main(String[] args) {
        User user1 = new User("john1", "John K");
        User user2 = new User("john2", "John D");
        User user3 = new User("ayden", "Ayden");
        User user4 = new User("robert", "Robert");
        User user5 = new User("sharon", "Sharon");

        ExpenseManager expenseManager = new ExpenseManager();

        //login with user2
        User loggedInUser = user2;
        expenseManager.setLoggedInUser(loggedInUser);

        int amount = 100;
        Category category = Category.FOOD;
        User targetUser = user5;
        boolean isExpenseAdded = expenseManager.addExpense(category, amount, targetUser, loggedInUser);
        System.out.print(category+" "+amount+" "+targetUser+" "+loggedInUser);
        System.out.println(isExpenseAdded ? "Added" : "Not Added");

        amount = 200;
        targetUser = user1;
        int[] splitRatio = new int[]{30};
        isExpenseAdded = expenseManager.addExpense(category, amount, targetUser, targetUser, splitRatio);
        System.out.print(category+" "+amount+" "+targetUser+" "+loggedInUser);
        System.out.println(isExpenseAdded ? "Added" : "Not Added");

//        loggedInUser.printAllExpenses();
    }
}
