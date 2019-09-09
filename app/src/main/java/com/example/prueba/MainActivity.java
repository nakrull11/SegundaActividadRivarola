package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText dolar;
    EditText euro;
    String resultado;
    Button btnConvertir;
    RadioButton dolarRadio;
    RadioButton euroRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativo);
        dolar = findViewById(R.id.etDolares);
        euro = findViewById(R.id.etEuros);
        dolarRadio = findViewById(R.id.rbDolar);
        euroRadio = findViewById(R.id.rbEuro);
        resultado = (findViewById(R.id.etConvertido)).toString();
        btnConvertir = findViewById(R.id.botonConvertir);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dolar != null){
                  String cantidad = dolar.toString();
                  double numero = Double.parseDouble(cantidad);
                  resultado = String.valueOf(numero * 0.91);
                }
            }
        });

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (euroRadio.isChecked()){
            euro.setEnabled(false);
            dolar.setEnabled(true);
        }else if (dolarRadio.isChecked()){
            dolar.setEnabled(false);
            euro.setEnabled(true);
        }
    }

    
}
