package service;

import model.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceService {
    private static ServiceService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/Services.csv";
    private List<Service> services = new ArrayList<>();

    private ServiceService() { }

    public static ServiceService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceService();
        }

        return INSTANCE;
    }

    public Service getServiceById(Integer idService) {
        try {
            int currentPosition = 0, index = -1;
            for (Service service : services) {
                if (service.getIdService().equals(idService)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return services.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public List<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }

//    public void updateServiceById(Integer idService) {
//
//    }

    public void deleteServiceById(Integer idService) {
        try {
            int currentPosition = 0, index = -1;
            for (Service service : services) {
                if (service.getIdService().equals(idService)) {
                    index = currentPosition;
                }
                ++currentPosition;
            }
            services.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readServicesFromFile() {
        String[] services = readService.readFromFile(this.fileName).split("\n");

        try {
            for (String service : services) {
                String[] serviceInfo = service.split(",");
                Service serviceToBeAdded = new Service(Integer.parseInt(serviceInfo[0]), null, serviceInfo[1], serviceInfo[2]);
                this.services.add(serviceToBeAdded);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void writeServicesToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (Service service : services) {
            String serviceInfo = service.getIdService() + "," + service.getDescription() + "," + service.getWorkSchedule();

            writeService.writeToFile(fileName, serviceInfo);
        }
    }
}
