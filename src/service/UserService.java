package service;

import model.Buyer;
import model.Seller;
import model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/Users.csv";
    private List<User> users = new ArrayList<>();

    private UserService() { }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }

        return INSTANCE;
    }

    public User getUserById(Integer idUser) {
        try {
            int currentPosition = 0, index = -1;
            for (User user : users) {
                if (user.getIdUser().equals(idUser)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return users.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public User getUserByUsername(String username) {
        try {
            int currentPosition = 0, index = -1;
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return users.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public List<User> getUsers() { return users; }

    public List<User> getUsersSortedByUsername() {
        return users.stream()
                .sorted(Comparator.comparing(User::getUsername))
                .collect(Collectors.toList());
    }

    public void addUser(User user) {
        users.add(user);
    }

//    public void updateUserById(Integer idUser) {
//
//    }

    public void deleteUserById(Integer idUser) {
        try {
            int currentPosition = 0, index = -1;
            for (User user : users) {
                if (user.getIdUser().equals(idUser)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            users.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readUsersFromFile() {
        String[] users = readService.readFromFile(this.fileName).split("\n");

        try {
            for (String user : users) {
                String[] userInfo = user.split(",");
                if (userInfo[1].equalsIgnoreCase("seller")) {
                    Seller seller = new Seller(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5], userInfo[6], userInfo[7], userInfo[8]);
                    this.users.add(seller);
                } else if (userInfo[1].equalsIgnoreCase("buyer")) {
                    Buyer buyer = new Buyer(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5], userInfo[6]);
                    this.users.add(buyer);
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void writeUsersToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (User user : users) {
            String userInfo =
                    user.getIdUser() + "," + user.getType() + "," + user.getFirstName() + "," +
                            user.getLastName() + "," + user.getUsername() + "," +
                            user.getEmail() + "," + user.getPassword();
            if (user.getType().equalsIgnoreCase("seller")) {
                userInfo += "," + ((Seller) user).getDescription() + "," + ((Seller) user).getPhoneNumber();
            }

            writeService.writeToFile(fileName, userInfo);
        }
    }
}
