public class PaymentGateway {
    private String name;
    private double feesPerTx;

    public PaymentGateway(String name, double feesPerTx) {
        this.name = name;
        this.feesPerTx = feesPerTx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFeesPerTx() {
        return feesPerTx;
    }

    public void setFeesPerTx(double feesPerTx) {
        this.feesPerTx = feesPerTx;
    }

    @Override
    public String toString() {
        return "PaymentGateway(name: " + name + ", feesPerTx: " + feesPerTx + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentGateway that = (PaymentGateway) o;

        if (Double.compare(feesPerTx, that.feesPerTx) != 0) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(feesPerTx);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
