package UF4.model;

import java.sql.SQLException;

public interface ProducteInterficie {
    void afegirProducteBD() throws SQLException;

    void borrarProducte() throws SQLException;

    void mostrarProducteBD() throws SQLException;
}
