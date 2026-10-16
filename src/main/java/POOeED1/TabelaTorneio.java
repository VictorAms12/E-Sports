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
        if (buscaBinariaTime(time.getNome()) != -1) {
            System.out.println("Time já cadastrado"); //Evitar duplicidadde do time
            return;
        }
        else if (quantidadeTimes < times.length) {
            times[quantidadeTimes] = time;
            quantidadeTimes++;
        }
    }

    public int buscarSequencialTimes(String nome) {
        for (int i = 0; i < quantidadeTimes; i++) {
            if (times[i].getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    public void ordenarPorPontuacao() {
        for (int i = 0; i < quantidadeTimes; i++) {
            for (int j = 0; j < quantidadeTimes - 1 - i; j++) {
                if (times[j].getPontos() < times[j + 1].getPontos()) {
                    Time aux = times[j];
                    times[j] = times[j + 1];
                    times[j + 1] = aux;
                } else if (times[j].getPontos() == times[j + 1].getPontos()) {
                    if (times[j].getVitorias() < times[j + 1].getVitorias()) {
                        Time aux = times[j];
                        times[j] = times[j + 1];
                        times[j + 1] = aux;
                    }
                }
            }
        }
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
        ordenarPorPontuacao();
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
            if (times[meio].getNome().equalsIgnoreCase(nome)) {
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

    public Time retornaObjetoVetor(int posicao) {
        Time time = times[posicao];
        return time;
    }
    public int returnQuantidadeTimes(){
        return quantidadeTimes;
    }
    public void removerTime(int pos){
        for(int i = pos; i<= quantidadeTimes -1;i++){
            if(i < quantidadeTimes-1){
                times[i] = times[i+1];
            }
            else{
                times[i] = null;
            }

        }
        quantidadeTimes--;
    }


}
