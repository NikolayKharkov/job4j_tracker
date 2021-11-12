package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс описывает аккаунт клиента банка
 * @author Kharkov Nikolay
 * @version 1.0
 */

public class Account {
    /**
     * Информация по аккаунту состоит из реквизита и баланса
     * У клиента может быть несколько аккаунтов
     */

    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Override необходим для проверки уникальности реквизита.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}