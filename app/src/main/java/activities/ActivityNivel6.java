package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import controladores.ControladorJuego;
import controladores.ControladorNumerosAleatorios;
import com.example.appjuegosnumeros.R;

public class ActivityNivel6 extends AppCompatActivity implements ActivityNivel {

    private TextView tv_nombre, tv_puntaje, tv_respuesta;
    private ImageView iv_valoruno, iv_valordos, iv_vidas, iv_signo;
    private EditText et_respuesta;

    private static int MAX_SCORE = 59;
    private static String[] NUMEROS = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

    String nombre_jugador;

    ControladorJuego controladorJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel6);

        Toast.makeText(this, "Nivel 6 - Sumas, Restas y Multiplicaciones", Toast.LENGTH_SHORT).show();

        tv_nombre = (TextView)findViewById(R.id.tv_nombre);
        tv_puntaje = (TextView)findViewById(R.id.textView_score);
        iv_valoruno = (ImageView)findViewById(R.id.imageView_primervalor);
        iv_valordos = (ImageView)findViewById(R.id.imageView_segundovalor);
        iv_vidas = (ImageView)findViewById(R.id.imageView_vidas);
        iv_signo = (ImageView)findViewById(R.id.imageView_signo);
        et_respuesta = (EditText)findViewById(R.id.editText_respuesta);

        tv_respuesta = (TextView) findViewById(R.id.tv_respuesta);

        controladorJuego = (ControladorJuego) getIntent().getSerializableExtra("ControladorJuego");

        nombre_jugador = controladorJuego.getNombreJugador();
        String nombre = "Jugador: " + nombre_jugador;
        tv_nombre.setText(nombre);

        tv_puntaje.setText("Puntaje: " + controladorJuego.getScore());
        this.setImageVida(controladorJuego.getVidasRestantes());
        tv_respuesta.setText("");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.generateNumbers();
    }

    @Override
    public void generateNumbers() {
        et_respuesta.setText("");
        controladorJuego.generateNumbers(this); }

    @Override
    public int getPuntajeMaximo() { return MAX_SCORE;    }

    @Override
    public void setScore(int score) { tv_puntaje.setText("Puntaje: " + score);    }

    @Override
    public void setImageVida(int i) {
        switch (i){
            case 3:
                iv_vidas.setImageResource(R.drawable.tresvidas);
                break;
            case 2:
                iv_vidas.setImageResource(R.drawable.dosvidas);
                break;
            case 1:
                iv_vidas.setImageResource(R.drawable.unavida);
                break;
        }
    }

    @Override
    public void iniciarActividadSiguiente() {

        Intent intent = new Intent(this, ActivityJuegoGanado.class);
        Bundle bundle =  new Bundle();
        bundle.putSerializable("ControladorJuego", controladorJuego);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }

    @Override
    public void setParameters(int numberOne, int numberTwo) {
        iv_valoruno.setImageResource(getResources().getIdentifier(NUMEROS[numberOne],"drawable", getPackageName()));
        iv_valordos.setImageResource(getResources().getIdentifier(NUMEROS[numberTwo],"drawable", getPackageName()));
    }

    @Override
    public int[][] generateRandomNumbers(ControladorNumerosAleatorios controladorNumerosAleatorios) {
        return controladorNumerosAleatorios.generateNumber(this);
    }

    public void Comparar(View view) {

        String respuesta = et_respuesta.getText().toString();
        controladorJuego.comparar(respuesta,this);
        et_respuesta.setText("");
        tv_respuesta.setText("");
        controladorJuego.setPistaInactiva();

    }

    public void setSigno(int i) {

        switch (i){
            case 0:
                iv_signo.setImageResource(R.drawable.adicion);
                break;
            case 1:
                iv_signo.setImageResource(R.drawable.resta);
                break;
            case 2:
                iv_signo.setImageResource(R.drawable.multiplicacion);
        }
    }

    public void Pista(View view){

        controladorJuego.setPistaActiva();
        tv_respuesta.setText("" + controladorJuego.getResultado());
    }
}
