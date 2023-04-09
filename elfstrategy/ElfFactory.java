package elfstrategy;

import common.Constants;

public final class ElfFactory {
    private static ElfFactory instance = null;

    private ElfFactory() {

    }

    /**
     * Metoda ce ajuta la crearea singletonului.
     * @return - instanta clasei.
     */

    public static ElfFactory getInstance() {
        if (instance == null) {
            instance = new ElfFactory();
        }
        return instance;
    }

    /**
     * Metoda verifica ce tip de elf este prezent si apeleaza
     * metodele potrivite pentru a efectua modificarile necesare
     * asupra bugetului.
     * @param elf - tipul de elf.
     * @return - rezultatul strategiei apelate.
     */
    public ElfStrategy createElfBudget(final String elf) {
        return switch (elf) {
            case Constants.WHITE_ELF, Constants.YELLOW_ELF -> new WhiteElf();
            case Constants.PINK_ELF -> new PinkElf();
            case Constants.BLACK_ELF -> new BlackElf();
            default -> null;
        };
    }
}
