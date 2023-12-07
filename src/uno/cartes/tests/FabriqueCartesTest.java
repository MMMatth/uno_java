package uno.cartes.tests;

import uno.cartes.*;

class FabriqueCartesTest {

    private FabriqueCartes fabriqueCartes;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fabriqueCartes = FabriqueCartes.getInstance();
    }

    @org.junit.jupiter.api.Test
    void testGetInstance() {
        assert fabriqueCartes != null : "getInstance() ne renvoie pas une instance";
    }

    @org.junit.jupiter.api.Test
    void testGetPaquetVide() {
        PaquetDeCartes p = fabriqueCartes.getPaquetVide();
        assert p.getNombreDeCartes() == 0 : "getPaquetVide() ne renvoie pas un paquet vide";
    }

    @org.junit.jupiter.api.Test
    void testGetPaquetEntier() {
        PaquetDeCartes p = fabriqueCartes.getPaquetEntier();
        assert p.getNombreDeCartes() == 108 : "getPaquetEntier() ne renvoie pas un paquet avec 108 cartes";
    }

    @org.junit.jupiter.api.Test
    void testGetPaquetMelange() {
        PaquetDeCartes p1 = fabriqueCartes.getPaquetEntier();
        PaquetDeCartes p2 = fabriqueCartes.getPaquetMelangerEntier();
        assert p1.getNombreDeCartes() == p2.getNombreDeCartes() : "getPaquetMelange() ne renvoie pas un paquet avec le même nombre de cartes";
    }

    @org.junit.jupiter.api.Test
    void testGetChiffreRouge() {
        PaquetDeCartes p = fabriqueCartes.getChiffreRouge();
        assert p.getNombreDeCartes() == 10 : "getChiffreRouge() ne renvoie pas un paquet avec 10 cartes rouges";
    }
}
