import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char jugadorActual ='X';
        char [][] tablero = new char[3][3];
        boolean juego = true;
        for (int i = 0; i<3; i++){
            Arrays.fill(tablero[i],' ');
        }
        iniciarJuego(tablero,jugadorActual);
    }

    public static  void imprimirtablero(char[][]tablero){
        for (int i = 0; i < 3; i++) {
            System.out.println(" "+tablero[i][0]+" | "+tablero[i][1]+" | "+tablero[i][2]);
        }
    }
    //Se recorre el tablero y se verifica si hay alguna posición vacía
    public  static  boolean tableroLleno(char[][]tablero){
        for(int i=0;i<3;i++){
            for(int j=0; j<3;j++){
                //si hay una posición vacía, se retorna false
                if(tablero[i][j]==' '){
                    return false;
                }
            }

        }
        //si no hay ninguna posición vacía, se retorna true
        return true;
    }
    public static boolean buscarGanador(char[][]tablero,char jugadorActual){
        for(int i = 0; i<3; i++) {
            //se verifica si hay 3 en línea en las filas
            //filas
            if (tablero[i][0]==jugadorActual&&tablero[i][1]==jugadorActual&&tablero[i][2]==jugadorActual) return true;
            //columnas
            if (tablero[0][i]==jugadorActual&&tablero[1][i]==jugadorActual&&tablero[2][i]==jugadorActual) return true;
    }
            //diagonales
        return ((tablero[0][0]==jugadorActual&&tablero[1][1]==jugadorActual&&tablero[2][2]==jugadorActual) ||(tablero[0][2]==jugadorActual&&tablero[1][1]==jugadorActual&&tablero[2][0]==jugadorActual));
    }
    public static boolean jugadaCorrecta(char[][]tablero, int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            return false;
        }
        return tablero[fila][columna] == ' ';
    }
    public static boolean posicionVacia(char[][]tablero, int fila, int columna) {
        return tablero[fila][columna] == ' ';
    }
    public  static void iniciarJuego(char[][]tablero, char jugadorActual){
        Scanner sc = new Scanner(System.in);
        boolean juego = true;
        do{
            System.out.println("Tictac toe");
            imprimirtablero(tablero);
            System.out.println("Ingresa la fila");
            int fila = sc.nextInt();
            System.out.println("Ingresa la columna");
            int columna = sc.nextInt();

            //la posición que puso el usuario es valida?
            if(!jugadaCorrecta(tablero,fila,columna)){
                System.out.println("Posición no válida");
                continue;
            }
            //la posición que puso el usuario está ocupada?
            if(!posicionVacia( tablero,fila,columna)){
                System.out.println("Posición ocupada");
                continue;
            }

            //Si la posición es valida y no está ocupada, entonces se coloca la ficha
            tablero[fila][columna]=jugadorActual;
            //Se verifica si hay un ganador
            if(buscarGanador(tablero,jugadorActual)){
                //si el jugador actual es el ganador, se imprime el tablero y se termina el juego
                System.out.println("Ha ganado: "+jugadorActual);
                imprimirtablero(tablero);
                juego= false;

            }
            //Si no hay ganador, se verifica si el tablero está lleno y no hay ganador
            if(tableroLleno(tablero)&&!buscarGanador(tablero,jugadorActual)){
            //si el tablero está lleno, se imprime el tablero y se termina el juego
                System.out.println("El juego termina en empate");

                imprimirtablero(tablero);

            }

            //si no hay ganador y el tablero no está lleno, se cambia de jugador para que siga el juego
            //si el jugador actual es X, se cambia a O y viceversa
            jugadorActual=(jugadorActual=='X'?'O':'X');

        }while(juego);

    }
}