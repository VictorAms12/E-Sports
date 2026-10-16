package POOeED1;

public class Partida {

    private Time time1;
    private Time time2;
    private int goals1;
    private int goals2;
    private Time vencedor;

    public Partida(Time time1, Time time2, int goals1, int goals2) {
        this.time1 = time1;
        this.time2 = time2;
        this.goals1 = goals1;
        this.goals2 = goals2;
        this.determinarVencedor();
    }

    public void determinarVencedor() {
        if (goals1 > goals2) {
            this.vencedor = time1;
            time1.adicionarVitoria();
            time2.adicionarDerrota();
        } else if (goals2 > goals1) {
            this.vencedor = time2;
            time2.adicionarVitoria();
            time1.adicionarDerrota();
        } else {
            this.vencedor = null;
        }
    }

    public Time getVencedor() {
        return vencedor;
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    @Override
    public String toString() {
        String nomeVencedor;
        if (vencedor != null) {
            nomeVencedor = vencedor.getNome();
        } else {
            nomeVencedor = "Empate";
        }
        return "Partida{"
                + "Time 1=" + time1.getNome()
                + ", Time 2=" + time2.getNome()
                + ", Pontuação do time 1=" + goals1
                + ", Pontuação do time 2=" + goals2
                + ", Vencedor=" + nomeVencedor
                + '}';
    }

}
