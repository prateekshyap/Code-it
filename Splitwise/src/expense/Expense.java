package expense;

import account.User;

public class Expense {
    int id;
    User payer;
    User[] users;
    int[] split;
    Category category;
    long amount;
    Split splitType;

    public Expense(int id) {
        this.id = id;
    }

    public int getId() { return this.id; }

    public void setUsers(User... user) {
        this.users = new User[user.length];
        this.split = new int[user.length];
        System.arraycopy(user, 0, users, 0, user.length);
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public void setSplitType(Split splitType) {
        this.splitType = splitType;
    }

    public boolean setSplitRatio(int[] splitRatio) {
        int ratioSum = 0;
        for (int r = 0; r < splitRatio.length; ++r) {
            split[r] = splitRatio[r];
            ratioSum += splitRatio[r];
        }
        split[users.length-1] = 100-ratioSum;
        return ratioSum > 0 && ratioSum < 100 - (users.length - 2);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("===Expense Report===\n");
        buffer.append("Total Amount =");
        buffer.append(this.amount);
        buffer.append("\nCategory: ");
        buffer.append(this.category);
        buffer.append("\nPaid by ");
        buffer.append(payer.getName());
        buffer.append("\nTo be split ");
        if (this.splitType == Split.EQUAL)
            buffer.append("equally\n");
        else if (this.splitType == Split.RATIO) {
            buffer.append("in ratio of ");
            for (int i = 0; i < users.length; ++i) {
                buffer.append(split[i]);
                buffer.append("%");
                if (i != users.length-1) buffer.append(", ");
                else buffer.append("\n");
            }
        }
        for (int i = 0; i < users.length; ++i) {
            buffer.append(users[i].getName());
            buffer.append(": ");
            buffer.append(amount*split[i]/100);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
