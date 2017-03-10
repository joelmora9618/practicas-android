package com.example.jmora.abmsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jmora.abmsqlite.DataBase.DBManager;
import com.example.jmora.abmsqlite.Persona.PersonaBaseClass;
import com.example.jmora.abmsqlite.Validator.FieldEmptyValidator;

public class AltaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etNombre,
             etApellido,
             etEdad,
             etDni;
    Button   btnGuardar,
             btnLimpiar;
    int edadAux,
        dniAux;
    DBManager helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);
        etEdad = (EditText)findViewById(R.id.etEdad);
        etDni = (EditText)findViewById(R.id.etDni);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);

        btnGuardar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

        helper = new DBManager(this);
    }

    public Boolean ValidarCampos()
    {
        Boolean estado = true;
        FieldEmptyValidator validatorField = new FieldEmptyValidator();
        validatorField.validarCampo(etNombre,"Error, Ingrese un nombre",estado);
        validatorField.validarCampo(etApellido,"Error, Ingrese un apellido",estado);
        validatorField.validarCampo(etEdad,"Error, Ingrese su edad",estado);
        validatorField.validarCampo(etDni,"Error, Ingrese su DNI",estado);

        return estado;
    }

    @Override
    public void onClick(View v) {
        if(v == btnGuardar)
        {
            if(ValidarCampos())
            {
                try {
                    PersonaBaseClass persona = new PersonaBaseClass();
                    persona.setNombre(etNombre.getText().toString());
                    persona.setApellido(etApellido.getText().toString());
                    edadAux = Integer.parseInt(etEdad.getText().toString());
                    persona.setEdad(edadAux);
                    dniAux = Integer.parseInt(etDni.getText().toString());
                    persona.setDni(dniAux);
                    helper.InsertarEmpleado(persona);
                    Toast toast = Toast.makeText(this,"empleado guardado exitosamente",Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e)
                {
                    Toast toast = Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }else if(v == btnLimpiar)
        {
            etNombre.setText("");
            etApellido.setText("");
            etEdad.setText("");
            etDni.setText("");
        }
    }
}
