import java.util.ArrayList;

public class BlackjackLogics {

    private int totalValue;
    private ArrayList<String> playerCards = new ArrayList<>();



    public BlackjackLogics() {
        totalValue = playerValue();
        newGameNewValues();
    }

    public void printArrayList() {
        for (int i = 0; i < playerCards.size(); i++) {
            System.out.print(playerCards.get(i) + " - ");
        }
    }
    public String decideValue() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int pickValue = (int) (Math.random() * 13);
        return values[pickValue];
    }

    public void newGameNewValues() {
        playerCards.add(decideValue());
        playerCards.add(decideValue());
    }

    public void hit() {
        playerCards.add(decideValue());
    }

    public int playerValue() {
        totalValue = 0;
        int aces = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            if (playerCards.get(i).equals("K") || playerCards.get(i).equals("Q") || playerCards.get(i).equals("J")) {
                totalValue += 10;
            } else if (playerCards.get(i).equals("A")) {
                aces++;
                totalValue += 11;
            } else {
                totalValue += Integer.parseInt(playerCards.get(i));
            }
            while ((totalValue > 21) && (aces > 0)) {
                aces -= 1;
                totalValue -= 10;
            }
        }

        return totalValue;
    }

    public void playerHand() {
        System.out.println("Your hand: ");
        printArrayList();
        System.out.println("Your Value: " + playerValue());
    }
    public boolean bust() {
        return totalValue > 21;
    }





}
