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
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El num, como entero
     */
    public int readNumber(String msg) {
        boolean repeat;
        int toret = 0;

        do {
            repeat = false;
            System.out.print(msg);
            try {
                toret = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException exc) {
                repeat = true;
            }
        } while (repeat);

        return toret;
    }

    /**
     * Lee un string de teclado
     *
     * @param msg mensaje a mostrar antes de la lectura
     * @return el string leido
     */
    public String readString(String msg) {
        String toret;
        System.out.print(msg);
        toret = keyboard.nextLine();
        return toret;
    }

    /**
     * muestra un mensaje por pantalla // la cosa Mas Reverendamente inutil que he visto y eso que yo existo : v
     *
     * @param msg el mensaje a mostrar
     */
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * devuelve el mensaje leido para usar en todas las clases sin inicializar
     * Scanner de nuevo ni usar una funcion solo para esto
     *
     * @param mesg el mensaje a mostrar
     * @return el string recogido
     */
    private String leer(String mesg) throws IllegalArgumentException {
        String res = "";
        boolean error = false;
        Scanner Input = new Scanner(System.in);

        do {
            try {
                res = Input.nextLine();
                System.out.print(mesg);
            } catch (IllegalArgumentException exc) {
                error = true;
            }
        } while (error);

        Input.close();
        return res;
    }

    /**
     * devuelve el numero leido sin inicializar Scanner de nuevo
     *
     * @param mesg el mensaje a mostrar
     * @return el numero recogido
     */
    public int leerInt(String mens) throws NumberFormatException {
        int res = 0;
        boolean error = false;
        do {
            try {
                res = Integer.parseInt(leer(mens));
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
    public String leerString(String msg) {
        return leer(msg);
    }
    /**
     * Lee un jugador por teclado
     *
     * @return el jugador leido
     */
    public Player leerPlayer() {
        String name = leerString("Nome deste jugador");
        Player nOne = new Player(name);
        return nOne;
    }
    /**
     * Lee un jugador por teclado
     *
     * @param pos el numero del turno que este jug es
     * @return el string leido
     */
    public Player leerPlayerx(int pos) {
        String name = leerString("Nome do jugador" + pos);
        Player nOne = new Player(name);
        return nOne;
    }
    /**
     * crea un DeckOfCards
     *
     * @return Deck
     */
    public DeckOfCards makeDeckOfCards(){
        DeckOfCards deck = new DeckOfCards();
        return deck;
    }
    /**
     * crea un DeckOfCards vacio
     *
     * @return Deck
     */
    public DeckOfCards makeEmptyDeckOfCards(){
        DeckOfCards emptyDeck = new DeckOfCards();
        while (!emptyDeck.isEmpty()){
            emptyDeck.pop();
        }
        return emptyDeck;
    }

}
