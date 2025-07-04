/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Smart Finance Tracker - Personal budget and investment calculator
 * Final Project for COSC 236
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.text.DecimalFormat;
import java.io.*;

public class SmartFinanceTracker extends JFrame implements ActionListener {
    
    // Collections to store data
    private List<Transaction> alTransactions;
    private Map<String, Double> hmCategoryTotals;
    private Queue<String> qRecentActivities;
    
    // GUI Components
    private JTextField tfAmount;
    private JTextField tfDescription;
    private JComboBox<String> cbCategory;
    private JRadioButton rbIncome;
    private JRadioButton rbExpense;
    private JCheckBox chkRecurring;
    private JTextArea taResults;
    private JTextField tfInvestmentAmount;
    private JTextField tfInterestRate;
    private JTextField tfYears;
    private JButton btnAddTransaction;
    private JButton btnCalculateInvestment;
    private JButton btnGenerateReport;
    private JButton btnClearAll;
    private JButton btnSaveData;
    private JButton btnLoadData;
    
    // Constants
    private static final String[] CATEGORIES = {
        "Food & Dining", "Transportation", "Shopping", "Entertainment",
        "Bills & Utilities", "Healthcare", "Education", "Travel", "Other"
    };
    
    private DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Could not set look and feel: " + e.getMessage());
            }
            new SmartFinanceTracker();
        });
    }
    
    public SmartFinanceTracker() {
        fvInitializeCollections();
        fvSetupGUI();
        fvInitializeDefaultData();
        setVisible(true);
    }
    
    // Method 1: Initialize all collections
    private void fvInitializeCollections() {
        alTransactions = new ArrayList<>();
        hmCategoryTotals = new HashMap<>();
        qRecentActivities = new LinkedList<>();
        
        // Initialize category totals
        for (String category : CATEGORIES) {
            hmCategoryTotals.put(category, 0.0);
        }
    }
    
    // Method 2: Setup the GUI
    private void fvSetupGUI() {
        setTitle("Smart Finance Tracker - Personal Budget & Investment Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create main panels
        JPanel pnlMain = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Transaction Entry Panel
        JPanel pnlTransaction = fvCreateTransactionPanel();
        
        // Investment Calculator Panel
        JPanel pnlInvestment = fvCreateInvestmentPanel();
        
        // Results Panel
        JPanel pnlResults = fvCreateResultsPanel();
        
        // Control Panel
        JPanel pnlControls = fvCreateControlPanel();
        
        pnlMain.add(pnlTransaction);
        pnlMain.add(pnlInvestment);
        pnlMain.add(pnlResults);
        pnlMain.add(pnlControls);
        
        add(pnlMain, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    // Method 3: Create transaction entry panel
    private JPanel fvCreateTransactionPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Add Transaction"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Amount field
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Amount:"), gbc);
        gbc.gridx = 1;
        tfAmount = new JTextField(10);
        panel.add(tfAmount, gbc);
        
        // Description field
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        tfDescription = new JTextField(15);
        panel.add(tfDescription, gbc);
        
        // Category dropdown
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        cbCategory = new JComboBox<>(CATEGORIES);
        panel.add(cbCategory, gbc);
        
        // Radio buttons for income/expense
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Type:"), gbc);
        gbc.gridx = 1;
        JPanel pnlRadio = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbIncome = new JRadioButton("Income", false);
        rbExpense = new JRadioButton("Expense", true);
        ButtonGroup bgType = new ButtonGroup();
        bgType.add(rbIncome);
        bgType.add(rbExpense);
        pnlRadio.add(rbIncome);
        pnlRadio.add(rbExpense);
        panel.add(pnlRadio, gbc);
        
        // Recurring checkbox
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        chkRecurring = new JCheckBox("Recurring Transaction");
        panel.add(chkRecurring, gbc);
        
        // Add button
        gbc.gridy = 5;
        btnAddTransaction = new JButton("Add Transaction");
        btnAddTransaction.addActionListener(this);
        panel.add(btnAddTransaction, gbc);
        
        return panel;
    }
    
    // Method 4: Create investment calculator panel
    private JPanel fvCreateInvestmentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Investment Calculator"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Investment Amount:"), gbc);
        gbc.gridx = 1;
        tfInvestmentAmount = new JTextField(10);
        panel.add(tfInvestmentAmount, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Annual Interest Rate (%):"), gbc);
        gbc.gridx = 1;
        tfInterestRate = new JTextField(10);
        panel.add(tfInterestRate, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Years:"), gbc);
        gbc.gridx = 1;
        tfYears = new JTextField(10);
        panel.add(tfYears, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        btnCalculateInvestment = new JButton("Calculate Future Value");
        btnCalculateInvestment.addActionListener(this);
        panel.add(btnCalculateInvestment, gbc);
        
        return panel;
    }
    
    // Method 5: Create results panel
    private JPanel fvCreateResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Results & Analysis"));
        
        taResults = new JTextArea(15, 30);
        taResults.setEditable(false);
        taResults.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(taResults);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Method 6: Create control panel
    private JPanel fvCreateControlPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(new TitledBorder("Controls"));
        
        btnGenerateReport = new JButton("Generate Report");
        btnGenerateReport.addActionListener(this);
        panel.add(btnGenerateReport);
        
        btnClearAll = new JButton("Clear All Data");
        btnClearAll.addActionListener(this);
        panel.add(btnClearAll);
        
        btnSaveData = new JButton("Save Data");
        btnSaveData.addActionListener(this);
        panel.add(btnSaveData);
        
        btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(this);
        panel.add(btnLoadData);
        
        return panel;
    }
    
    // Method 7: Initialize default data
    private void fvInitializeDefaultData() {
        qRecentActivities.offer("Application started");
        fvUpdateResults("Smart Finance Tracker initialized.\nAdd transactions or calculate investments to begin.");
    }
    
    // Method 8: Action event handler
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnAddTransaction) {
                fvProcessTransaction();
            } else if (e.getSource() == btnCalculateInvestment) {
                fvCalculateInvestmentGrowth();
            } else if (e.getSource() == btnGenerateReport) {
                fvGenerateFinancialReport();
            } else if (e.getSource() == btnClearAll) {
                fvClearAllData();
            } else if (e.getSource() == btnSaveData) {
                fvSaveDataToFile();
            } else if (e.getSource() == btnLoadData) {
                fvLoadDataFromFile();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                                        "Application Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method 9: Process transaction with validation
    private void fvProcessTransaction() {
        // Validate amount
        double dAmount = fdValidateAndParseAmount(tfAmount.getText().trim());
        if (dAmount <= 0) {
            return; // Validation failed
        }
        
        // Validate description presence
        String sDescription = tfDescription.getText().trim();
        if (!fbValidatePresence(sDescription, "Description")) {
            return;
        }
        
        String sCategory = (String) cbCategory.getSelectedItem();
        boolean bIsIncome = rbIncome.isSelected();
        boolean bIsRecurring = chkRecurring.isSelected();
        
        // Create and add transaction
        Transaction transaction = new Transaction(dAmount, sDescription, sCategory, bIsIncome, bIsRecurring);
        alTransactions.add(transaction);
        
        // Update category totals
        fvUpdateCategoryTotals(sCategory, dAmount, bIsIncome);
        
        // Add to recent activities
        qRecentActivities.offer((bIsIncome ? "Income" : "Expense") + ": " + 
                               dfCurrency.format(dAmount) + " - " + sDescription);
        if (qRecentActivities.size() > 10) {
            qRecentActivities.poll(); // Keep only last 10 activities
        }
        
        // Clear input fields
        fvClearTransactionFields();
        
        // Update display
        fvGenerateFinancialReport();
        
        JOptionPane.showMessageDialog(this, "Transaction added successfully!");
    }
    
    // Method 10: Validate and parse amount with range checking
    private double fdValidateAndParseAmount(String psAmount) {
        if (!fbValidatePresence(psAmount, "Amount")) {
            return -1;
        }
        
        try {
            double dAmount = Double.parseDouble(psAmount);
            if (dAmount <= 0 || dAmount > 1000000) {
                JOptionPane.showMessageDialog(this, 
                    "Amount must be between $0.01 and $1,000,000", 
                    "Invalid Range", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return dAmount;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid numeric amount", 
                "Invalid Data Type", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    // Method 11: Validate presence of required fields
    private boolean fbValidatePresence(String psValue, String psFieldName) {
        if (psValue == null || psValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                psFieldName + " is required and cannot be empty", 
                "Required Field", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    // Method 12: Update category totals
    private void fvUpdateCategoryTotals(String psCategory, double pdAmount, boolean pbIsIncome) {
        double dCurrentTotal = hmCategoryTotals.get(psCategory);
        if (pbIsIncome) {
            hmCategoryTotals.put(psCategory, dCurrentTotal + pdAmount);
        } else {
            hmCategoryTotals.put(psCategory, dCurrentTotal - pdAmount);
        }
    }
    
    // Method 13: Calculate investment growth using recursion
    private void fvCalculateInvestmentGrowth() {
        try {
            double dPrincipal = fdValidateAndParseAmount(tfInvestmentAmount.getText().trim());
            if (dPrincipal <= 0) return;
            
            String sRateText = tfInterestRate.getText().trim();
            if (!fbValidatePresence(sRateText, "Interest Rate")) return;
            
            String sYearsText = tfYears.getText().trim();
            if (!fbValidatePresence(sYearsText, "Years")) return;
            
            double dRate = Double.parseDouble(sRateText) / 100.0;
            int iYears = Integer.parseInt(sYearsText);
            
            if (dRate < 0 || dRate > 0.50) {
                JOptionPane.showMessageDialog(this, 
                    "Interest rate must be between 0% and 50%", 
                    "Invalid Range", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (iYears < 1 || iYears > 100) {
                JOptionPane.showMessageDialog(this, 
                    "Years must be between 1 and 100", 
                    "Invalid Range", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Recursive compound interest calculation
            double dFutureValue = fdCalculateCompoundInterestRecursive(dPrincipal, dRate, iYears);
            double dTotalGain = dFutureValue - dPrincipal;
            
            StringBuilder sbResult = new StringBuilder();
            sbResult.append("=== INVESTMENT ANALYSIS ===\n");
            sbResult.append("Initial Investment: ").append(dfCurrency.format(dPrincipal)).append("\n");
            sbResult.append("Annual Interest Rate: ").append(String.format("%.2f%%", dRate * 100)).append("\n");
            sbResult.append("Investment Period: ").append(iYears).append(" years\n");
            sbResult.append("Future Value: ").append(dfCurrency.format(dFutureValue)).append("\n");
            sbResult.append("Total Gain: ").append(dfCurrency.format(dTotalGain)).append("\n");
            sbResult.append("ROI: ").append(String.format("%.1f%%", (dTotalGain / dPrincipal) * 100)).append("\n\n");
            
            fvUpdateResults(sbResult.toString());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numeric values", 
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method 14: Recursive compound interest calculation
    private double fdCalculateCompoundInterestRecursive(double pdPrincipal, double pdRate, int piYears) {
        // Base case
        if (piYears == 0) {
            return pdPrincipal;
        }
        
        // Recursive case: calculate compound interest for one less year
        return fdCalculateCompoundInterestRecursive(pdPrincipal * (1 + pdRate), pdRate, piYears - 1);
    }
    
    // Method 15: Generate comprehensive financial report
    private void fvGenerateFinancialReport() {
        StringBuilder sbReport = new StringBuilder();
        
        sbReport.append("=== FINANCIAL SUMMARY REPORT ===\n");
        sbReport.append("Generated: ").append(new Date()).append("\n\n");
        
        // Calculate totals
        double dTotalIncome = 0;
        double dTotalExpenses = 0;
        
        for (Transaction transaction : alTransactions) {
            if (transaction.fbIsIncome()) {
                dTotalIncome += transaction.fdGetAmount();
            } else {
                dTotalExpenses += transaction.fdGetAmount();
            }
        }
        
        double dNetIncome = dTotalIncome - dTotalExpenses;
        
        sbReport.append("OVERVIEW:\n");
        sbReport.append("Total Income: ").append(dfCurrency.format(dTotalIncome)).append("\n");
        sbReport.append("Total Expenses: ").append(dfCurrency.format(dTotalExpenses)).append("\n");
        sbReport.append("Net Income: ").append(dfCurrency.format(dNetIncome));
        
        if (dNetIncome > 0) {
            sbReport.append(" (Surplus)\n");
        } else if (dNetIncome < 0) {
            sbReport.append(" (Deficit)\n");
        } else {
            sbReport.append(" (Break Even)\n");
        }
        
        sbReport.append("\nCATEGORY BREAKDOWN:\n");
        for (Map.Entry<String, Double> entry : hmCategoryTotals.entrySet()) {
            if (entry.getValue() != 0) {
                sbReport.append(String.format("%-15s: %s\n", 
                    entry.getKey(), dfCurrency.format(Math.abs(entry.getValue()))));
            }
        }
        
        sbReport.append("\nRECENT ACTIVITIES:\n");
        for (String activity : qRecentActivities) {
            sbReport.append("• ").append(activity).append("\n");
        }
        
        sbReport.append("\nTRANSACTION COUNT: ").append(alTransactions.size()).append("\n");
        
        fvUpdateResults(sbReport.toString());
    }
    
    // Method 16: Update results display
    private void fvUpdateResults(String psText) {
        taResults.setText(psText);
        taResults.setCaretPosition(0);
    }
    
    // Method 17: Clear transaction input fields
    private void fvClearTransactionFields() {
        tfAmount.setText("");
        tfDescription.setText("");
        cbCategory.setSelectedIndex(0);
        rbExpense.setSelected(true);
        chkRecurring.setSelected(false);
    }
    
    // Method 18: Clear all data
    private void fvClearAllData() {
        int iResult = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to clear all data? This cannot be undone.",
            "Confirm Clear All", JOptionPane.YES_NO_OPTION);
        
        if (iResult == JOptionPane.YES_OPTION) {
            alTransactions.clear();
            hmCategoryTotals.clear();
            qRecentActivities.clear();
            
            for (String category : CATEGORIES) {
                hmCategoryTotals.put(category, 0.0);
            }
            
            fvClearTransactionFields();
            tfInvestmentAmount.setText("");
            tfInterestRate.setText("");
            tfYears.setText("");
            
            fvUpdateResults("All data cleared. Ready for new entries.");
            
            JOptionPane.showMessageDialog(this, "All data has been cleared.");
        }
    }
    
    // Method 19: Save data to file
    private void fvSaveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("finance_data.txt"))) {
            writer.println("# Smart Finance Tracker Data Export");
            writer.println("# Generated: " + new Date());
            writer.println();
            
            for (Transaction transaction : alTransactions) {
                writer.println(transaction.fsToFileString());
            }
            
            JOptionPane.showMessageDialog(this, 
                "Data saved successfully to finance_data.txt");
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error saving data: " + e.getMessage(), 
                "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method 20: Load data from file
    private void fvLoadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("finance_data.txt"))) {
            alTransactions.clear();
            hmCategoryTotals.clear();
            qRecentActivities.clear();
            
            for (String category : CATEGORIES) {
                hmCategoryTotals.put(category, 0.0);
            }
            
            String sLine;
            int iLoadedCount = 0;
            
            while ((sLine = reader.readLine()) != null) {
                if (!sLine.startsWith("#") && !sLine.trim().isEmpty()) {
                    Transaction transaction = Transaction.fsFromFileString(sLine);
                    if (transaction != null) {
                        alTransactions.add(transaction);
                        fvUpdateCategoryTotals(transaction.fsGetCategory(), 
                                             transaction.fdGetAmount(), 
                                             transaction.fbIsIncome());
                        iLoadedCount++;
                    }
                }
            }
            
            fvGenerateFinancialReport();
            JOptionPane.showMessageDialog(this, 
                "Loaded " + iLoadedCount + " transactions successfully");
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                "No saved data file found (finance_data.txt)", 
                "File Not Found", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading data: " + e.getMessage(), 
                "Load Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}