public class ChocolateBoilerStatic {
    private static ChocolateBoilerStatic instance = new ChocolateBoilerStatic();

    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerStatic() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerStatic getInstance() {
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
