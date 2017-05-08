public class Estado{

public char id;
public boolean edoAceptacion;
public char x0destino;
public char x1destino;

//Constructor mas simple (ideologia de ir armando el estado poco a poco)
public Estado(char id){
  this.id = id;
  edoAceptacion = false;
}


//chance no se acaba usando este constructor
public Estado(char id,boolean edoAceptacion, char x0destino, char x1destino){
  this.id = id;
  this.edoAceptacion = edoAceptacion;
  this.x0destino = x0destino;
  this.x1destino = x1destino;
}

public String toString(){
  return "id: " + id + ", edoAceptacion: " + edoAceptacion + ", x0destino: " + x0destino + ", x1destino: " + x1destino;
}


}
