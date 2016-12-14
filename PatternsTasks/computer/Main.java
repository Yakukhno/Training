package ua.training.patterns.computer;

public class Main {
    public static void main(String[] args) {
        IDevice computer = new Computer();
        computer.turnOn();
    }
}

interface IDevice {
    void turnOn();
    void turnOff();
}

class Computer implements IDevice {
    private IDevice cpu = new CPU();
    private IDevice gpu = new GPU();
    private IDevice hdd = new HDD();

    @Override
    public void turnOn() {
        cpu.turnOn();
        gpu.turnOn();
        hdd.turnOn();
    }

    @Override
    public void turnOff() {
        cpu.turnOff();
        gpu.turnOff();
        hdd.turnOff();
    }
}

class CPU implements IDevice {
    @Override
    public void turnOn() {
        System.out.println("CPU is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("CPU is OFF");
    }
}
class GPU implements IDevice {
    @Override
    public void turnOn() {
        System.out.println("GPU is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("GPU is OFF");
    }
}

class HDD implements IDevice {
    @Override
    public void turnOn() {
        System.out.println("HDD is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("HDD is OFF");
    }
}


