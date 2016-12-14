package ua.training.patterns.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

interface IEmployee {
    String getName();
    Date getBirthDate();
    Date getHireDate();
}

abstract class AbstractEmployee implements IEmployee {
    protected String name;
    protected Date birthDate;
    protected Date hireDate;

    public AbstractEmployee(String name, Date birthDate, Date hireDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    abstract IEmployee getEmployeeOnNewPosition(Position position);
}

class Worker extends AbstractEmployee {
    public Worker(String name, Date birthDate, Date hireDate) {
        super(name, birthDate, hireDate);
    }

    @Override
    IEmployee getEmployeeOnNewPosition(Position position) {
        switch (position) {
            case WORKER:
                return this;
            case MANAGER:
                return new Manager(name, birthDate, hireDate);
            case OTHER:
                return new OtherEmployee(name, birthDate, hireDate);
        }
        return this;
    }
}

class Manager extends AbstractEmployee {
    private Set<IEmployee> subordinates = new HashSet<>();

    public Manager(String name, Date birthDate, Date hireDate) {
        super(name, birthDate, hireDate);
    }

    public void addIEmployee(IEmployee employee) {
        subordinates.add(employee);
    }

    public void removeIEmployee(IEmployee employee) {
        subordinates.remove(employee);
    }

    public Set<IEmployee> getSubordinates() {
        return subordinates;
    }

    @Override
    IEmployee getEmployeeOnNewPosition(Position position) {
        switch (position) {
            case WORKER:
                return new Worker(name, birthDate, hireDate);
            case MANAGER:
                return this;
            case OTHER:
                return new OtherEmployee(name, birthDate, hireDate);
        }
        return this;
    }
}

class OtherEmployee extends AbstractEmployee {
    private String description = "";

    public OtherEmployee(String name, Date birthDate, Date hireDate) {
        super(name, birthDate, hireDate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    IEmployee getEmployeeOnNewPosition(Position position) {
        switch (position) {
            case WORKER:
                return new Worker(name, birthDate, hireDate);
            case MANAGER:
                return new Manager(name, birthDate, hireDate);
            case OTHER:
                return this;
        }
        return this;
    }
}

enum Position {WORKER, MANAGER, OTHER}