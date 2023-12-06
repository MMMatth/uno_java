package uno.cartes.tests;

import uno.cartes.*;

class FabriqueCartesTest {

    public static void main(String[] args) {
        getInstance();
        getPaquetVide();
        getPaquetEntier();
        getPaquetMelange();
        getChiffreRouge();
    }

    private static void getInstance() {
        assert FabriqueCartes.getInstance() != null : "getInstance() ne renvoie pas une instance";
    }

    private static void getPaquetVide() {
        PaquetDeCartes p = FabriqueCartes.getInstance().getPaquetVide();
        assert p.getNombreDeCartes() == 0 : "getPaquetVide() ne renvoie pas un paquet vide";
    }

    private static void getPaquetEntier() {
        PaquetDeCartes p = FabriqueCartes.getInstance().getPaquetEntier();
        assert p.getNombreDeCartes() == 108 : "getPaquetEntier() ne renvoie pas un paquet avec 108 cartes";
    }

    private static void getPaquetMelange() {
        PaquetDeCartes p1 = FabriqueCartes.getInstance().getPaquetEntier();
        PaquetDeCartes p2 = FabriqueCartes.getInstance().getPaquetMelange();
        assert p1.getNombreDeCartes() == p2.getNombreDeCartes() : "getPaquetMelange() ne renvoie pas un paquet avec le même nombre de cartes";
    }

    private static void getChiffreRouge() {
        PaquetDeCartes p = FabriqueCartes.getInstance().getChiffreRouge();
        assert p.getNombreDeCartes() == 10 : "getChiffreRouge() ne renvoie pas un paquet avec 10 cartes rouges";
    }
}