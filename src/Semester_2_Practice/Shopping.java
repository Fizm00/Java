package Semester_2_Practice;

import java.util.*;

public class Shopping {
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
            System.out.print(">> ");
            int menu = ui.nextInt();

            switch(menu) {
                case 1:
                    System.out.print("Berapa item yang ingin ditambahkan?");
                    int n = ui.nextInt();
                    for(int i=0; i<n; i++){
                        System.out.print("Masukkan nama item ke-" + (i+1) + ": ");
                        String name = ui.next();
                        System.out.print("Masukkan harga item ke-" + (i+1) + ": ");
                        double price = ui.nextDouble();
                        System.out.print("Masukkan jumlah item ke-" + (i+1) + ": ");
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
                        System.out.println("Item: " + itemOrder2.getItem().getName() + ", Harga: " + itemOrder2.getItem().getPrice() + ", Jumlah: " + itemOrder2.getQuantity());
                    else
                        System.out.println("Item tidak ditemukan");
                    break;
                case 4:
                    System.out.println("Masukkan index item yang ingin dihapus");
                    System.out.print(">> ");
                    int index = ui.nextInt();
                    cart.removeItemOrder(index);
                    break;
                case 5:
                    System.out.println("Total harga: " + cart.getTotalPrice());

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
    public void removeItemOrder(int index){
        if(index >= 0 && index < itemOrders.size())
            itemOrders.remove(index);
    }
    public ItemOrder searchItemOrderByName(String name){
        for(int i=0; i<itemOrders.size(); i++){
            ItemOrder itemOrder = itemOrders.get(i);
            if(itemOrder.getItem().getName().equals(name))
                return itemOrder;
        }
        return null;
    }
    public double calculateDiscount(ItemOrder io){
        int bundle = io.getQuantity() / 3;
        double discount = bundle * io.getItem().getPrice() * 0.5;
        return discount;
        
    }
    
    public double getTotalPrice(){
        double totalPrice = 0;
        for(int i=0; i<itemOrders.size(); i++){
            totalPrice += itemOrders.get(i).getPrice() - calculateDiscount(itemOrders.get(i));
        }
        return totalPrice;
    }
}