/*
 * Description: LashBiz Pro - Appointment & Income Tracker for Beauty Professionals
 */

 import javax.swing.*;
 import javax.swing.border.TitledBorder;
 import javax.swing.table.DefaultTableModel;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.*;
 import java.util.List;
 import java.text.DecimalFormat;
 import java.text.SimpleDateFormat;
 import java.text.ParseException;
 import java.io.*;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 
 public class LashBizPro extends JFrame implements ActionListener {
     
     // Core Collections
     private Map<String, List<Appointment>> hmClientAppointments;
     private Map<String, Integer> hmClientLoyaltyCount;
     private List<Appointment> alAllAppointments;
     private Queue<String> qRecentActivities;
     private Set<String> hsClientNames;
     
     // GUI Components
     private JTextField tfClientName;
     private JTextField tfAppointmentDate;
     private JTextField tfCustomPrice;
     private JTextField tfNotes;
     private JComboBox<ServiceType> cbServiceType;
     private JRadioButton rbNewClient;
     private JRadioButton rbReturningClient;
     private JCheckBox chkLoyaltyDiscount;
     private JTable tblAppointments;
     private JTextArea taResults;
     private JTextArea taAnalytics;  // Analytics tab display area
     private JTextArea taStats;      // Statistics tab display area
     private DefaultTableModel tmAppointments;
     
     // Filter components
     private JTextField tfStartDate;
     private JTextField tfEndDate;
     private JTextField tfClientFilter;
     
     // Buttons
     private JButton btnAddAppointment;
     private JButton btnViewClientHistory;
     private JButton btnGenerateReport;
     private JButton btnCalculateIncome;
     private JButton btnClearAll;
     private JButton btnSaveData;
     private JButton btnLoadData;
     private JButton btnApplyFilters;
     
     // Constants and Formatters
     private static final int LOYALTY_THRESHOLD = 5;
     private static final double LOYALTY_DISCOUNT = 0.10; // 10% discount
     private DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
     private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
     
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
             try {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             } catch (Exception e) {
                 System.err.println("Could not set look and feel: " + e.getMessage());
             }
             new LashBizPro();
         });
     }
     
     public LashBizPro() {
         fvInitializeCollections();
         fvSetupGUI();
         fvInitializeDefaultData();
         setVisible(true);
     }
     
     // Method 1: Initialize all collections
     private void fvInitializeCollections() {
         hmClientAppointments = new HashMap<>();
         hmClientLoyaltyCount = new HashMap<>();
         alAllAppointments = new ArrayList<>();
         qRecentActivities = new LinkedList<>();
         hsClientNames = new HashSet<>();
     }
     
     // Method 2: Setup the main GUI
     private void fvSetupGUI() {
         setTitle("LashBiz Pro - Professional Appointment & Income Tracker");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
         
         // Create main tabbed pane
         JTabbedPane tabbedPane = new JTabbedPane();
         
         // Tab 1: Appointment Booking
         tabbedPane.addTab("Book Appointment", fvCreateBookingPanel());
         
         // Tab 2: Client History & Reports
         tabbedPane.addTab("Client History", fvCreateHistoryPanel());
         
         // Tab 3: Income Analytics
         tabbedPane.addTab("Income Analytics", fvCreateAnalyticsPanel());
         
         // Tab 4: Settings & Data
         tabbedPane.addTab("Data Management", fvCreateDataPanel());
         
         add(tabbedPane, BorderLayout.CENTER);
         
         // Status bar
         JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
         pnlStatus.setBorder(BorderFactory.createLoweredBevelBorder());
         JLabel lblStatus = new JLabel("LashBiz Pro Ready - Book your first appointment!");
         pnlStatus.add(lblStatus);
         add(pnlStatus, BorderLayout.SOUTH);
         
         setSize(900, 700);
         setLocationRelativeTo(null);
         setResizable(true);
     }
     
     // Method 3: Create booking panel
     private JPanel fvCreateBookingPanel() {
         JPanel panel = new JPanel(new BorderLayout(10, 10));
         panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
         
         // Input form
         JPanel pnlForm = new JPanel(new GridBagLayout());
         pnlForm.setBorder(new TitledBorder("New Appointment Details"));
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(8, 8, 8, 8);
         gbc.anchor = GridBagConstraints.WEST;
         
         // Client name
         gbc.gridx = 0; gbc.gridy = 0;
         pnlForm.add(new JLabel("Client Name:"), gbc);
         gbc.gridx = 1; gbc.gridwidth = 2;
         tfClientName = new JTextField(20);
         pnlForm.add(tfClientName, gbc);
         
         // Service type
         gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
         pnlForm.add(new JLabel("Service Type:"), gbc);
         gbc.gridx = 1; gbc.gridwidth = 2;
         cbServiceType = new JComboBox<>(ServiceType.values());
         cbServiceType.addActionListener(e -> fvUpdatePriceForService());
         pnlForm.add(cbServiceType, gbc);
         
         // Date
         gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
         pnlForm.add(new JLabel("Date (yyyy-mm-dd):"), gbc);
         gbc.gridx = 1; gbc.gridwidth = 2;
         tfAppointmentDate = new JTextField(15);
         tfAppointmentDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         pnlForm.add(tfAppointmentDate, gbc);
         
         // Custom price
         gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
         pnlForm.add(new JLabel("Custom Price:"), gbc);
         gbc.gridx = 1; gbc.gridwidth = 2;
         tfCustomPrice = new JTextField(10);
         pnlForm.add(tfCustomPrice, gbc);
         
         // Client type radio buttons
         gbc.gridx = 0; gbc.gridy = 4;
         pnlForm.add(new JLabel("Client Type:"), gbc);
         gbc.gridx = 1; gbc.gridwidth = 2;
         JPanel pnlRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
         rbNewClient = new JRadioButton("New Client", true);
         rbReturningClient = new JRadioButton("Returning Client");
         ButtonGroup bgClientType = new ButtonGroup();
         bgClientType.add(rbNewClient);
         bgClientType.add(rbReturningClient);
         pnlRadio.add(rbNewClient);
         pnlRadio.add(rbReturningClient);
         pnlForm.add(pnlRadio, gbc);
         
         // Loyalty discount checkbox
         gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 3;
         chkLoyaltyDiscount = new JCheckBox("Apply Loyalty Discount (10% off)");
         chkLoyaltyDiscount.setEnabled(false);
         pnlForm.add(chkLoyaltyDiscount, gbc);
         
         // Notes
         gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 1;
         pnlForm.add(new JLabel("Notes:"), gbc);
         gbc.gridx = 1; gbc.gridwidth = 2;
         tfNotes = new JTextField(25);
         pnlForm.add(tfNotes, gbc);
         
         // Buttons
         gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 3;
         JPanel pnlButtons = new JPanel(new FlowLayout());
         btnAddAppointment = new JButton("Book Appointment");
         btnAddAppointment.addActionListener(this);
         btnAddAppointment.setBackground(new Color(76, 175, 80));
         btnAddAppointment.setForeground(Color.BLACK);
         btnAddAppointment.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
         pnlButtons.add(btnAddAppointment);
         
         JButton btnClear = new JButton("Clear Form");
         btnClear.addActionListener(e -> fvClearBookingForm());
         pnlButtons.add(btnClear);
         
         pnlForm.add(pnlButtons, gbc);
         
         panel.add(pnlForm, BorderLayout.NORTH);
         
         // Recent activities
         JPanel pnlRecent = new JPanel(new BorderLayout());
         pnlRecent.setBorder(new TitledBorder("Recent Activities"));
         taResults = new JTextArea(8, 40);
         taResults.setEditable(false);
         taResults.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
         JScrollPane scrollRecent = new JScrollPane(taResults);
         pnlRecent.add(scrollRecent, BorderLayout.CENTER);
         
         panel.add(pnlRecent, BorderLayout.CENTER);
         
         return panel;
     }
     
     // Method 4: Create history panel
     private JPanel fvCreateHistoryPanel() {
         JPanel panel = new JPanel(new BorderLayout(10, 10));
         panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
         
         // Filter panel
         JPanel pnlFilters = new JPanel(new FlowLayout(FlowLayout.LEFT));
         pnlFilters.setBorder(new TitledBorder("Filters"));
         
         pnlFilters.add(new JLabel("Client:"));
         tfClientFilter = new JTextField(15);
         pnlFilters.add(tfClientFilter);
         
         pnlFilters.add(new JLabel("Start Date:"));
         tfStartDate = new JTextField(10);
         pnlFilters.add(tfStartDate);
         
         pnlFilters.add(new JLabel("End Date:"));
         tfEndDate = new JTextField(10);
         pnlFilters.add(tfEndDate);
         
         btnApplyFilters = new JButton("Apply Filters");
         btnApplyFilters.addActionListener(this);
         pnlFilters.add(btnApplyFilters);
         
         btnViewClientHistory = new JButton("View All History");
         btnViewClientHistory.addActionListener(this);
         pnlFilters.add(btnViewClientHistory);
         
         panel.add(pnlFilters, BorderLayout.NORTH);
         
         // Table for appointments
         String[] columnNames = {"Date", "Client", "Service", "Price", "Notes", "Loyalty"};
         tmAppointments = new DefaultTableModel(columnNames, 0) {
             @Override
             public boolean isCellEditable(int row, int column) {
                 return false;
             }
         };
         tblAppointments = new JTable(tmAppointments);
         tblAppointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         tblAppointments.getTableHeader().setReorderingAllowed(false);
         
         JScrollPane scrollTable = new JScrollPane(tblAppointments);
         scrollTable.setPreferredSize(new Dimension(800, 400));
         panel.add(scrollTable, BorderLayout.CENTER);
         
         return panel;
     }
     
     // Method 5: Create analytics panel
     private JPanel fvCreateAnalyticsPanel() {
         JPanel panel = new JPanel(new BorderLayout(10, 10));
         panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
         
         // Income calculation controls
         JPanel pnlControls = new JPanel(new FlowLayout());
         pnlControls.setBorder(new TitledBorder("Income Analysis"));
         
         btnCalculateIncome = new JButton("Calculate Total Income");
         btnCalculateIncome.addActionListener(this);
         pnlControls.add(btnCalculateIncome);
         
         btnGenerateReport = new JButton("Generate Detailed Report");
         btnGenerateReport.addActionListener(this);
         pnlControls.add(btnGenerateReport);
         
         panel.add(pnlControls, BorderLayout.NORTH);
         
         // Results area - Fixed to store reference in class field
         taAnalytics = new JTextArea(25, 60);
         taAnalytics.setEditable(false);
         taAnalytics.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
         taAnalytics.setText("Click 'Calculate Total Income' or 'Generate Detailed Report' to view analytics...");
         JScrollPane scrollAnalytics = new JScrollPane(taAnalytics);
         panel.add(scrollAnalytics, BorderLayout.CENTER);
         
         return panel;
     }
     
     // Method 6: Create data management panel
     private JPanel fvCreateDataPanel() {
         JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
         panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
         
         // Data operations
         JPanel pnlData = new JPanel(new FlowLayout());
         pnlData.setBorder(new TitledBorder("Data Management"));
         
         btnSaveData = new JButton("Save All Data");
         btnSaveData.addActionListener(this);
         pnlData.add(btnSaveData);
         
         btnLoadData = new JButton("Load Data");
         btnLoadData.addActionListener(this);
         pnlData.add(btnLoadData);
         
         btnClearAll = new JButton("Clear All Data");
         btnClearAll.addActionListener(this);
         btnClearAll.setBackground(new Color(244, 67, 54));
         btnClearAll.setForeground(Color.BLACK);
         pnlData.add(btnClearAll);
         
         panel.add(pnlData);
         
         // Statistics panel - Fixed to store reference in class field
         JPanel pnlStats = new JPanel(new BorderLayout());
         pnlStats.setBorder(new TitledBorder("Business Statistics"));
         
         taStats = new JTextArea(15, 50);
         taStats.setEditable(false);
         taStats.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
         JScrollPane scrollStats = new JScrollPane(taStats);
         pnlStats.add(scrollStats, BorderLayout.CENTER);
         
         panel.add(pnlStats);
         
         return panel;
     }
     
     // Method 7: Initialize default data
     private void fvInitializeDefaultData() {
         fvUpdatePriceForService();
         fvAddToRecentActivities("LashBiz Pro initialized and ready for appointments");
         fvUpdateResultsDisplay("Welcome to LashBiz Pro!\nBook your first appointment to get started.");
         fvUpdateBusinessStatistics(); // Initialize business statistics display
     }
     
     // Method 8: Main action event handler
     @Override
     public void actionPerformed(ActionEvent e) {
         try {
             if (e.getSource() == btnAddAppointment) {
                 fvProcessNewAppointment();
             } else if (e.getSource() == btnViewClientHistory) {
                 fvDisplayAllAppointments();
             } else if (e.getSource() == btnCalculateIncome) {
                 fvCalculateAndDisplayIncome();
             } else if (e.getSource() == btnGenerateReport) {
                 fvGenerateDetailedReport();
             } else if (e.getSource() == btnApplyFilters) {
                 fvApplyFiltersToHistory();
             } else if (e.getSource() == btnSaveData) {
                 fvSaveAllData();
             } else if (e.getSource() == btnLoadData) {
                 fvLoadAllData();
             } else if (e.getSource() == btnClearAll) {
                 fvClearAllData();
             }
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, 
                 "Error: " + ex.getMessage(), 
                 "Application Error", 
                 JOptionPane.ERROR_MESSAGE);
         }
     }
     
     // Method 9: Process new appointment with comprehensive validation
     private void fvProcessNewAppointment() {
         // Recursive validation of all inputs
         if (!fbValidateAppointmentInputRecursive(0)) {
             return;
         }
         
         String sClientName = tfClientName.getText().trim().toLowerCase();
         ServiceType serviceType = (ServiceType) cbServiceType.getSelectedItem();
         String sDate = tfAppointmentDate.getText().trim();
         String sNotes = tfNotes.getText().trim();
         boolean bIsNewClient = rbNewClient.isSelected();
         
         // Calculate price with loyalty discount if applicable
         double dPrice = fdCalculateFinalPrice(sClientName, serviceType);
         
         // Create appointment
         Appointment appointment = new Appointment(sClientName, serviceType, sDate, dPrice, sNotes, bIsNewClient);
         
         // Add to collections
         alAllAppointments.add(appointment);
         
         // Update client appointments map
         hmClientAppointments.computeIfAbsent(sClientName, k -> new ArrayList<>()).add(appointment);
         
         // Update loyalty count
         hmClientLoyaltyCount.put(sClientName, hmClientLoyaltyCount.getOrDefault(sClientName, 0) + 1);
         
         // Add to client names set
         hsClientNames.add(sClientName);
         
         // Update displays
         fvAddToRecentActivities("Appointment booked: " + sClientName + " - " + serviceType + " - " + dfCurrency.format(dPrice));
         fvDisplayAllAppointments();
         fvClearBookingForm();
         fvUpdateBusinessStatistics(); // Update business statistics after new appointment
         
         // Success message
         String sMessage = "Appointment booked successfully for " + sClientName + "!\n" +
                          "Service: " + serviceType + "\n" +
                          "Price: " + dfCurrency.format(dPrice);
         
         // Check loyalty milestone
         int iLoyaltyCount = hmClientLoyaltyCount.get(sClientName);
         if (iLoyaltyCount % LOYALTY_THRESHOLD == 0) {
             sMessage += "\n🎉 " + sClientName + " has reached " + iLoyaltyCount + " appointments! Loyalty discount unlocked!";
         }
         
         JOptionPane.showMessageDialog(this, sMessage, "Appointment Confirmed", JOptionPane.INFORMATION_MESSAGE);
     }
     
     // Method 10: Recursive input validation (satisfies recursion requirement)
     private boolean fbValidateAppointmentInputRecursive(int iFieldIndex) {
         String[] asFieldNames = {"Client Name", "Date", "Service Type"};
         String[] asFieldValues = {
             tfClientName.getText().trim(),
             tfAppointmentDate.getText().trim(),
             cbServiceType.getSelectedItem().toString()
         };
         
         // Base case: all fields validated
         if (iFieldIndex >= asFieldNames.length) {
             return true;
         }
         
         // Validate current field
         if (!fbValidatePresence(asFieldValues[iFieldIndex], asFieldNames[iFieldIndex])) {
             return false;
         }
         
         // Special validation for date
         if (iFieldIndex == 1) {
             if (!fbValidateDateFormat(asFieldValues[iFieldIndex])) {
                 return false;
             }
         }
         
         // Recursive call for next field
         return fbValidateAppointmentInputRecursive(iFieldIndex + 1);
     }
     
     // Method 11: Calculate final price with loyalty discount
     private double fdCalculateFinalPrice(String psClientName, ServiceType pServiceType) {
         double dBasePrice;
         
         // Use custom price if provided, otherwise use service default
         String sCustomPrice = tfCustomPrice.getText().trim();
         if (!sCustomPrice.isEmpty()) {
             try {
                 dBasePrice = Double.parseDouble(sCustomPrice);
             } catch (NumberFormatException e) {
                 dBasePrice = pServiceType.fdGetPrice();
             }
         } else {
             dBasePrice = pServiceType.fdGetPrice();
         }
         
         // Apply loyalty discount if eligible and checkbox is checked
         if (chkLoyaltyDiscount.isSelected()) {
             return dBasePrice * (1.0 - LOYALTY_DISCOUNT);
         }
         
         return dBasePrice;
     }
     
     // Method 12: Update price when service changes
     private void fvUpdatePriceForService() {
         ServiceType selectedService = (ServiceType) cbServiceType.getSelectedItem();
         if (selectedService != null) {
             tfCustomPrice.setText(String.valueOf(selectedService.fdGetPrice()));
             
             // Check if loyalty discount should be enabled
             String sClientName = tfClientName.getText().trim().toLowerCase();
             if (!sClientName.isEmpty() && hmClientLoyaltyCount.containsKey(sClientName)) {
                 int iLoyaltyCount = hmClientLoyaltyCount.get(sClientName);
                 chkLoyaltyDiscount.setEnabled(iLoyaltyCount >= LOYALTY_THRESHOLD);
             }
         }
     }
     
     // Method 13: Display all appointments in table
     private void fvDisplayAllAppointments() {
         tmAppointments.setRowCount(0);
         
         for (Appointment appointment : alAllAppointments) {
             Object[] rowData = {
                 appointment.fsGetDate(),
                 appointment.fsGetClientName(),
                 appointment.fsGetService(),
                 dfCurrency.format(appointment.fdGetPrice()),
                 appointment.fsGetNotes(),
                 hmClientLoyaltyCount.getOrDefault(appointment.fsGetClientName(), 0) + " visits"
             };
             tmAppointments.addRow(rowData);
         }
     }
     
     // Method 14: Calculate and display total income - FIXED
     private void fvCalculateAndDisplayIncome() {
         double dTotalIncome = fdCalculateTotalIncomeRecursive(alAllAppointments, 0, 0.0);
         
         StringBuilder sbIncome = new StringBuilder();
         sbIncome.append("=== INCOME ANALYSIS ===\n");
         sbIncome.append("Total Appointments: ").append(alAllAppointments.size()).append("\n");
         sbIncome.append("Total Income: ").append(dfCurrency.format(dTotalIncome)).append("\n");
         sbIncome.append("Average per Appointment: ").append(
             alAllAppointments.size() > 0 ? dfCurrency.format(dTotalIncome / alAllAppointments.size()) : "$0.00"
         ).append("\n\n");
         
         // Income by service type
         Map<ServiceType, Double> hmServiceIncome = new HashMap<>();
         Map<ServiceType, Integer> hmServiceCount = new HashMap<>();
         
         for (Appointment apt : alAllAppointments) {
             ServiceType service = apt.fsGetService();
             hmServiceIncome.put(service, hmServiceIncome.getOrDefault(service, 0.0) + apt.fdGetPrice());
             hmServiceCount.put(service, hmServiceCount.getOrDefault(service, 0) + 1);
         }
         
         sbIncome.append("INCOME BY SERVICE TYPE:\n");
         for (ServiceType service : ServiceType.values()) {
             double dIncome = hmServiceIncome.getOrDefault(service, 0.0);
             int iCount = hmServiceCount.getOrDefault(service, 0);
             if (iCount > 0) {
                 sbIncome.append(String.format("%-15s: %s (%d appointments)\n", 
                     service, dfCurrency.format(dIncome), iCount));
             }
         }
         
         // Update analytics display instead of recent activities
         fvUpdateAnalyticsDisplay(sbIncome.toString());
         
         // Also update recent activities with brief summary
         fvAddToRecentActivities("Income calculated - Total: " + dfCurrency.format(dTotalIncome));
     }
     
     // Method 15: Recursive income calculation (satisfies recursion requirement)
     private double fdCalculateTotalIncomeRecursive(List<Appointment> palAppointments, int piIndex, double pdAccumulator) {
         // Base case: processed all appointments
         if (piIndex >= palAppointments.size()) {
             return pdAccumulator;
         }
         
         // Recursive case: add current appointment price and continue
         return fdCalculateTotalIncomeRecursive(palAppointments, piIndex + 1, 
                                              pdAccumulator + palAppointments.get(piIndex).fdGetPrice());
     }
     
     // Method 16: Generate detailed business report - FIXED
     private void fvGenerateDetailedReport() {
         StringBuilder sbReport = new StringBuilder();
         sbReport.append("=== LASHBIZ PRO BUSINESS REPORT ===\n");
         sbReport.append("Generated: ").append(new Date()).append("\n\n");
         
         // Overview statistics
         sbReport.append("BUSINESS OVERVIEW:\n");
         sbReport.append("Total Clients: ").append(hsClientNames.size()).append("\n");
         sbReport.append("Total Appointments: ").append(alAllAppointments.size()).append("\n");
         sbReport.append("Total Revenue: ").append(dfCurrency.format(fdCalculateTotalIncomeRecursive(alAllAppointments, 0, 0.0))).append("\n\n");
         
         // Top clients by visits
         sbReport.append("TOP CLIENTS BY VISITS:\n");
         hmClientLoyaltyCount.entrySet().stream()
             .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
             .limit(5)
             .forEach(entry -> sbReport.append(String.format("%-20s: %d visits\n", 
                 entry.getKey(), entry.getValue())));
         
         sbReport.append("\nLOYALTY PROGRAM STATUS:\n");
         for (Map.Entry<String, Integer> entry : hmClientLoyaltyCount.entrySet()) {
             if (entry.getValue() >= LOYALTY_THRESHOLD) {
                 sbReport.append("✅ ").append(entry.getKey()).append(" - VIP Customer (").append(entry.getValue()).append(" visits)\n");
             }
         }
         
         // Service type analysis
         sbReport.append("\nSERVICE TYPE BREAKDOWN:\n");
         Map<ServiceType, Integer> hmServiceCount = new HashMap<>();
         for (Appointment apt : alAllAppointments) {
             ServiceType service = apt.fsGetService();
             hmServiceCount.put(service, hmServiceCount.getOrDefault(service, 0) + 1);
         }
         
         for (ServiceType service : ServiceType.values()) {
             int iCount = hmServiceCount.getOrDefault(service, 0);
             if (iCount > 0) {
                 double dPercentage = (double) iCount / alAllAppointments.size() * 100;
                 sbReport.append(String.format("%-20s: %d appointments (%.1f%%)\n", 
                     service, iCount, dPercentage));
             }
         }
         
         // Recent activities
         sbReport.append("\nRECENT ACTIVITIES:\n");
         for (String activity : qRecentActivities) {
             sbReport.append("• ").append(activity).append("\n");
         }
         
         // Update analytics display instead of recent activities
         fvUpdateAnalyticsDisplay(sbReport.toString());
         
         // Also update recent activities with brief summary
         fvAddToRecentActivities("Detailed business report generated");
     }
     
     // Method 17: Validate presence of required fields
     private boolean fbValidatePresence(String psValue, String psFieldName) {
         if (psValue == null || psValue.trim().isEmpty()) {
             JOptionPane.showMessageDialog(this, 
                 psFieldName + " is required and cannot be empty", 
                 "Required Field Missing", 
                 JOptionPane.ERROR_MESSAGE);
             return false;
         }
         return true;
     }
     
     // Method 18: Validate date format
     private boolean fbValidateDateFormat(String psDate) {
         try {
             sdfDate.parse(psDate);
             return true;
         } catch (ParseException e) {
             JOptionPane.showMessageDialog(this, 
                 "Please enter date in yyyy-mm-dd format", 
                 "Invalid Date Format", 
                 JOptionPane.ERROR_MESSAGE);
             return false;
         }
     }
     
     // Method 19: Apply filters to appointment history
     private void fvApplyFiltersToHistory() {
         String sClientFilter = tfClientFilter.getText().trim().toLowerCase();
         String sStartDate = tfStartDate.getText().trim();
         String sEndDate = tfEndDate.getText().trim();
         
         tmAppointments.setRowCount(0);
         
         for (Appointment appointment : alAllAppointments) {
             boolean bShowAppointment = true;
             
             // Client filter
             if (!sClientFilter.isEmpty() && !appointment.fsGetClientName().contains(sClientFilter)) {
                 bShowAppointment = false;
             }
             
             // Date range filter
             if (!sStartDate.isEmpty() || !sEndDate.isEmpty()) {
                 try {
                     Date aptDate = sdfDate.parse(appointment.fsGetDate());
                     
                     if (!sStartDate.isEmpty()) {
                         Date startDate = sdfDate.parse(sStartDate);
                         if (aptDate.before(startDate)) {
                             bShowAppointment = false;
                         }
                     }
                     
                     if (!sEndDate.isEmpty()) {
                         Date endDate = sdfDate.parse(sEndDate);
                         if (aptDate.after(endDate)) {
                             bShowAppointment = false;
                         }
                     }
                 } catch (ParseException e) {
                     // Skip date filtering if dates are invalid
                 }
             }
             
             if (bShowAppointment) {
                 Object[] rowData = {
                     appointment.fsGetDate(),
                     appointment.fsGetClientName(),
                     appointment.fsGetService(),
                     dfCurrency.format(appointment.fdGetPrice()),
                     appointment.fsGetNotes(),
                     hmClientLoyaltyCount.getOrDefault(appointment.fsGetClientName(), 0) + " visits"
                 };
                 tmAppointments.addRow(rowData);
             }
         }
     }
     
     // Method 20: Save all data to file
     private void fvSaveAllData() {
         try (PrintWriter writer = new PrintWriter(new FileWriter("lashbiz_data.txt"))) {
             writer.println("# LashBiz Pro Data Export");
             writer.println("# Generated: " + new Date());
             writer.println();
             
             for (Appointment appointment : alAllAppointments) {
                 writer.println(appointment.fsToFileString());
             }
             
             JOptionPane.showMessageDialog(this, 
                 "Data saved successfully to lashbiz_data.txt");
             fvAddToRecentActivities("Data exported to file");
             fvUpdateBusinessStatistics(); // Update stats after save
             
         } catch (IOException e) {
             JOptionPane.showMessageDialog(this, 
                 "Error saving data: " + e.getMessage(), 
                 "Save Error", 
                 JOptionPane.ERROR_MESSAGE);
         }
     }
     
     // Method 21: Load all data from file
     private void fvLoadAllData() {
         try (BufferedReader reader = new BufferedReader(new FileReader("lashbiz_data.txt"))) {
             // Clear existing data
             alAllAppointments.clear();
             hmClientAppointments.clear();
             hmClientLoyaltyCount.clear();
             hsClientNames.clear();
             
             String sLine;
             int iLoadedCount = 0;
             
             while ((sLine = reader.readLine()) != null) {
                 if (!sLine.startsWith("#") && !sLine.trim().isEmpty()) {
                     Appointment appointment = Appointment.fsFromFileString(sLine);
                     if (appointment != null) {
                         alAllAppointments.add(appointment);
                         
                         String sClientName = appointment.fsGetClientName();
                         hmClientAppointments.computeIfAbsent(sClientName, k -> new ArrayList<>()).add(appointment);
                         hmClientLoyaltyCount.put(sClientName, hmClientLoyaltyCount.getOrDefault(sClientName, 0) + 1);
                         hsClientNames.add(sClientName);
                         
                         iLoadedCount++;
                     }
                 }
             }
             
             fvDisplayAllAppointments();
             fvAddToRecentActivities("Loaded " + iLoadedCount + " appointments from file");
             fvUpdateBusinessStatistics(); // Update stats after load
             JOptionPane.showMessageDialog(this, 
                 "Loaded " + iLoadedCount + " appointments successfully");
             
         } catch (FileNotFoundException e) {
             JOptionPane.showMessageDialog(this, 
                 "No saved data file found (lashbiz_data.txt)", 
                 "File Not Found", 
                 JOptionPane.INFORMATION_MESSAGE);
         } catch (IOException e) {
             JOptionPane.showMessageDialog(this, 
                 "Error loading data: " + e.getMessage(), 
                 "Load Error", 
                 JOptionPane.ERROR_MESSAGE);
         }
     }
     
     // Method 22: Clear all application data
     private void fvClearAllData() {
         int iResult = JOptionPane.showConfirmDialog(this,
             "Are you sure you want to clear all appointment data?\nThis action cannot be undone.",
             "Confirm Clear All Data", 
             JOptionPane.YES_NO_OPTION,
             JOptionPane.WARNING_MESSAGE);
         
         if (iResult == JOptionPane.YES_OPTION) {
             alAllAppointments.clear();
             hmClientAppointments.clear();
             hmClientLoyaltyCount.clear();
             hsClientNames.clear();
             qRecentActivities.clear();
             
             tmAppointments.setRowCount(0);
             fvClearBookingForm();
             fvUpdateResultsDisplay("All data cleared. Ready for new appointments.");
             fvUpdateAnalyticsDisplay("All data cleared. Analytics will appear when data is available.");
             fvUpdateBusinessStatistics(); // Update stats after clear
             
             JOptionPane.showMessageDialog(this, "All appointment data has been cleared.");
         }
     }
     
     // Method 23: Clear booking form
     private void fvClearBookingForm() {
         tfClientName.setText("");
         tfCustomPrice.setText("");
         tfNotes.setText("");
         rbNewClient.setSelected(true);
         chkLoyaltyDiscount.setSelected(false);
         chkLoyaltyDiscount.setEnabled(false);
         cbServiceType.setSelectedIndex(0);
         fvUpdatePriceForService();
     }
     
     // Method 24: Add activity to recent activities queue
     private void fvAddToRecentActivities(String psActivity) {
         String sTimestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
         qRecentActivities.offer("[" + sTimestamp + "] " + psActivity);
         
         // Keep only last 10 activities
         while (qRecentActivities.size() > 10) {
             qRecentActivities.poll();
         }
         
         // Update display
         StringBuilder sbActivities = new StringBuilder();
         sbActivities.append("Recent Activities:\n");
         for (String activity : qRecentActivities) {
             sbActivities.append(activity).append("\n");
         }
         
         fvUpdateResultsDisplay(sbActivities.toString());
     }
     
     // Method 25: Update results display area
     private void fvUpdateResultsDisplay(String psText) {
         taResults.setText(psText);
         taResults.setCaretPosition(0);
     }
     
     // NEW Method 26: Update analytics display area
     private void fvUpdateAnalyticsDisplay(String psText) {
         taAnalytics.setText(psText);
         taAnalytics.setCaretPosition(0);
     }
     
     // NEW Method 27: Update business statistics display
     private void fvUpdateBusinessStatistics() {
         StringBuilder sbStats = new StringBuilder();
         sbStats.append("=== BUSINESS STATISTICS ===\n");
         sbStats.append("Last Updated: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n\n");
         
         if (alAllAppointments.isEmpty()) {
             sbStats.append("No appointment data available yet.\n");
             sbStats.append("Book your first appointment to see statistics here!\n");
         } else {
             // Basic statistics
             double dTotalRevenue = fdCalculateTotalIncomeRecursive(alAllAppointments, 0, 0.0);
             sbStats.append("OVERVIEW:\n");
             sbStats.append("Total Clients: ").append(hsClientNames.size()).append("\n");
             sbStats.append("Total Appointments: ").append(alAllAppointments.size()).append("\n");
             sbStats.append("Total Revenue: ").append(dfCurrency.format(dTotalRevenue)).append("\n");
             sbStats.append("Average Revenue per Appointment: ").append(dfCurrency.format(dTotalRevenue / alAllAppointments.size())).append("\n");
             sbStats.append("Average Appointments per Client: ").append(String.format("%.1f", (double) alAllAppointments.size() / hsClientNames.size())).append("\n\n");
             
             // Loyalty statistics
             sbStats.append("LOYALTY PROGRAM:\n");
             int iVipClients = 0;
             for (Integer visits : hmClientLoyaltyCount.values()) {
                 if (visits >= LOYALTY_THRESHOLD) {
                     iVipClients++;
                 }
             }
             sbStats.append("VIP Clients (5+ visits): ").append(iVipClients).append("\n");
             sbStats.append("Regular Clients: ").append(hsClientNames.size() - iVipClients).append("\n");
             if (hsClientNames.size() > 0) {
                 sbStats.append("VIP Client Percentage: ").append(String.format("%.1f%%", (double) iVipClients / hsClientNames.size() * 100)).append("\n");
             }
             sbStats.append("\n");
             
             // Service popularity
             sbStats.append("MOST POPULAR SERVICES:\n");
             Map<ServiceType, Integer> hmServiceCount = new HashMap<>();
             for (Appointment apt : alAllAppointments) {
                 ServiceType service = apt.fsGetService();
                 hmServiceCount.put(service, hmServiceCount.getOrDefault(service, 0) + 1);
             }
             
             hmServiceCount.entrySet().stream()
                 .sorted(Map.Entry.<ServiceType, Integer>comparingByValue().reversed())
                 .limit(3)
                 .forEach(entry -> {
                     double dPercentage = (double) entry.getValue() / alAllAppointments.size() * 100;
                     sbStats.append(String.format("%-20s: %d appointments (%.1f%%)\n", 
                         entry.getKey(), entry.getValue(), dPercentage));
                 });
             
             sbStats.append("\n");
             
             // Top clients
             sbStats.append("TOP CLIENTS:\n");
             hmClientLoyaltyCount.entrySet().stream()
                 .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                 .limit(3)
                 .forEach(entry -> sbStats.append(String.format("%-20s: %d visits\n", 
                     entry.getKey(), entry.getValue())));
         }
         
         taStats.setText(sbStats.toString());
         taStats.setCaretPosition(0);
     }
 }