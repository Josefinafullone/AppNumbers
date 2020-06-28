package controladores;

import java.io.Serializable;
import java.util.Random;

import activities.ActivityNivel;
import activities.ActivityNivel1;
import activities.ActivityNivel2;
import activities.ActivityNivel3;
import activities.ActivityNivel4;
import activities.ActivityNivel5;
import activities.ActivityNivel6;
import controladores.ControladorDeSigno;

public class ControladorNumerosAleatorios implements Serializable {

    ControladorDeSigno controladorDeSigno = new ControladorDeSigno();
    String numeros[] = {"cero","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};


    public int[][] generateNumber(ActivityNivel activityNivel){
        return activityNivel.generateRandomNumbers(this);

    }

    public int[][] generateNumber(ActivityNivel1 activityNivel1){
        Random random = new Random();

        int numberOne = random.nextInt(numeros.length);
        int numberTwo = random.nextInt(numeros.length);
        while(numberOne + numberTwo > 10){
            numberTwo = random.nextInt(numeros.length);
        }
        int[][] randNumbers = new int[1][3];
        randNumbers[0][0] = numberOne;
        randNumbers[0][1] = numberTwo;
        randNumbers[0][2] = numberOne + numberTwo;
        return randNumbers;

    }

    public int[][] generateNumber(ActivityNivel2 activityNivel2){
        Random random = new Random();

        int[][] randNumbers = new int[1][3];

        randNumbers[0][0] = random.nextInt(numeros.length);
        randNumbers[0][1] = random.nextInt(numeros.length);
        randNumbers[0][2] = randNumbers[0][0] + randNumbers[0][1];

        return randNumbers;

    }

    public int[][] generateNumber(ActivityNivel3 activityNivel3){
        Random random = new Random();

        int numberOne = random.nextInt(numeros.length);
        int numberTwo = random.nextInt(numeros.length);
        if(numberOne < numberTwo){
            int numberAux = numberOne;
            numberOne = numberTwo;
            numberTwo = numberAux;
        }

        int[][] randNumbers = new int[1][3];
        randNumbers[0][0] = numberOne;
        randNumbers[0][1] = numberTwo;
        randNumbers[0][2] = numberOne - numberTwo;
        return randNumbers;

    }


    public int[][] generateNumber(ActivityNivel4 activityNivel4){
        Random random = new Random();

        int numberOne = random.nextInt(numeros.length);
        int numberTwo = random.nextInt(numeros.length);

        int[][] randNumbers = new int[1][3];

        randNumbers = controladorDeSigno.generarSignoYNumerosPara(activityNivel4, numberOne, numberTwo);

        return randNumbers;

    }

    public int[][] generateNumber(ActivityNivel5 activityNivel5){
        Random random = new Random();

        int[][] randNumbers = new int[1][3];

        randNumbers[0][0] = random.nextInt(numeros.length);
        randNumbers[0][1] = random.nextInt(numeros.length);
        randNumbers[0][2] = randNumbers[0][0] * randNumbers[0][1];

        return randNumbers;

    }

    public int[][] generateNumber(ActivityNivel6 activityNivel6){
        Random random = new Random();

        int numberOne = random.nextInt(numeros.length);
        int numberTwo = random.nextInt(numeros.length);

        int[][] randNumbers = new int[1][3];

        randNumbers = controladorDeSigno.generarSignoYNumerosPara(activityNivel6, numberOne, numberTwo);

        return randNumbers;

    }

}
