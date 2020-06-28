package vidas;

import android.content.Context;
import android.widget.Toast;

import activities.ActivityNivel;

import controladores.ControladorJuego;

import java.io.Serializable;

public class EstadoDosVidas implements EstadoVida, Serializable {

    private static int VIDAS = 2;

    @Override
    public void perderVida(ControladorJuego controladorJuego, ActivityNivel activityNivel) {
        Toast.makeText((Context) activityNivel, "Incorrecto. Te queda una vida!", Toast.LENGTH_SHORT).show();
        controladorJuego.setVida(new EstadoUnaVida());
        activityNivel.setImageVida(1);
    }

    @Override
    public void continuarJugando(ControladorJuego controladorJuego, ActivityNivel activityNivel) {
        controladorJuego.generateNumbers(activityNivel);
    }

    @Override
    public int getVidasRestantes() { return VIDAS;    }
}
