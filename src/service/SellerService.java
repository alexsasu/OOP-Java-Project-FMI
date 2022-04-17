package service;

import model.Seller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SellerService {
    private static SellerService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/Users.csv";
    private List<Seller> sellers = new ArrayList<>();

    private SellerService() { }

    public static SellerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SellerService();
        }

        return INSTANCE;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public List<Seller> getSellersSortedByUsername() {
        return sellers.stream()
                .sorted(Comparator.comparing(Seller::getUsername))
                .collect(Collectors.toList());
    }

    public void addSeller(Seller seller) {
        String sellerInfo =
                seller.getType() + "," + seller.getFirstName() + "," +
                seller.getLastName() + "," + seller.getUsername() + "," +
                seller.getEmail() + "," + seller.getPassword() + "," +
                seller.getDescription() + "," + seller.getPhoneNumber();

        sellers.add(seller);
        writeService.writeToFile(fileName, sellerInfo);
    }

//    public void updateSellerById(Integer sellerId) {
//
//    }

    public void deleteSellerById(Integer sellerId) {
        try {
            sellers.remove(sellerId - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readSellersFromFile() {
        String[] users = readService.readFromFile(this.fileName).split("\n");

        for (String user : users) {
            String[] userInfo = user.split(",");
            if (userInfo[0].equalsIgnoreCase("seller")) {
                Seller seller = new Seller(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5], userInfo[6], userInfo[7]);
                sellers.add(seller);
            }
        }
    }

    public void writeSellersToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (Seller seller : sellers) {
            String sellerInfo =
                    seller.getType() + "," + seller.getFirstName() + "," +
                            seller.getLastName() + "," + seller.getUsername() + "," +
                            seller.getEmail() + "," + seller.getPassword() + "," +
                            seller.getDescription() + "," + seller.getPhoneNumber();

            writeService.writeToFile(fileName, sellerInfo);
        }
    }
}
