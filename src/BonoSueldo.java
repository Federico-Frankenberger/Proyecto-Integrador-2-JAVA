import java.util.Scanner;

public class BonoSueldo {
    private Empleado empleado;
    private int mesLiquidacion;
    private int anioLiquidacion;
    private double sumaHaberes;
    private double sumaDeducciones;
    private double montoLiquidacion;
    private int contador;
    private String [][] matrixx;

    public void cargarBono(){
        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        System.out.println("Ingresa el mes de liquidacion:");
        this.mesLiquidacion=sc.nextInt();
        do{
            System.out.println("Ingresa el anio de liquidacion:");
            this.anioLiquidacion=sc.nextInt();
            if(v.validarAnio(anioLiquidacion)){
                System.out.println("El año ingresado es superior al actual, ingrese uno menor!");
            }
        }while(v.validarAnio(anioLiquidacion));

    }


    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getMesLiquidacion() {
        return mesLiquidacion;
    }

    public void setMesLiquidacion(int mesLiquidacion) {
        this.mesLiquidacion = mesLiquidacion;
    }

    public int getAnioLiquidacion() {
        return anioLiquidacion;
    }

    public void setAnioLiquidacion(int anioLiquidacion) {
        this.anioLiquidacion = anioLiquidacion;
    }

    public double getSumaHaberes() {
        return sumaHaberes;
    }

    public void setSumaHaberes(double sumaHaberes) {
        this.sumaHaberes = sumaHaberes;
    }

    public double getSumaDeducciones() {
        return sumaDeducciones;
    }

    public void setSumaDeducciones(double sumaDeducciones) {
        this.sumaDeducciones = sumaDeducciones;
    }

    public double getMontoLiquidacion() {
        return montoLiquidacion;
    }

    public void setMontoLiquidacion(double montoLiquidacion) {
        this.montoLiquidacion = montoLiquidacion;
    }

    public String[][] getMatrixx() {
        return matrixx;
    }

    public void setMatrixx(String[][] matrixx) {
        this.matrixx = matrixx;
    }
}
