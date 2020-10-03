import java.util.List;
import java.util.Scanner;

public class Interpreter {
    //TODO: Ver como fazer pra receber as infos
    public static void interpretador(List<String> source){
        byte[] memoria = new byte[1000];
        int pDados = 0;
        int pPrograma = 0;

        for(int i = 0; i < source.size(); i++){
            String str = source.get(i);
            pPrograma = i;
            switch (source.get(i)) {
                case ">":
                    pDados++;
                    break;
                case "<":
                    pDados--;
                    break;
                case "+":
                    memoria[pDados]++;
                    break;
                case "-":
                    memoria[pDados]--;
                    break;
                case "[":
                    if (memoria[pDados] == 0) {
                        i++;
                        //TODO: pilha para garantir  o "]" correspondente
                        while (!source.get(i).equals("]") || pPrograma > 0) {
                            if(source.get(i).equals("[")){
                                pPrograma++;
                            }
                            else if(source.get(i).equals("]")){
                                pPrograma--;
                            }
                            i++;
                        }
                    }
                    break;
                case "]":
                    if (memoria[pDados] != 0) {
                        i--;
                        //TODO: pilha para garantir  o "[" correspondente
                        while (!source.get(i).equals("[") || pPrograma > 0){
                            if(source.get(i).equals("]")){
                                pPrograma++;
                            }
                            else if(source.get(i).equals("[")){
                                pPrograma--;
                            }
                            i--;
                        }
                    }
                    break;
                case ",":
                    //TODO: lê uma linha do arquivo IF e o armazena na posição apontada pelo ponteiro de dados
                    memoria[pDados] = 007;
                    break;
                case ".":
                    //TODO: escrever no arquivo OF
                    WriterReader.fileWriter(Byte.toString(memoria[pDados]), "OutputFile");
                    break;
                case "$":
                    //TODO: ???
                    for (int pos = 0; pos < memoria.length; pos++){
                        WriterReader.fileWriter(Integer.toString(memoria[i]), "OutputFile");
                    }
                    break;
            }
        }
    }
}

