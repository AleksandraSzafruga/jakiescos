package pl.sda.javalondek4.java_demo.optional.java7;

public class GraphicCard {

    private String model;

    public GraphicCard(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "GraphicCard{" +
                "model='" + model + '\'' +
                '}';
    }
}
