package POOeED1;

public class Time {

    private String nome;
    private int vitorias;
    private int derrotas;
    private int pontos;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarVitoria() {
        this.vitorias = this.vitorias + 1;
        this.pontos = this.pontos + 3;
    }

    public void adicionarDerrota() {
        this.derrotas = this.derrotas + 1;
    }

}
