import java.util.ArrayList;

//Fazer depois
public class Gladiador extends Lutador
{
    ArrayList<Arsenal> armas = new ArrayList<>();
    ArrayList<Arsenal> armaduras = new ArrayList<>();

    public Gladiador(String nome , double nivelEnergia)
    {
        super(nome,nivelEnergia);
    }

    public int apagarDepois()
    {
        return 2;
    }





}
