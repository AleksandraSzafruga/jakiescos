package pl.sda.javalondek4.java_demo.optional.java8;

public class ComputerUtils {

    private ComputerUtils() {
        throw new UnsupportedOperationException("This class shouldn't be instantiated");
    }

    public static String getGraphicCardModelGoodApproach(Computer computer) {

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
