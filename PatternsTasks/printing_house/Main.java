package ua.training.patterns.printing_house;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrintingHouse printingHouse = new PrintingHouse();

        printingHouse.addSubscriber(new Citizen(Area.CITY));
        printingHouse.addSubscriber(new Citizen(Area.CITY));
        printingHouse.addSubscriber(new Citizen(Area.VILLAGE));
        printingHouse.addSubscriber(new Citizen(Area.CITY));
        printingHouse.addSubscriber(new Citizen(Area.VILLAGE));

        printingHouse.publishNewspaperForVillagers();
    }
}

interface Observable {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}

class PrintingHouse implements Observable {

    private List<Subscriber> subscribers = new ArrayList<>();

    public void publishNewspaper() {
        notifySubscribers();
    }

    public void publishNewspaperForVillagers() {
        notifySubscribersInVillage();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(Subscriber::handleNotification);
    }

    public void notifySubscribersInVillage() {
        subscribers.stream()
                .filter(subscriber -> subscriber.getArea().equals(Area.VILLAGE))
                .forEach(Subscriber::handleNotification);
    }
}

interface Subscriber {
    void handleNotification();
    Area getArea();
}

class Citizen implements Subscriber {

    private Area area;

    public Citizen(Area area) {
        this.area = area;
    }

    @Override
    public void handleNotification() {
        System.out.println(area + " citizen got a newspaper.");
    }

    @Override
    public Area getArea() {
        return area;
    }
}

enum Area {CITY, VILLAGE}
