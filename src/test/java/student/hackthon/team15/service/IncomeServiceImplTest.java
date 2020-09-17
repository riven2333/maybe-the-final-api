package student.hackthon.team15.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import student.hackthon.team15.dao.AccountEntityDao;
import student.hackthon.team15.dao.IncomeEntityDao;
import student.hackthon.team15.entity.AccountEntity;
import student.hackthon.team15.entity.IncomeEntity;
import static org.mockito.Mockito.verify;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IncomeServiceImplTest {
    @InjectMocks
    IncomeServiceImpl incomeService;
    @Mock
    IncomeEntityDao incomeEntityDao;
    @Mock
    AccountEntityDao accountEntityDao;

    IncomeEntity income = new IncomeEntity("asdasac","cds",23.98,"dhshsd");
    AccountEntity accountEntity = new AccountEntity("asasd",90.98);
    List<IncomeEntity> incomes = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        incomes.add(income);

    }

    @Test
    public void getIncomesList() {
        Mockito.when(incomeEntityDao.getAllIncome()).thenReturn(incomes);
        assertEquals(incomes,incomeService.getIncomesList());
    }

    @Test
    public void addIncome() {
        incomeService.addIncome(income);
        verify(incomeEntityDao).addItemToIncome(income);
    }

    @Test
    public void deleteIncome() {
        incomeService.deleteIncome(income);
        verify(incomeEntityDao).deleteItemInIncome(income);
    }

    @Test
    public void updateIncome() {
        incomeService.updateIncome(income);
        verify(incomeEntityDao).updateItemInIncome(income);
    }
}