package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Foo {
    /*
     * Complete the 'IsBuyerWinner' function below.
     *
     * The function is expected to return an Integer.
     * The function accepts following parameters:
     * 1. List (STRING_ARRAY) - codeList
     * 2. List (STRING_ARRAY) - shoppingCart
     */
    public static int IsBuyerWinner(List<String> codeList, List<String> shoppingCart) {
        if (codeList == null || codeList.isEmpty()) {
            // If codeList is empty, then the buyer is a winner
            return 1;
        }
        if (shoppingCart == null || shoppingCart.isEmpty()) {
            // If shoppingCart is empty, then the buyer is not a winner
            return 0;
        }
        int i = 0, j = 0;
        while (i < codeList.size() && j < shoppingCart.size()) {
            String[] code = codeList.get(i).split(" ");
            if (code.length == 1 && code[0].equals("anything")) {
                // If code has only "anything", then any fruit can be in its place
                i++;
                continue;
            }
            int k = j;
            while (k < shoppingCart.size()) {
                String[] cart = shoppingCart.get(k).split(" ");
                if (code[0].equals(cart[0]) || code[0].equals("anything")) {
                    // If first fruit in code matches current fruit in shoppingCartor it's "anything"
                    boolean found = true;
                    for (int l = 1; l < code.length; l++) {
                        if (k+l >= shoppingCart.size()) {
                            // If code has more fruits than remaining shoppingCart items, then break
                            found = false;
                            break;
                        }
                        cart = shoppingCart.get(k+l).split(" ");
                        if (!code[l].equals(cart[0]) && !code[l].equals("anything")) {
                            // If any other fruit in code does not match with the next item in shoppingCart, then break
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        // If all fruits in code match with shoppingCart items, then move on to next group
                        i++;
                        j = k + code.length;
                        break;
                    }
                }
                k++;
            }
            if (k == shoppingCart.size()) {
                // If no match found in shoppingCart for current code group, then buyer is not a winner
                return 0;
            }
        }
        return i == codeList.size() ? 1 : 0;
    }





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

