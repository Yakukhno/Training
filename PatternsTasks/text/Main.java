package ua.training.patterns.text;

public class Main {
    public static void main(String[] args) {
        IPerson writer = new Writer(new Pen(),
                new Poem("Some poem"),
                new Paper());
        writer.doAction();
        writer.doAction();
        writer.doAction();
        writer.doAction();
        writer.doAction();
        writer.doAction();
    }
}

interface IPerson {
    void doAction();
}

class Writer implements IPerson {
    private IPen pen;
    private IText text;
    private IPaper paper;

    public Writer(IPen pen, IText text, IPaper paper) {
        this.pen = pen;
        this.text = text;
        this.paper = paper;
    }

    @Override
    public void doAction() {
        pen.write(text, paper);
    }

    public IPen getPen() {
        return pen;
    }

    public void setPen(IPen pen) {
        this.pen = pen;
    }

    public IText getText() {
        return text;
    }

    public void setText(IText text) {
        this.text = text;
    }

    public IPaper getPaper() {
        return paper;
    }

    public void setPaper(IPaper paper) {
        this.paper = paper;
    }
}

interface IPen {
    void write(IText text, IPaper paper);
}

class Pen implements IPen {
    @Override
    public void write(IText text, IPaper paper) {
        paper.addLine(text);
    }
}

interface IPaper {
    void addLine(IText text);
}

class Paper implements IPaper {
    private String[] lines = new String[5];
    private int currentLine;

    @Override
    public void addLine(IText text) {
        if (currentLine != lines.length) {
            lines[currentLine++] = text.getText();
        } else {
            System.out.println("End of paper");
        }
    }
}

interface IText {
    String getText();
}

class Poem implements IText {
    private String text;

    public Poem(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
