/*
* В залежності від C2 визначити інтерфейс, який реалізує колекція:
* С2 = 1
* Інтерфейс
* Set
*
* В залежності від C3 визначити внутрішню структуру колекції:
* C3 = 1
* Внутрішня структура колекції
* Однозв’язний список

* Створити клас, що описує типізовану колекцію (типом колекції є узагальнений клас з лр №5),
* що реалізує заданий варіантом інтерфейс (п.2) та має задану внутрішню структуру (п.3).
* Реалізувати всі методи інтерфейсу, а також створити не менше ніж 3 конструктори
* (1 – порожній, 2 – в який передається 1 об’єкт узагальненого класу, 3 – в який передається стандартна колекція об’єктів).
* Всі початкові дані задаються у виконавчому методі.
* Код повинен бути детально задокументований.
* Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
* та бути завантаженим на GitHub.
*/

public class Main {
    public static void main(String[] args) {
        Sword sword = new Sword("Excalibur", 1000, 8);
        Armor armor = new Armor("Knight's Armor", 250, 10);
        Helmet helmet = new Helmet("Knight's Helmet", 120, 1.5);
        Shield shield = new Shield("Knight's Shield", 200, 2);

        EquipmentSet equipmentSet = new EquipmentSet();
        equipmentSet.add(sword);
        equipmentSet.add(armor);
        equipmentSet.add(helmet);
        equipmentSet.add(shield);

        System.out.println("Equipment set:");
        for (Equipment equipment : equipmentSet) {
            equipment.displayInfo();
        }

        equipmentSet.remove(armor);
        equipmentSet.add(armor);
        equipmentSet.remove(shield);

        System.out.println("\nAfter removal:");
        for (Equipment equipment : equipmentSet) {
            equipment.displayInfo();
        }

        equipmentSet.removeAll(equipmentSet);
        System.out.println("\nAfter all removal:");
        for (Equipment equipment : equipmentSet) {
            equipment.displayInfo();
        }

    }
}
