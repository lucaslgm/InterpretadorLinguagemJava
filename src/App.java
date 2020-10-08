import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        WriterReader.setDir();
        //WriterReader.fileWriter("","InputFile", false);
        WriterReader.fileWriter("","OutputFile", false);

        List<String> sourceFile = WriterReader.inputReader("./arquivos/SourceFile.txt");
        List<String> inputFile = new ArrayList<>();

        for (String line : sourceFile){
//            line = line.replaceAll("[^-><+\\]\\[,.$]","");
            if(line.charAt(0) != '%'){
                for (int i = 0; i < line.length(); i++){
                    //WriterReader.fileWriter(Character.toString(line.charAt(i)),"InputFile", true);
                    inputFile.add(Character.toString(line.charAt(i)));
                }
            }
        }

       Interpreter.interpretador(inputFile);
    }
}
