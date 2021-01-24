package pl.sda.javalondek4.java_demo.optional.java8;

import java.util.Optional;

public class GraphicCard {

    private String model;

    public GraphicCard(String model) {
        this.model = model;
    }

    public Optional<String> getModel() {
        return Optional.ofNullable(model);
    }

    @Override
    public String toString() {
        return "GraphicCard{" +
                "model='" + model + '\'' +
                '}';
    }
}
