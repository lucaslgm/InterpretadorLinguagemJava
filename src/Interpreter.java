import java.util.List;

public class Interpreter {
    //TODO: Ver como fazer pra receber as infos
    public static void interpretador(List<String> source){
        byte[] memoria = new byte[1000];
        int pDados = 0;
        int pPrograma = 0;

        for(int i = 0; i < source.size(); i++){
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
                    char aux = (char) memoria[pDados];
                    System.out.println(aux);
                    WriterReader.fileWriter(Character.toString(aux), "OutputFile", true);
                    break;
                case "$":
                    WriterReader.fileWriter("\n", "OutputFile",true);
                    for (byte b : memoria) {
                        WriterReader.fileWriter(Integer.toString(b), "OutputFile",true);
                    }
                    break;
            }
        }
    }
}

