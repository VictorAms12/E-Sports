package POOeED1;
//Ainda tem que fazer um metodo, ou uma funçao que defina o vencedor de cada partida cadastrada, pode estar
//dentro do proprio cadastro ao adicionar partida, atribuindo o time que tiver mais pontuação ao
//atributo private Time vencedor; por exemplo
public class HistoricoPartidas {

    private Partida[] partidas;
    private int quantidadePartidas;

    public HistoricoPartidas() {
        partidas = new Partida[50];
        quantidadePartidas = 0;
    }

    public void adicionarPartida(Partida partida) {

        if (quantidadePartidas < partidas.length) {
            partidas[quantidadePartidas] = partida;
            quantidadePartidas++;
        }
    }


    public Partida[] buscarPorTime(String nome) {

        int quantidade = 0;

        for (int i = 0; i < quantidadePartidas; i++) {

            if (partidas[i].getTime1().getNome().equalsIgnoreCase(nome)
                    || partidas[i].getTime2().getNome().equalsIgnoreCase(nome)) {

                quantidade++;
            }
        }

        Partida[] resultado = new Partida[quantidade];

        int posicao = 0;

        for (int i = 0; i < quantidadePartidas; i++) {

            if (partidas[i].getTime1().getNome().equalsIgnoreCase(nome)
                    || partidas[i].getTime2().getNome().equalsIgnoreCase(nome)) {

                resultado[posicao] = partidas[i];
                posicao++;
            }
        }

        return resultado;
    }
    public void returnPartida(int indice) {

        System.out.println(partidas[indice].toString());

    }
}