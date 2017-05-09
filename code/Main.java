import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;


public class Main{

//Alfabeto para poder ir asignando letras a los estados conforme los vayamos leyendo
//La razon por la cual usamos strings es porque son mucho mas manejables que chars en java
//(no uso acentos al programar...)
public static String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};



public static void main(String[] args){

  //ArrayList de arreglo de strings, para ir guardando lo que leemos, pues tendremos que releerlo.
  ArrayList<String[]> alestados = new ArrayList();

  //HashMap (diccionario, hashtable, whatever...) de String a objeto Estad, para poder
  //Acceder directo al objeto estado correspondiente a la letra de su id.s
  HashMap<String, Estado> mapestados = new HashMap();


  System.out.println("Leyendo datos:");

  //bloque try catch porque java es fan de las ioExceptions (can't blame them tho, they DO suck)
  try{
    File file = new File("../data/ejemplo.txt"); //Esta ruta debe ser modificada para windows, pues es estilo unix
    Scanner fileScanner = new Scanner(file); //Scanner para el archivo
    Scanner scan; //Scanner para las lineas individuales

    //mientras haya lineas en el archivo
    while(fileScanner.hasNext()){
      scan = new Scanner(fileScanner.nextLine());
      scan.useDelimiter("\t");


      String estado0 = scan.next();
      String transicion0 = scan.next();
      String estado1 = scan.next();
      String transicion1 = scan.next();

      System.out.println(estado0 + " " + transicion0 + " " + estado1 + " " + transicion1);


      String[] arrEstado = {estado0, transicion0, estado1, transicion1};
      alestados.add(arrEstado);

    }


  }
  catch(Exception e){
    //Rete mal manejo de excepcion pero que flojera hacerlo bien
    System.out.println("Algun tipo de exception estilo ioException sucedio...: " + e.getMessage());

  }

  //imprimpiendo los estados para checar
  for (int i = 0; i < alestados.size() ; i++) {
    for (int j = 0; j < 4 ; j++) {
      System.out.print(alestados.get(i)[j]);
    }
    System.out.println();
  }

  //Ir creando objetos estado con los estados a los que pueden transicionar.
  for (int i = 0;i < alestados.size() ;i++ ) {
    Estado e = new Estado(alfabeto[i]);
    e.x0destino = alestados.get(i)[0];
    e.x1destino = alestados.get(i)[2];
    mapestados.put(e.id,e); //Agregar el estado al HashMap
  }

  System.out.println(mapestados.toString());

  /*Ir checando los estados que son de aceptacion.
    En caso de que uno sea, con el HashMap lo encontramos
    y vamos y le decimos que SI es de aceptacion
  */
  for (int i = 0;i < alestados.size();i++) {
    if(alestados.get(i)[1].equals("1")){
      mapestados.get(alestados.get(i)[0]).edoAceptacion = true;
    }

    if(alestados.get(i)[3].equals("1")){
      mapestados.get(alestados.get(i)[2]).edoAceptacion = true;
    }
  }

  for (int i = 0; i < alestados.size() ;i++ ) {
    System.out.println(mapestados.get(alfabeto[i]).toString());
  }





}




}
