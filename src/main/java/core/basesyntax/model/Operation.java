package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Operation {
    private final Type type;
    private final String fruit;
    private final int amount;

    public Operation(Type type, String fruit, int amount) {
        this.type = type;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return amount == operation.amount
                && type == operation.type
                && Objects.equals(fruit, operation.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, amount);
    }

    public enum Type {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private static final Map<String, Type> typesMap = new HashMap<>();

        static {
            for (Type type : Type.values()) {
                typesMap.put(type.getType(), type);
            }
        }

        private String type;

        Type(String s) {
            this.type = s;
        }

        public static Type get(String type) {
            return typesMap.get(type);
        }

        public String getType() {
            return type;
        }
    }
}