package vidas;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import activities.ActivityNivel;
import controladores.ControladorJuego;
import activities.MainActivity;

import java.io.Serializable;

public class EstadoUnaVida implements EstadoVida, Serializable {

    private static int VIDAS = 2;

    @Override
    public void perderVida(ControladorJuego controladorJuego, ActivityNivel activityNivel) {
        Toast.makeText((Context) activityNivel, "Te quedaste sin vidas!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent((Context) activityNivel, MainActivity.class);
        ((Context) activityNivel).startActivity(intent);
        ((AppCompatActivity) activityNivel).finish();

    }

    @Override
    public void continuarJugando(ControladorJuego controladorJuego, ActivityNivel activityNivel) {

    }

    @Override
    public int getVidasRestantes() { return VIDAS;    }
}
