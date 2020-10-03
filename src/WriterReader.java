import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriterReader {

    public static void setDir(){
        File diretorio = new File("arquivos");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
    }

    public static boolean fileDontExist(String nomeArquivo) {
        String dir = "./arquivos/";
        String fileAux = dir.concat(nomeArquivo.concat(".txt"));
        File file = new File(fileAux);
        return !file.exists();
    }

    public static List<String> inputReader(String url){
        Path path = Paths.get(url);
        List<String> lines = new ArrayList();
        //String[] lines = new String[100000];
        //int index = 0;

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                //lines[index] = line;
                //index++;
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
        return lines;
    }

    public static void outputWriter(String url, String line){

        Path path = Paths.get(url);
        try (BufferedWriter writer = Files.newBufferedWriter(path,Charset.defaultCharset())){
            int  temp = 0;
        }
        catch (IOException e) {
            System.err.format("Erro na escrita do arquivo: ", e);
        }
    }

    public static void fileWriter(String output, String nomeArquivo){
        String fileName = "./arquivos/"+nomeArquivo+".txt";
        File file = new File(fileName);
        FileWriter fileWriter;
        try{
            if(file.exists()){
                fileWriter = new FileWriter(fileName, true);
            }
            else {
                fileWriter = new FileWriter(fileName);
            }
            fileWriter.write(output+"\n");
            fileWriter.close();;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
