import java.util.Scanner;

public class test {
    public test() {
    }

    public static void main(String[] args) {
        int comp = 0;
        Scanner scanner = new Scanner(System.in);

        char[][] tableau;
        for(tableau = new char[][]{{' ', '●', ' ', '●', ' ', '●', ' ', '●'}, {'●', ' ', '●', ' ', '●', ' ', '●', ' '}, {' ', '●', ' ', '●', ' ', '●', ' ', '●'}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'O', ' ', 'O', ' ', 'O', ' ', 'O', ' '}, {' ', 'O', ' ', 'O', ' ', 'O', ' ', 'O'}, {'O', ' ', 'O', ' ', 'O', ' ', 'O', ' '}}; verifGagnant(tableau); ++comp) {
            affichePlateau(tableau);
            System.out.println("Au joueur n°" + (comp % 2 + 1) + " de jouer");
            deplace(tableau, scanner, comp % 2 + 1);
        }

        affichePlateau(tableau);
        scanner.close();
    }

    public static void affichePlateau(char[][] tab) {
        System.out.print("  \u001b[4m 1 2 3 4 5 6 7 8 \u001b[0m \n");

        for(int i = 0; i < tab.length; ++i) {
            System.out.print(i + 1 + " |");

            for(int j = 0; j < tab.length; ++j) {
                System.out.print(tab[i][j] + "|");
            }

            System.out.println();
        }

        System.out.println("  ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }

    public static void deplace(char[][] tab, Scanner scanner, int joueur) {
        int temp = false;

        int pionl;
        int pionc;
        int objectifl;
        int objectifc;
        do {
            do {
                do {
                    int temp;
                    do {
                        do {
                            do {
                                System.out.println("Veuillez entrer le pion à déplacer");
                                temp = scanner.nextInt();
                                if (temp <= 88 && temp >= 10) {
                                    pionc = temp % 10 - 1;
                                    pionl = temp / 10 - 1;
                                } else {
                                    System.out.println("Les coordonnées rentrées ne sont pas valides");
                                    pionl = 0;
                                    pionc = 0;
                                }
                            } while(temp > 88);
                        } while(temp < 10);
                    } while(verifPlace(tab, pionl, pionc, ' '));

                    temp = false;

                    do {
                        System.out.println("Veuillez entrer la case objectif");
                        temp = scanner.nextInt();
                        if (temp <= 88 && temp >= 10) {
                            objectifc = temp % 10 - 1;
                            objectifl = temp / 10 - 1;
                        } else {
                            System.out.println("Les coordonnées rentrées ne sont pas valides");
                            objectifl = 0;
                            objectifc = 0;
                        }
                    } while(temp > 88 || temp < 10 || verifPlace(tab, objectifl, objectifc, ' ') || objectifl == pionl && objectifc == pionc);

                    temp = false;
                } while(verifPlace(tab, pionl, pionc, 'O') && joueur == 1);
            } while(verifPlace(tab, pionl, pionc, '●') && joueur == 2);
        } while(verifPlace(tab, pionl, pionc, ' '));

        tab[objectifl][objectifc] = tab[pionl][pionc];
        tab[pionl][pionc] = ' ';
    }

    public static boolean verifPlace(char[][] tab, int ligne, int colonne, char contenu) {
        return tab[ligne][colonne] == contenu;
    }

    public static boolean verifGagnant(char[][] tab) {
        boolean flag = false;
        char[][] var2 = tab;
        int var3 = tab.length;

        int var4;
        char[] chars;
        int j;
        for(var4 = 0; var4 < var3; ++var4) {
            chars = var2[var4];

            for(j = 0; j < tab.length; ++j) {
                if (chars[j] == 9679) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            flag = false;
            var2 = tab;
            var3 = tab.length;

            for(var4 = 0; var4 < var3; ++var4) {
                chars = var2[var4];

                for(j = 0; j < tab.length; ++j) {
                    if (chars[j] == 'O') {
                        flag = true;
                        break;
                    }
                }
            }
        }

        return flag;
    }
}
