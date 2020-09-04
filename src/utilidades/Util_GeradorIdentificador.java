
package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util_GeradorIdentificador {
    private int id = 0;
    String nomeDoArquivo = "IdGerado.txt";
    
    public Util_GeradorIdentificador()throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        id = Integer.parseInt(linha);
        br.close();
    }
    public int getID(){
        return ++id;
    }
    public void finalize()throws IOException{
        FileWriter fw = new FileWriter(nomeDoArquivo, false);
        BufferedWriter bw = new BufferedWriter(fw);
        String saida = id + "";
        bw.write(saida);
        bw.close();
    }
    
}
