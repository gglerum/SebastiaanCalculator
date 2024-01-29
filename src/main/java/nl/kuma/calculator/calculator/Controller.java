package nl.kuma.calculator.calculator;

public class Controller {

  private NumPad numPad;
  private static Controller controllerInstance;

  private Controller() {
    this.numPad = new NumPad();
  }

  public NumPad getNumPad() {
    return numPad;
  }

  /**
   * Hiermee maken we Controller een singleton class, dit doen we omdat er maar 1 instance
   * van Controller nodig is om het programma te laten draaien en we CalculatorButton ook
   * toegang willen geven aan de methods binnen deze class
   *
   * @return
   */
  public static Controller getControllerInstance() {
    if (controllerInstance == null) {
      controllerInstance = new Controller();
    }

    return controllerInstance;
  }

  /**
   * Deze method zet de currentOperator field om naar de ingedrukte knop op
   * de rekenmachine en voert dan code uit gebaseerd op de staat van de andere waarden. Als
   * currentValue leeg is was dit de eerste keer dat de operator werd gebruikt en zet hij
   * simpelweg de waarde van input naar currentValue en wordt input weer gereset zodat je verder
   * kan rekenen. Als er al wel een currentValue is, maar input niet is ingevuld gebeurt er niks
   * en kan je gewoon verder rekenen. Als de operator wordt ingedrukt met een ingevulde input EN
   * currentValue fungeert hij als een soort equals knop zoals moderne rekenmachine apps zodat je
   * zonder tussendoor op equals te hoeven drukken kan doorrekenen.
   *
   * @param operatorInput
   */
  public void selectOperator(String operatorInput) {
    numPad.setCurrentOperator(operatorInput);

    if (numPad.getCurrentValue().isEmpty()) {
      numPad.setCurrentValue(numPad.getInput());
      numPad.setInput("");
    } else if (numPad.getInput().isEmpty()) {

    } else {
      equals();
      numPad.setInput("");
    }
  }

  /**
   * De equals method maakt double versies van currentValue en input en lost de berekening op met
   * de ingevulde waardes.
   */
  public void equals() {
    double parsedCurrentValue = Double.parseDouble(numPad.getCurrentValue());
    double parsedInput = Double.parseDouble(numPad.getInput());

    double sum = switch(numPad.getCurrentOperator()) {
      case "+" -> parsedCurrentValue + parsedInput;
      case "-" -> parsedCurrentValue - parsedInput;
      case "*" -> parsedCurrentValue * parsedInput;
      case "/" -> parsedCurrentValue / parsedInput;
      default -> parsedInput;
    };

    numPad.setCurrentValue(Double.toString(sum));
  }

  /**
   * cReset maakt alle huidige waarden weer leeg wanneer de C knop op de rekenmachine wordt
   * ingedrukt door de huidige instance van numPad te vervangen voor een nieuwe.
   */
  public void cReset() {
    numPad.setInput("");
    numPad.setCurrentValue("");
    numPad.setCurrentOperator("");
  }

}
