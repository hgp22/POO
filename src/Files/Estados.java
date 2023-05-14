package Files;
import Model.*;
import java.io.*;

public class Estados {

    public void guardarEstado (String ficheiro, GestorVintage gestor) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(ficheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(gestor);
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
