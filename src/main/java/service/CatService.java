package service;

import model.Cat;
import model.Eat;


public class CatService {
    private Cat cat;

    public CatService(Cat cat) {
        this.cat = cat;
    }

    public CatService() {

    }

    public int eat(Eat eat) {
        while (cat.getSatiety() <= 10) {
            if (cat.getSatiety() == 10) {
                return cat.getSatiety();
            }
            if (eat.getCount() < 1) {
                return cat.getSatiety();
            }
            cat.setSatiety(cat.getSatiety() + 1);
            eat.decreaseCount();
        }
        return cat.getSatiety();
    }
}

