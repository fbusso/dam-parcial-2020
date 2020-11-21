package com.fbusso.parcialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGuardarEntidad(View view) {
        EditText editTextValorEntidad = findViewById(R.id.main_activity_edit_text);
        ToggleButton tb = findViewById(R.id.main_activity_toggle_button);

        String valorEntidad = editTextValorEntidad.getText().toString();
        if(tb.isChecked()) {
            valorEntidad = valorEntidad.toUpperCase();
        }

        CustomEntity e = new CustomEntity(valorEntidad);


        CustomDbHelper db = new CustomDbHelper(this);
        db.insert(e);
        Toast.makeText(getApplicationContext(),"ENTIDAD GUARDADA", Toast.LENGTH_SHORT).show();
    }

    public void onClickMostrarLista(View view) {
        CustomDbHelper db = new CustomDbHelper(this);
        if(db.getAllCustomEntities().size() != 0) {
            Intent listaEntidadesIntent = new Intent(this, ListViewActivity.class);
            startActivity(listaEntidadesIntent);
        }

        else {
            Toast.makeText(getApplicationContext(),"SE TIENE QUE GUARDAR UNA ENTIDAD PRIMERO", Toast.LENGTH_SHORT).show();
        }

    }
}