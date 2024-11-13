import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculoBonoSueldo {
    static String[][] haberes = {
            {"100", "Presentismo", "9"},
            {"101", "Titulo Profesional", "9"},
            {"102", "Horas Extraordinarias", "M"},
            {"103", "Horas Nocturnas", "M"},
            {"104", "Otros Haberes", "M"}
    };
    static String[][] deducciones = {
            {"200", "Obra Social", "3"},
            {"201", "Jubilacion", "11"},
            {"202", "Sindicato", "2"},
            {"203", "Seguro", "1.5"},
            {"204", "Otros", "M"}
    };
    static List<Integer> codigosIngresados = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado empleado = new Empleado();
        Validaciones v = new Validaciones();
        empleado.cargaEmpleado();
        while(true){
            codigosIngresados.clear();
            BonoSueldo bonoSueldo = new BonoSueldo();
            bonoSueldo.cargarBono();
            String[][] matrix = new String[10][4];
            System.out.println("Ingrese los Haberes del Empleado");
            int codigo;
            int contador = 0;
            double sumahaberes = 0;
            while (true){
                do {
                    System.out.println("Ingrese el código del ítem:");
                    codigo = sc.nextInt();
                    if (codigo==000){
                        break;
                    }
                    if((v.validarCodigo(codigosIngresados, codigo))==false){
                        for(int i = 0; i<5;i++){
                            if(haberes[i][0].equals(String.valueOf(codigo))){
                                matrix[contador][0] = haberes[i][0];
                                matrix[contador][1] = haberes[i][1];
                                if(haberes[i][2].equals("M")) {
                                    System.out.println("Ingrese el valor del porcentaje:");
                                    double porcentaje = sc.nextDouble();
                                    matrix[contador][2] = String.valueOf((empleado.getSueldoBasico())*(porcentaje/100));
                                }else{
                                    matrix[contador][2] = String.valueOf(empleado.getSueldoBasico()*((Double.valueOf(haberes[i][2])/100)));
                                }
                                sumahaberes=sumahaberes+Double.parseDouble(matrix[contador][2]);
                                contador++;
                            }
                        }
                    }else{
                        System.out.println("Código ya ingresado");
                    }
                } while (v.validarCodigo(codigosIngresados, codigo));
                if (codigo==000){
                    if(v.validarEmpty(codigosIngresados)){
                        break;
                    }else {
                        System.out.println("Ingrese al menos 1 codigo!");
                    }

                }
            }
            bonoSueldo.setSumaHaberes(sumahaberes);
            System.out.println("--------------------------------------------------");
            System.out.println("Ingrese las deducciones del empleado" );
            double sumaDeducciones=0;
            while (true){
                do {
                    System.out.println("Ingrese el código del ítem:");
                    codigo = sc.nextInt();
                    if (codigo==000){
                        break;
                    }
                    if((v.validarCodigo(codigosIngresados, codigo))==false){
                        for(int i = 0; i<5;i++){
                            if(deducciones[i][0].equals(String.valueOf(codigo))){
                                matrix[contador][0] = deducciones[i][0];
                                matrix[contador][1] = deducciones[i][1];
                                if(deducciones[i][2].equals("M")) {
                                    System.out.println("Ingrese el valor del porcentaje:");
                                    double porcentaje = sc.nextDouble();
                                    matrix[contador][3] = String.valueOf((empleado.getSueldoBasico())*(porcentaje/100));
                                }else{
                                    matrix[contador][3] = String.valueOf(empleado.getSueldoBasico()*((Double.valueOf(deducciones[i][2])/100)));
                                }
                                sumaDeducciones=sumaDeducciones+Double.parseDouble(matrix[contador][3]);
                                contador++;
                            }
                        }
                    }else{
                        System.out.println("Código ya ingresado");
                    }
                } while (v.validarCodigo(codigosIngresados, codigo));
                if (codigo==000){
                    if(v.validarEmpty(codigosIngresados)){
                        break;
                    }else {
                        System.out.println("Ingrese al menos 1 codigo!");
                    }

                }
            }
            bonoSueldo.setSumaDeducciones(sumaDeducciones);
            bonoSueldo.setContador(contador);
            double montoliquidar = ((empleado.getSueldoBasico()+ empleado.getMontoAntiguedad()+sumahaberes)-sumaDeducciones);
            bonoSueldo.setMontoLiquidacion(montoliquidar);
            bonoSueldo.setMatrixx(matrix);
            empleado.agregarBono(bonoSueldo);
            System.out.println("Desea cargar otro bono? SI/NO");
            sc.nextLine();
            String respuesta = sc.nextLine().trim().toLowerCase();
            if(respuesta.toLowerCase().equals("no")){
                break;
            }
        }
        for(BonoSueldo bonos: empleado.getBonos()){
            System.out.println("--------------------El Bono de Sueldo a Liquidar es:---------------------");
            System.out.println("Nombre: "+empleado.getNombreEmpleado());
            System.out.println("Cuil: "+empleado.getCuil());
            System.out.println("Mes Liquidación: "+ bonos.getMesLiquidacion()+"\t\t"+"Año Liquidación: "+bonos.getAnioLiquidacion());
            System.out.println("Sueldo Básico: "+empleado.getSueldoBasico()+"\t"+"Año Ingreso: "+empleado.getAnioIngreso());
            System.out.println("Código Ítem \t\tDenominación\t\tHaberes\t\tDeducciones  ");
            System.out.println("\t\t\t\t\tSueldo Básico\t\t"+empleado.getSueldoBasico());
            System.out.println("\t\t\t\t\tAntiguedad\t\t\t"+empleado.getMontoAntiguedad());
            String[][] casa = bonos.getMatrixx();
            for(int i = 0; i<bonos.getContador();i++){
                for(int j = 0; j<4;j++){
                    System.out.print(String.format("%-20s", casa[i][j]));
                }
                System.out.println();
            }
            System.out.println("\t\t\t\t\tSubTotal\t\t\t"+(empleado.getSueldoBasico()+ empleado.getMontoAntiguedad()+ bonos.getSumaHaberes())+"\t\t\t"+bonos.getSumaDeducciones());
            System.out.println("\t\t\t\t\tNeto\t\t\t\t"+bonos.getMontoLiquidacion());
            System.out.println("-------------------------------------------------------------------------");



        }

    }
}
