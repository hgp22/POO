package Files;

import java.io.*;
import Model.*;


public class Estado implements Serializable {
    public void guardarEstado (String ficheiro) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(ficheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public static GestorVintage carregarEstado (String ficheiro) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ficheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestorVintage c = (GestorVintage) ois.readObject();
        ois.close();
        return c;
    }
}
