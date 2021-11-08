package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user.getPassport())) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        Account checkUnique;
        if (user != null) {
            checkUnique = findByRequisite(passport, account.getRequisite());
            if (checkUnique == null) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
                break;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        boolean check = findByPassport(srcPassport) != null && findByPassport(destPassport) != null;
        if (check) {
            check = findByRequisite(srcPassport, srcRequisite) != null
                    && findByRequisite(destPassport, destRequisite) != null;
            if (check) {
                check = findByRequisite(srcPassport, srcRequisite).getBalance() >= amount;
                if (check) {
                    findByRequisite(srcPassport, srcRequisite).
                            setBalance(findByRequisite(srcPassport, srcRequisite)
                                    .getBalance() - amount);
                    findByRequisite(destPassport, destRequisite).
                            setBalance(findByRequisite(destPassport, destRequisite)
                                    .getBalance() + amount);
                    rsl = true;
                }
            }
        }
        return rsl;
    }
}