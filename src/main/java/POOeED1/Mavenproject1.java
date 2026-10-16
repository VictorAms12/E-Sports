package POOeED1;

import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        TabelaTorneio tabela = new TabelaTorneio();
        HistoricoPartidas historico = new HistoricoPartidas();
        Time t1 = new Time("FURIA");
        Time t2 = new Time("LOUD");
        Time t3 = new Time("MIBR");
        Time t4 = new Time("PAIN");
        Time t5 = new Time("RED Canids");
        Time t6 = new Time("Fluxo");
        Time t7 = new Time("Liberty");
        Time t8 = new Time("Vivo Keyd");
        Time t9 = new Time("INTZ");
        Time t10 = new Time("Kabum");
        Time t11 = new Time("Alpha");
        Time t12 = new Time("Bravo");
        Time t13 = new Time("Delta");
        Time t14 = new Time("Omega");
        Time t15 = new Time("Phoenix");
        Time t16 = new Time("Titans");
        Time t17 = new Time("Dragons");
        Time t18 = new Time("Warriors");
        Time t19 = new Time("Storm");
        Time t20 = new Time("Galaxy");

        tabela.adicionarTime(t1);
        tabela.adicionarTime(t2);
        tabela.adicionarTime(t3);
        tabela.adicionarTime(t4);
        tabela.adicionarTime(t5);
        tabela.adicionarTime(t6);
        tabela.adicionarTime(t7);
        tabela.adicionarTime(t8);
        tabela.adicionarTime(t9);
        tabela.adicionarTime(t10);
        tabela.adicionarTime(t11);
        tabela.adicionarTime(t12);
        tabela.adicionarTime(t13);
        tabela.adicionarTime(t14);
        tabela.adicionarTime(t15);
        tabela.adicionarTime(t16);
        tabela.adicionarTime(t17);
        tabela.adicionarTime(t18);
        tabela.adicionarTime(t19);
        tabela.adicionarTime(t20);

        historico.adicionarPartida(new Partida(t1, t2, 3, 1));
        historico.adicionarPartida(new Partida(t3, t4, 2, 0));
        historico.adicionarPartida(new Partida(t5, t6, 1, 3));
        historico.adicionarPartida(new Partida(t7, t8, 2, 1));
        historico.adicionarPartida(new Partida(t9, t10, 0, 2));

        historico.adicionarPartida(new Partida(t11, t12, 4, 1));
        historico.adicionarPartida(new Partida(t13, t14, 1, 2));
        historico.adicionarPartida(new Partida(t15, t16, 3, 0));
        historico.adicionarPartida(new Partida(t17, t18, 2, 4));
        historico.adicionarPartida(new Partida(t19, t20, 1, 0));

        historico.adicionarPartida(new Partida(t1, t3, 2, 1));
        historico.adicionarPartida(new Partida(t2, t4, 3, 2));
        historico.adicionarPartida(new Partida(t5, t7, 2, 0));
        historico.adicionarPartida(new Partida(t6, t8, 1, 2));
        historico.adicionarPartida(new Partida(t9, t11, 3, 1));

        historico.adicionarPartida(new Partida(t10, t12, 2, 1));
        historico.adicionarPartida(new Partida(t13, t15, 0, 3));
        historico.adicionarPartida(new Partida(t14, t16, 1, 2));
        historico.adicionarPartida(new Partida(t17, t19, 4, 2));
        historico.adicionarPartida(new Partida(t18, t20, 2, 3));
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
                                + "3-Remover Partida\n" +
                                "-1 Sair");
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
                            case 3:
                                historico.listarPartidas();
                                System.out.println("Informe o índice da partida que deseja remover:");
                                int partidaRemovida = ler.nextInt();

                                System.out.println("Informe o indice a remover");

                                if(partidaRemovida <= historico.retornaQuantidadePartidas()){
                                    historico.removerPartida(partidaRemovida);
                                }
                                else{
                                    System.out.println("Partida Removida");
                                }






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
