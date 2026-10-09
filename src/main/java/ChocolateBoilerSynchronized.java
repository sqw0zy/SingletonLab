public class ChocolateBoilerSynchronized {
    private static ChocolateBoilerSynchronized instance;

    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerSynchronized() {
        empty = true;
        boiled = false;
    }

    public static synchronized ChocolateBoilerSynchronized getInstance() {
        if (instance == null) {
            instance = new ChocolateBoilerSynchronized();
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
