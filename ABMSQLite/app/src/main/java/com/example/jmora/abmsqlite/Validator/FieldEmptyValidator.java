package com.example.jmora.abmsqlite.Validator;

import android.widget.EditText;

/**
 * Created by JMora on 02/01/2017.
 */

public class FieldEmptyValidator {


    public Boolean validarCampo(EditText field,String errorMenssage,Boolean estado)
    {
        estado = true;
        if(field.getText().toString() == "")
        {
            field.setError(errorMenssage);
            estado = false;
        }
        return estado;
    }

}
