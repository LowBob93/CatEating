package model;

public class Plate {
    private Eat eat;

    public Plate(Eat eat) {
        this.eat = eat;
    }

    public Eat getEat() {
        return eat;
    }

    public void addEat(Eat eat) {
        this.eat = eat;
        System.out.println("Вы добавили " + eat.getCount());

    }

    public boolean isPlateEmpty() {
        return this.eat.getCount() < 1;
    }
}

