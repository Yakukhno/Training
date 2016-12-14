package ua.training.patterns.watches;

public class Main {
    public static void main(String[] args) {
        IWatch watch = getWatchByType("digital");
        watch.showTime();
        watch = getWatchByType("quartz");
        watch.showTime();
    }

    static IWatch getWatchByType(String type) {
        WatchFactory watchFactory;
        switch (type) {
            case "quartz" :
                watchFactory = new QuartzWatchFactory();
                break;
            case "digital" :
                watchFactory = new DigitalWatchFactory();
                break;
            default :
                throw new RuntimeException("unknown type of watch");
        }
        return watchFactory.createWatch();
    }
}

interface IWatch {
    void showTime();
}

class QuartzWatch implements IWatch {
    @Override
    public void showTime() {
        System.out.println("quartz clock");
    }
}

class DigitalWatch implements IWatch {
    @Override
    public void showTime() {
        System.out.println("digital clock");
    }
}

interface WatchFactory {
    IWatch createWatch();
}

class QuartzWatchFactory implements WatchFactory {
    @Override
    public IWatch createWatch() {
        return new QuartzWatch();
    }
}

class DigitalWatchFactory implements WatchFactory {
    @Override
    public IWatch createWatch() {
        return new DigitalWatch();
    }
}
