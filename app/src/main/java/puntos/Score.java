package puntos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appjuegosnumeros.AdminSQLiteOpenHelper;

import activities.ActivityNivel;

import java.io.Serializable;

public class Score implements Serializable {
    protected int score;
    protected String jugador;
    EstadoScore estadoScore;

    public Score(){
        this.score = 0;
        this.estadoScore = new ScoreSumaPuntos();
    }

    public void nuevoPunto(ActivityNivel activityNivel) {

        if(score < activityNivel.getPuntajeMaximo()){
            score = score + estadoScore.nuevoPunto();
            BaseDeDatos(activityNivel);
            activityNivel.setScore(score);
            activityNivel.generateNumbers();
        }else{
            score = score + estadoScore.nuevoPunto();
            if(score == activityNivel.getPuntajeMaximo()){
                BaseDeDatos(activityNivel);
                activityNivel.setScore(score);
                activityNivel.generateNumbers();
            } else {
                BaseDeDatos(activityNivel);
                activityNivel.iniciarActividadSiguiente();
            }
        }
    }

    public int getScore() { return score; }

    public void setEstadoNoSumaPuntos() { this.estadoScore = new ScoreNoSumaPuntos();    }

    public void setEstadoSumaPuntos() { this.estadoScore = new ScoreSumaPuntos();    }

    public void BaseDeDatos(ActivityNivel activityNivel){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper((Context) activityNivel,"BD",null,1);
        SQLiteDatabase BD = admin.getWritableDatabase();
        Cursor consulta = BD.rawQuery("select * from puntaje where score = (select max(score) from puntaje)", null);
        if(consulta.moveToFirst()){
            String temp_nombre = consulta.getString(0);
            String temp_score = consulta.getString(1);

            int mejorPuntaje = Integer.parseInt(temp_score);

            if(score > mejorPuntaje){
                ContentValues modificacion = new ContentValues();
                modificacion.put("nombre", jugador);
                modificacion.put("score", score);

                BD.update("puntaje", modificacion,"score=" + mejorPuntaje,null);

            }
            BD.close();
        }else{
            ContentValues insertar = new ContentValues();
            insertar.put("nombre",jugador);
            insertar.put("score",score);

            BD.insert("puntaje",null,insertar);
            BD.close();
        }
    }


    public void setJugadorName(String name) { this.jugador = name;    }
}
