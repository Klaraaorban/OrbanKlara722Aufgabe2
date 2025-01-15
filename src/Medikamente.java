public class Medikamente {
    String name;
    int price;

    public Medikamente(String name, int price, String krankenhaus) {
        this.name = name;
        this.price = price;
        Krankenhaus = krankenhaus;
    }

    String Krankenhaus;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getKrankenhaus() {
        return Krankenhaus;
    }

    @Override
    public String toString() {
        return "Medikamente{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Krankenhaus='" + Krankenhaus + '\'' +
                '}';
    }
}
