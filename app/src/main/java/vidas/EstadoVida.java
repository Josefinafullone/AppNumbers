package vidas;

import activities.ActivityNivel;

import controladores.ControladorJuego;

public interface EstadoVida {

    void perderVida(ControladorJuego controladorJuego, ActivityNivel activityNivel);

    void continuarJugando(ControladorJuego controladorJuego, ActivityNivel activityNivel);

    int getVidasRestantes();
}
