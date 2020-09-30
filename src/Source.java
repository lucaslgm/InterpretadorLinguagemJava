import java.util.Scanner;

public class Source {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] memoria = new int[1000];
        char[] toPrint = new char[1000];
        int indice = 0;
        int count = 0;

        for(int posicao : memoria){
            posicao = 0;
        }
        //TODO: Ver como fazer pra receber as infos
        System.out.println("input: ");
        String aux = sc.next();

        for(int i = 0; i < aux.length(); i++){
            if(aux.charAt(i) == '>'){
                indice++;
            }
            else if(aux.charAt(i) == '<'){
                indice--;
            }
            else if(aux.charAt(i) == '+'){
                memoria[indice]++;
            }
            else if(aux.charAt(i) == '-'){
                memoria[indice]--;
            }
            else if(aux.charAt(i) == '['){
                if(memoria[indice] == 0) {
                    do{
                        indice++;
                    }
                    while(memoria[indice] != ']');
                }
                indice++;
            }
            else if(aux.charAt(i) == ']'){
                if(memoria[indice] != 0) {
                    do{
                        indice--;
                    }
                    while(memoria[indice] != '[');
                }
                indice--;
            }
            else if(aux.charAt(i) == ','){
                //TODO: ler entrada do arquivo IF
                System.out.println("input: ");
                memoria[indice] = sc.nextInt(); //TODO: Arquivo lido
            }
            else if(aux.charAt(i) == '.'){
                //TODO: escrever no arquivo OF
                toPrint[count] = (char) memoria[indice];
                count++;
            }
            else if(aux.charAt(i) == '.'){
                for(char c : toPrint)
                {
                    System.out.println(c);
                }
                break;
            }
        }
    }
}