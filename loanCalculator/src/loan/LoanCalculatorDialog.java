package loan;

import Util.FunUtil;
import tablelayout.swing.Table;

import javax.swing.*;
import java.awt.*;

public class LoanCalculatorDialog extends JDialog {
    private static final int DEFAULT_TEXTFIELD_WIDTH = 100;

    private JRadioButton averageCapitalRadioButton = null;              // 等额本金
    private JRadioButton averageCapitalPlusInterestRadioButton = null; // 等额本息
    private JTextField totalLoanTextField = null;               // 贷款金额
    private JTextField totalLoanPeriodTextField = null;         // 贷款期数
    private JTextField loanRateTextField = null;                // 贷款年利率
    private JTextField payDateTextField = null;                // 开始还款日期
    private JButton calculateButton = null;
    private LoanTable loanTable = null;

    private double totalLoan = 0.0;             // 贷款金额
    private double totalLoanPeriod = 0.0;       // 贷款期数
    private double loanMonthRate = 0.0;              // 贷款月利率

    public LoanCalculatorDialog() {
        try {
            setTitle("贷款计算");
            initGui();
            pack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initGui() {
        JPanel paramPanel = new JPanel(new BorderLayout());
        Table paramTable = new Table();
        paramPanel.add(paramTable, BorderLayout.CENTER);

        paramTable.addCell(new JLabel("贷款方式"));
        averageCapitalPlusInterestRadioButton = new JRadioButton("等额本息贷款");
        averageCapitalPlusInterestRadioButton.setSelected(true);
        paramTable.addCell(averageCapitalPlusInterestRadioButton);
        averageCapitalRadioButton = new JRadioButton("等额本金贷款");
        paramTable.addCell(averageCapitalRadioButton);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(averageCapitalPlusInterestRadioButton);
        buttonGroup.add(averageCapitalRadioButton);

        paramTable.row();
        paramTable.addCell(new JLabel("贷款金额(￥)"));
        totalLoanTextField = new JTextField("520000");
        totalLoanTextField.setColumns(DEFAULT_TEXTFIELD_WIDTH);
        paramTable.addCell(totalLoanTextField);

        paramTable.row();
        paramTable.addCell(new JLabel("贷款期数(月)"));
        totalLoanPeriodTextField = new JTextField("360");
        totalLoanPeriodTextField.setColumns(DEFAULT_TEXTFIELD_WIDTH);
        paramTable.addCell(totalLoanPeriodTextField);

        paramTable.row();
        paramTable.addCell(new JLabel("贷款年利率"));
        loanRateTextField = new JTextField("5.895");
        loanRateTextField.setColumns(DEFAULT_TEXTFIELD_WIDTH);
        paramTable.addCell(loanRateTextField);

        paramTable.row();
        paramTable.addCell(new JLabel("开始还款日期(年-月)"));
        payDateTextField = new JTextField("2013-05");
        payDateTextField.setColumns(DEFAULT_TEXTFIELD_WIDTH);
        paramTable.addCell(payDateTextField);

        paramTable.row();
        calculateButton = new JButton("计算");
        calculateButton.addActionListener(event -> {
            calculate();
        });
        paramTable.addCell(calculateButton);

        loanTable = new LoanTable();
        JScrollPane scrollPane = new JScrollPane(loanTable);
        JPanel talbePanel = new JPanel(new BorderLayout());
        talbePanel.add(scrollPane);

        this.setLayout(new BorderLayout());
        this.add(paramPanel, BorderLayout.NORTH);
        this.add(talbePanel, BorderLayout.CENTER);
    }

    private void calculate() {
        if (!isValidData()) {
            return;
        }

        loanTable.clearTable();
        double loanBalance = totalLoan;
        for (int i = 0; i < totalLoanPeriod; ++i) {
            LoanTableData loanTableData = new LoanTableData();

            loanTableData.setPayDate(getPayDate(i));

            double payAmount = calculateAmount();
            loanTableData.setPayAmount(payAmount);

            double payPrincipal = calculatePrincipal(i + 1);
            loanTableData.setPayPrincipal(payPrincipal);

            double payInterest = payAmount - payPrincipal;
            loanTableData.setPayInterest(payInterest);

            loanBalance -= payPrincipal;
            loanTableData.setLoanBalance(loanBalance);

            loanTable.addData(loanTableData);
        }
    }

    private boolean isValidData() {
        totalLoan = FunUtil.convertToDouble(totalLoanTextField.getText());
        if (Math.abs(totalLoan) < 1e-6) {
            JOptionPane.showMessageDialog(this, "贷款金额输入不正确", "数据校验",
                    JOptionPane.YES_OPTION);
            return false;
        }

        totalLoanPeriod = FunUtil.convertToDouble(totalLoanPeriodTextField.getText());
        if (Math.abs(totalLoanPeriod) < 1e-6) {
            JOptionPane.showMessageDialog(this, "贷款期数输入不正确", "数据校验",
                    JOptionPane.YES_OPTION);
            return false;
        }

        loanMonthRate = FunUtil.convertToDouble(loanRateTextField.getText()) / 100.0 / 12;
        if (Math.abs(loanMonthRate) < 1e-6) {
            JOptionPane.showMessageDialog(this, "贷款利率输入不正确", "数据校验",
                    JOptionPane.YES_OPTION);
            return false;
        }

        return true;
    }

    /**
     * 每期应还金额计算
     * @return
     */
    private double calculateAmount() {
        // 计划月还款额=〔贷款本金×月利率×（1+月利率）^还款月数〕÷〔（1+月利率）^还款月数－1〕
        double value = (totalLoan * loanMonthRate * Math.pow(1 + loanMonthRate, totalLoanPeriod))
                / (Math.pow(1 + loanMonthRate, totalLoanPeriod) - 1);
        return value;
    }

    /**
     * 每期应还本金计算
     * @param number 还贷期数
     * @return
     */
    private double calculatePrincipal(int number) {
        // 本月应还本金 = (贷款本金 * 月利率 * (1 + 月利率)^(第n期还贷数 - 1)) ÷〔（1+月利率）^还款月数－1〕
        double value = (totalLoan * loanMonthRate * Math.pow(1 + loanMonthRate, (number - 1)))
                / (Math.pow(1 + loanMonthRate, totalLoanPeriod) - 1);
        return value;
    }

    /**
     * 获取还款日期
     * @param index 还款期数
     * @return
     */
    private String getPayDate(int index) {
        String date = payDateTextField.getText();
        String year = date.substring(0, date.indexOf("-"));
        String month = date.substring(date.indexOf("-") + 1);
        int yearValue = FunUtil.convertToInt(year);
        int monthValue = FunUtil.convertToInt(month);
        monthValue = monthValue + index;
        if (monthValue > 12) {
            int value = monthValue / 12;
            if (monthValue % 12 == 0) {
                yearValue += value - 1;
                monthValue = 12;
            } else {
                yearValue += value;
                monthValue -= 12 * value;
            }
        }
        return yearValue + "-" + monthValue;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LoanCalculatorDialog dialog = new LoanCalculatorDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }
}
