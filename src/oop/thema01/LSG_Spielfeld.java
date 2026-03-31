package oop.thema01;

public class LSG_Spielfeld {
    // ==================================================================================
    // Attribute
    // ----------------------------------------------------------------------------------
    private char[] feld = new char[9];

    // ==================================================================================
    // Methoden
    // ----------------------------------------------------------------------------------
    public char getFeld(int id) {
        return feld[id];
    }

    public boolean setzen(int id, int spieler) {
        if (feld[id] != 0) {
            return false;
        } else {
            if (spieler == 1) {
                feld[id] = 'X';
            } else {
                feld[id] = 'O';
            }
            return true;
        }
    }
    
}
