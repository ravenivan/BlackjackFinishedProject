import java.util.ArrayList;

public class ComputerLogic {

    private int totalValue;
    private ArrayList<String> dealerCards = new ArrayList<>();



    public ComputerLogic() {
        totalValue = dealerValue();
        newGameNewValues();
    }

    // added just for project requirements
    public ComputerLogic(int num1) {
        totalValue = dealerValue();
        newGameNewValues();
    }

    // added just for project requirements
    public int roundSubtractedNumbers(double num1, double num2) {
        return (int) (num1 - num2);
    }
    public void revealOneCard() {
        System.out.println(dealerCards.get(0));
        System.out.println("The second card is faced down.");
        lineBreak();
    }
    public void printArrayList() {
        for (int i = 0; i < dealerCards.size(); i++) {
            System.out.print(dealerCards.get(i) + " - ");
        }
    }
    public String decideValue() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int pickValue = (int) (Math.random() * 13);
        return values[pickValue];
    }

    public void newGameNewValues() {
        dealerCards.add(decideValue());
        dealerCards.add(decideValue());
    }

    public void hitOrStand() {
        while (totalValue < 17) {
            System.out.println("Dealer draws a card...");
            dealerCards.add(decideValue());
            dealerValue();
            dealerHand();
            lineBreak();
        }

    }

    public int dealerValue() {
        totalValue = 0;
        int aces = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            if (dealerCards.get(i).equals("K") || dealerCards.get(i).equals("Q") || dealerCards.get(i).equals("J")) {
                totalValue += 10;
            } else if (dealerCards.get(i).equals("A")) {
                aces++;
                totalValue += 11;
            } else {
                totalValue += Integer.parseInt(dealerCards.get(i));
            }
            while ((totalValue > 21) && (aces > 0)) {
                aces -= 1;
                totalValue -= 10;
            }
        }

        return totalValue;
    }

    public void dealerHand() {
        System.out.println("Dealer hand: ");
        printArrayList();
        System.out.println("Dealer Value: " + dealerValue());
    }

    public boolean bust() {
        return totalValue > 21;
    }

    // added just for project requirements
    public boolean bust(int num1) {
        return totalValue > 21;
    }

    private void lineBreak() {
        System.out.println("--------------------");
    }





}
