import java.util.Map;

public class Basket {

    protected Purchase[] purchases;
    protected Map<String, Integer> prices;

    public Basket(Map<String, Integer> prices) {
        this.prices = prices;
        this.purchases = new Purchase[prices.size()];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            sum += (long) purchase.count * prices.get(purchase.title);
        }
        return sum;
    }

    public void showingTheBasket(Map<String, Integer> prices) {
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
        }
        System.out.println("Сумма всех товаров в корзине: " + this.sum(prices));
    }
}
