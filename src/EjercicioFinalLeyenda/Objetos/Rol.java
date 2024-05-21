package EjercicioFinalLeyenda.Objetos;

import java.io.Serial;
import java.io.Serializable;

public enum Rol implements Serializable {
    NECROFAGO("Hostil, bueno a melé, no se le puede robar, no se puede comerciar con él."),
    AVENTURERO("Amigable, bueno a melé, no se le puede robar, se puede comerciar con él."),
    MAGO("Puede ser amigable o hostil, bueno con los hechizos, se le puede robar, se puede comerciar con él"),
    TECNICO("Puede ser amigable o hostil, bueno con los fusiles, no se le puede robar, se puede comerciar con él"),
    REY("Amigable, bueno con el arco, se le puede robar, no se puede comerciar con él.");
    private String descip;
    @Serial
    private static final long serialVersionUID = -6879910234505033L;
    Rol(String descrip) {
        this.descip = descrip;
    }
    public String getDescip(){
        return descip;
    }
}