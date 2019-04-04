package lesson2;

public enum SortType {
  BUBBLE ("Пузырьковая сортировка"), INSERTION ("Сортировка вставкой"), SELECTION ("Сортировка выбором");
  private String name;

  SortType(String s) {
    name = s;
  }

  public String getName() {
    return name;
  }
}