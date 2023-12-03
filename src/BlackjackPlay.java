import java.util.Scanner;

public class BlackjackPlay {

    public static final String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};

    private BlackjackLogics player;
    private ComputerLogic dealer;
    private Scanner sc;


    public BlackjackPlay() {
        sc = new Scanner(System.in);
        player = new BlackjackLogics();
        dealer = new ComputerLogic();

    }

    public void start() {
        greet();
        game();

    }

    public void greet() {
        System.out.println("Hello! Welcome to Blackjack!");
        lineBreak();
    }

    public void dealerOneCard() {
        System.out.print("The dealer's hand: ");
        dealer.revealOneCard();
    }

    public void dealersTurn() {
        System.out.println("Dealer flips his second card...");
        dealer.dealerHand();
        lineBreak();
        dealer.hitOrStand();
        if (dealer.bust()) {
            System.out.println("Dealer busted! You win! The round is over.");
            System.exit(0);
        }
    }

    public void game() {
        dealerOneCard();
        player.playerHand();
        lineBreak();
        while (!player.bust() && hitOrStand()) {
            if (player.bust()) {
                System.out.println("You busted! Dealer wins. The round is over.");
                System.exit(0);
            }
        }

        dealersTurn();

        gameEnd();

    }

    public boolean hitOrStand() {
        System.out.println("Would you like to: \n1) Hit \n2) Stand");
        String answer = sc.nextLine();
        lineBreak();
        if (answer.equals("1")) {
            System.out.println("The dealer hands you a card from the deck.");
            player.hit();
            player.playerHand();
            lineBreak();
            return true;
        } else {
            System.out.println("Player final value: " + player.playerValue());
            lineBreak();
            return false;
        }
    }
    public void gameEnd() {
        if (player.playerValue() > dealer.dealerValue()) {
            System.out.println("Player value higher! You win! The round is over.");
        } else if (player.playerValue() < dealer.dealerValue()) {
            System.out.println("Dealer value higher! Dealer wins. The round is over.");
        } else {
            System.out.println("Same value! You push. The round is over.");
        }
    }

    public static void lineBreak() {
        System.out.println("--------------------");
    }
}
