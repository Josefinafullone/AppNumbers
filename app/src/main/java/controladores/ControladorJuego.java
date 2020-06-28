package controladores;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;


import java.io.Serializable;

import activities.ActivityNivel;
import activities.MainActivity;
import puntos.Score;
import vidas.EstadoTresVidas;
import vidas.EstadoVida;

public class ControladorJuego implements Serializable {

    protected ControladorNumerosAleatorios controladorNumerosAleatorios = new ControladorNumerosAleatorios();
    protected EstadoVida estadoVida;
    protected Score score;
    private int resultado = 0;
    String jugador;

    public ControladorJuego(){
        this.estadoVida = new EstadoTresVidas();
        this.score = new Score();
    }

    public void jugar(EditText et_nombre, MainActivity mainActivity) {

        String name = et_nombre.getText().toString();
        if(!name.equals("")){
            score.setJugadorName(name);
            mainActivity.comenzarActivity(name);
        }else{
            Toast.makeText(mainActivity, "Ingrese el nombre del jugador para jugar", Toast.LENGTH_SHORT).show();
            et_nombre.requestFocus();
            InputMethodManager imm = (InputMethodManager) mainActivity.getSystemService(mainActivity.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_nombre, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public void generateNumbers(ActivityNivel activityNivel) {

        int[][] randNumbs = controladorNumerosAleatorios.generateNumber(activityNivel);

        int numberOne = randNumbs[0][0];
        int numberTwo = randNumbs[0][1];

        this.resultado = randNumbs[0][2];

        activityNivel.setParameters(numberOne, numberTwo);
    }

    public void comparar(String respuesta, ActivityNivel activityNivel) {
        if(!respuesta.equals("")) {
            int respuesta_jugador = Integer.parseInt(respuesta);
            if (respuesta_jugador == resultado) {
                score.nuevoPunto(activityNivel);
            } else {
                estadoVida.perderVida(this, activityNivel);
                estadoVida.continuarJugando(this, activityNivel);
            }
        }
    }

    public void setVida(EstadoVida estadoVida) {
        this.estadoVida = estadoVida;
    }

    public void setNombreJugador(String jugador) { this.jugador = jugador;}

    public String getNombreJugador() { return jugador; }

    public int getScore() {
        System.out.println("Dentro de controlador" + score.getScore());
        return score.getScore();}

    public int getVidasRestantes() { return estadoVida.getVidasRestantes();}

    public int getResultado() { return resultado;}

    public void setPistaActiva() {
        System.out.println("Dentro de controlador set pista activa");
        score.setEstadoNoSumaPuntos();    }

    public void setPistaInactiva() { score.setEstadoSumaPuntos();}

}
