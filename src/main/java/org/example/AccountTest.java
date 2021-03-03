package org.example;

import java.util.Scanner;

import static org.example.Account.*;

public class AccountTest {

    private static int userChoice;
    private static boolean quit = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = "";
        double balance = 0.0;
        double investmentBalance = 0.0;
        int id = 0;
        int currencyType;
        double currencyExchangeAmount;
        double interestRate = 0.05;

        Account myAccount = new Account(name, balance, id, investmentBalance);

        System.out.printf("%24s\n","PROJEKT_BANK v1.0");
        System.out.println("#################################");
        System.out.println("Podaj swoje imię i nazwisko: ");
        name = input.nextLine();
        myAccount.setName(name);
        System.out.println("Podaj początkowe saldo Twojego konta: ");
        balance = input.nextDouble();
        myAccount.setBalance(balance);
        System.out.println("Twój numer konta klienta to: ");
        System.out.println(myAccount.setId());

        while(!quit) {
            myAccount.printMenu();
            userChoice = input.nextInt();

            switch(userChoice) {
                case 1:
                    System.out.printf("Twój stan konta wynosi: %2f", myAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Jaką kwotę w PLN chcesz dodać do swojego konta? ");
                    myAccount.deposit(input.nextDouble());
                    break;
                case 3:
                    System.out.println("Jaką kwotę w PLN chcesz przelać do banku Javy? ");
                    myAccount.transferMoney(input.nextDouble());
                    break;
                case 4:
                    System.out.print("Jaką walutę chcesz zakupić?\n" +
                            "1. Dolar amerykański\n" + "2. Euro\n" +
                            "3. Funt szterling\n");
                    currencyType = input.nextInt();
                    System.out.println("Jaką kwotę w tej walucie chcesz zakupić?");
                    currencyExchangeAmount = input.nextDouble();
                    myAccount.currencyExchange(currencyType, currencyExchangeAmount);
                    break;
                case 5:
                    System.out.println("Oprocentowanie lokaty wynosi " + interestRate);
                    System.out.print("Jaką kwotę chcesz wpłacić na lokatę?: ");
                    double investmentAmount = input.nextDouble();
                    myAccount.setInvestmentBalance(investmentAmount);
                    //myAccount.depositInvestment(interestRate);
                    System.out.println("Operacja przebiegła pomyślnie. Dziękujemy.");
                    break;
                case 6:
                    System.out.println("Kwota na lokacie to: "
                            + myAccount.getInvestmentBalance() + "zł.");
                    break;
                case 7:
                    System.out.println("Dziękujemy i zapraszamy ponownie.");
                    quit = true;
                    break;
                default:
                    System.out.println("Wystąpił błąd. Proszę spróbować ponownie.");
            }
        }

    }

}
