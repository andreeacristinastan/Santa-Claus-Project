package command;

public interface Command {

    /**
     * Metoda reprezinta calea catre executia comenzilor
     * necesare pentru annual changes, mai exact apeleaza
     * fiecare metoda a fiecarei clase ce implementeaza Command
     * si efectueaza cresterea varstelor copiilor cu cate un an,
     * respectiv actualizeaza bugetul mosului pentru anul curent.
     */
    void execute();

    /**
     * Fiecare clasa ce implementeaza Command contine cate o metoda
     * undo ce presupune revenirea la valorile precedente in cazul in
     * care acest lucru e necesar.
     */
    void undo();
}
