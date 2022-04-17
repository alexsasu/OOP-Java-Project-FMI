package service;

import model.BuyerUtility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyerUtilityService {
    private static BuyerUtilityService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/BuyerUtilities.csv";
    private List<BuyerUtility> buyerUtilities = new ArrayList<>();

    private BuyerUtilityService() { }

    public static BuyerUtilityService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BuyerUtilityService();
        }

        return INSTANCE;
    }

    public BuyerUtility getBuyerUtilityById(Integer idUtility) {
        try {
            int currentPosition = 0, index = -1;
            for (BuyerUtility buyerUtility : buyerUtilities) {
                if (buyerUtility.getIdUtility().equals(idUtility)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return buyerUtilities.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public List<BuyerUtility> getBuyerUtilities() { return buyerUtilities; }

    public void addBuyerUtility(BuyerUtility buyerUtility) {
        buyerUtilities.add(buyerUtility);
    }

//    public void updateBuyerUtilityById(Integer idUtility) {
//
//    }

    public void deleteBuyerUtilityById(Integer idUtility) {
        try {
            int currentPosition = 0, index = -1;
            for (BuyerUtility buyerUtility : buyerUtilities) {
                if (buyerUtility.getIdUtility().equals(idUtility)) {
                    index = currentPosition;
                }
                ++currentPosition;
            }
            buyerUtilities.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readBuyerUtilitiesFromFile() {
        String[] buyerUtilities = readService.readFromFile(this.fileName).split("\n");

        try {
            for (String buyerUtility : buyerUtilities) {
                String[] buyerUtilityInfo = buyerUtility.split(",");
                BuyerUtility buyerUtilityToBeAdded = new BuyerUtility(Integer.parseInt(buyerUtilityInfo[0]), buyerUtilityInfo[1], null);
                this.buyerUtilities.add(buyerUtilityToBeAdded);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void writeBuyerUtilitiesToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (BuyerUtility buyerUtility : buyerUtilities) {
            String buyerUtilityInfo = buyerUtility.getIdUtility() + "," + buyerUtility.getType();

            writeService.writeToFile(fileName, buyerUtilityInfo);
        }
    }
}
