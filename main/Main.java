package main;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import jsonwriter.WriterHelp;
import jsonwriter.AnnualChildren;
import jsonwriter.Children;
import jsonwriter.Output;
import jsonwriter.Creator;
import annualchanges.Changes;
import rounds.FirstRound;
import checker.Checker;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import init.InputLoader;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * Metoda este folosita pentru a face legatura intre fisierele JSON si restul proiectului.
     * Initial, parcurg toate testele si imi creez noi obiecte in functie de necesitati.
     * Pentru inceput, cu ajutorul objectMapper-ului citesc informatia din fisierele JSON
     * si o stochez in variabila InputLoader pentru a o prelucra ulterior.
     * Apoi, pentru cei numberOfYears ani, efectuez rundele in cadrul metodelor apelate.
     * Dupa ce toate rundele au fost efectuate, iar informatiile necesare despre copii
     * actualizate, creez listele cu informatiile ceruta pentru output, apoi adaug in
     * fisierele JSON de output informatiile stocate cu ajutorul ObjectWriter-ului,
     * folosindu-ma de prettyPrinter.
     * @param args - argumentele din linia de comanda
     * @throws IOException - utilitar pentru citirea si scrierea JSON files.
     */
    public static void main(final String[] args) throws IOException {

        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            Children kid = new Children();
            AnnualChildren annualChildren = new AnnualChildren();
            ArrayList<Children> finalArray = new ArrayList<>();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            Changes changes = new Changes();

            InputLoader inputLoader = objectMapper.readValue(new File(Constants.TESTS_PATH + i
                    + Constants.FILE_EXTENSION), InputLoader.class);

            for (int j = 0; j <= inputLoader.getNumberOfYears(); j++) {
                ArrayList<Output> out = new ArrayList<>();

                if (j != 0) {
                    changes.makeChanges(inputLoader, j);
                }
                FirstRound.startRound(inputLoader, j);

                Creator.createOutput(inputLoader, out);
                WriterHelp.getInstance().createWriteFile(j, kid, finalArray, out, annualChildren);

            }

            writer.writeValue(new File(Constants.OUTPUT_PATH + i
                    + Constants.FILE_EXTENSION), annualChildren);
        }
        Checker.calculateScore();
    }
}
