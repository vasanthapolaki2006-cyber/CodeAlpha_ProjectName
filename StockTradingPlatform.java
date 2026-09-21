import java.util.*;

class Stock {
    String symbol;
    String name;
    double price;

    Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(symbol + " - " + name + " - Rs." + price);
    }
}

class Portfolio {
    HashMap<String, Integer> holdings = new HashMap<>();
    double balance;

    Portfolio(double balance) {
        this.balance = balance;
    }

    void buy(Stock stock, int quantity) {
        double cost = stock.price * quantity;

        if (balance >= cost) {
            balance -= cost;
            holdings.put(stock.symbol,
                    holdings.getOrDefault(stock.symbol, 0) + quantity);

            System.out.println("Stock bought successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sell(Stock stock, int quantity) {
        int owned = holdings.getOrDefault(stock.symbol, 0);

        if (owned >= quantity) {
            balance += stock.price * quantity;

            holdings.put(stock.symbol, owned - quantity);

            System.out.println("Stock sold successfully!");
        } else {
            System.out.println("You don't own enough shares!");
        }
    }

    void displayPortfolio(ArrayList<Stock> stocks) {
        double totalValue = balance;

        System.out.println("\n----- PORTFOLIO -----");

        for (Stock stock : stocks) {
            int quantity = holdings.getOrDefault(stock.symbol, 0);

            if (quantity > 0) {
                double value = quantity * stock.price;
                totalValue += value;

                System.out.println(
                    stock.symbol + " : " + quantity +
                    " shares = Rs." + value
                );
            }
        }

        System.out.println("Cash Balance : Rs." + balance);
        System.out.println("Total Portfolio Value : Rs." + totalValue);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("TCS", "Tata Consultancy Services", 3500));
        stocks.add(new Stock("INFY", "Infosys", 1600));
        stocks.add(new Stock("RELIANCE", "Reliance Industries", 2800));
        stocks.add(new Stock("HDFC", "HDFC Bank", 1700));

        Portfolio portfolio = new Portfolio(100000);

        while (true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. Display Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("\n----- MARKET DATA -----");

                for (Stock stock : stocks) {
                    stock.display();
                }

            } else if (choice == 2) {

                System.out.print("Enter stock symbol: ");
                String symbol = sc.next().toUpperCase();

                Stock selected = findStock(stocks, symbol);

                if (selected != null) {
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    portfolio.buy(selected, quantity);
                } else {
                    System.out.println("Stock not found!");
                }

            } else if (choice == 3) {

                System.out.print("Enter stock symbol: ");
                String symbol = sc.next().toUpperCase();

                Stock selected = findStock(stocks, symbol);

                if (selected != null) {
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    portfolio.sell(selected, quantity);
                } else {
                    System.out.println("Stock not found!");
                }

            } else if (choice == 4) {

                portfolio.displayPortfolio(stocks);

            } else if (choice == 5) {

                System.out.println("Thank you for using Stock Trading Platform!");
                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    static Stock findStock(ArrayList<Stock> stocks, String symbol) {

        for (Stock stock : stocks) {
            if (stock.symbol.equals(symbol)) {
                return stock;
            }
        }

        return null;
    }
}