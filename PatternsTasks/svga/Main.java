package ua.training.patterns.svga;

public class Main {
    public static void main(String[] args) {
        DVI dvi = new AdapterSVGAToDVI(new ComputerWithSVGA());
        dvi.connectViaDVI();
    }
}

interface DVI {
    void connectViaDVI();
}

interface SVGA {
    void connectViaSVGA();
}

class ComputerWithSVGA implements SVGA {
    @Override
    public void connectViaSVGA() {
        System.out.println("connected via SVGA");
    }
}

class AdapterSVGAToDVI implements DVI {
    private SVGA svga;

    public AdapterSVGAToDVI(SVGA svga) {
        this.svga = svga;
    }

    @Override
    public void connectViaDVI() {
        System.out.println("connected via DVI");
        svga.connectViaSVGA();
    }
}
