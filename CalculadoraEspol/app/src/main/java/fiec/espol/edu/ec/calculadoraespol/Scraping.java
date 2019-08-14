package fiec.espol.edu.ec.calculadoraespol;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Scraping extends AppCompatActivity implements InterfaceParsing {
    private TextView headlineTextView;
    private TextView articleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrapview);

        headlineTextView = findViewById(R.id.txtTitulo);
        articleTextView = findViewById(R.id.txtDatos);

        //Execute AsyncTask for Parsing HTML
        new Parsing(this).execute("https://www.fiec.espol.edu.ec/es/lista-excelencia");
    }

    @Override
    public void onParsingDone(Modelo articleModel) {



        if(articleModel!=null){
            headlineTextView.setText(articleModel.getHeadline());
            articleTextView.setText(articleModel.getBody().toString());
        }
        else{
            Toast.makeText(getApplicationContext(), "ERROR, revise la URL", Toast.LENGTH_SHORT).show();
        }

    }
}
