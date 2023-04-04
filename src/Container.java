public class Container {
    int ID;
    int weight;
    String country;
    boolean inspected;
    int priorityLevel;
    String description;
    String companySend;
    String companyReceive;

    Container() {
    }

    Container(int ID, int weight, String country, boolean inspected, int priority, String description, String companyS, String companyR) {
        this.ID = ID;
        this.weight = weight;
        this.country = country;
        this.inspected = inspected;
        this.priorityLevel = priority;
        this.description = description.substring(0,100);
        this.companySend = companyS.substring(0,20);
        this.companyReceive = companyR.substring(0,20);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCompanyReceive(String companyReceive) {
        this.companyReceive = companyReceive;
    }

    public String getCompanyReceive() {
        return this.companyReceive;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public void setCompanySend(String companySend) {
        this.companySend = companySend;
    }

    public String getCompanySend() {
        return this.companySend;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public boolean isInspected() {
        return this.inspected;
    }
}

