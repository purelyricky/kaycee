The issue is that all the results are being displayed in the "Recent Activities" area of the Book Appointment tab instead of their respective tabs. Let me fix this by updating the code to display results in the correct tabs.

Here are the key changes needed:

## Updated Main Class with Fixed Display Areas

Replace the relevant parts of your `LashBizPro.java` with these corrections:

### 1. Add separate text area variables (add these after the existing GUI component declarations):

```java
// Separate text areas for different tabs
private JTextArea taResults;      // For booking tab (recent activities)
private JTextArea taAnalytics;    // For analytics tab
private JTextArea taStats;        // For data management tab
```

### 2. Update the `fvCreateAnalyticsPanel()` method:

```java
// Method 5: Create analytics panel (UPDATED)
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
    
    // Results area - FIXED: Now properly assigned to class variable
    taAnalytics = new JTextArea(25, 60);
    taAnalytics.setEditable(false);
    taAnalytics.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    taAnalytics.setText("Welcome to Income Analytics!\n\nClick 'Calculate Total Income' or 'Generate Detailed Report' to view your business insights.");
    JScrollPane scrollAnalytics = new JScrollPane(taAnalytics);
    panel.add(scrollAnalytics, BorderLayout.CENTER);
    
    return panel;
}
```

### 3. Update the `fvCreateDataPanel()` method:

```java
// Method 6: Create data management panel (UPDATED)
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
    
    JButton btnShowStats = new JButton("Show Business Statistics");
    btnShowStats.addActionListener(e -> fvDisplayBusinessStatistics());
    pnlData.add(btnShowStats);
    
    panel.add(pnlData);
    
    // Statistics panel - FIXED: Now properly assigned to class variable
    JPanel pnlStats = new JPanel(new BorderLayout());
    pnlStats.setBorder(new TitledBorder("Business Statistics"));
    
    taStats = new JTextArea(15, 50);
    taStats.setEditable(false);
    taStats.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    taStats.setText("Business Statistics will appear here.\n\nUse the buttons above to manage your data or click 'Show Business Statistics' to view detailed analytics.");
    JScrollPane scrollStats = new JScrollPane(taStats);
    pnlStats.add(scrollStats, BorderLayout.CENTER);
    
    panel.add(pnlStats);
    
    return panel;
}
```

### 4. Add new update methods for different tabs:

```java
// Method 26: Update analytics display area
private void fvUpdateAnalyticsDisplay(String psText) {
    taAnalytics.setText(psText);
    taAnalytics.setCaretPosition(0);
}

// Method 27: Update statistics display area
private void fvUpdateStatsDisplay(String psText) {
    taStats.setText(psText);
    taStats.setCaretPosition(0);
}

// Method 28: Display business statistics in data management tab
private void fvDisplayBusinessStatistics() {
    StringBuilder sbStats = new StringBuilder();
    sbStats.append("=== BUSINESS STATISTICS ===\n");
    sbStats.append("Generated: ").append(new Date()).append("\n\n");
    
    // Basic stats
    sbStats.append("OVERVIEW:\n");
    sbStats.append("Total Clients: ").append(hsClientNames.size()).append("\n");
    sbStats.append("Total Appointments: ").append(alAllAppointments.size()).append("\n");
    sbStats.append("Unique Services Offered: ").append(ServiceType.values().length).append("\n\n");
    
    // Average metrics
    if (alAllAppointments.size() > 0) {
        double dTotalRevenue = fdCalculateTotalIncomeRecursive(alAllAppointments, 0, 0.0);
        sbStats.append("Total Revenue: ").append(dfCurrency.format(dTotalRevenue)).append("\n");
        sbStats.append("Average Revenue per Appointment: ").append(dfCurrency.format(dTotalRevenue / alAllAppointments.size())).append("\n");
        sbStats.append("Average Appointments per Client: ").append(String.format("%.1f", (double)alAllAppointments.size() / hsClientNames.size())).append("\n\n");
    }
    
    // Client loyalty breakdown
    sbStats.append("CLIENT LOYALTY BREAKDOWN:\n");
    int iVipClients = 0;
    int iRegularClients = 0;
    int iNewClients = 0;
    
    for (Map.Entry<String, Integer> entry : hmClientLoyaltyCount.entrySet()) {
        int visits = entry.getValue();
        if (visits >= LOYALTY_THRESHOLD) {
            iVipClients++;
        } else if (visits > 1) {
            iRegularClients++;
        } else {
            iNewClients++;
        }
    }
    
    sbStats.append("VIP Clients (").append(LOYALTY_THRESHOLD).append("+ visits): ").append(iVipClients).append("\n");
    sbStats.append("Regular Clients (2+ visits): ").append(iRegularClients).append("\n");
    sbStats.append("New Clients (1 visit): ").append(iNewClients).append("\n\n");
    
    // Service popularity
    Map<ServiceType, Integer> hmServiceCount = new HashMap<>();
    for (Appointment apt : alAllAppointments) {
        ServiceType service = apt.fsGetService();
        hmServiceCount.put(service, hmServiceCount.getOrDefault(service, 0) + 1);
    }
    
    sbStats.append("MOST POPULAR SERVICES:\n");
    hmServiceCount.entrySet().stream()
        .sorted(Map.Entry.<ServiceType, Integer>comparingByValue().reversed())
        .limit(5)
        .forEach(entry -> sbStats.append(String.format("%-20s: %d bookings\n", 
            entry.getKey().fsGetDisplayName(), entry.getValue())));
    
    fvUpdateStatsDisplay(sbStats.toString());
}
```

### 5. Update the income calculation methods to use the analytics display:

```java
// Method 14: Calculate and display total income (UPDATED)
private void fvCalculateAndDisplayIncome() {
    double dTotalIncome = fdCalculateTotalIncomeRecursive(alAllAppointments, 0, 0.0);
    
    StringBuilder sbIncome = new StringBuilder();
    sbIncome.append("=== INCOME ANALYSIS ===\n");
    sbIncome.append("Generated: ").append(new Date()).append("\n\n");
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
            sbIncome.append(String.format("%-20s: %s (%d appointments)\n", 
                service.fsGetDisplayName(), dfCurrency.format(dIncome), iCount));
        }
    }
    
    // Monthly breakdown if we have appointments
    if (alAllAppointments.size() > 0) {
        sbIncome.append("\nRECENT PERFORMANCE:\n");
        
        // Get current month income
        String sCurrentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        double dCurrentMonthIncome = 0;
        int iCurrentMonthAppointments = 0;
        
        for (Appointment apt : alAllAppointments) {
            if (apt.fsGetDate().startsWith(sCurrentMonth)) {
                dCurrentMonthIncome += apt.fdGetPrice();
                iCurrentMonthAppointments++;
            }
        }
        
        sbIncome.append("Current Month (").append(sCurrentMonth).append("):\n");
        sbIncome.append("  Income: ").append(dfCurrency.format(dCurrentMonthIncome)).append("\n");
        sbIncome.append("  Appointments: ").append(iCurrentMonthAppointments).append("\n");
    }
    
    // FIXED: Use analytics display instead of results display
    fvUpdateAnalyticsDisplay(sbIncome.toString());
}

// Method 16: Generate detailed business report (UPDATED)
private void fvGenerateDetailedReport() {
    StringBuilder sbReport = new StringBuilder();
    sbReport.append("=== LASHBIZ PRO DETAILED BUSINESS REPORT ===\n");
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
        .limit(10)
        .forEach(entry -> sbReport.append(String.format("%-20s: %d visits\n", 
            entry.getKey(), entry.getValue())));
    
    sbReport.append("\nLOYALTY PROGRAM STATUS:\n");
    long lVipCount = hmClientLoyaltyCount.entrySet().stream()
        .filter(entry -> entry.getValue() >= LOYALTY_THRESHOLD)
        .count();
    
    sbReport.append("VIP Customers: ").append(lVipCount).append(" clients\n");
    
    for (Map.Entry<String, Integer> entry : hmClientLoyaltyCount.entrySet()) {
        if (entry.getValue() >= LOYALTY_THRESHOLD) {
            sbReport.append("✅ ").append(entry.getKey()).append(" - VIP Customer (").append(entry.getValue()).append(" visits)\n");
        }
    }
    
    // Service performance
    sbReport.append("\nSERVICE PERFORMANCE:\n");
    Map<ServiceType, Double> hmServiceRevenue = new HashMap<>();
    Map<ServiceType, Integer> hmServiceCount = new HashMap<>();
    
    for (Appointment apt : alAllAppointments) {
        ServiceType service = apt.fsGetService();
        hmServiceRevenue.put(service, hmServiceRevenue.getOrDefault(service, 0.0) + apt.fdGetPrice());
        hmServiceCount.put(service, hmServiceCount.getOrDefault(service, 0) + 1);
    }
    
    for (ServiceType service : ServiceType.values()) {
        double dRevenue = hmServiceRevenue.getOrDefault(service, 0.0);
        int iCount = hmServiceCount.getOrDefault(service, 0);
        if (iCount > 0) {
            sbReport.append(String.format("%-20s: %s revenue, %d bookings, avg %s\n", 
                service.fsGetDisplayName(), 
                dfCurrency.format(dRevenue), 
                iCount,
                dfCurrency.format(dRevenue / iCount)));
        }
    }
    
    // Recent activities
    sbReport.append("\nRECENT ACTIVITIES:\n");
    for (String activity : qRecentActivities) {
        sbReport.append("• ").append(activity).append("\n");
    }
    
    // Business insights
    sbReport.append("\nBUSINESS INSIGHTS:\n");
    if (alAllAppointments.size() > 0) {
        double dAvgAppointmentValue = fdCalculateTotalIncomeRecursive(alAllAppointments, 0, 0.0) / alAllAppointments.size();
        if (dAvgAppointmentValue > 100) {
            sbReport.append("💰 High average appointment value - great premium service positioning!\n");
        }
        
        if (lVipCount > hsClientNames.size() * 0.3) {
            sbReport.append("🌟 Strong client loyalty - over 30% are VIP customers!\n");
        }
        
        if (hmServiceCount.getOrDefault(ServiceType.VOLUME_FULL_SET, 0) > hmServiceCount.getOrDefault(ServiceType.CLASSIC_FULL_SET, 0)) {
            sbReport.append("📈 Volume lashes are more popular than classic - consider promoting premium services!\n");
        }
    }
    
    // FIXED: Use analytics display instead of results display
    fvUpdateAnalyticsDisplay(sbReport.toString());
}
```

### 6. Update the load data method to show statistics:

```java
// Method 21: Load all data from file (UPDATED - add stats display)
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
        fvDisplayBusinessStatistics(); // ADDED: Update stats display
        fvAddToRecentActivities("Loaded " + iLoadedCount + " appointments from file");
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
```

## Summary of Changes

The key fixes made:

1. **Separate Text Areas**: Each tab now has its own properly assigned text area variable
2. **Tab-Specific Update Methods**: Added `fvUpdateAnalyticsDisplay()` and `fvUpdateStatsDisplay()` methods
3. **Correct Display Routing**: Income and report methods now update the analytics tab display
4. **Business Statistics Method**: Added dedicated method for data management statistics
5. **Enhanced Content**: Added more detailed statistics and business insights

Now when you:
- Go to **Income Analytics** tab and click buttons → Results appear in that tab
- Go to **Data Management** tab and load data → Statistics appear in that tab
- Use **Book Appointment** tab → Recent activities appear in that tab

Each tab now properly displays its relevant information!