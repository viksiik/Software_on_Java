/*
*  В залежності від C13 визначити варіант завдання:
*  C13 = 6

*  Варіант завдання:
*  Визначити ієрархію амуніції лицаря.
*  Екіпірувати лицаря.
*  Порахувати вартість амуніції.
*  Провести сортування амуніції за вагою.
*  Знайти елементи амуніції, що відповідає заданому діапазону цін.

*  Створити узагальнений клас та не менше 3 класів-нащадків,
*  що описують задану варіантом (п.2) область знань.
*  Створити клас, що складається з масиву об’єктів, з яким можна виконати вказані варіантом дії.
*  Необхідно обробити всі виключні ситуації, що можуть виникнути під час виконання програмного коду.
*  Код повинен бути детально задокументований.
*  Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
*  та бути завантаженим на GitHub.
*/

public class Main {
    public static void main(String[] args) {
        try {
            // Initializing the elements of the knight`s equipment set
            Helmet helmet = new Helmet("Knight's Helmet", 120, 1.5);
            Armor armor = new Armor("Knight's Armor", 250, 10);
            Shield shield = new Shield("Steel Shield", 150, 5);
            Sword sword = new Sword("Excalibur", 1000, 8);

            // Initializing the knight`s equipment set
            Equipment[] equipments = {helmet, armor, shield, sword};
            KnightEquipmentSet armorSet = new KnightEquipmentSet(equipments);

            // Displaying info about the knight`s equipment set
            System.out.println("Knight's Equipment Set:");
            armorSet.displayInfo();

            // Calculating total cost of the knight`s equipment set
            System.out.println("\nTotal cost of the set: " + armorSet.totalCost());

            // Sorting set by weight
            armorSet.sortByWeight();
            System.out.println("\nSorted set by weight:");
            armorSet.displayInfo();

            // Finding equipment`s price in range
            System.out.println("\nItems in price range 100 to 250:");
            armorSet.findItemsInPriceRange(100, 250);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}