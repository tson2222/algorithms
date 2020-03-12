package hackerrank;

public class Trader {
    private final String companyName;
    private final String location;
    private final String services;
    private final int numEmployees;
    private final Double dailyRate;
    private final String description;

    public Trader (String companyName, String location, String services, int numEmployees, double dailyRate, String description)
    {
        this.companyName = companyName;
        this.location = location;
        this.services = services;
        this.numEmployees = numEmployees;
        this.dailyRate = dailyRate;
        this.description = description;

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getServices() {
        return services;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public String getDescription() {
        return description;
    }
    public String toString()
    {
        return "Trader: " + companyName + "\n" + "Location: " + location + "\n" + "Services: " + services +
                "\n" + "Number of Employees: " + numEmployees + "\n" + "Daily Rate(£): " + dailyRate + "\n" + "Description: " + description;
    }
}