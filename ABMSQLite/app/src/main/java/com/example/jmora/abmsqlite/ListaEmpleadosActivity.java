package com.example.jmora.abmsqlite;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmora.abmsqlite.DataBase.DBManager;
import com.example.jmora.abmsqlite.Persona.ContactoClase;
import com.example.jmora.abmsqlite.Persona.PersonaBaseClass;

import java.util.ArrayList;
import java.util.List;

public class ListaEmpleadosActivity extends AppCompatActivity {

    ListView lvEmpleados;
    ArrayList<PersonaBaseClass> listaEmpleados;
    AdaptadorEmpleados adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        lvEmpleados = (ListView)findViewById(R.id.lvEmpleados);
        DBManager helper = new DBManager(this);
        listaEmpleados = helper.listaEmpleados();

        adaptador = new AdaptadorEmpleados(this,listaEmpleados);
        lvEmpleados.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        lvEmpleados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaEmpleadosActivity.this,BajaActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
                return false;
            }
        });
    }

    public class AdaptadorEmpleados extends ArrayAdapter<PersonaBaseClass>
    {
        public AdaptadorEmpleados(Context context, List<PersonaBaseClass> listaEmpleados) {
            super(context, R.layout.list_item_layout,listaEmpleados);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item_layout,null);

            TextView tvNombre = (TextView)item.findViewById(R.id.tvNombre);
            tvNombre.setText(listaEmpleados.get(position).getNombre());

            TextView tvApellido = (TextView)item.findViewById(R.id.tvApellido);
            tvApellido.setText(listaEmpleados.get(position).getApellido());

            TextView tvEdad = (TextView)item.findViewById(R.id.tvEdad);
            tvEdad.setText(String.valueOf(listaEmpleados.get(position).getEdad()));

            TextView tvDni = (TextView)item.findViewById(R.id.tvDni);
            tvDni.setText(String.valueOf(listaEmpleados.get(position).getDni()));

            return (item);
        }
    }
}
