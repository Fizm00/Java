import java.util.*;

public class ShoppingTravis {
    public static void main(String[] args) {
        ArrayList<Item> orders = new ArrayList<Item>();
        ShoppingCart cart = new ShoppingCart();
        Scanner ui = new Scanner(System.in);
        boolean loop = true;
        System.out.println("Selamat Datang di Program Shopping Cart!");
        
        while (loop) {
            System.out.println("+-----------------------------+");
            System.out.println("Silahkan pilih menu dibawah ini");
            System.out.println("+-----------------------------+");
            System.out.println("1. Tambahkan item ke keranjang");
            System.out.println("2. Lihat keranjang");
            System.out.println("3. Cari item di keranjang");
            System.out.println("4. Hapus item dari keranjang");
            System.out.println("5. Tampilkan total harga");
            System.out.println("6. Keluar");
            System.out.print("Choose: ");
            int menu = ui.nextInt();

            switch(menu) {
                case 1:
                    System.out.print("Berapa item yang ingin ditambahkan? ");
                    int n = ui.nextInt();
                    for(int i = 0; i < n; i++){
                        System.out.print("[+] Masukkan nama item ke-" + (i + 1) + ": ");
                        String name = ui.next();
                        System.out.print("[+] Masukkan harga item ke-" + (i + 1) + ": ");
                        double price = ui.nextDouble();
                        System.out.print("[+] Masukkan jumlah item ke-" + (i + 1) + ": ");
                        int quantity = ui.nextInt();
                        Item item = new Item(name, price);
                        ItemOrder itemOrder = new ItemOrder(item, quantity);
                        cart.addItemOrder(itemOrder);
                    }
                    break;
                case 2:
                    System.out.println("Daftar item di keranjang");
                    for(int i=0; i<cart.itemOrders.size(); i++){
                        ItemOrder itemOrder1 = cart.itemOrders.get(i);
                        System.out.println("[ "+ i + " ] Item: " + itemOrder1.getItem().getName() + ", Harga: " + itemOrder1.getItem().getPrice() + ", Jumlah: " + itemOrder1.getQuantity());
                    }
                    break;
                case 3:
                    System.out.println("Masukkan nama item yang ingin dicari");
                    System.out.print(">> ");
                    String name1 = ui.next();
                    ItemOrder itemOrder2 = cart.searchItemOrderByName(name1);
                    if(itemOrder2 != null)
                        System.out.println("[+] Item: " + itemOrder2.getItem().getName() + ", Harga: " + itemOrder2.getItem().getPrice() + ", Jumlah: " + itemOrder2.getQuantity());
                    else
                        System.out.println("Item tidak ditemukan");
                    break;
                case 4:
                    System.out.println("Masukkan nama item yang ingin dihapus");
                    System.out.print(">> ");
                    String name2 = ui.next();
                    ItemOrder itemOrder3 = cart.searchItemOrderByName(name2);
                    if(itemOrder3 != null){
                        cart.removeItemOrder(itemOrder3);
                        System.out.println("Item berhasil dihapus");
                    }
                    else
                        System.out.println("Item tidak ditemukan");
                    break;
                case 5:
                    System.out.println(">> Total harga: " + cart.getTotalPrice());
                    break;
                case 6:
                    loop = false;
            } 
        }
    }
}

class Item { 
    private String name; 
    private double price; 
    public Item (String n, double p)
    { 
        name = n;  
        price = p; 
    } 
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}

class ItemOrder {
    private Item item; 
    private int quantity;
    boolean Discount = false;
    public ItemOrder (Item i, int q) { 
        item = i;  
        quantity = q; 
    }
    public Item getItem(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return item.getPrice() * quantity;
    }
}

class ShoppingCart { 
    ArrayList<ItemOrder> itemOrders; 
    public ShoppingCart () { 
        itemOrders = new ArrayList<ItemOrder> (); 
    } 
    public void addItemOrder(ItemOrder io){
        itemOrders.add(io);
    }
    public void removeItemOrder(ItemOrder io){
        itemOrders.remove(io);
    }
    public ItemOrder searchItemOrderByName(String name){
        for(int i=0; i<itemOrders.size(); i++){
            ItemOrder itemOrder = itemOrders.get(i);
            if(itemOrder.getItem().getName().equals(name))
                return itemOrder;
        }
        return null;
    }
    /* 
     * Diskon didapat dari ada berapa jumlah bundle yang memenuhi syarat.
     * Syarat bundle adalah kuantitas item berkelipatan 3.
     * Jika jumlah bundle lebih dari 1, maka akan didapat diskon sebesar 50% dari harga item untuk satu item.
     * Misal item A sejumlah 4 dengan harga masing-masing 1000, maka akan didapat diskon sebesar 50% untuk satu item.
     * Jadi total harga yang harus dibayar adalah 3500 atau [500 + 1000 + 1000] + 1000.
     * Oleh karena itu, harga setelah diskon yang didapat dipengaruhi oleh harga item yang ada di bundle tersebut.
     * Dengan kata lain, jika beli dua item di pembelian ketiga mendapat diskon sebesar 50% dari harga item tersebut,
     * hanya berlaku pada item yang sama.
     * 
     * 
     * Jika ingin mengganti sistematika diskon, maka cukup mengubah menjadi:
     * 
     * double discount = bundle * 3 * io.getItem().getPrice() * 0.05;
     * 
     * Hal tersebut akan menghasilkan diskon sebesar 5%  untuk tiga item di dalam bundle tersebut.
     * Misal item A sejumlah 4 dengan harga masing-masing 1000, maka akan didapat diskon sebesar 5% untuk tiga item.
     * Jadi total harga yang harus dibayar adalah 3850 atau [950 + 950 + 950] + 1000.
     * Tanda [] digunakan untuk menandakan bahwa diskon hanya diberikan untuk tiga item pada bundle.
     */
    public double calculateDiscount(ItemOrder io){
        int bundle = io.getQuantity() / 3;
        double discount = bundle * io.getItem().getPrice() * 0.5;
        return discount;
    }
    public double getTotalPrice(){
        double totalPrice = 0;
        for(int i = 0; i < itemOrders.size(); i++){
            ItemOrder io = itemOrders.get(i);
            double itemPrice = io.getPrice();
            if(io.getQuantity() >= 3 && io.getQuantity() % 3 == 0) {
                itemPrice -= calculateDiscount(io);
            }
            totalPrice += itemPrice;
        }
        return totalPrice;
    }
}
