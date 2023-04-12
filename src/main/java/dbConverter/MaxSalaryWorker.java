package dbConverter;

public class MaxSalaryWorker {
    private int id;
    private String name;
    private String birthday;
    private Enum level;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Enum getLevel() {
        return level;
    }

    public void setLevel(String level) {
        switch (level) {
            case "Trainee":
                this.level = Level.Trainee;
                        break;
            case "Junior":
                this.level = Level.Junior;
                break;
            case "Middle":
                this.level = Level.Middle;
                break;
            case "Senior":
                this.level = Level.Senior;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private enum Level {
        Senior,
        Junior,
        Trainee,
        Middle
    }

    @Override
    public String toString(){
        return "MaxSalaryWorker: " + "name - " + name + ", " + "salary - " + salary;
    }

}
