package model;

public class CherryTree implements FruitTree {
    private final int age;

    public CherryTree(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getType() {
        return "Cherry";
    }

    @Override
    public boolean isOlderThan(int years) {
        return age > years;
    }

    @Override
    public String toString() {
        return "CherryTree{age=" + age + "}";
    }
}
