/*
Created by Jesus Guillen
 */

import java.io.IOException;
import java.util.Random; // for random function
import java.util.Scanner; // for asking user for input
import java.net.URI; // send user to a link

public class Main { // runs the main method

    public static void main(String[] args) {
        Welcome(); // main method
    }

    public static void Welcome() {
        Scanner userInputReaders = new Scanner(System.in); // lets user input be collected

        System.out.println("\nWelcome to the game lobby. Here you will be able to choose from 5 different games."); // welcomes
                                                                                                                    // user
                                                                                                                    // and
                                                                                                                    // collects
                                                                                                                    // first
                                                                                                                    // name
        System.out.println("What is your first name");
        String firstName = userInputReaders.nextLine();

        System.out.println("What is your Last name"); /// welcomes user and collects last name
        String lastName = userInputReaders.nextLine();

        System.out.println("Welcome " + firstName + " " + lastName + " Are you ready to play?(Yes/No)"); // asks user if
                                                                                                         // they are
                                                                                                         // ready to
                                                                                                         // play
        String user = userInputReaders.nextLine();
        String Answer = user.toUpperCase(); // changes string to upper case

        if (Answer.equals("YES")) { // if yes they will be asked to pick a game
            System.out.print("\n");
            System.out.print("---------------------");
            System.out.print("\n");
            System.out.println("Let show you the games we have!! ");
            System.out.println(
                    "Your options are Coin flip(1), guess the animal(2), guess the number(3), and rock paper scissors(4)."
                            +
                            "Type in the number assigned to the game you want to play"); // the options they are give
            String Pick = userInputReaders.nextLine();
            int PickNum = Integer.parseInt(Pick); // changes string to an integer

            switch (PickNum) { // depending on the number they picked they will be taken to that game.
                case 1:
                    Coin();
                case 2:
                    GuessAnm();
                case 3:
                    GuessNum();
                case 4:
                    RPS();
                default:
                    System.out.println("Not a valid option try again."); // if tis not a number they will be asked ot
                                                                         // try again
                    Welcome();
            }

        } else if (Answer.equals("NO")) { // if no they will be sent to a link as a joke
            System.out.println("I was not expecting this enjoy this song but I hope you come back.");

            try {
                java.awt.Desktop.getDesktop().browse(URI.create("https://youtu.be/HmsUQEFYGI?t=123")); // they will beno
                                                                                                        // sent here
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.exit(0); // for an invalid response the game will quit
        }
    }

    public static void Coin() { // coin flip game
        Scanner userInputReaders = new Scanner(System.in);

        int tail = 1; // assign head and tails their values
        int heads = 0;
        int temp = (Math.random() <= 0.5) ? tail : heads; // pick either heads or tails randomly with 50% change for
                                                          // each
        System.out.print("---------------------");
        System.out.print("\n");
        System.out.println(
                "\n Welcome to the coin game. Its simple you pick heads or tails then flip a coin. If the coin flips to"
                        +
                        "what you picked you win. If not you lose."); // collects user input for game for which coin
                                                                      // they pick
        System.out.println("Do you pick heads or tails?");
        String user = userInputReaders.nextLine();
        String CoinANS = user.toUpperCase(); // turns string into caps

        if (CoinANS.equals("HEADS")) { // if heads they will be assignes heads and AI will pick tails
            int User1 = 0;
            int AI = 1;
            if (User1 == temp) {
                System.out.println("Congrats you won!! It was heads."); // if temp equal to user they win
            } else {
                System.out.println("Sorry the AI won you lost!! It was tails."); // if not they AI wins
            }
        } else if (CoinANS.equals("TAILS")) { // if tails user is assigned tails
            int User1 = 1;
            int AI = 0;
            if (User1 == temp) {
                System.out.println("Congrats you won!! It was tails."); // if temp equals user they win
            } else {
                System.out.println("\nSorry the AI won you lost!! It was heads."); // if not thhe AI wins
            }
        } else {
            System.out.println("Sorry that is not a valid response please try again"); // if there is no valid response
                                                                                       // then they are asked to play
                                                                                       // again
            Coin();
        }
        Again();

    }

    public static void GuessNum() { // this game asked the user to guess the correct number they picked
        Scanner userInputReaders = new Scanner(System.in);

        System.out.println("\nWelcome to 'Guess the number' where you guess a whole number 1 to 5.\n " + // asked for
                                                                                                         // input on
                                                                                                         // which
                                                                                                         // number they
                                                                                                         // want to
                                                                                                         // guess
                "The number changes everytime. Are you ready? GO! Type 10 to stop the game.");
        String user = userInputReaders.nextLine();
        int UserNUM = Integer.parseInt(user); // changes string to integer

        Random rand = new Random(); // instance of random class
        int upperbound = 5; // assigns limit of the random variable
        int int_random = rand.nextInt(upperbound); // random 1
        int int_random2 = rand.nextInt(upperbound); // random 2

        if (UserNUM == int_random) { // if they pick the correct number
            System.out.println("Congrats that was the correct number " + int_random + ".");
            Again();
        } else if (UserNUM == 10) { // this lets the user stop the game by typing in 10
            Again();
        }

        else {
            System.out.println("Try again but remember the number changes."); // if they did not pick the correct number
            if (int_random2 == int_random) {
                System.out.println("The AI guessed currently this time! The number was " + int_random + "\n"); // shows
                                                                                                               // if AI
                // guessed
                // correctly
            } else {
                System.out
                        .println("Neither the AI or you guessed currently The correct answer was " + int_random + "\n");// shows
                // if
                // the
                // both
                // lost
            }
            GuessNum();
        }
        Again(); // are asked ot try again

    }

    public static void GuessAnm() { // this game the user has to guess the correct animal the gmae gives a hint
        Scanner userInputReaders = new Scanner(System.in);

        final String[] Animal = { "Cheetah", "Whale", "Snail", "Falcon", "Dog" }; // these are the list of animals the
                                                                                  // user can pick from
        Random random = new Random();// randomly picks one animal from the lsit
        int List = random.nextInt(Animal.length);
        System.out.println(
                "\nIn this game you guess which animal I randomly pick. The options are Cheetah,Whale, Snail, Falcon, and Dog.");
        // gives the user their options to what they can pick from

        switch (Animal[List]) { // depending on what animal the program randomly chooses that response will
                                // active the case
            case "Dog": // if picked dog the don't hint will be shown
                System.out.println("This animal is a common house hold pet.");
                break;
            case "Cheetah": // so on so forth
                System.out.println("This animal is the fastest in the planet.");
                break;
            case "Whale":
                System.out.println("This animal is the largest in the ocean.");
                break;
            case "Snail":
                System.out.println("This animal is super slow.");
                break;
            case "Falcon":
                System.out.println("This animal is super fast in the air.");
                break;
        }

        System.out.println("What is your guess?"); // they will be asked to guess which animal they think it is
        String user = userInputReaders.nextLine();
        String GuessAns = user.toUpperCase(); // changes string to upper case
        String Ans = Animal[List];
        String LowAns = Ans.toUpperCase(); // changes string to upper case

        if (GuessAns.equals(LowAns)) {
            System.out.println("Congrats you got the answer correct."); // if they guess the animal current
        } else {
            System.out.println("That was not the correct Answer"); // if they guess the animal wrong
        }
        Again(); // they will be asked if they want to play again
    }

    public static void RPS() {
        Scanner userInputReaders2 = new Scanner(System.in);

        final String[] RPS = { "Rock", "Paper", "Scissors" }; // the list the program randomly picks from
        Random random = new Random();
        int List = random.nextInt(RPS.length); // pick random string

        System.out.println(
                "\nIn this game you are playing rock paper scissors against an AI. Pick one to start. Write it below(Rock,Paper,Scissors)");
        String user = userInputReaders2.nextLine(); // ask user which option they pick
        String RPSAnswer = user.toUpperCase(); // switch string to upper case

        switch (RPSAnswer) {
            case "ROCK": // if rock they are assigned rock then the AI makes their chose after which the
                         // games states who won
                int rock = 1; // user hand
                int paper = 2;
                int scissors = 0;
                final int[] RPS2 = { paper, rock, scissors }; // list of integers they program picks from
                Random random1 = new Random(); // picks randomly from list
                int List1 = random1.nextInt(RPS.length);
                // System.out.println("This is what the AI hand is " + List1); // list what the
                // AI picked

                if (rock < List1) {
                    System.out.println("You lost against the AI it picked paper sorry.");
                } // if your lost t states this
                else if (rock > List1) {
                    System.out.println("You won congrats the AI it picked scissors."); // if you won its states this
                } else {
                    System.out.println("It was a tie you both picked rock.");
                } // if you pick the same thing
                Again();
                break;

            case "PAPER": // if user picks paper.
                int rock2 = 0;
                int paper2 = 1; // user hand
                int scissors2 = 2;
                final int[] RPS3 = { paper2, rock2, scissors2 }; // list from which programs picks from
                Random random2 = new Random();
                int List2 = random2.nextInt(RPS.length); // picks random integer from this
                // System.out.println("This is what the AI hand is " + List2); // lists AI hand

                if (paper2 < List2) {
                    System.out.println("You lost against the AI it picked scissors sorry.");
                } // if user won
                else if (paper2 > List2) {
                    System.out.println("You won congrats the AI it picked rock."); // if user lost
                } else {
                    System.out.println("It was a tie you both picked Paper.");
                } // if AI and user tie
                Again();
                break;

            case "SCISSORS": // if user picks scissors

                int rock3 = 2;
                int paper3 = 0;
                int scissors3 = 1; // user hand
                final int[] RPS4 = { paper3, rock3, scissors3 }; // integer list
                Random random3 = new Random();
                int List3 = random3.nextInt(RPS.length); // randomly picks one integer from list
                // System.out.println("This is what the AI hand is " + List3); // list AI hand

                if (scissors3 < List3) {
                    System.out.println("You lost against the AI it picked rock sorry.");
                } // if user won
                else if (scissors3 > List3) {
                    System.out.println("You won congrats the AI it picked paper."); // if user lost
                } else {
                    System.out.println("It was a tie you both picked scissors.");
                } // if user and AI tie
                Again();
                break;

        }

    }

    public static void Again() { // ask the plyer if they want to play again
        Scanner userInputReaders = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Do you wanna play again?(Yes/No)"); // ask user for yes or no input
        String user = userInputReaders.nextLine();
        String Answer = user.toUpperCase(); // changes string to uppercase

        if (Answer.equals("YES")) { // if yes a space it added, and they are referred to quick-welcome
            // System.out.print("\n");
            System.out.print("---------------------");
            System.out.print("\n");
            System.out.print("\n");

            QuickWelcome(); // quick welcome is a faster method ot get them back to playing
        } else if (Answer.equals("NO")) { // if no they the program cancels
            System.out.println("Thanks for playing come back soon.");
            Welcome(); // takes them back the main menu
            System.exit(0);

        } else {
            System.exit(0); // system exits if no valid response
        }

    }

    public static void QuickWelcome() { // similar to welcome but simply ask what game they want to paly
        Scanner userInputReaders = new Scanner(System.in);

        System.out.println(
                "Your options are Coin flip(1), guess the animal(2), guess the number(3), and rock paper scissors(4)." +
                        "Type in the number assigned to the game you want to play");
        String Pick = userInputReaders.nextLine();// ask user what game they want to play
        int PickNum = Integer.parseInt(Pick); // changes string to integer

        switch (PickNum) { // deadening the number picked hey are then sent to that game
            case 1:
                Coin();
            case 2:
                GuessAnm();
            case 3:
                GuessNum();
            case 4:
                RPS();
            default:
                System.out.println("Not a valid option try again."); // if not a valid option they are referred to
                                                                     // welcome
                // method again
                QuickWelcome();
        }
    }
}
