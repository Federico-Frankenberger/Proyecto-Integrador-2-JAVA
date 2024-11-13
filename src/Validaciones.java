import java.util.List;

public class Validaciones {
    public boolean validarAnio(int anio){
        if(anio<=2024){
            return false;
        }else {
            return true;
        }
    }
    public boolean validarCodigo(List<Integer> codigos,int codigo){
        for(Integer i:codigos){
            if(i==codigo){
                return true;
            }
        }
        codigos.add(codigo);
        return false;
    }
    public boolean validarEmpty(List<Integer> codigos){
        if(!codigos.isEmpty()){
            return true;
        }
        return false;
    }

}
