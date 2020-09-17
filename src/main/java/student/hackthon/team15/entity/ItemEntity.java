package student.hackthon.team15.entity;

public class ItemEntity {
    private String name;
    private double value;
    public ItemEntity(String name, double value){
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}

