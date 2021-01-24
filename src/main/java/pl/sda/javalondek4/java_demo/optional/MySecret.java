package pl.sda.javalondek4.java_demo.optional;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class MySecret<T> {

    private T Secret;

    public MySecret(T secret) {
        Secret = secret;
    }

    public T getSecret() {
        return Secret;
    }

    public void setSecret(T secret) {
        Secret = secret;
    }

    @Override
    public String toString() {
        return "MySecret{" +
                "Secret='" + Secret + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MySecret<String> realOne = new MySecret<>("Secret");
        MySecret<String> withNullContent = new MySecret<>(null);
        printSecretLength(realOne);
        printSecretLength(withNullContent);

        MySecret<Integer> secretNumber = new MySecret<>(6);
        MySecret<Integer> secretNullNumber = new MySecret<>(0);
        var secretNumOne = secretNumber.getSecret();
        var secretNull = secretNullNumber.getSecret();

        Optional<Integer> number = Optional.of(6);
        Optional<Integer> isThereNull = Optional.empty(); //=
        Optional<Integer> isThereNull2 = Optional.ofNullable(null);
    }

    public static void printSecretLength(MySecret<String> mySecret) {
        int secretLen = mySecret.getSecret() != null ? mySecret.getSecret().length() : 0;
        secretLen = nonNull(mySecret.getSecret()) ? mySecret.getSecret().length() : 0;
        System.out.println("My secret has " + secretLen + " characters.");
    }

    public static <T> void processSecret(T optional) {
        Optional<T> opt = Optional.ofNullable(optional);
        int number = 4;
        Optional<Integer> numberInsideOptional = Optional.of(number);

        // T unpacked = opt.get(); -nie można używać gdyż wywali się przy nulu

        T unpacked;
        if (opt.isPresent()) {
            unpacked = opt.get();
        } else {
            unpacked = null;
        }

        unpacked = opt.orElse(null);
        unpacked = (T) opt.or(() -> null);

        Optional<String> string = Optional.empty();
        Optional<String> fromOptional = string.or(() -> Optional.of("no value"));
    }

}
