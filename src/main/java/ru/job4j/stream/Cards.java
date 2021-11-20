package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cards {
    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static class Card {
        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        public static void main(String[] args) {
            Suit[] suits = {Suit.Diamonds, Suit.Hearts, Suit.Spades, Suit.Clubs};
            Value[] values = {Value.V_6, Value.V_7, Value.V_8};
            Stream.of(suits)
                    .flatMap(s -> Stream.of(values)
                            .map(v -> s + " " + v))
                    .forEach(System.out::println);
        }
    }
}
