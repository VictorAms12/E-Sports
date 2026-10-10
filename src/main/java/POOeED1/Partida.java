package POOeED1;

public class Partida {

    private Time time1;
    private Time time2;
    private int goals1;
    private int goals2;

    public Partida(Time time1, Time time2, int goals1, int goals2) {
        this.time1 = time1;
        this.time2 = time2;
        this.goals1 = goals1;
        this.goals2 = goals2;
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "Time 1=" + time1.getNome() +
                ", Time 2=" + time2.getNome() +
                ", Pontuação do time 1=" + goals1 +
                ", Pontuação do time 2=" + goals2 +
                '}';
    }
}