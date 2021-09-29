/**
 * autor Carlos Caceres
 * Escrito el dia 22 de Septiembre de 2021
 *
 */
package com.usb.appusb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nomtext;
    private EditText edadtext;
    private RadioButton mascr;
    private RadioButton femr;
    private RadioButton nor;
    private CheckBox clibro;
    private CheckBox cplayer;
    private CheckBox cdiseno;
    private TextView saltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponente();

    }

    public void inicializarComponente(){
        nomtext=findViewById(R.id.nomtext);
        edadtext=findViewById(R.id.edadtext);
        mascr=findViewById(R.id.mascr);
        femr=findViewById(R.id.femr);
        nor=findViewById(R.id.nor);
        clibro=findViewById(R.id.clibro);
        cplayer=findViewById(R.id.cplayer);
        cdiseno=findViewById(R.id.cdiseno);
        saltext=findViewById(R.id.saltext);
    }

   public void mostrar(View view){
        mostrarInformacion();
   }

    public void mostrarInformacion(){
        String nombre,sexo,gusto1,gusto2,gusto3,salida,edad;
        List<String> gustos=getGustos(clibro,cplayer,cdiseno);
        salida="";
        nombre=nomtext.getText().toString();
        edad=edadtext.getText().toString();
        sexo=getSexo(mascr,femr,nor);
        gusto1=gustos.get(0);
        gusto2=gustos.get(1);
        gusto3=gustos.get(2);
        salida="Datos de Información\n"+
                "Nombre:"+nombre+"\n"+
                "Edad:"+edad+"\n"+
                "Sexo "+sexo+"\n"+
                gusto1+"\n"+
                gusto2+"\n"+
                gusto3+"\n";
        saltext.setText(salida);

    }

    public String getSexo(RadioButton mascr,RadioButton femr,RadioButton nor){
        String sexo="";
        if(mascr.isChecked()){
           sexo="Masculino";
        }
        else if(femr.isChecked()){
            sexo="Femenino";
        }
        else if(nor.isChecked()){
            sexo="No Registra Sexo";
        }

        return sexo;
    }

    public List<String> getGustos(CheckBox clibro, CheckBox cplayer, CheckBox cdiseno){
        String gusto1,gusto2,gusto3;
        List<String> gustos=new ArrayList<String>();
        gusto1=(clibro.isChecked()==true)?"Me gusta leer Libro":"No me Gusta Leer Libro";
        gusto2=(cplayer.isChecked()==true)?"Me gusta Jugar Video Juegos":"No me gusta Jugar Video Juegos";
        gusto3=(cdiseno.isChecked()==true)?"Me gusta Diseñar":"No me Gusta Diseñar";
        gustos.add(gusto1);
        gustos.add(gusto2);
        gustos.add(gusto3);

        return gustos;
    }



}