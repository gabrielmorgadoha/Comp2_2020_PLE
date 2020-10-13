import java.util.HashMap;
import java.util.List;

public class CalculadorIntersecaoEsperto extends CalculadorIntersecao<Integer> {

    HashMap<Integer, Integer> mapa = new HashMap<>();

    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {

        int count = 0;

        for (int aux = 0; aux < lista1.size(); aux++){
            mapa.put(aux, lista1.get(aux));
        }

        for (int i = 0; i < lista2.size(); i++){
            if (mapa.containsKey(lista2.get(i))){
                count++;
            }
        }

        return count;
    }
}
