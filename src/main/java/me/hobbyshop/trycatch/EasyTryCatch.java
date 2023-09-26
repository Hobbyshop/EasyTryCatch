package me.hobbyshop.trycatch;

import java.util.function.Consumer;

public class EasyTryCatch {

    public static CatchHandler easyTry(TryProvider toTry) {
        Throwable throwable = null;
        try {
            toTry.run();
        } catch (Throwable t) {
            throwable = t;
        }
        return new CatchHandler(throwable);
    }

    public static class CatchHandler {

        private final Throwable throwable;

        private boolean throwableCovered;

        public CatchHandler(Throwable throwable) {
            this.throwable = throwable;
            this.throwableCovered = false;
        }

        public <T extends Throwable> CatchHandler catchThrowable(Class<T> caughtThrowable, Consumer<T> toCatch) {
            if (throwable != null && caughtThrowable.equals(throwable.getClass())) {
                toCatch.accept((T) throwable);
                this.throwableCovered = true;
            }
            return this;
        }

        public <T extends Throwable> CatchHandler printThrowable(Class<T> caughtThrowable) {
            if (throwable != null && caughtThrowable.equals(throwable.getClass())) {
                throwable.printStackTrace();
                this.throwableCovered = true;
            }
            return this;
        }

        public void throwUncaughtThrowables() {
            if (throwable != null && !this.throwableCovered)
                throw new RuntimeException(throwable);
        }

        public void printUncaughtThrowables() {
            if (throwable != null && !this.throwableCovered)
                throwable.printStackTrace();
        }

    }

    public interface TryProvider {

        void run() throws Throwable;

    }

}
