import model.*;
import service.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void clrscr() {
        for (int i = 0; i < 30; ++i) {
            System.out.println();
        }
    }

    public static void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        ServiceService serviceService = ServiceService.getInstance();
        BuyerUtilityService buyerUtilityService = BuyerUtilityService.getInstance();
        LanguageService languageService = LanguageService.getInstance();
        JobService jobService = JobService.getInstance();
        CityService cityService = CityService.getInstance();

        Boolean continueNavigation = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome back, administrator!\n");

        while (continueNavigation) {
            System.out.println("What do you wish to do?\n");
            System.out.println("Import data from file - 1");
            System.out.println("Export data to file - 2");
            System.out.println("Add new entry - 3");
            System.out.println("Get entry by ID and print it to screen - 4");
            System.out.println("Get entry by name and print it to screen - 5");
            System.out.println("Print all entries of certain type to screen - 6");
            System.out.println("Remove entry - 7");
            System.out.println("Class specific operations - 8");
            System.out.println("Exit menu - 9\n");

            System.out.print("Choose option: ");
            Integer option = Integer.parseInt(sc.nextLine());
            clrscr();

            switch (option) {
                case 1: {
                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Import data from \"Users.csv\" - 1");
                        System.out.println("Import data from \"Services.csv\" - 2");
                        System.out.println("Import data from \"BuyerUtilities.csv\" - 3");
                        System.out.println("Import data from \"Languages.csv\" - 4");
                        System.out.println("Import data from \"Jobs.csv\" - 5");
                        System.out.println("Import data from \"Cities.csv\" - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        userService.readUsersFromFile();

                                        System.out.println("Successfully imported users!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                                        clrscr();

                                        break;
                                    }
                                    case 2: {
                                        serviceService.readServicesFromFile();

                                        System.out.println("Successfully imported services!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                                        clrscr();

                                        break;
                                    }
                                    case 3: {
                                        buyerUtilityService.readBuyerUtilitiesFromFile();

                                        System.out.println("Successfully imported buyer utilities!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                                        clrscr();

                                        break;
                                    }
                                    case 4: {
                                        languageService.readLanguagesFromFile();

                                        System.out.println("Successfully imported languages!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                                        clrscr();

                                        break;
                                    }
                                    case 5: {
                                        jobService.readJobsFromFile();

                                        System.out.println("Successfully imported jobs!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                                        clrscr();

                                        break;
                                    }
                                    case 6: {
                                        cityService.readCitiesFromFile();

                                        System.out.println("Successfully imported cities!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                                        clrscr();

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 2: {
                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Export data to \"Users.csv\" - 1");
                        System.out.println("Export data to \"Services.csv\" - 2");
                        System.out.println("Export data to \"BuyerUtilities.csv\" - 3");
                        System.out.println("Export data to \"Languages.csv\" - 4");
                        System.out.println("Export data to \"Jobs.csv\" - 5");
                        System.out.println("Export data to \"Cities.csv\" - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        userService.writeUsersToFile();

                                        System.out.println("Successfully exported users!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 2: {
                                        serviceService.writeServicesToFile();

                                        System.out.println("Successfully exported services!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 3: {
                                        buyerUtilityService.writeBuyerUtilitiesToFile();

                                        System.out.println("Successfully exported buyer utilities!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 4: {
                                        languageService.writeLanguagesToFile();

                                        System.out.println("Successfully exported languages!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 5: {
                                        jobService.writeJobsToFile();

                                        System.out.println("Successfully exported jobs!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 6: {
                                        cityService.writeCitiesToFile();

                                        System.out.println("Successfully exported cities!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 3: {
                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Add new user - 1");
                        System.out.println("Add new service - 2");
                        System.out.println("Add new buyer utility - 3");
                        System.out.println("Add new language - 4");
                        System.out.println("Add new job - 5");
                        System.out.println("Add new city - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                Scanner scInfo = new Scanner(System.in);

                                switch (option) {
                                    case 1: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.println("Add new seller - 1");
                                            System.out.println("Add new buyer - 2\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 2)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            }
                                            else if (option != 0) {
                                                switch (option) {
                                                    case 1: {
                                                        String type = "seller";
                                                        System.out.print("First name: ");
                                                        String firstName = scInfo.nextLine();
                                                        System.out.print("Last name: ");
                                                        String lastName = scInfo.nextLine();
                                                        System.out.print("Username: ");
                                                        String username = scInfo.nextLine();
                                                        System.out.print("E-mail: ");
                                                        String email = scInfo.nextLine();
                                                        System.out.print("Password: ");
                                                        String password = scInfo.nextLine();
                                                        System.out.print("Description: ");
                                                        String description = scInfo.nextLine();
                                                        System.out.print("Phone number: ");
                                                        String phoneNumber = scInfo.nextLine();

                                                        userService.addUser(new Seller(type, firstName, lastName, username, email, password, description, phoneNumber));

                                                        System.out.println();
                                                        System.out.println("Seller successfully added!");
                                                        try {
                                                            Thread.sleep(2000);
                                                        } catch (InterruptedException e) {
                                                            System.out.println(e.getClass() + " " + e.getMessage());
                                                        }
                                                        clrscr();

                                                        break;
                                                    }
                                                    case 2: {
                                                        String type = "buyer";
                                                        System.out.print("First name: ");
                                                        String firstName = scInfo.nextLine();
                                                        System.out.print("Last name: ");
                                                        String lastName = scInfo.nextLine();
                                                        System.out.print("Username: ");
                                                        String username = scInfo.nextLine();
                                                        System.out.print("E-mail: ");
                                                        String email = scInfo.nextLine();
                                                        System.out.print("Password: ");
                                                        String password = scInfo.nextLine();

                                                        userService.addUser(new Buyer(type, firstName, lastName, username, email, password));

                                                        System.out.println();
                                                        System.out.println("Buyer successfully added!");
                                                        try {
                                                            Thread.sleep(2000);
                                                        } catch (InterruptedException e) {
                                                            System.out.println(e.getClass() + " " + e.getMessage());
                                                        }
                                                        clrscr();

                                                        break;
                                                    }
                                                }
                                            } else {
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    case 2: {
                                        System.out.print("Description: ");
                                        String description = scInfo.nextLine();
                                        System.out.print("Work schedule: ");
                                        String workSchedule = scInfo.nextLine();

                                        serviceService.addService(new Service(null, description, workSchedule));

                                        System.out.println();
                                        System.out.println("Service successfully added!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 3: {
                                        System.out.print("Type: ");
                                        String type = scInfo.nextLine();

                                        buyerUtilityService.addBuyerUtility(new BuyerUtility(type, null));

                                        System.out.println();
                                        System.out.println("Buyer utility successfully added!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Language name: ");
                                        String name = scInfo.nextLine();

                                        languageService.addLanguage(new Language(name));

                                        System.out.println();
                                        System.out.println("Language successfully added!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 5: {
                                        System.out.print("Job name: ");
                                        String name = scInfo.nextLine();

                                        jobService.addJob(new Job(name));

                                        System.out.println();
                                        System.out.println("Job successfully added!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                    case 6: {
                                        System.out.print("City name: ");
                                        String name = scInfo.nextLine();

                                        cityService.addCity(new City(name));

                                        System.out.println();
                                        System.out.println("City successfully added!");
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            System.out.println(e.getClass() + " " + e.getMessage());
                                        }
                                        clrscr();

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 4: {
                    Scanner scId = new Scanner(System.in);
                    Integer id;

                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Print user by id to screen - 1");
                        System.out.println("Print service by id to screen - 2");
                        System.out.println("Print buyer utility by id to screen - 3");
                        System.out.println("Print language by id to screen - 4");
                        System.out.println("Print job by id to screen - 5");
                        System.out.println("Print city by id to screen - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        List<User> users = userService.getUsers();

                                        if (!users.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which user do you wish to print?\n");

                                                List<Integer> userIds = users.stream().
                                                        map(User::getIdUser).toList();
                                                List<String> userIdsToStrings = userIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllUserIds = userIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated users):");
                                                System.out.println(stringOfAllUserIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!userIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(userService.getUserById(id) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no users to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 2: {
                                        List<Service> services = serviceService.getServices();

                                        if (!services.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which service do you wish to print?\n");

                                                List<Integer> serviceIds = services.stream().
                                                        map(Service::getIdService).toList();
                                                List<String> serviceIdsToStrings = serviceIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllServiceIds = serviceIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated services):");
                                                System.out.println(stringOfAllServiceIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!serviceIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(serviceService.getServiceById(id) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no services to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 3: {
                                        List<BuyerUtility> buyerUtilities = buyerUtilityService.getBuyerUtilities();

                                        if (!buyerUtilities.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which buyer utility do you wish to print?\n");

                                                List<Integer> utilityIds = buyerUtilities.stream().
                                                        map(BuyerUtility::getIdUtility).toList();
                                                List<String> utilityIdsToStrings = utilityIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllUtilityIds = utilityIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated buyer utilities):");
                                                System.out.println(stringOfAllUtilityIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!utilityIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(buyerUtilityService.getBuyerUtilityById(id) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no buyer utilities to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 4: {
                                        List<Language> languages = languageService.getLanguages();

                                        if (!languages.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which language do you wish to print?\n");

                                                List<Integer> languageIds = languages.stream().
                                                        map(Language::getIdLanguage).toList();
                                                List<String> languageIdsToStrings = languageIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllLanguageIds = languageIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated languages):");
                                                System.out.println(stringOfAllLanguageIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!languageIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(languageService.getLanguageById(id) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no languages to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 5: {
                                        List<Job> jobs = jobService.getJobs();

                                        if (!jobs.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which job do you wish to print?\n");

                                                List<Integer> jobIds = jobs.stream().
                                                        map(Job::getIdJob).toList();
                                                List<String> jobIdsToStrings = jobIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllJobIds = jobIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated jobs):");
                                                System.out.println(stringOfAllJobIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!jobIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(jobService.getJobById(id) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no jobs to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 6: {
                                        List<City> cities = cityService.getCities();

                                        if (!cities.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which city do you wish to print?\n");

                                                List<Integer> cityIds = cities.stream().
                                                        map(City::getIdCity).toList();
                                                List<String> cityIdsToStrings = cityIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllCityIds = cityIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated cities):");
                                                System.out.println(stringOfAllCityIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!cityIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(cityService.getCityById(id) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no cities to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 5: {
                    Scanner scName = new Scanner(System.in);
                    String name;

                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Print user by username to screen - 1");
                        System.out.println("Print language by name to screen - 2");
                        System.out.println("Print job by name to screen - 3");
                        System.out.println("Print city by name to screen - 4\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 4)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        List<User> users = userService.getUsers();

                                        if (!users.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which user do you wish to print?\n");

                                                List<String> userUsernames = users.stream().
                                                        map(User::getUsername).toList();
                                                String stringOfAllUserUsernames = userUsernames.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following usernames (usernames indicating their associated users):");
                                                System.out.println(stringOfAllUserUsernames + "\n");

                                                System.out.print("Insert username: ");
                                                name = scName.nextLine();

                                                System.out.println();

                                                if (!userUsernames.contains(name)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(userService.getUserByUsername(name) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no users to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 2: {
                                        List<Language> languages = languageService.getLanguages();

                                        if (!languages.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which language do you wish to print?\n");

                                                List<String> languageNames = languages.stream().
                                                        map(Language::getName).toList();
                                                String stringOfAllLanguageNames = languageNames.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following language names (language names indicating their associated languages):");
                                                System.out.println(stringOfAllLanguageNames + "\n");

                                                System.out.print("Insert language name: ");
                                                name = scName.nextLine();

                                                System.out.println();

                                                if (!languageNames.contains(name)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(languageService.getLanguageByName(name) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no languages to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 3: {
                                        List<Job> jobs = jobService.getJobs();

                                        if (!jobs.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which job do you wish to print?\n");

                                                List<String> jobNames = jobs.stream().
                                                        map(Job::getName).toList();
                                                String stringOfAllJobNames = jobNames.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following job names (job names indicating their associated jobs):");
                                                System.out.println(stringOfAllJobNames + "\n");

                                                System.out.print("Insert job name: ");
                                                name = scName.nextLine();

                                                System.out.println();

                                                if (!jobNames.contains(name)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(jobService.getJobByName(name) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no jobs to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 4: {
                                        List<City> cities = cityService.getCities();

                                        if (!cities.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which city do you wish to print?\n");

                                                List<String> cityNames = cities.stream().
                                                        map(City::getName).toList();
                                                String stringOfAllCityNames = cityNames.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following city names (city names indicating their associated cities):");
                                                System.out.println(stringOfAllCityNames + "\n");

                                                System.out.print("Insert city name: ");
                                                name = scName.nextLine();

                                                System.out.println();

                                                if (!cityNames.contains(name)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            System.out.println(cityService.getCityByName(name) + "\n");
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no cities to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 6: {
                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Print all users to screen - 1");
                        System.out.println("Print all services to screen - 2");
                        System.out.println("Print all buyer utilities to screen - 3");
                        System.out.println("Print all languages to screen - 4");
                        System.out.println("Print all jobs to screen - 5");
                        System.out.println("Print all cities to screen - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        List<User> users = userService.getUsers();

                                        if (!users.isEmpty()) {
                                            System.out.println("All of the stored users:\n");

                                            for (User user : users) {
                                                System.out.println(user);
                                            }

                                            System.out.println();
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no users to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 2: {
                                        List<Service> services = serviceService.getServices();

                                        if (!services.isEmpty()) {
                                            System.out.println("All of the stored services:\n");

                                            for (Service service : services) {
                                                System.out.println(service);
                                            }

                                            System.out.println();
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no services to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 3: {
                                        List<BuyerUtility> buyerUtilities = buyerUtilityService.getBuyerUtilities();

                                        if (!buyerUtilities.isEmpty()) {
                                            System.out.println("All of the stored buyer utilities:\n");

                                            for (BuyerUtility buyerUtility : buyerUtilities) {
                                                System.out.println(buyerUtility);
                                            }

                                            System.out.println();
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no buyer utilities to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 4: {
                                        List<Language> languages = languageService.getLanguages();

                                        if (!languages.isEmpty()) {
                                            System.out.println("All of the stored languages:\n");

                                            for (Language language : languages) {
                                                System.out.println(language);
                                            }

                                            System.out.println();
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no languages to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 5: {
                                        List<Job> jobs = jobService.getJobs();

                                        if (!jobs.isEmpty()) {
                                            System.out.println("All of the stored jobs:\n");

                                            for (Job job : jobs) {
                                                System.out.println(job);
                                            }

                                            System.out.println();
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no jobs to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 6: {
                                        List<City> cities = cityService.getCities();

                                        if (!cities.isEmpty()) {
                                            System.out.println("All of the stored cities:\n");

                                            for (City city : cities) {
                                                System.out.println(city);
                                            }

                                            System.out.println();
                                            pressEnterToContinue();

                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no cities to print!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 7: {
                    Scanner scId = new Scanner(System.in);
                    Integer id;

                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("Remove user - 1");
                        System.out.println("Remove service - 2");
                        System.out.println("Remove buyer utility - 3");
                        System.out.println("Remove language - 4");
                        System.out.println("Remove job - 5");
                        System.out.println("Remove city - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        List<User> users = userService.getUsers();

                                        if (!users.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which user do you wish to remove?\n");

                                                List<Integer> userIds = users.stream().
                                                        map(User::getIdUser).toList();
                                                List<String> userIdsToStrings = userIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllUserIds = userIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated users):");
                                                System.out.println(stringOfAllUserIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!userIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            userService.deleteUserById(id);

                                            System.out.println("User successfully removed!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no users to remove!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 2: {
                                        List<Service> services = serviceService.getServices();

                                        if (!services.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which service do you wish to remove?\n");

                                                List<Integer> serviceIds = services.stream().
                                                        map(Service::getIdService).toList();
                                                List<String> serviceIdsToStrings = serviceIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllServiceIds = serviceIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated services):");
                                                System.out.println(stringOfAllServiceIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!serviceIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            serviceService.deleteServiceById(id);

                                            System.out.println("Service successfully removed!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no services to remove!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 3: {
                                        List<BuyerUtility> buyerUtilities = buyerUtilityService.getBuyerUtilities();

                                        if (!buyerUtilities.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which buyer utility do you wish to remove?\n");

                                                List<Integer> utilityIds = buyerUtilities.stream().
                                                        map(BuyerUtility::getIdUtility).toList();
                                                List<String> utilityIdsToStrings = utilityIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllUtilityIds = utilityIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated buyer utilities):");
                                                System.out.println(stringOfAllUtilityIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!utilityIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            buyerUtilityService.deleteBuyerUtilityById(id);

                                            System.out.println("Buyer utility successfully removed!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no buyer utilities to remove!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 4: {
                                        List<Language> languages = languageService.getLanguages();

                                        if (!languages.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which language do you wish to remove?\n");

                                                List<Integer> languageIds = languages.stream().
                                                        map(Language::getIdLanguage).toList();
                                                List<String> languageIdsToStrings = languageIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllLanguageIds = languageIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated languages):");
                                                System.out.println(stringOfAllLanguageIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!languageIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            languageService.deleteLanguageById(id);

                                            System.out.println("Language successfully removed!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no languages to remove!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 5: {
                                        List<Job> jobs = jobService.getJobs();

                                        if (!jobs.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which job do you wish to remove?\n");

                                                List<Integer> jobIds = jobs.stream().
                                                        map(Job::getIdJob).toList();
                                                List<String> jobIdsToStrings = jobIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllJobIds = jobIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated jobs):");
                                                System.out.println(stringOfAllJobIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!jobIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            jobService.deleteJobById(id);

                                            System.out.println("Job successfully removed!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no jobs to remove!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                    case 6: {
                                        List<City> cities = cityService.getCities();

                                        if (!cities.isEmpty()) {
                                            while (true) {
                                                System.out.println("Which city do you wish to remove?\n");

                                                List<Integer> cityIds = cities.stream().
                                                        map(City::getIdCity).toList();
                                                List<String> cityIdsToStrings = cityIds.stream().
                                                        map(String::valueOf).toList();
                                                String stringOfAllCityIds = cityIdsToStrings.stream().
                                                        map(String::valueOf).
                                                        collect(Collectors.joining(", "));

                                                System.out.println("Insert one of the following numbers (ids indicating their associated cities):");
                                                System.out.println(stringOfAllCityIds + "\n");

                                                System.out.print("Insert id: ");
                                                id = Integer.parseInt(scId.nextLine());

                                                System.out.println();

                                                if (!cityIds.contains(id)) {
                                                    System.out.println("Wrong input!");
                                                    try {
                                                        Thread.sleep(2000);
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e.getClass() + " " + e.getMessage());
                                                    }
                                                    clrscr();
                                                } else {
                                                    break;
                                                }
                                            }

                                            cityService.deleteCityById(id);

                                            System.out.println("City successfully removed!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        } else {
                                            System.out.println("There are no cities to remove!");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException e) {
                                                System.out.println(e.getClass() + " " + e.getMessage());
                                            }
                                            clrscr();
                                        }

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 8: {
                    while (true) {
                        System.out.println("Go back - 0\n");

                        System.out.println("User specific operations - 1");
                        System.out.println("Service specific operations - 2");
                        System.out.println("Buyer utility specific operations - 3");
                        System.out.println("Language specific operations - 4");
                        System.out.println("Job specific operations - 5");
                        System.out.println("City specific operations - 6\n");

                        System.out.print("Choose option: ");
                        option = Integer.parseInt(sc.nextLine());
                        clrscr();

                        if ((option < 0) || (option > 6)) {
                            System.out.println("Wrong input!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getClass() + " " + e.getMessage());
                            }
                            clrscr();
                        } else {
                            if (option != 0) {
                                switch (option) {
                                    case 1: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.println("Print all users sorted by username - 1\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 1)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            } else {
                                                if (option != 0) {
                                                    switch (option) {
                                                        case 1: {
                                                            List<User> users = userService.getUsersSortedByUsername();

                                                            if (!users.isEmpty()) {
                                                                System.out.println("All of the stored users, sorted by username:\n");

                                                                for (User user : users) {
                                                                    System.out.println(user);
                                                                }

                                                                System.out.println();
                                                                pressEnterToContinue();

                                                                try {
                                                                    Thread.sleep(2000);
                                                                } catch (InterruptedException e) {
                                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                                }
                                                                clrscr();
                                                            } else {
                                                                System.out.println("There are no users to print!");
                                                                try {
                                                                    Thread.sleep(2000);
                                                                } catch (InterruptedException e) {
                                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                                }
                                                                clrscr();
                                                            }

                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                    case 2: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 0)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            } else {
                                                if (option != 0) {

                                                } else {
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                    case 3: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 0)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            } else {
                                                if (option != 0) {

                                                } else {
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                    case 4: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 0)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            } else {
                                                if (option != 0) {

                                                } else {
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                    case 5: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 0)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            } else {
                                                if (option != 0) {

                                                } else {
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                    case 6: {
                                        while (true) {
                                            System.out.println("Go back - 0\n");

                                            System.out.print("Choose option: ");
                                            option = Integer.parseInt(sc.nextLine());
                                            clrscr();

                                            if ((option < 0) || (option > 0)) {
                                                System.out.println("Wrong input!");
                                                try {
                                                    Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                    System.out.println(e.getClass() + " " + e.getMessage());
                                                }
                                                clrscr();
                                            } else {
                                                if (option != 0) {

                                                } else {
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    break;
                }
                case 9: {
                    continueNavigation = false;
                    System.out.println("Goodbye!");
                    try {
                        Thread.sleep(2200);
                    } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }

                    break;
                }
                default: {
                    System.out.println("Wrong input!");
                    try {
                        Thread.sleep(2000);
                    } catch(InterruptedException e) { System.out.println(e.getClass() + " " + e.getMessage()); }
                    clrscr();
                }
            }
        }
    }
}
