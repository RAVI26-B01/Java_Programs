package designpattern;


interface Printer {
    void print();
}

class LegacyPrinter {

    public void printDocument() {
        System.out.println("Printing using Legacy Printer");
    }
}

class PrinterAdapter implements Printer {

    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}

public class Adapter {
	public static void main(String[] args) {

        LegacyPrinter legacyPrinter = new LegacyPrinter();

        Printer printer = new PrinterAdapter(legacyPrinter);

        printer.print();
    }
}
