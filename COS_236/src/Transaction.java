import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private double dAmount;
    private String sDescription;
    private String sCategory;
    private boolean bIsIncome;
    private boolean bIsRecurring;
    private Date dateCreated;
    
    public Transaction(double pdAmount, String psDescription, String psCategory, 
                      boolean pbIsIncome, boolean pbIsRecurring) {
        this.dAmount = pdAmount;
        this.sDescription = psDescription;
        this.sCategory = psCategory;
        this.bIsIncome = pbIsIncome;
        this.bIsRecurring = pbIsRecurring;
        this.dateCreated = new Date();
    }
    
    // Getters
    public double fdGetAmount() { return dAmount; }
    public String fsGetDescription() { return sDescription; }
    public String fsGetCategory() { return sCategory; }
    public boolean fbIsIncome() { return bIsIncome; }
    public boolean fbIsRecurring() { return bIsRecurring; }
    public Date fdGetDateCreated() { return dateCreated; }
    
    // Convert to file string format
    public String fsToFileString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("%.2f|%s|%s|%s|%s|%s",
            dAmount, sDescription, sCategory, 
            bIsIncome ? "INCOME" : "EXPENSE",
            bIsRecurring ? "RECURRING" : "ONE_TIME",
            sdf.format(dateCreated));
    }
    
    // Create from file string format
    public static Transaction fsFromFileString(String psLine) {
        try {
            String[] parts = psLine.split("\\|");
            if (parts.length >= 5) {
                double dAmount = Double.parseDouble(parts[0]);
                String sDescription = parts[1];
                String sCategory = parts[2];
                boolean bIsIncome = parts[3].equals("INCOME");
                boolean bIsRecurring = parts[4].equals("RECURRING");
                
                return new Transaction(dAmount, sDescription, sCategory, bIsIncome, bIsRecurring);
            }
        } catch (Exception e) {
            System.err.println("Error parsing transaction: " + e.getMessage());
        }
        return null;
    }
}