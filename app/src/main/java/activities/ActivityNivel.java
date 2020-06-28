package activities;

import controladores.ControladorNumerosAleatorios;

public interface ActivityNivel {

    void generateNumbers();
    int getPuntajeMaximo();
    void setScore(int score);
    void setImageVida(int i);
    void iniciarActividadSiguiente();
    void setParameters(int numberOne, int numberTwo);
    int[][] generateRandomNumbers(ControladorNumerosAleatorios controladorNumerosAleatorios);
}
