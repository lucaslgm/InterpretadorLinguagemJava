public class Source {
    public static void main(String[] args){
        int[] memoria = new int[1000];
        int indice = 0;

        for(int posicao : memoria){
            posicao = 0;
        }

        char aux = ' ';

        do {
            if(aux == '>'){
                indice++;
            }
            else if(aux == '<'){
                indice--;
            }
            else if(aux == '+'){
                memoria[indice]++;
            }
            else if(aux == '-'){
                memoria[indice]--;
            }
            else if(aux == '['){
                if(memoria[indice] == 0) {
                    //TODO
                }
                else{
                    indice++;
                }
            }
            else if(aux == ']'){
                if(memoria[indice] != 0) {
                    //TODO
                }
            }
            else if(aux == ','){
                //TODO: ler entrada do arquivo IF
                memoria[indice] = -1; //TODO: Arquivo lido
            }
            else if(aux == '.'){
                //TODO: escrever no arquivo OF de memoria[indice]
            }
        }
        while (aux != '$');
    }
}
