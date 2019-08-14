package fiec.espol.edu.ec.calculadoraespol;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Parsing extends AsyncTask<String, Void, Modelo> {
    private InterfaceParsing parserResponseInterface;

    public Parsing(InterfaceParsing parserResponseInterface){
        this.parserResponseInterface = parserResponseInterface;
    }

    @Override
    protected Modelo doInBackground(String... params) {

        String url = params[0];
        Modelo articleModel = null;

        Document doc;



        try {
            doc = Jsoup.connect(url).get();

            Elements estudiantes = doc.select("td >p"); // a with href

            articleModel = new Modelo("Estudiantes destacados de FEC", estudiantes.text());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleModel;
    }

    @Override
    protected void onPostExecute(Modelo articleModel) {
        super.onPostExecute(articleModel);

        parserResponseInterface.onParsingDone(articleModel);
    }

}
