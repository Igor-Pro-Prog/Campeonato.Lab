import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Clube> clubes = new ArrayList<>();
        clubes.add(new Clube("Brasil"));
        clubes.add(new Clube("Alemaha"));
        clubes.add(new Clube("Argentina"));
        clubes.add(new Clube("Uruguai"));
        clubes.add(new Clube("Portugal"));
        clubes.add(new Clube("França"));


        Campeonato campeonato = new Campeonato(clubes);
        campeonato.jogarCampeonato();
        System.out.println(campeonato.getClassificacao());

        System.out.println("\033[32m" + campeonato.getCampeao().getNome() + " é o vencedor do campeonato!\033[0m");
    }
}
