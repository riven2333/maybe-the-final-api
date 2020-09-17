package student.hackthon.team15.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection="budget")
public class BudgetEntity {
    @Id
    private String id;
    private String dateByMonth;
    private double value;
    BudgetEntity(){}

    public BudgetEntity(String id, String dateByMonth, double value) {
        this.id = id;
        this.dateByMonth = dateByMonth;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateByMonth() {
        return dateByMonth;
    }

    public void setDateByMonth(String dateByMonth) {
        this.dateByMonth = dateByMonth;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
