import java.util.Collections;
import java.util.List;

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
        sb.append("===============================================================\n");
        sb.append("CLASSIFICAÇÃO DO CAMPEONATO\n");
        sb.append("===============================================================\n");
        sb.append(String.format("%-4s%-20s%-10s%-12s\n", "POS", "CLUBE", "PONTOS", "SALDO GOLS"));
        for (int i = 0; i < clubes.size(); i++) {
            sb.append(String.format("%-4s%-20s%-10s%-12s\n", i + 1, clubes.get(i).getNome(),
                    clubes.get(i).getPontos(), clubes.get(i).getSaldoGols(),
                    clubes.get(i).getGolsMarcados(), clubes.get(i).getGolsSofridos()));
        }
        return sb.toString();
    }

    public Clube getCampeao() {
        return clubes.get(0);
    }
}
