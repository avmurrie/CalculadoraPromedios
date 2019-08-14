package fiec.espol.edu.ec.calculadoraespol;

public class Modelo {
    private String headline;
    private String body;

    public Modelo(String headline, String body) {
        this.headline = headline;
        this.body = body;
    }

    public String getHeadline() {
        return headline;
    }

    public String getBody() {
        return body;
    }
}
