package fiec.espol.edu.ec.calculadoraespol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etPorTeorico;
    private EditText etNota1P;
    private EditText etNota2P;
    private EditText etNotaMej;
    private EditText etPractico;

    private TextView tvPorPract;
    private TextView tvPromFinal;
    private TextView tvnotaMin;
    private TextView tvEstado;

    private Button btnCalcular;
    private Button btnScraping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcview);

        etPorTeorico= findViewById(R.id.txtPorTeorico);
        etNota1P= findViewById(R.id.txt1P);
        etNota2P= findViewById(R.id.txt2P);
        etNotaMej= findViewById(R.id.txtMejor);
        etPractico= findViewById(R.id.txtPract);

        tvPorPract= findViewById(R.id.txtPorPractico);
        tvPromFinal= findViewById(R.id.txtPromFinal);
        tvnotaMin= findViewById(R.id.txtNotaMin);
        tvEstado= findViewById(R.id.txtEstado);

        btnCalcular=findViewById(R.id.btnResult);
        btnScraping=findViewById(R.id.btnEst);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int porTeorico=Integer.parseInt(etPorTeorico.getText().toString())/100;
                double nota1P=Double.parseDouble(etNota1P.getText().toString());
                double nota2P=Double.parseDouble(etNota2P.getText().toString());
                double notaMej=Double.parseDouble(etNotaMej.getText().toString());
                double pract=Double.parseDouble(etPractico.getText().toString());

                int porPractico=1-porTeorico;

                double minimo=Math.min(nota1P,nota2P);
                minimo=Math.min(minimo,notaMej);

                double maximo=Math.max(nota1P,nota2P);
                maximo=Math.max(maximo,notaMej);

                double promTeorico= (nota1P+nota2P+notaMej-minimo)/2;
                double promFinal=promTeorico*(porTeorico)+pract*porPractico;

                double notaMin=(2*(60-pract*porPractico)/porTeorico)-maximo;

                tvPorPract.setText(String.valueOf(porPractico));

                if (promFinal>=60){
                    tvEstado.setText("AP");
                    tvPromFinal.setText(String.valueOf(promFinal));
                    tvnotaMin.setText("0");
                }
                else{
                    tvEstado.setText("RP");
                    tvPromFinal.setText(String.valueOf(promFinal));
                    tvnotaMin.setText(String.valueOf(notaMin));

                }
            }
        }
        );

        btnScraping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Scraping.class);
                startActivity(intent);
            }
        });

    }


}
