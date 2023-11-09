public class MyContextManager implements AutoCloseable {

    private Car car;

    MyContextManager(Car car) {
        this.car = car;
    }

    @Override
    public void close() {
        if(this.car.isStart()) {
            this.car.stop();
        }
    }
}
