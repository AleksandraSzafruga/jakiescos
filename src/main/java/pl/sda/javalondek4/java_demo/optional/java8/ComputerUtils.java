package pl.sda.javalondek4.java_demo.optional.java8;

import java.util.Optional;

public class ComputerUtils {

    private ComputerUtils() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static String getGraphicCardModelGoodApproach(Computer computer) {

        Optional.ofNullable(computer)

                //.map(comp -> comp.getGraphicCard().get()) very dangerous!
                //.map(comp -> comp.getGraphicCard().orElse(null)) can be ok, but
                .flatMap(comp -> comp.getGraphicCard()) //if Optional inside use flatMap
                .flatMap(gc -> gc.getModel())
                .orElse("no model");

        var maybeGraphicCard = Optional.ofNullable(computer)
                .map(comp -> comp.getGraphicCard())
                .orElse(Optional.empty());

        maybeGraphicCard.map(gc -> gc.getModel())
                .orElse(Optional.empty())
                .orElse("no model");

        return null;

    }


    public static void main(String[] args) {

        Computer withoutGraphicCard = new Computer(null);
        Computer withUnknownModel = new Computer(new GraphicCard(null));
        Computer personalComputer = new Computer(new GraphicCard("nVidia"));


        getGraphicCardModelGoodApproach(withoutGraphicCard);
        getGraphicCardModelGoodApproach(withUnknownModel);
        getGraphicCardModelGoodApproach(personalComputer);
    }
}
