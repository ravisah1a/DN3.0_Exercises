public class Logger {
    private static Logger instance; 
    private Logger() {

    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); 
        }
        return instance;
    }
}
public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Singleton pattern works! Only one instance of Logger.");
        } else {
            System.out.println("Oops! Singleton pattern failed.");
        }
    }
}