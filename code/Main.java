import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class Main{

public static char[] alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};



public static void main(String[] args){

  ArrayList<Estado> estados = new ArrayList();

  System.out.println("Leyendo datos:");

  try{
    File file = new File("../data/ejemplo.txt"); //Esta ruta debe ser modificada para windows, pues es estilo unix
    Scanner fileScanner = new Scanner(file); //Scanner para el archivo
    Scanner scan;


    int i = 0;
    while(fileScanner.hasNext()){
      scan = new Scanner(fileScanner.nextLine());

      //boolean edoAceptacion, char x0destino, char x1destino
      //


      char estado0 = scan.next().charAt(0);
      int transicion0 = scan.nextInt();
      char estado1 = scan.next().charAt(0);
      int transicion1 = scan.nextInt();

      System.out.println(estado0 + " " + transicion0 + " " + estado1 + " " + transicion1);

//char id,boolean edoAceptacion, char x0destino, char x1destino

      Estado e = new Estado(alfabeto[i]);
      e.x0destino = estado0;
      e.x1destino = estado1;

      estados.add(e);

      i++; //Contador para saber cuantas lineas se leyeron
    }


  }
  catch(Exception e){
    System.out.println("Algun tipo de exception estilo ioException sucedio...: " + e.getMessage());

  }

  //imprimpiendo los estados para checar
  for (int i = 0; i < estados.size() ; i++) {
    System.out.println(estados.get(i).toString());

  }

  }




}
