package EjercicioFinalLeyenda.Objetos;

import java.io.Serial;
import java.io.Serializable;

public enum Tipo implements Serializable {

    MELE,
    HECHIZO,
    ARCO,
    FUSIL;
    @Serial
    private static final long serialVersionUID = -6879914884005033L;
}