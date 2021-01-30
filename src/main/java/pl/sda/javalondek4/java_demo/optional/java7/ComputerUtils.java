package pl.sda.javalondek4.java_demo.optional.java7;

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

    public static String getGCModelJava8(Computer computer){
       return Optional.ofNullable(computer)
                .map(comp -> comp.getGraphicCard())
                .map(graphicCard -> graphicCard.getModel())
                .orElse("no model");
    }

    public static String getGCModelJava8WithVar(Computer computer){


        return "";
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
