package pl.sda.javalondek4.java_demo.optional;

import static java.util.Objects.nonNull;

public class MySecret {

    private String Secret;

    public MySecret(String secret) {
        Secret = secret;
    }

    public String getSecret() {
        return Secret;
    }

    public void setSecret(String secret) {
        Secret = secret;
    }

    @Override
    public String toString() {
        return "MySecret{" +
                "Secret='" + Secret + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MySecret realOne = new MySecret("Secret");
        MySecret withNullContent = new MySecret(null);
        printSecretLength(realOne);
        printSecretLength(withNullContent);
    }

    public static void printSecretLength(MySecret mySecret) {
        int secretLen = mySecret.getSecret() != null ? mySecret.getSecret().length() : 0;
        secretLen = nonNull(mySecret.getSecret()) ? mySecret.getSecret().length() : 0;
        System.out.println("My secret has " + secretLen + " characters.");
    }
}
