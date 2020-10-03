import java.util.List;

public class App {
    public static void main(String[] args){
        List<String> inputFile = WriterReader.inputReader("C:\\Users\\gomes\\Desktop\\inputFile.txt");
        String source = ">++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<+\n" +
                "+.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-\n" +
                "]<+.$";
        List<String> src = null;
        WriterReader.setDir();
        //System.out.println(inputFile);
        Interpreter.interpretador(inputFile);
    }
}
