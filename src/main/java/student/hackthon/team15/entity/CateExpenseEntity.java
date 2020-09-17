package student.hackthon.team15.entity;

import java.util.List;

public class CateExpenseEntity {
    private String categoryName;
    private List<ExpensesEntity> expenseItems;
    private double totalValue;

    public CateExpenseEntity(String categoryName, List<ExpensesEntity> expensesItems, double totalValue){
        this.categoryName = categoryName;
        this.expenseItems = expensesItems;
        this.totalValue = totalValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<ExpensesEntity> getExpenseItems() {
        return expenseItems;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setExpenseItems(List<ExpensesEntity> expenseItems) {
        this.expenseItems = expenseItems;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
