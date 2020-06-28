package controladores;

import java.io.Serializable;
import java.util.Random;

import activities.ActivityNivel4;
import activities.ActivityNivel6;

public class ControladorDeSigno implements Serializable {

    public int[][] generarSignoYNumerosPara(ActivityNivel4 activityNivel4, int numberOne, int numberTwo) {
        Random random = new Random();
        int number = random.nextInt(2);
        int resultado = 0;
        int[][] valores = new int[1][3];

        switch (number){
            case 0:
                activityNivel4.setSigno(0);
                resultado = numberOne + numberTwo;
                break;
            case 1:
                activityNivel4.setSigno(1);
                if(numberOne < numberTwo){
                    int numberAux = numberOne;
                    numberOne = numberTwo;
                    numberTwo = numberAux;
                }
                resultado = numberOne - numberTwo;
                break;
        }
        valores[0][0] = numberOne;
        valores[0][1] = numberTwo;
        valores[0][2] = resultado;

        return valores;

    }

    public int[][] generarSignoYNumerosPara(ActivityNivel6 activityNivel6, int numberOne, int numberTwo) {
        Random random = new Random();
        int number = random.nextInt(3);
        int resultado = 0;
        int[][] valores = new int[1][3];

        switch (number){
            case 0:
                activityNivel6.setSigno(0);
                resultado = numberOne + numberTwo;
                break;
            case 1:
                activityNivel6.setSigno(1);
                if(numberOne < numberTwo){
                    int numberAux = numberOne;
                    numberOne = numberTwo;
                    numberTwo = numberAux;
                }
                resultado = numberOne - numberTwo;
                break;
            case 2:
                activityNivel6.setSigno(2);
                resultado = numberOne * numberTwo;
        }
        valores[0][0] = numberOne;
        valores[0][1] = numberTwo;
        valores[0][2] = resultado;

        return valores;

    }
}
