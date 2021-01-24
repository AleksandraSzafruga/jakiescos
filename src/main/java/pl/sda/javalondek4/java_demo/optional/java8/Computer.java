package pl.sda.javalondek4.java_demo.optional.java8;

import java.util.Optional;

public class Computer {

    private GraphicCard graphicCard;

    public Computer(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public Optional<GraphicCard> getGraphicCard() {
        return Optional.ofNullable(graphicCard);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "graphicCard=" + graphicCard +
                '}';
    }
}
