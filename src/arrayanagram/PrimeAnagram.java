package arrayanagram;
import java.util.ArrayList;
import java.util.Arrays;
public class PrimeAnagram {

        ArrayList<ArrayList> listAnagram = new ArrayList();
        ArrayList<ArrayList> listNotAnagram = new ArrayList();
        int[][] primeNoArray = new int[10][100];
        static final int a = 10;

        public PrimeAnagram() {
            primeNo();
        }

        private void primeNo() {
            for (int i = 2; i < 1000; i++) {
                int count = 0;
                for (int j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                    if (count == 2) {
                        break;
                    }
                }
                if (count == 1) {
                    int index1 = i / 100;
                    int index2 = i % 100 - 1;
                    primeNoArray[index1][index2] = i;
                }
            }
        }

        public void show() {
            System.out.println("Anagrams");
            for (ArrayList list : listAnagram) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println("                  ");
            }

            System.out.println("Not anagrams");
            for (ArrayList list : listNotAnagram) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println("                    ");
            }
        }

        public void anagramNo() {
            for (int[] list : primeNoArray) {
                ArrayList<Integer> listA = new ArrayList();
                ArrayList<Integer> listB = new ArrayList();
                for (int prime : list) {
                    if (prime == 0) {
                        continue;
                    }
                    int check = 0;
                    for (int n : list) {
                        if (prime != n) {
                            if (checkAnagram(prime, n)) {
                                listA.add(prime);
                                check++;
                            }
                        }
                        if (check == 1) {
                            break;
                        }
                    }
                    if (check == 0) {
                        listB.add(prime);
                    }

                }
                listAnagram.add(listA);
                listNotAnagram.add(listB);
            }

        }



        private boolean checkAnagram(int a, int b) {
            int[] a1 = frequency(a);
            int[] b1 = frequency(b);
            if(Arrays.equals(a1, b1)) {
                return true;
            }
            return false;
        }

        private int[] frequency(int number) {
            int[] digits = new int[10];
            while (number > 0) {
                int digit = number % a;
                number = number / 10;
                digits[digit]++;
            }
            return digits;
        }
}
