import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {

        char[][] tableau = choixPlateau();
        affichePlateau(tableau);
//        partie(tableau);
    }

//    /**
//     *
//     * @param plateau
//     */
//    public static void partie(char[][] plateau) {
//
//        int tour = 1;
//        while (!gagnant(plateau)){
//            System.out.println("Au tour du joueur n°"+tour+" :");
//            if (tour == 1) tourAttaquant(plateau);
//            else tourDefenseur(plateau);
//            tour = tour % 2 + 1;
//        }
//        if (roiVivant(plateau)) System.out.println("Le défenseur a gagné !");
//        else System.out.println("L'attaquant a gagné !");
//    }

    /**
     *
     * @param plateau
     * @return
     */
    public static boolean gagnant(char[][] plateau) {

        if (plateau[0][0] == '■' || plateau[0][plateau.length-1] == '■' || plateau[plateau.length-1][0] == '■'
                || plateau[plateau.length-1][plateau.length-1] == '■') {
            return true;
        }
        return !roiVivant(plateau);
    }

    /**
     *
     * @param plateau
     * @return
     */
    public static boolean roiVivant(char[][] plateau) {

        for (int i = 0 ; i < plateau.length ; i++)
            for (char pion : plateau[i]){
                if (pion == '■') return true;
            }
        return false;
    }

//    /**
//     *
//     * @param plateau
//     */
//    public static void deplacement(char[][] plateau, int tour) {
//
//        Scanner scanner = new Scanner(System.in);
//        int saisie;
//        System.out.println("Entrez les coordonnées du pion à déplacer sous la forme lignecolonne");
//    }
//
//    /**
//     *
//     * @param saisie
//     * @return
//     */
//    public static boolean verifSaisie(int saisie) {
//
//
//        return
//    }
//    /**
//     *
//     * @param plateau
//     */
//    public static void tourAttaquant(char[][] plateau) {
//
//        affichePlateau(plateau);
//        deplacement(plateau, 1);
//    }
//
//    /**
//     *
//     * @param plateau
//     */
//    public static void tourDefenseur(char[][] plateau) {
//
//        affichePlateau(plateau);
//        deplacement(plateau, 2);
//    }
    /**
     *
     * @return
     */
    public static char[][] choixPlateau() {

        Scanner scanner = new Scanner(System.in);
        //Demande à l'utilisateur la taille du plateau sur lequel il veut joueur
        System.out.println("Quelle taille de plateau voulez-vous, 9 ou 7 ?");
        //Retourne le tableau de dimension demandé
        return switch (scanner.nextInt()) {
            case 9 -> new char[][]{
                    {' ', ' ', '◯', '◯', '◯', '◯', '◯', ' ', ' '},
                    {' ', ' ', ' ', ' ', '◯', ' ', ' ', ' ', ' '},
                    {'◯', ' ', ' ', ' ', '⬤', ' ', ' ', ' ', '◯'},
                    {'◯', ' ', ' ', '⬤', '⬤', '⬤', ' ', ' ', '◯'},
                    {'◯', '◯', '⬤', '⬤', '■', '⬤', '⬤', '◯', '◯'},
                    {'◯', ' ', ' ', '⬤', '⬤', '⬤', ' ', ' ', '◯'},
                    {'◯', ' ', ' ', ' ', '⬤', ' ', ' ', ' ', '◯'},
                    {' ', ' ', ' ', ' ', '◯', ' ', ' ', ' ', ' '},
                    {' ', ' ', '◯', '◯', '◯', '◯', '◯', ' ', ' '}};
            case 7 -> new char[][]{
                    {' ', ' ', '◯', '◯', '◯', ' ', ' '},
                    {' ', ' ', ' ', '◯', ' ', ' ', ' '},
                    {'◯', ' ', '⬤', '⬤', '⬤', ' ', '◯'},
                    {'◯', '◯', '⬤', '■', '⬤', '◯', '◯'},
                    {'◯', ' ', '⬤', '⬤', '⬤', ' ', '◯'},
                    {' ', ' ', ' ', '◯', ' ', ' ', ' '},
                    {' ', ' ', '◯', '◯', '◯', ' ', ' '}};
            default -> new char[0][0];
        };
    }

    /**
     *
     * @param tab
     */
    public static void affichePlateau(char[][] tab) {

        //Affichage du numéro des colonnes
        System.out.print("    ");
        for (int n = 1 ; n <= tab.length ; n++){
            System.out.print(n+" ");
        }
        //Affichage de la séparation du haut du plateau
        System.out.print("\n    ");
        for (int n = 1 ; n <= tab.length ; n++){
            System.out.print("\u001B[4m \u001B[0m"+" ");
        }
        System.out.println();
        //Affichage du plateau et du numéro de chaques lignes
        for (int i = 0 ; i < tab.length ; i++){
            System.out.print((i+1)+"  |");
            for (int j = 0 ; j < tab.length ; j++){
                System.out.print("\u001B[4m"+tab[i][j]+"\u001B[0m"+"|");
            }
            System.out.println();
        }
    }
}
