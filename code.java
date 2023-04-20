import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Foo {
    /*
     * Complete the 'IsBuyerWinner' function below.
     *
     * The function is expected to return an Integer.
     * The function accepts following parameters:
     * 1. List (STRING_ARRAY) - codeList
     * 2. List (STRING_ARRAY) - shoppingCart
     */
    public static int IsBuyerWinner(List<String> codeList, List<String> shoppingCart) {
        // TODO: Implement the function
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int codeListCount = Integer.parseInt(scanner.nextLine().trim());
        List<String> codeList = new ArrayList<>();
        for (int i = 0; i < codeListCount; i++) {
            String codeListItem = scanner.nextLine();
            codeList.add(codeListItem);
        }
        int shoppingCartCount = Integer.parseInt(scanner.nextLine().trim());
        List<String> shoppingCart = new ArrayList<>();
        for (int i = 0; i < shoppingCartCount; i++) {
            String shoppingCartItem = scanner.nextLine();
            shoppingCart.add(shoppingCartItem);
        }
        int foo = Foo.IsBuyerWinner(codeList, shoppingCart);
        System.out.println(foo);
        scanner.close();
    }
}
