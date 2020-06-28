package vidas;

import android.content.Context;
import android.widget.Toast;

import activities.ActivityNivel;
import controladores.ControladorJuego;

import java.io.Serializable;

public class EstadoTresVidas implements EstadoVida, Serializable {

    private static int VIDAS = 3;


    @Override
    public void perderVida(ControladorJuego controladorJuego, ActivityNivel activityNivel) {
        Toast.makeText((Context) activityNivel, "Incorrecto. Te quedan dos vidas!", Toast.LENGTH_SHORT).show();
        controladorJuego.setVida(new EstadoDosVidas());
        activityNivel.setImageVida(2);
    }

    @Override
    public void continuarJugando(ControladorJuego controladorJuego, ActivityNivel activityNivel) {
        controladorJuego.generateNumbers(activityNivel);

    }

    @Override
    public int getVidasRestantes() { return VIDAS;  }
}
