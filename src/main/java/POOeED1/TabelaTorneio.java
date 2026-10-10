package POOeED1;
//Aqui ainda tem que fazer
public class TabelaTorneio {

    private Time[] times;
    private int quantidadeTimes;

    public TabelaTorneio() {
        times = new Time[20];
        quantidadeTimes = 0;

    }

    public void adicionarTime(Time time) {
        if (quantidadeTimes < times.length) {
            times[quantidadeTimes] = time;
            quantidadeTimes++;
        }

    }

    public int buscarSequencialTimes(String nome) {
        for (int i = 0; i < quantidadeTimes; i++) {
            if (times[i].getNome().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    public void ordenarPorPontuacao() {

    }

    public void ordenarPorNome() {

        for (int i = 0; i < quantidadeTimes - 1; i++) {

            for (int j = 0; j < quantidadeTimes - 1 - i; j++) {

                if (times[j].getNome().compareToIgnoreCase(times[j + 1].getNome()) > 0) {

                    Time aux = times[j];

                    times[j] = times[j + 1];

                    times[j + 1] = aux;
                }
            }
        }
    }

    public void listarTimes() {
        ordenarPorNome();
        for (int i = 0; i < quantidadeTimes; i++) {
            IO.println("Time na posicao [" + i + "]");
            IO.println("Nome:" + times[i].getNome());
            IO.println("Vitorias:" + times[i].getVitorias());
            IO.println("Pontos:" + times[i].getPontos());

        }
    }

    public int buscaBinariaTime(String nome) {
        ordenarPorNome();
        int fim = quantidadeTimes - 1;
        int inicio = 0;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            if (times[meio].getNome().equals(nome)) {
                return meio;
            }
            if (times[meio].getNome().compareTo(nome) < 0) {
                inicio = meio + 1;
            }
            if (times[meio].getNome().compareTo(nome) > 0) {
                fim = meio - 1;
            }
        }
        return -1;
    }
    public Time retornaObjetoVetor(int posicao){
        Time time = times[posicao];
        return time;
    }


}
