package gal.uvigo.esei.aed1.chupatedos.iu;

import java.util.Scanner;

import gal.uvigo.esei.aed1.chupatedos.core.DeckOfCards;
import gal.uvigo.esei.aed1.chupatedos.core.Player;

public class IU {

    private final Scanner keyboard;

    public IU() {
        keyboard = new Scanner(System.in);
    }

    /**
     * muestra un mensaje por pantalla // la cosa Mas Reverendamente inutil que
     * he visto y eso que yo existo : v
     *
     * @param msg el mensaje a mostrar
     */
    public void displaymessage(String msg) {
        System.out.println(msg);
    }

    /**
     * devuelve el numero leido
     *
     * @param mesg el mensaje a mostrar
     * @return el numero recogido
     */
    public int readInt(String mens) throws NumberFormatException {
        int res = 0;

        boolean error = false;
        do {
            error = false;
            System.out.println(mens);
            try {
                res = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                error = true;
            }
        } while (error);
        return res;
    }

    /**
     * Lee un string de teclado
     *
     * @param mesg mensaje a mostrar antes de la lectura
     * @return el string leido
     */
    public String readString(String msg) {
        String toret;
        System.out.print(msg);
        toret = keyboard.nextLine();
        return toret;
    }

    /**
     * Lee los nombres de jugadores por teclado
     * nota la cantidad de jugadores se con con la longitud del array para otras funciones
     *
     * @return Un array de jugadores
     */
    public String[] readPlayers() {
        
        int Cantidad = 0;
        do {
            Cantidad = this.readInt("Introduzca el número de jugadores (min: 2 / max: 5): ");//lee la cantidad hasta que sea correcta
        } while (Cantidad < 2 || Cantidad > 5);
        String Jugadores[] = new String[Cantidad];

        
        for (int i = 0; i < Cantidad; i++) {
            do{
                Jugadores[i] = readString("Nombre del jugador " + i + ": "); //pregunta los nomres y los almacena en Jugadores
            }while (Jugadores[i].trim() == "");   
            for (int j = 0; j<i;j++){
                if (Jugadores[i].equals(Jugadores[j])){
                    Jugadores[i] += " (";
                    Jugadores[i] += i+1;
                    Jugadores[i] += ")";
                }
            }
        }

        return Jugadores;
    }

    /**
     * Lee un jugador por teclado
     *
     * @param pos el numero del turno que este jug es
     * @return el string leido
     */
    public Player readPlayerx(int pos) {
        String name = readString("Nome do jugador " + pos + ": ");
        Player nOne = new Player(name);
        return nOne;
    }

    /**
     * crea un DeckOfCards
     *
     * @return Deck
     */
    public DeckOfCards makeDeckOfCards() {
        DeckOfCards deck = new DeckOfCards();
        return deck;
    }

    /**
     * crea un DeckOfCards vacio
     *
     * @return Deck
     */
    public DeckOfCards makeEmptyDeckOfCards() {
        DeckOfCards emptyDeck = new DeckOfCards();
        while (!emptyDeck.isEmpty()) {
            emptyDeck.pop();
        }
        return emptyDeck;
    }

}
