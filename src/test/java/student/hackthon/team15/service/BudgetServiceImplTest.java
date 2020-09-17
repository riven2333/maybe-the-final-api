package student.hackthon.team15.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import student.hackthon.team15.dao.AccountEntityDao;
import student.hackthon.team15.dao.BudgetEntityDao;
import student.hackthon.team15.dao.IncomeEntityDao;
import student.hackthon.team15.entity.AccountEntity;
import student.hackthon.team15.entity.BudgetEntity;
import student.hackthon.team15.entity.IncomeEntity;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetServiceImplTest {
    @InjectMocks
    BudgetServiceImpl budgetService;
    @Mock
    BudgetEntityDao budgetEntityDao;

    BudgetEntity budgetEntity = new BudgetEntity("chasia","2020-9-3",98.98);
    List<BudgetEntity> budgetEntities = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        budgetEntities.add(budgetEntity);
    }


    @Test
    public void getAllBudget() {
        Mockito.when(budgetEntityDao.getAllBudget()).thenReturn(budgetEntities);
        assertEquals(budgetEntities,budgetService.getAllBudget());
    }

    @Test
    public void ifContainsBudget() {
        budgetService.ifContainsBudget(budgetEntity);
        verify(budgetEntityDao).ifContainsBudget();

    }

    @Test
    public void modifyBudget() {
        budgetService.modifyBudget(budgetEntity);
        verify(budgetEntityDao).modifyBudgetItem(budgetEntity);
    }

    @Test
    public void addBudget() {
        budgetService.addBudget(budgetEntity);
        verify(budgetEntityDao).addItemToBudget(budgetEntity);
    }

    @Test
    public void deleteBudget() {
        budgetService.deleteBudget(budgetEntity);
        verify(budgetEntityDao).deleteBudgetItem(budgetEntity);
    }
}