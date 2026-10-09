public class ChocolateBoilerContitionalBlocking {
    private volatile static ChocolateBoilerContitionalBlocking instance;

    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerContitionalBlocking() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerContitionalBlocking getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoilerContitionalBlocking.class) {
                if (instance == null) {
                    instance = new ChocolateBoilerContitionalBlocking();
                }
            }
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

/*Ключевое слово volatile гарантирует, что параллельные про-
граммные потоки будут правильно работать с переменной
uniqueInstance при ее инициализации экземпляром Singleton.*/