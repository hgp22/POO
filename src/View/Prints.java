package View;

import java.io.Serializable;
import java.util.List;

public class Prints implements Serializable {

    private void printLine(int size) {
        for(int i = 0; i < size; i++)
            System.out.print("-");

        System.out.println("");
    }


    public void printMenu (String[] entrys, String title, int type)
    {
        int maxSize = title.length()+6, nEntrys = entrys.length;

        for (String entry : entrys)
            if (entry.length() +6 > maxSize) maxSize = entry.length() + 6;

        printLine(maxSize);
        System.out.println(title);
        printLine(maxSize);

        for (int i=1 ; i<nEntrys+1 ; i++)
        {
            System.out.println(" " + i + " ) " + entrys[i-1] + " ");
        }

        if (type==0)
            System.out.println(" 0 ) Sair ");
        else if (type==1)
            System.out.println(" 0 ) Voltar ");
        else if (type==2)
            System.out.println(" 0 ) Criar Novo ");
        printLine(maxSize);
    }

    public void printListO (List<Object> list, String message, int type)
    {
        int maxSize = message.length()+6;


        printLine(maxSize);
        System.out.println(message);
        printLine(maxSize);

        for (Object o : list)
            System.out.println(o.toString());

        if (type==0)
            System.out.println(" 0 ) Sair ");
        else if (type==1)
            System.out.println(" 0 ) Voltar ");
        else if (type==2)
            System.out.println(" 0 ) Criar Novo ");
        printLine(maxSize);
    }

    public void printList (List<String> l, String message, int type)
    {
        int maxSize = message.length()+6, nEntrys = l.size();

        for (String entry : l)
            if (entry.length() +6 > maxSize) maxSize = entry.length() + 6;

        printLine(maxSize);
        System.out.println(message);
        printLine(maxSize);

        for (int i=1 ; i<nEntrys+1 ; i++)
        {
            System.out.println(" " + i + " ) " + l.get(i-1) + " ");
        }

        if (type==0)
            System.out.println(" 0 ) Sair ");
        else if (type==1)
            System.out.println(" 0 ) Voltar ");
        else if (type==2)
            System.out.println(" 0 ) Criar Novo ");
        printLine(maxSize);
    }

    /*
    public void printArray(String message, List<String> arr) {
        System.out.println("\n" + message);

        for(String line : arr)
            System.out.println(line);

        System.out.print("\n");
    }

    public void printTable(String message, List<String> arr) {
        System.out.println("\n" + message);

        for(int i = 0; i < arr.size(); i++)
            System.out.println(String.format("%2d %1s",(i+1), ") ") + arr.get(i));

        System.out.print("\n");
    }
    */

    public void printMessage(String message) {
        System.out.println(message);
    }
}
