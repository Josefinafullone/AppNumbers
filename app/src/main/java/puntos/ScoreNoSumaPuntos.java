package puntos;

import java.io.Serializable;

public class ScoreNoSumaPuntos implements EstadoScore, Serializable {

    @Override
    public int nuevoPunto() { return 0; }
}
