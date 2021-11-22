package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод поиска клиента по паспорту
     * В случаии не нахождения, возвращает null
     * @return {@link User}
     * @param passport
     */

    public Optional<User> findByPassport(String passport) {
        return users
                .keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Метод поиска аккаунта по паспорту и реквизитам
     * Принимает паспорт и реквизиты
     * Если аккаунт не найден, то вернет null
     * @return {@link Account}
     * @param passport, requisite
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users
                    .get(user.get())
                    .stream()
                    .filter(u -> requisite.equals(u.getRequisite()))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() - amount >= 0) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}