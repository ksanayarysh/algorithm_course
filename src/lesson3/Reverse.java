package lesson3;

public class Reverse {
    public String makeReverse(String str){
        MyArrayStack<Character> string = new MyArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            string.push(str.charAt(i));
        }

        StringBuilder reverseString = new StringBuilder();
        int count = string.getSize();
        for (int i = 0; i < count; i++) {
            reverseString.append(string.pop());
        }

        return reverseString.toString();
    }

    public static void main(String[] args) {
        new Reverse().makeReverse("Just");
    }
}
