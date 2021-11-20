package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Класс описывает работу банка
 * @author Kharkov Nikolay
 * @version 1.0
 */

public class BankService {
    /**
     * Информация о клиентах банка хранится в словаре,
     * ключом является класс {@link User}
     * значние коллекция, которая содержит {@link Account}
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового пользователя
     * @param user
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавления аккаунта к клиенту
     * Принимате паспорт и и объект класса {@link Account}
     * Если такой аккаунт с паспортом существует, то добавление не произойдет
     * @param passport, account
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
                users.get(user).add(account);
        }
    }

    /**
     * Метод поиска клиента по паспорту
     * В случаии не нахождения, возвращает null
     * @return {@link User}
     * @param passport
     */

    public User findByPassport(String passport) {
        return users
                .keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод поиска аккаунта по паспорту и реквизитам
     * Принимает паспорт и реквизиты
     * Если аккаунт не найден, то вернет null
     * @return {@link Account}
     * @param passport, requisite
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users
                    .get(user)
                    .stream()
                    .filter(u -> requisite.equals(u.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод денежного перевода между счетами
     * Принимает номер паспорта и номер реквизита, а так же сумму, обоих участников перовода
     * Получатель, помечается префиксом dest, отправитель src
     * Идет проверка на существование аккаунтов, а так же баланс отправителя
     * В случаии успешной транзакции вернет true, иначе false
     * @return boolean
     * @param srcPassport, srcRequisite, destPassport, destRequisite, amount
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() - amount >= 0) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}