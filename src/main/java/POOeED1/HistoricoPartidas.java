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
    public int quantidadePartidaPorTime(String nome){
        int quantidade = 0;

        for (int i = 0; i < quantidadePartidas; i++) {

            if (partidas[i].getTime1().getNome().equalsIgnoreCase(nome)
                    || partidas[i].getTime2().getNome().equalsIgnoreCase(nome)) {

                quantidade++;
            }
        }
        return quantidade;
    }
    public Partida[] buscarPorTime(String nome) {

        int quantidade = quantidadePartidaPorTime(nome);

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

    public void listarPartidas() {
        if (quantidadePartidas == 0) {
            System.out.println("Nenhuma Partida Encontrada Ainda.");
            return;
        }
        for (int i = 0; i < quantidadePartidas; i++) {
            System.out.println("[" + i + "]" + partidas[i].toString());
        }
    }

    public void returnPartida(int indice) {
        if (indice >= 0 && indice < quantidadePartidas && partidas[indice] != null){
            System.out.println(partidas[indice].toString());
        }
        else {
            System.out.println("Índice inválido ou partida não cadastrada");
        }   

    }
    public int retornaQuantidadePartidas(){
        return this.quantidadePartidas;
    }
    public void removerPartida(int indice) {

        if (indice < 0 || indice >= quantidadePartidas) {
            System.out.println("Índice inválido.");
            return;
        }

        partidas[indice].desfazerResultado();

        for (int i = indice; i < quantidadePartidas - 1; i++) {
            partidas[i] = partidas[i + 1];
        }

        partidas[quantidadePartidas - 1] = null;

        quantidadePartidas--;

        System.out.println("Partida removida com sucesso!");
    }

}
