package com.example.jmora.pruebas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNombre,
             etApellido,
             etEdad,
             etDni;
    int edadAux,
        dniAux;
    Button btnIngresar,
           btnBorrar;
    ListView lvLista;
    List<ClsContactoPersona> ListaPersonas;
    ClsContactoPersona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);
        etEdad = (EditText)findViewById(R.id.etEdad);
        etDni = (EditText)findViewById(R.id.etDni);

        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        lvLista = (ListView)findViewById(R.id.lvLista);

        ListaPersonas = new ArrayList<ClsContactoPersona>();
        final AdaptadorTitulares adaptador = new AdaptadorTitulares(this,ListaPersonas);
        lvLista.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNombre.setText("");
                etApellido.setText("");
                etEdad.setText("");
                etDni.setText("");
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    persona = new ClsContactoPersona();
                    if(etNombre.getText().toString() != "")
                    {
                        persona.setNombre(etNombre.getText().toString());
                    }
                    if(etApellido.getText().toString()!= "")
                    {
                        persona.setApellido(etApellido.getText().toString());
                    }
                    if(etEdad.getText().toString()!="")
                    {
                        edadAux = Integer.parseInt(etEdad.getText().toString());
                        persona.setEdad(edadAux);
                    }
                    if (etDni.getText().toString()!="")
                    {
                        dniAux = Integer.parseInt(etDni.getText().toString());
                        persona.setDni(dniAux);
                    }
                    ListaPersonas.add(persona);
                    adaptador.notifyDataSetChanged();
                    Toast toast = Toast.makeText(MainActivity.this,"Usuario agregado con exito",Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch (Exception e)
                {
                    Toast toast = Toast.makeText(MainActivity.this,e.getMessage().toString(),Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("person",ListaPersonas.get(position));
                intent.putExtra("position",position);
                startActivity(intent);
                return false;
            }
        });
    }

    class AdaptadorTitulares extends ArrayAdapter<ClsContactoPersona>
    {
        public AdaptadorTitulares(Context context, List<ClsContactoPersona>personas) {
            super(context, R.layout.item_layout,personas);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_layout,null);

            TextView tvNombre = (TextView) item.findViewById(R.id.tvNombre);
            tvNombre.setText(ListaPersonas.get(position).getNombre());

            TextView tvApellido = (TextView)item.findViewById(R.id.tvApellido);
            tvApellido.setText(ListaPersonas.get(position).getApellido());

            TextView tvEdad = (TextView) item.findViewById(R.id.tvEdad);
            tvEdad.setText(String.valueOf(ListaPersonas.get(position).getEdad()));

            TextView tvDni = (TextView)item.findViewById(R.id.tvDni);
            tvDni.setText(String.valueOf(ListaPersonas.get(position).getDni()));
            return (item);
        }
    }
}


