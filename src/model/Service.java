package model;

import java.util.ArrayList;
import java.util.List;

public final class Service {
    private Integer idService;
    private static Integer newIdService = 1;
    private Seller seller;
    private String description;
    private List<Job> jobsRequired = new ArrayList<>();
    private List<City> eligibleCities = new ArrayList<>();
    private String workSchedule;

    public Service(Seller seller, String description, String workSchedule) {
        this.idService = Service.newIdService;
        this.seller = seller;
        this.description = description;
        this.workSchedule = workSchedule;

        ++newIdService;
    }

    public Service(Integer idService, Seller seller, String description, String workSchedule) {
        this.idService = idService;
        this.seller = seller;
        this.description = description;
        this.workSchedule = workSchedule;

        if (idService >= newIdService) {
            newIdService = idService + 1;
        }
    }

    public Integer getIdService() {
        return idService;
    }

    public static Integer getNewIdService() {
        return newIdService;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobsRequired() {
        return jobsRequired;
    }

    public void setJobsRequired(List<Job> jobsRequired) {
        this.jobsRequired = jobsRequired;
    }

    public List<City> getEligibleCities() {
        return eligibleCities;
    }

    public void setEligibleCities(List<City> eligibleCities) {
        this.eligibleCities = eligibleCities;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", seller=" + seller +
                ", description='" + description + '\'' +
                ", jobsRequired=" + jobsRequired +
                ", eligibleCities=" + eligibleCities +
                ", workSchedule='" + workSchedule + '\'' +
                '}';
    }
}
