package account;

import java.util.HashMap;

import expense.Expense;

public class User {
    String id, name;
    HashMap<Integer, Expense> expenses;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.expenses = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    public String getName() { return this.name; }

    public void printAllExpenses() {
        System.out.println(expenses);
    }
}
