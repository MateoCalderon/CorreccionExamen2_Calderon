package test;
import dominio.JubiladoDiscapacidad;
import dominio.JubiladoVejez;
import dominio.Jubilado;
import dominio.JubiladoPatron;
import java.util.ArrayList;
import java.util.Scanner;

public class TestJubilado {
    int i = 0;
    int j = 0;
    int k = 0;
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<JubiladoVejez> jubiladosVejez = new ArrayList<>();
    static ArrayList<JubiladoDiscapacidad> jubiladosDiscapacidad = new ArrayList<>();
    static ArrayList<JubiladoPatron> jubiladosPatron = new ArrayList<>();
    public static void main(String[] args) {
        int i=0;
        int j=0;
        int k=0;
        int op = 0;        
        String cedula, nombres;
        int anios;
        do {
            op = menu(op);
             if(op==1){
            i=1;
            }
            if(op==2){
            j=1;
            }
            if(op==3){
            k=1;
            }
            if (op != 5 && op != 4) {
                entrada.nextLine();
                System.out.print("Cedula: ");
                cedula = entrada.nextLine();
                System.out.print("Nombres: ");
                nombres = entrada.nextLine();
                System.out.print("Anios Aporte:  ");
                anios = entrada.nextInt();
                datos(op, cedula, nombres, anios);
                
            }
            if(op==4){
                if(i==1){
                    System.out.println("Jublilado por Vejez: ");
                for(JubiladoVejez jub:jubiladosVejez){
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if(jub instanceof JubiladoVejez){
                       System.out.println(jub);
                    }
                   
                }
                }
                if(j==1){
                    System.out.println("Jublilado por Discapacidad: ");
                for(JubiladoDiscapacidad jub:jubiladosDiscapacidad){
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if(jub instanceof JubiladoDiscapacidad){
                      System.out.println(jub);  
                }
                }
                }
                if(k==1){
                    System.out.println("Jublilado Patronal: ");
                for(JubiladoPatron jub:jubiladosPatron){
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if(jub instanceof JubiladoPatron){
                        ((JubiladoPatron) jub).bonoSueldo();
                        System.out.println(jub);
                    }
                }
                }
            }
        } while (op != 5);
      } 
    public static int menu(int op) {
       
        System.out.println("Menu Jubilado");
        System.out.print("1. Vejez\n2. Invalidez\n3. Patronal\n4. Reporte\n5. Salir\nEscoja una Opcion. ");
        op = entrada.nextInt();
        
        return op;
    }

    public static void datos(int op, String cedula, String nombres, int anios) {
        double porcentaje;
        int tipo;
        switch (op) {
            case 1:
                jubiladosVejez.add(new JubiladoVejez(cedula, nombres, anios));                
                break;
            case 2:
                System.out.print("Porcentaje de discapacidad: ");
                porcentaje = entrada.nextDouble();
                jubiladosDiscapacidad.add(new JubiladoDiscapacidad(cedula, nombres, anios, porcentaje));
                break;
            case 3:
                System.out.print("Porcentaje de Inflacion: ");
                porcentaje = entrada.nextDouble();
                System.out.print("Tipo Empresa <<1>> publica <<2>> privada ");
                tipo = entrada.nextInt();
                jubiladosPatron.add(new JubiladoPatron(cedula, nombres, anios, porcentaje, tipo));
        }
    }
}
