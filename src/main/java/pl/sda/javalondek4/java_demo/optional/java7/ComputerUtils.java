package pl.sda.javalondek4.java_demo.optional.java7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerUtils {

    private ComputerUtils() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static String getGraphicCardModelFirstNaiveApproach(Computer computer) {
        return computer.getGraphicCard().getModel();
    }

    public static String getGraphicCardModelGoodApproach(Computer computer) {

        String result = null;

        if (computer != null) {
            GraphicCard graphicCard = computer.getGraphicCard();

            if (graphicCard.getModel() != null) {
                result = graphicCard.getModel();
            }
        }
        return result;
    }

    public static String getGCModelJava8(Computer computer) {
        return Optional.ofNullable(computer)
                .map(comp -> comp.getGraphicCard())
                .map(graphicCard -> graphicCard.getModel())
                .orElse("no model");
    }

    public static String getGCModelWithJava8WithVar(Computer computer) {
        /*
        var in JavaScript
        var name = "Mariusz";
        var age = 18;
        name = age;
        age = "Ala"
         */
        var name = "Mariusz"; // String name = "Mariusz";
//        var surname = null; var must have type!!!
        var age = 5;
        var ageL = 5L;
        List<String> stringList = new ArrayList<String>(); // Java 6
        List<String> stringList2 = new ArrayList<>(); // Java 7
        var stringList3 = new ArrayList<>(); // better use that method below:) use new ArrayList<String>()
//        stringList3.get(0);
        var stringList4 = new ArrayList<String>(); // use this
//        String var; // var can be variable name :) var is context keyword!!!
        var var = "name"; // don't do it

        var maybeComputer = Optional.ofNullable(computer);
        var maybeGraphicCard = maybeComputer.map(comp -> comp.getGraphicCard());
        var maybeModel = maybeGraphicCard.map(graphicCard -> graphicCard.getModel());

        var maybeModelOfGC = Optional.ofNullable(computer)
                .map(comp -> comp.getGraphicCard())
                .map(graphicsCard -> graphicsCard.getModel());
        maybeModelOfGC.orElse("no model");
        return maybeModel.orElse("no model");
    }

    public static void main(String[] args) {

        Computer nullComputer = null;
        Computer withoutGraphicCard = new Computer(null);
        Computer withUnknownModel = new Computer(new GraphicCard(null));
        Computer personalComputer = new Computer(new GraphicCard("nVidia"));

        //getGraphicCardModelFirstNaiveApproach(withoutGraphicCard);
        //getGraphicCardModelFirstNaiveApproach(withUnknownModel);
        //getGraphicCardModelFirstNaiveApproach(personalComputer);

        getGraphicCardModelGoodApproach(withoutGraphicCard);
        getGraphicCardModelGoodApproach(withUnknownModel);
        getGraphicCardModelGoodApproach(personalComputer);
    }
}
