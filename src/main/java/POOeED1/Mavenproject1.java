package POOeED1;

import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        TabelaTorneio tabela = new TabelaTorneio();
        HistoricoPartidas historico = new HistoricoPartidas();
        int opcao = 0;
        while (opcao != -1) {
            System.out.println(
                    "Escolha uma opção:\n"
                    + "1-Times\n"
                    + "2-Partidas\n"
                    + "3-Historico\n"
                    + "4-Tabela Torneio\n" +
                            "-1 Sair");
            opcao = ler.nextInt();

            switch (opcao) {
                //Times
                case 1:
                    int opcaoTime = 0;
                    while (opcaoTime != -1) {
                        System.out.println("Escolha uma opção:\n"
                                + "1-Cadastrar Time\n"
                                + "2-Consultar Times\n" +
                                "3-Remover time"
                        );
                        System.out.println("-1 Sair");
                        opcaoTime = ler.nextInt();
                        ler.nextLine();
                        switch (opcaoTime) {

                            case 1:
                                System.out.println("Informe o nome do novo time:");
                                String nome = ler.nextLine();
                                Time time = new Time(nome);
                                tabela.adicionarTime(time);

                                break;

                            case 2:

                                System.out.println("Informe o nome do time a consultar:");
                                String nomeConsulta = ler.nextLine();
                                int posicao = tabela.buscaBinariaTime(nomeConsulta);
                                if (posicao != -1) {
                                    System.out.println("Posicao do Time:" + posicao);
                                } else {
                                    System.out.println("Time não está na tabela");
                                }
                                break;
                            case 3:
                                System.out.println("Informe o nome do time a remover:");
                                String nomeRemover =  ler.nextLine();
                                int pos = tabela.buscaBinariaTime(nomeRemover);
                                System.out.println("Time na posição:"+pos);
                                if (pos != -1) {
                                    tabela.removerTime(pos);
                                    System.out.println("Time removido!");
                                } else {
                                    System.out.println("Time não está na tabela");
                                }


                        }
                    }
                    break;
                //Partidas
                case 2:
                    int opcaoPartida = 0;
                    while (opcaoPartida != -1) {
                        System.out.println("Escolha uma opção:\n"
                                + "1-Cadastrar Partidas\n"
                                + "2-Consultar Partida\n"
                                + "-1 Sair");
                        opcaoPartida = ler.nextInt();
                        ler.nextLine();
                        switch (opcaoPartida) {
                            case 1:
                                System.out.println("Informe o nome do primeiro time:");
                                String time1 = ler.nextLine();
                                int posicao1 = tabela.buscaBinariaTime(time1);
                                System.out.println("Informe o nome do segundo time:");
                                String time2 = ler.nextLine();
                                int posicao2 = tabela.buscaBinariaTime(time2);
                                System.out.println("Informe o pontuação do 1 e 2 time respectivamente:");
                                int pontos1 = ler.nextInt();
                                int pontos2 = ler.nextInt();

                                if (posicao1 != -1 && posicao2 != -1) {
                                    if(posicao1 != posicao2) {
                                        Time timeobj1 = tabela.retornaObjetoVetor(posicao1);
                                        Time timeobj2 = tabela.retornaObjetoVetor(posicao2);
                                        Partida partida = new Partida(timeobj1, timeobj2, pontos1, pontos2);
                                        historico.adicionarPartida(partida);
                                        System.out.println("Partida Cadastrada!");
                                    }
                                    else{
                                        System.out.println("Time não pode disputar contra ele mesmo");
                                    }

                                } else {
                                    System.out.println("Um ou os dois times não foram encontrados :(");
                                }

                                break;
                            case 2:
                                System.out.println("Informe o indice a consultar:");
                                int indice = ler.nextInt();
                                if(indice <= historico.retornaQuantidadePartidas()){
                                    historico.returnPartida(indice);
                                }
                                else{
                                    System.out.println("Indice ainda sem partida");
                                }

                                break;

                        }
                    }

                    break;
                //Historico
                case 3:
                    int opcaoHistorico = 0;
                    while(opcaoHistorico != -1) {
                        System.out.println("1-Listar Partidas\n" +
                                "2-Consultar Partidas por Time\n" +
                                "-1 Sair");
                        opcaoHistorico = ler.nextInt();
                         ler.nextLine();
                                switch(opcaoHistorico) {
                                    case 1:
                                        historico.listarPartidas();
                                        break;
                                    case 2:
                                        System.out.println("Informe o nome do time a pesquisar:");
                                        String nome = ler.nextLine();
                                        int quantidadePartidas = historico.quantidadePartidaPorTime(nome);
                                        Partida [] partidasTime = historico.buscarPorTime(nome);
                                        for(int i = 0; i < quantidadePartidas; i++){
                                            String resul = partidasTime[i].toString();
                                            System.out.println(resul);
                                        }
                                        break;

                                }
                    }
                    historico.listarPartidas();
                    break;
                //TabelaTorneio
                case 4:
                    int opcaoTabela = 0;
                    while (opcaoTabela != -1) {
                        System.out.println("1-Lista times da tabela Torneio\n"
                                + "-1 Sair");
                        opcaoTabela = ler.nextInt();
                        switch (opcaoTabela) {
                            case 1:

                                tabela.listarTimes();
                                break;
                        }
                    }

            }

        }
    }
}
