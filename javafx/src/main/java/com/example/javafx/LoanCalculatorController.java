package com.example.javafx;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class LoanCalculatorController
{
    @FXML
    private TextField tfAnnualInterestRate;

    @FXML
    private TextField tfNumberOfYears;

    @FXML
    private TextField tfLoanAmount;

    @FXML
    private TextField tfMonthlyPayment;

    @FXML
    private TextField tfTotalPayment;

    @FXML
    private Button btCalculate;

    @FXML
    protected void onbtCalculateClick()
    {
        double interest =
                Double.parseDouble(tfAnnualInterestRate.getText());		// "15" --> 15.0
        int year = Integer.parseInt(tfNumberOfYears.getText());		// "150" --> 150
        double loanAmount =
                Double.parseDouble(tfLoanAmount.getText());

        // Create a loan object. Loan defined in Listing 10.2
        Loan loan = new Loan(interest, year, loanAmount);

        // Display monthly payment and total payment
        tfMonthlyPayment.setText(String.format("$%.2f",
                loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%.2f",
                loan.getTotalPayment()));
    }
}
