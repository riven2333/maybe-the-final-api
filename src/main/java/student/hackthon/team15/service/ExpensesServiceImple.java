package student.hackthon.team15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.hackthon.team15.dao.AccountEntityDao;
import student.hackthon.team15.dao.CategoriesEntityDao;
import student.hackthon.team15.dao.ExpensesEntityDao;
import student.hackthon.team15.entity.CategoriesEntity;
import student.hackthon.team15.entity.ExpensesEntity;
import student.hackthon.team15.entity.CateExpenseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpensesServiceImple implements ExpensesService{

    @Autowired
    ExpensesEntityDao expensesEntityDao;
    @Autowired
    CategoriesEntityDao categoriesEntityDao;
    @Autowired
    AccountEntityDao accountEntityDao;

    @Override
    public List<CateExpenseEntity> getAllExpenses() {
        List<CateExpenseEntity> cateExpenseEntities = new ArrayList<CateExpenseEntity>();
        List<ExpensesEntity> expensesEntities = expensesEntityDao.getAllExpenses();
        Map<String , List<ExpensesEntity>> map = new HashMap<String, List<ExpensesEntity>>();
        List<CategoriesEntity> categoriesEntities = categoriesEntityDao.getAllCategories();
        for(CategoriesEntity category : categoriesEntities){
            map.put(category.getName(),new ArrayList<ExpensesEntity>());
        }
        for(ExpensesEntity expensesEntity : expensesEntities){
            map.get(expensesEntity.getCategoryName()).add(expensesEntity);
        }
        for(String key: map.keySet()){
            List<ExpensesEntity> entities = map.get(key);
            double totalValue = 0.0;
            for(ExpensesEntity e: entities){
                totalValue += e.getValue();
            }
            CateExpenseEntity cateExpenseEntity = new CateExpenseEntity(key,entities,totalValue);
            cateExpenseEntities.add(cateExpenseEntity);
        }
        return cateExpenseEntities;
    }

    @Override
    public void addItemsToExpenses(ExpensesEntity expensesEntity) {
        expensesEntityDao.addItemToExpenses(expensesEntity);
        double account = accountEntityDao.getAccountValue();
        account -= expensesEntity.getValue();
        accountEntityDao.updateAccount(account);
    }

    @Override
    public void modifyExpenses(ExpensesEntity expensesEntity) {
        String id = expensesEntity.getId();
        double o_expense = expensesEntityDao.getExpense(id);
        double n_expense = expensesEntity.getValue();
        double account = accountEntityDao.getAccountValue();
        account += n_expense;
        account -= o_expense;
        accountEntityDao.updateAccount(account);
        expensesEntityDao.updateItemInExpenses(expensesEntity);
    }
    @Override
    public void deleteExpensebyId(String id){
        expensesEntityDao.deleteItemInExpensesbyId(id);
    }
    @Override
    public void deleteExpense(ExpensesEntity expensesEntity){
        double account = accountEntityDao.getAccountValue();
        account -= expensesEntity.getValue();
        accountEntityDao.updateAccount(account);
        expensesEntityDao.deleteItemInExpenses(expensesEntity);
    }

    @Override
    public void addItemsToCategory(CategoriesEntity categoriesEntity) {
        categoriesEntityDao.addItemToCategories(categoriesEntity);
    }

    @Override
    public List<CategoriesEntity> getAllCategories() {
        return categoriesEntityDao.getAllCategories();
    }

    @Override
    public void modifyItemInCategories(CategoriesEntity categoriesEntity) {
        categoriesEntityDao.updateItemInCategories(categoriesEntity);
    }

    @Override
    public void deleteItemInCategories(CategoriesEntity categoriesEntity) {
        categoriesEntityDao.deleteItemInCategories(categoriesEntity);
    }
    @Override
    public void deleteItemInCategoriesbyId(String id){
        categoriesEntityDao.deleteItemInCategoriesbyId(id);
    }


}
