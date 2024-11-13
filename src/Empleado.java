import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empleado {
    private String nombreEmpleado;
    private long cuil;
    private int anioIngreso;
    private double montoAntiguedad;
    private double sueldoBasico;
    private List<BonoSueldo> bonos;

    public void agregarBono(BonoSueldo b) {
        if (bonos == null) {
            bonos = new ArrayList<BonoSueldo>();
        }
        bonos.add(b);
    }

    public void montoAntiguedad() {
        int anioactual=2024;
        int aniosAntiguedad=(anioactual-anioIngreso);
        double montoAntiguedad=sueldoBasico*(aniosAntiguedad*0.02);
        this.montoAntiguedad=montoAntiguedad;
    }

    public void cargaEmpleado(){
        Scanner sc=new Scanner(System.in);
        Validaciones v=new Validaciones();
        System.out.println("Ingrese el nombre completo:");
        this.nombreEmpleado= sc.nextLine();
        System.out.println("Ingrese el cuil:");
        this.cuil= sc.nextLong();
        do{
            System.out.println("Ingrese el anio de ingreso:");
            this.anioIngreso= sc.nextInt();
            if(v.validarAnio(anioIngreso)){
                System.out.println("Año superior al actual, vuelva a ingresar uno menor!");
            }
        }while(v.validarAnio(anioIngreso));
        System.out.println("Ingrese el sueldo básico:");
        this.sueldoBasico= sc.nextDouble();
        montoAntiguedad();
    }




    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public double getMontoAntiguedad() {
        return montoAntiguedad;
    }

    public void setMontoAntiguedad(double montoAntiguedad) {
        this.montoAntiguedad = montoAntiguedad;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public List<BonoSueldo> getBonos() {
        return bonos;
    }

    public void setBonos(List<BonoSueldo> bonos) {
        this.bonos = bonos;
    }
}
