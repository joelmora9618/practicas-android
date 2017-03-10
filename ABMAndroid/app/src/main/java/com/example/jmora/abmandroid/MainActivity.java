package com.example.jmora.abmandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmora.abmandroid.SQLite.BdaAyuda;

public class MainActivity extends AppCompatActivity {

    EditText etNumbero;
    Button btnIngresar,
           btnMostrar;
    TextView tvNumero;
    String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumbero = (EditText)findViewById(R.id.etTelefono);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnMostrar = (Button)findViewById(R.id.btnMostrar);
        tvNumero = (TextView)findViewById(R.id.tvNumero);

         numero = etNumbero.getText().toString();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    BdaAyuda ayuda;
                    ayuda = new BdaAyuda(MainActivity.this);
                    ayuda.abrir();
                    long resultado = ayuda.registrar(numero);
                    ayuda.cerrar();
                    if(resultado>0)
                    {
                        Toast toast = Toast.makeText(MainActivity.this,"numero agregado con exito",Toast.LENGTH_SHORT);
                        toast.show();
                    }

                } catch (Exception e) {
                    Toast toast = Toast.makeText(MainActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    BdaAyuda ayuda;
                    ayuda = new BdaAyuda(MainActivity.this);
                    ayuda.abrir();
                    String resultado = ayuda.consultar();
                    ayuda.cerrar();
                    tvNumero.setText(resultado);
                    Toast toast = Toast.makeText(MainActivity.this,"datos".toString(),Toast.LENGTH_SHORT);
                    toast.show();

                } catch (Exception e) {
                    Toast toast = Toast.makeText(MainActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
