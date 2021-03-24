package com.example.combustiveis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtPrecoEtanol = findViewById(R.id.edtPrecoEtanol);
        EditText edtPrecoGasolina = findViewById(R.id.edtPrecoGasolina);
        EditText edtRendimentoComEtanol = findViewById(R.id.edtRendimentoComEtanol);
        EditText edtRendimentoGasolina = findViewById(R.id.edtRendimentoGasolina);
        TextView txtMelhorCombustivel = findViewById(R.id.txtMelhorCombustivel);

        final Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double preco = Double.parseDouble(edtPrecoEtanol.getText().toString()) /
                               Double.parseDouble(edtPrecoGasolina.getText().toString());
                Double rendimento = Double.parseDouble(edtRendimentoComEtanol.getText().toString()) /
                                    Double.parseDouble(edtRendimentoGasolina.getText().toString());
                if (preco <= rendimento) {
                    txtMelhorCombustivel.setText("Melhor abastecer com Álcool!");
                } else {
                    txtMelhorCombustivel.setText("Melhor abastecer com Gasolina!");
                }
            }
        });

        final Button btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                edtPrecoEtanol.setText("");
                edtPrecoGasolina.setText("");
                edtRendimentoComEtanol.setText("");
                edtRendimentoGasolina.setText("");
                txtMelhorCombustivel.setText("");
                edtPrecoEtanol.requestFocus();
            }
        });

        final Button btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}