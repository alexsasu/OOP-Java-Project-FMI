package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class BuyerUtility {
    private Integer idUtility;
    private static Integer newIdUtility = 1;
    private String type;
    private List<Service> services = new ArrayList<>();
    private Buyer buyer;
    private List<Date> servicesAddedDates = new ArrayList<>();

    public BuyerUtility(String type, Buyer buyer) {
        this.idUtility = BuyerUtility.newIdUtility;
        this.type = type;
        this.buyer = buyer;

        ++newIdUtility;
    }

    public BuyerUtility(Integer idUtility, String type, Buyer buyer) {
        this.idUtility = idUtility;
        this.type = type;
        this.buyer = buyer;

        if (idUtility >= newIdUtility) {
            newIdUtility = idUtility + 1;
        }
    }

    public Integer getIdUtility() {
        return idUtility;
    }

    public static Integer getNewIdUtility() {
        return newIdUtility;
    }

    public String getType() {
        return type;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public List<Date> getServicesAddedDates() {
        return servicesAddedDates;
    }

    public void setServicesAddedDates(List<Date> servicesAddedDates) {
        this.servicesAddedDates = servicesAddedDates;
    }

    @Override
    public String toString() {
        return "BuyerUtility{" +
                "idUtility=" + idUtility +
                ", type='" + type + '\'' +
                ", services=" + services +
                ", buyer=" + buyer +
                ", servicesAddedDates=" + servicesAddedDates +
                '}';
    }
}
