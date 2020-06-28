package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appjuegosnumeros.AdminSQLiteOpenHelper;
import controladores.ControladorJuego;
import controladores.ControladorDeImagenDeBienvenida;
import com.example.appjuegosnumeros.R;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView im_personaje;
    private TextView tv_mejor_puntaje;

    public ControladorDeImagenDeBienvenida controladorDeImagenDeBienvenida;
    ControladorJuego controladorJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        im_personaje = (ImageView)findViewById(R.id.imageView_Personaje);
        tv_mejor_puntaje = (TextView)findViewById(R.id.tv_mejorpuntaje);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        controladorDeImagenDeBienvenida = new ControladorDeImagenDeBienvenida(this);

        im_personaje.setImageResource(controladorDeImagenDeBienvenida.getImageId());

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD",null,1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        Cursor consulta = BD.rawQuery(
                "select * from puntaje where score = (select max(score) from puntaje)", null);
        if(consulta.moveToFirst()){
            String temp_nombre = consulta.getString(0);
            String temp_score = consulta.getString(1);
            tv_mejor_puntaje.setText("Record: " + temp_score + " de " + temp_nombre);
            BD.close();
        }else{
            BD.close();
        }

    }

    public void Jugar(View view) {

        controladorJuego = new ControladorJuego();
        controladorJuego.jugar(et_nombre, this);

    }

    public void comenzarActivity(String name){

        Intent intent = new Intent(this, ActivityNivel1.class);
        intent.putExtra("jugador", name);
        Bundle bundle =  new Bundle();
        bundle.putSerializable("ControladorJuego", controladorJuego);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){

    }
}
