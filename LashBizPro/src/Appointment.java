/*
 * Appointment class representing a client appointment
 */

 import java.text.SimpleDateFormat;
 import java.util.Date;
 
 public class Appointment {
     private String sClientName;
     private ServiceType serviceType;
     private String sDate;
     private double dPrice;
     private String sNotes;
     private boolean bIsNewClient;
     private Date dateCreated;
     
     public Appointment(String psClientName, ServiceType pServiceType, String psDate, 
                       double pdPrice, String psNotes, boolean pbIsNewClient) {
         this.sClientName = psClientName;
         this.serviceType = pServiceType;
         this.sDate = psDate;
         this.dPrice = pdPrice;
         this.sNotes = psNotes;
         this.bIsNewClient = pbIsNewClient;
         this.dateCreated = new Date();
     }
     
     // Getters
     public String fsGetClientName() { return sClientName; }
     public ServiceType fsGetService() { return serviceType; }
     public String fsGetDate() { return sDate; }
     public double fdGetPrice() { return dPrice; }
     public String fsGetNotes() { return sNotes; }
     public boolean fbIsNewClient() { return bIsNewClient; }
     public Date fdGetDateCreated() { return dateCreated; }
     
     // Convert to file string format
     public String fsToFileString() {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return String.format("%s|%s|%s|%.2f|%s|%s|%s",
             sClientName, serviceType.name(), sDate, dPrice, sNotes,
             bIsNewClient ? "NEW" : "RETURNING",
             sdf.format(dateCreated));
     }
     
     // Create from file string format
     public static Appointment fsFromFileString(String psLine) {
         try {
             String[] parts = psLine.split("\\|");
             if (parts.length >= 6) {
                 String sClientName = parts[0];
                 ServiceType serviceType = ServiceType.valueOf(parts[1]);
                 String sDate = parts[2];
                 double dPrice = Double.parseDouble(parts[3]);
                 String sNotes = parts[4];
                 boolean bIsNewClient = parts[5].equals("NEW");
                 
                 return new Appointment(sClientName, serviceType, sDate, dPrice, sNotes, bIsNewClient);
             }
         } catch (Exception e) {
             System.err.println("Error parsing appointment: " + e.getMessage());
         }
         return null;
     }
 }