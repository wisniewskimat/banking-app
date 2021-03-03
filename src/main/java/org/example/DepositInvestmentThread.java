package org.example;

public class DepositInvestmentThread extends Thread {

    double investmentBalance;
    double interestRate;

    DepositInvestmentThread(double interestRate, double investmentBalance) {
        this.investmentBalance = investmentBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(36000);
                investmentBalance += (investmentBalance * interestRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

