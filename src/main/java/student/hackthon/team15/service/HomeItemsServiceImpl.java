package student.hackthon.team15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.hackthon.team15.dao.AccountEntityDao;
import student.hackthon.team15.dao.BudgetEntityDao;
import student.hackthon.team15.dao.ExpensesEntityDao;
import student.hackthon.team15.dao.IncomeEntityDao;
import student.hackthon.team15.entity.HomeItems;
import student.hackthon.team15.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeItemsServiceImpl implements HomeItemsService{
    @Autowired
    ExpensesEntityDao expensesEntityDao;
    @Autowired
    IncomeEntityDao incomeEntityDao;
    @Autowired
    BudgetEntityDao budgetEntityDao;
    @Autowired
    AccountEntityDao accountEntityDao;


    @Override
    public List<ItemEntity> getHomeItems() {
        List<ItemEntity> items = new ArrayList<>();
        double expenses, bills, billsUnpaid, incomeValue, budget, accountValue;
        expenses = expensesEntityDao.getTotalAccout();
        bills = expensesEntityDao.getTotalBills();
        billsUnpaid = expensesEntityDao.getTotalBillsUnpaid();
        incomeValue = incomeEntityDao.getTotalIncome();
        budget = budgetEntityDao.getCurrentBudget();
        accountValue = accountEntityDao.getAccountValue();

        ItemEntity expenseItem = new ItemEntity("expenses",expenses);
        ItemEntity billsItem = new ItemEntity("bills",bills);
        ItemEntity unpaidItem = new ItemEntity("billsUnpaid",billsUnpaid);
        ItemEntity incomeItem = new ItemEntity("income",incomeValue);
        ItemEntity budgetItem = new ItemEntity("budget",budget);
        ItemEntity accountItem = new ItemEntity("account",accountValue);
        items.add(expenseItem);
        items.add(billsItem);
        items.add(unpaidItem);
        items.add(incomeItem);
        items.add(budgetItem);
        items.add(accountItem);

//        HomeItems homeItems = new HomeItems(expenses,bills,billsUnpaid,incomeValue,budget,accountValue);
        return items;
    }
}
