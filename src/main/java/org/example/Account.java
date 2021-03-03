package org.example;

import java.util.Random;
import java.math.BigDecimal;
import java.text.NumberFormat;
import org.example.DepositInvestmentThread;
public class Account {
    private String name;
    private double balance;
    private int id;
    private double investmentBalance;
    private double bankOfJavaAccountBalance = 1000.0;

    public Account(String name, double balance, int id, double investmentBalance) {
        if(balance < 0) {
            throw new IllegalArgumentException("Początkowy stan konta nie może być mniejszy od zera.");
        }
        this.name = name;
        this.balance = balance;
        this.id = id;
        this.investmentBalance = investmentBalance;
    }

    public void transferMoney(double transferAmount) {
        if (transferAmount <= 0) {
            throw new IllegalArgumentException("Podana kwota jest nieprawidłowa. Proszę wprowadzić ją raz jeszcze.");
        } else if (transferAmount > this.balance) {
            throw new IllegalArgumentException("Niestety, podana kwota przekracza saldo konta. " +
                    "Proszę wprowadzić ją raz jeszcze.");
        } else {
            bankOfJavaAccountBalance+= transferAmount;
            balance-=transferAmount;
            System.out.println("Przelew został wykonany.");
        }
    }

    public void deposit(double depositAmount) {
        boolean badAmount = false;
        while (!badAmount) {
            if (depositAmount <= 0.0) {
                throw new IllegalArgumentException("Podana kwota jest nieprawidłowa. Proszę wprowadzić ją raz jeszcze.");
            } else {
                balance += depositAmount;
                System.out.printf("Udało się!");
                badAmount = true;
            }
        }
    }
    public void currencyExchange(int currencyType, double currencyExchangeAmount) {
        double currencyExchangeValue;
        switch(currencyType) {
            case 1:
                currencyExchangeValue = 3.9; // dolar amerykański
                break;
            case 2:
                currencyExchangeValue = 4.6; // euro
                break;
            case 3:
                currencyExchangeValue = 5.0; // funt szterling
                break;
            default:
                throw new IllegalArgumentException("Proszę wybrać walutę ponownie.");
        }
        double currencyBought = currencyExchangeValue * currencyExchangeAmount;
        if (currencyBought < balance) {
            balance-=currencyBought;
        } else {
            throw new IllegalArgumentException("Nie można wykonać operacji. Zbyt mało środków na koncie.");
        }

    }


    public void depositInvestment(double interestRate) {
        DepositInvestmentThread invest = new DepositInvestmentThread(interestRate, investmentBalance);

        invest.start();

    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {

        this.name = name;
    }
    public String getName() {

        return name;
    }
    public int getId() {
        return id;
    }
    public double getInvestmentBalance() {
        return investmentBalance;
    }
    public void setInvestmentBalance(double investmentBalance) {

        this.investmentBalance = investmentBalance;
    }
    public int setId() {
        Random r = new Random();
        id = 100000 + r.nextInt(500000);
        return id;
    }
    public void printMenu() {
        System.out.print("\n" +
                "=====================================\n" +
                "Witaj, " + name + "\n" +
                "Co chcesz dzisiaj zrobić?:\n" +
                "1 - Sprawdź stan konta\n" +
                "2 - Dodaj środki\n" +
                "3 - Zrób przelew do banku Javy\n" +
                "4 - Zakup walutę\n" +
                "5 - Wpłać pieniądze na lokatę oszczędnościową\n" +
                "6 - Sprawdź stan lokaty\n" +
                "7 - Wyjdź\n" +
                "=====================================\n" +
                "Twój wybór: ");
    }

}
