/*
 * Service types offered by lash technicians with pricing
 */

 public enum ServiceType {
    CLASSIC_FULL_SET("Classic Full Set", 120.00),
    CLASSIC_FILL("Classic Fill", 65.00),
    HYBRID_FULL_SET("Hybrid Full Set", 140.00),
    HYBRID_FILL("Hybrid Fill", 75.00),
    VOLUME_FULL_SET("Volume Full Set", 160.00),
    VOLUME_FILL("Volume Fill", 85.00),
    MEGA_VOLUME("Mega Volume", 180.00),
    LASH_REMOVAL("Lash Removal", 25.00),
    LASH_LIFT("Lash Lift & Tint", 75.00),
    CONSULTATION("Consultation", 0.00);
    
    private String sDisplayName;
    private double dPrice;
    
    ServiceType(String psDisplayName, double pdPrice) {
        this.sDisplayName = psDisplayName;
        this.dPrice = pdPrice;
    }
    
    public String fsGetDisplayName() {
        return sDisplayName;
    }
    
    public double fdGetPrice() {
        return dPrice;
    }
    
    @Override
    public String toString() {
        return sDisplayName;
    }
}