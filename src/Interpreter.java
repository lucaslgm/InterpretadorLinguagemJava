import java.util.ArrayList;
import java.util.List;

public class Interpreter {
    //TODO: Ver como fazer pra receber as infos
    public static void interpretador(List<String> source){
        byte[] memoria = new byte[1000];
        int pDados = 0;
        int pPrograma = 0;

        int countInputFile = 0;
        List<String> inputTXT = WriterReader.inputReader("./arquivos/InputFile.txt");
        List<String> linesInputFile = new ArrayList<>();

        for (String line : inputTXT){
            for (int i = 0; i < line.length(); i++){
                linesInputFile.add(line);
            }
        }

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
                    int valueInputFile = Integer.parseInt(linesInputFile.get(countInputFile));
                    memoria[pDados] = (byte) valueInputFile;
                    countInputFile++;
                    break;
                case ".":
                    char aux = (char) memoria[pDados];
                    System.out.print(aux);
                    WriterReader.fileWriter(Character.toString(aux), "OutputFile", true);
                    break;
                case "$":
                    WriterReader.fileWriter("\n", "OutputFile",true);
                    for (byte b : memoria) {
                        WriterReader.fileWriter(Integer.toString(b), "OutputFile",true);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

