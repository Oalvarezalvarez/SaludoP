package com.example.oalvarezalvarez.saludop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.CompoundButton;


public class MainActivity extends Activity
{
    EditText texto;
    TextView n2;
    Button botonSaludo;
    RadioButton sr,sra;
    RadioGroup grupo;
    CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto =(EditText) findViewById(R.id.entrada);
        n2 =(TextView) findViewById(R.id.saludo);
        botonSaludo=(Button) findViewById(R.id.b_saludo);
        sr=(RadioButton)findViewById(R.id.radiosr);
        sra=(RadioButton)findViewById(R.id.radiosra);
        grupo=(RadioGroup)findViewById(R.id.radioGrupo);
        box=(CheckBox)findViewById(R.id.checkBox);

        String salutation="adios";
        final Intent intento=new Intent(MainActivity.this,MainActivity2.class);
        intento.putExtra("saludo",salutation);

        Bundle recipiente=new Bundle();
        recipiente.putInt("edad",35);
        recipiente.putString("nombre","damian");
        intento.putExtras(recipiente);

        Clase persona1=new Clase("Oscar",19);
        intento.putExtra("id1",persona1);

        botonSaludo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if ("".equals(texto.getText().toString().trim()))
                {

                    showToast("Algo");
                    return;
                }
                String salutation = null;
                String enteredName = texto.getText().toString();

                if (R.id.radiosr == grupo.getCheckedRadioButtonId())
                {
                    salutation = getResources().getString(R.string.radiosr).toLowerCase();
                } else
                {
                    salutation = getResources().getString(R.string.radiosra).toLowerCase();
                }
                salutation = getResources().getString(R.string.b_saludo) + " " + salutation + " " + enteredName;

                if (box.isChecked())
                {
                    DatePicker date = (DatePicker) findViewById(R.id.datePicker);
                    String dateToShow = date.getDayOfMonth() + "/" + (date.getMonth() + 1) + "/" + date.getYear();
                    TimePicker time = (TimePicker) findViewById(R.id.timePicker);
                    dateToShow += " " + time.getCurrentHour() + ":" + time.getCurrentMinute();

                }
                startActivityForResult(intento,1);

            }
        });

        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int visibility = isChecked ? View.VISIBLE : View.GONE;
                View view = findViewById(R.id.timePicker);
                view.setVisibility(visibility);
                view = findViewById(R.id.datePicker);
                view.setVisibility(visibility);
            }
        });

    }
    public void showToast(String mensaje)
    {
        Context contexto=getApplicationContext();
        int duracion= Toast.LENGTH_SHORT;
        Toast tostada=Toast.makeText(contexto,mensaje,duracion);
        tostada.show();

    }


    public void onActivityResult(int reqC,int resC,Intent data)
    {
        if (reqC==1)
        {

        }
        if (resC==RESULT_OK)
        {

        }

        String MiRespuesta=data.getExtras().getString("id1");
        showToast(MiRespuesta);

    }




}
