 class BreadBaker {
    public void bakeBread() {
        System.out.println("Bread is Baked");
    }
}

class InventoryManager {
    public void manageInventory() {
        System.out.println("Inventory is managed");
    }
}

class SupplyOrder {
    public void orderSupplies() {
        System.out.println("Supply Chain is managed");
    }
}

class CustomerService {
    public void serveCustomer() {
        System.out.println("Customer Service is managed");
    }
}

class BakeryCleaner {
    public void cleanBakery() {
        System.out.println("Bakery is cleaned");
    }
}

public class BakeryManagement {
    public static void main(String[] args) {
        BreadBaker baker = new BreadBaker();
        InventoryManager inventoryManager = new InventoryManager();
        SupplyOrder supplyOrder = new SupplyOrder();
        CustomerService customerService = new CustomerService();
        BakeryCleaner cleaner = new BakeryCleaner();

        // Each class focuses on its specific responsibility
        baker.bakeBread();
        inventoryManager.manageInventory();
        supplyOrder.orderSupplies();
        customerService.serveCustomer();
        cleaner.cleanBakery();

    }
}
