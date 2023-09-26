import me.hobbyshop.trycatch.EasyTryCatch;

public class Main {

    public static void main(String[] args) {
        EasyTryCatch.easyTry(() -> Thread.sleep(420))
                        .catchThrowable(InterruptedException.class, e -> System.out.println("fnjdfhsdofas"))
                        .printUncaughtThrowables();

        try {
            Thread.sleep(420);
        } catch (InterruptedException e) {
            System.out.println("fngodfjsdifo");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
