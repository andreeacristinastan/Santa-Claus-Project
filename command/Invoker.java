package command;

import java.util.LinkedList;

public final class Invoker {
    private final LinkedList<Command> history = new LinkedList<>();

    /**
     * Metoda se ocupa cu executia comenzilor necesare pentru
     * annual changes si retine intr-o lista istoricul comenzilor
     * pentru a se putea efectua operatia de undo in cazul in
     * care este necesar.
     * @param command - tipul de comanda ce trebuie efectuata.
     */
    public void edit(final Command command) {
        history.push(command);
        command.execute();
    }

    /**
     * Fata de metoda precedenta, aceasta se ocupa cu revenirea
     * la pasul anterior al celui curent in cazul in care este
     * nevoie si extrage din lista numele comenzii pentru a marca
     * efectuarea cu succes a revenirii la valorile anterioare.
     */
    public void undo() {
        if (history.isEmpty()) {
            return;
        }
        Command command = history.pop();

        command.undo();
    }
}
