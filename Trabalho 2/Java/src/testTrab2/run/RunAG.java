package testTrab2.run;

import testTrab2.model.Algoritimo;
import testTrab2.model.Populacao;

public class RunAG {
	public static void main(String[] args) {

        //Define a solu��o
        Algoritimo.setSolucao("Jo�o V�tor Gomes Silva");
        //Define os caracteres existentes
        Algoritimo.setCaracteres("!,.:;?�����������������QWERTYUIOPASDFGHJKL�ZXCVBNMqwertyuiopasdfghjkl�zxcvbnm1234567890 ");
        //taxa de crossover de 60%
        Algoritimo.setTaxaDeCrossover(0.6);
        //taxa de muta��o de 3%
        Algoritimo.setTaxaDeMutacao(0.3);
        //elitismo
        boolean eltismo = true;
        //tamanho da popula��o
        int tamPop = 100;
        //numero m�ximo de gera��es
        int numMaxGeracoes = 10000;

        //define o n�mero de genes do indiv�duo baseado na solu��o
        int numGenes = Algoritimo.getSolucao().length();

        //cria a primeira popula��o aleat�rioa
        Populacao populacao = new Populacao(numGenes, tamPop);

        boolean temSolucao = false;
        int geracao = 0;

        System.out.println("Iniciando... Aptid�o da solu��o: "+Algoritimo.getSolucao().length());
        
        //loop at� o crit�rio de parada
        while (!temSolucao && geracao < numMaxGeracoes) {
            geracao++;

            //cria nova populacao
            populacao = Algoritimo.novaGeracao(populacao, eltismo);

            System.out.println("Gera��o " + geracao + " | Aptid�o: " + populacao.getIndivduo(0).getAptidao() + " | Melhor: " + populacao.getIndivduo(0).getGenes());
            
            //verifica se tem a solucao
            temSolucao = populacao.temSolocao(Algoritimo.getSolucao());
        }

        if (geracao == numMaxGeracoes) {
            System.out.println("N�mero Maximo de Gera��es | " + populacao.getIndivduo(0).getGenes() + " " + populacao.getIndivduo(0).getAptidao());
        }

        if (temSolucao) {
            System.out.println("Encontrado resultado na gera��o " + geracao + " | " + populacao.getIndivduo(0).getGenes() + " (Aptid�o: " + populacao.getIndivduo(0).getAptidao() + ")");
        }
    }
}
