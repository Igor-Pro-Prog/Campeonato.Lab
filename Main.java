import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

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
}

class Campeonato {
    private List<Clube> clubes;

    public Campeonato(List<Clube> clubes) {
        this.clubes = clubes;
    }

    public void jogarCampeonato() {
        for (int i = 0; i < clubes.size(); i++) {
            for (int j = i + 1; j < clubes.size(); j++) {
                jogarPartida(clubes.get(i), clubes.get(j));
                jogarPartida(clubes.get(j), clubes.get(i));
            }
        }
    }

    private void jogarPartida(Clube mandante, Clube visitante) {
        int golsMandante = (int) (Math.random() * 6);
        int golsVisitante = (int) (Math.random() * 6);

        if (golsMandante > golsVisitante) {
            mandante.ganhar(golsMandante - golsVisitante);
            visitante.perder(golsMandante - golsVisitante);
        } else if (golsMandante < golsVisitante) {
            visitante.ganhar(golsVisitante - golsMandante);
            mandante.perder(golsVisitante - golsMandante);
        } else {
            mandante.empatar();
            visitante.empatar();
        }
        System.out.println("PARTIDA:");
        System.out.println(mandante.getNome() + " " + golsMandante + " x " + golsVisitante + " " + visitante.getNome());
    }

    public String getClassificacao() {
        Collections.sort(clubes, (c1, c2) -> {
            if (c1.getPontos() != c2.getPontos()) {
                return Integer.compare(c2.getPontos(), c1.getPontos());
            } else {
                return Integer.compare(c2.getSaldoGols(), c1.getSaldoGols());
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append( "CLASSIFICAÇÃO DO CAMPEONATO" + "\n");
        sb.append("==================================================\n");

        for (int i = 0; i < clubes.size(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(clubes.get(i).getNome()).append(" - ");
            sb.append(clubes.get(i).getPontos()).append(" pontos, ");
            sb.append(clubes.get(i).getSaldoGols()).append(" de saldo de gols");
            sb.append("\n");
        }

        return sb.toString();
    }

    public Clube getCampeao() {
        return clubes.get(0);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Clube> clubes = new ArrayList<>();
        clubes.add(new Clube("Matemática Computacional"));
        clubes.add(new Clube("Ciência da Computação"));
        clubes.add(new Clube("Engenharia Cívil"));
        clubes.add(new Clube("Engenharia de Materiais"));

        Campeonato campeonato = new Campeonato(clubes);
        campeonato.jogarCampeonato();
        System.out.println(campeonato.getClassificacao());
        
        System.out.println("\033[32m" + campeonato.getCampeao().getNome() + " é o vencedor do campeonato!\033[0m");
    }
}
