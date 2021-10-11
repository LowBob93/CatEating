import model.Cat;
import model.Eat;
import model.Plate;
import service.CatService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        feedTheCats();
    }

    public static void feedTheCats() {
        Cat[] cat = new Cat[7];
        cat[0] = new Cat("Локи", 4);
        cat[1] = new Cat("Коди", 0);
        cat[2] = new Cat("Микс", 3);
        cat[3] = new Cat("Флаг", 2);
        cat[4] = new Cat("Люфт", 5);
        cat[5] = new Cat("Баки", 7);
        cat[6] = new Cat("Боря", 3);
        Plate plate = new Plate(new Eat("\"Молоко\"", 35));
        for (int i = 0; i < cat.length; i++) {
            System.out.println("______________");
            System.out.println("Кошка " + cat[i].getName() + "  сыта на " + cat[i].getSatiety() + " из 10");
            System.out.println("Для насышения нужно съесть " + (10 - cat[i].getSatiety()) + " едениц пищи " + plate.getEat().getName());
            CatService catService = new CatService(cat[i]);
            if (catService.eat(plate.getEat()) > 1) {
                if (!cat[i].isCatFull(catService.eat(plate.getEat()))) {
                    System.out.println("Кошке " + cat[i].getName() + " не хватило еды");
                    System.out.println(cat[i].isCatFull(catService.eat(plate.getEat())));
                    plate.addEat(new Eat("\"Сухой корм\"", 5));
                    catService.eat(plate.getEat());
                }

            } else {
                System.out.println("Кошка " + cat[i].getName() + " съела нужное количество еды");
                System.out.println(cat[i].isCatFull(catService.eat(plate.getEat())));
            }


            catService.eat(plate.getEat());
            System.out.println("Оставщееся количество еды " + plate.getEat().getName() + " в тарелке равно " + plate.getEat().getCount());
            System.out.println(cat[i].isCatFull(catService.eat(plate.getEat())));
        }


    }

}
