package pl.sda.javalondek4.java_demo.optional.java7;

public class Computer {

    private GraphicCard graphicCard;

    public Computer(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "graphicCard=" + graphicCard +
                '}';
    }
}
