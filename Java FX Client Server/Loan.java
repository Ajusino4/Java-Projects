package adj009;


public class Loan extends Assignment09{

	//Loan class which extends server
	//Creating private classes for loan
	private static final long serialVersionUID = 1L;
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date date;
	
	
	public Loan() {
		this(2.5, 1, 1000);
	}
	
	//Assigning variables and date
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		date = new java.util.Date();
	}
	 //Returning variables for "get" + variables
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public int getNumberOfYears() {
		return numberOfYears;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	//Setting variables for assignment
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	//Creating new method with math for calculating monthly payment
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1+ monthlyInterestRate,  numberOfYears * 12)));
		return monthlyPayment;
	}
	
	//Creating new method for calculating total payment
	public double getTotalPayment() {
		double totalPay = getMonthlyPayment() * numberOfYears * 12;
		return totalPay;
	}
	//Getting date
	public java.util.Date getLoanDate() {
		return date;
	}
	
	
	
	
	
}//End of class
