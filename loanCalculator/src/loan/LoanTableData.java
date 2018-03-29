package loan;

public class LoanTableData {
    private String payDate = "";        // 还款日期
    private double loanBalance = 0.0;   // 贷款余额
    private double payAmount = 0.0;     // 还款额
    private double payPrincipal = 0.0;  // 应还本金
    private double payInterest = 0.0;   // 应还利息

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public double getPayPrincipal() {
        return payPrincipal;
    }

    public void setPayPrincipal(double payPrincipal) {
        this.payPrincipal = payPrincipal;
    }

    public double getPayInterest() {
        return payInterest;
    }

    public void setPayInterest(double payInterest) {
        this.payInterest = payInterest;
    }
}
