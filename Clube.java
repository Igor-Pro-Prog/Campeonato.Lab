class Clube {
    private String nome;
    private int pontos;
    private int saldoGols;

    public Clube(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.saldoGols = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void ganhar(int saldoGols) {
        this.pontos += 3;
        this.saldoGols += saldoGols;
    }

    public void empatar() {
        this.pontos += 1;
    }

    public void perder(int saldoGols) {
        this.saldoGols -= saldoGols;
    }

	public Object getGolsMarcados() {

        return null;


	}
    public Object getGolsSofridos() {
        return null;
    }
}
