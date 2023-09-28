public abstract class Solitario {

    ///Deja el juego listo para empezar a ser jugado a partir de una semilla random
    public abstract void crearLayout(int seed);

    ///Deja el juego listo para empezar a ser jugado a partir de una partida setteada
    public abstract void crearLayout(Solitario solitario);


    //************OPCIONES PARA TOMAR UN PILON DE CARTAS********************
    //Toma un pilon a partir de una carta foundation y la columna en que se encuentra
    //Retorna la capacidad de la accion de ejecutarse en función de las reglas del juego
    public abstract boolean tomarPilon(Carta foundation, int columna);

    //Toma un pilon a partir de la altura de una carta y la columna en que se encuentra
    //Retorna la capacidad de la accion de ejecutarse en función de las reglas del juego
    public abstract boolean tomarPilon(int alturaCarta, int columna);

    //Toma un pilon a partir de una carta foundation y el pilon en que se encuentra
    //Retorna la capacidad de la accion de ejecutarse en función de las reglas del juego
    public abstract boolean tomarPilon(Carta foundation, Pilon pilon);

    //Toma un pilon a partir de la altura de una carta y el pilon en que se encuentra
    //Retorna la capacidad de la accion de ejecutarse en función de las reglas del juego
    public abstract boolean tomarPilon(int alturaCarta, Pilon pilon);

    //**********************************************************************

    //************OPCIONES PARA COLOCAR UN PILON DE CARTAS********************
    //Coloca un pilon previamente tomado en una columna segun su indice
    //Retorna la capacidad de la accion de ejecutarse en función de las reglas del juego
    public abstract boolean colocarPilon(Pilon pilon, int columna);

    //Coloca un pilon previamente tomado en otro pilon
    //Retorna la capacidad de la accion de ejecutarse en función de las reglas del juego
    public abstract boolean colocarPilon(Pilon pilon, Pilon otroPilon);
    //**********************************************************************

    public abstract boolean juegoFinalizado(); // -> En realidad deberia ser un EstadoJuego el retorno
}
/*

Cartas: Mostrables ¿Movibles?

Pilones:
    Conjunto de cartas
    Mover:
        Pilon (carta)-> Pilon
            Un strategy al construir el juego que determine el algoritmo a seguir para cada pilón al
            momento de querer recibir una carta o un pilón
    Puede solo recibir, o solo dar, o ambas
        Lo implemento con delegacion simple

Inicializar juego a partir de una semilla:
    Genero cartas y las pongo en x pilones, x cantidad

Ganar:
    A partir de un strategy puedo pasarle al juego un algoritmo para determinar la forma en que se gana,
    cada juego conoce este algoritmo y le pasa a los pilones correspondientes el chequeo a realizar

* */