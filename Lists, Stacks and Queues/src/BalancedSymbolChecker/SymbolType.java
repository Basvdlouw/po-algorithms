package BalancedSymbolChecker;

public enum SymbolType {
    OPENING('('),
    CLOSING(')');

    private Character character;

    SymbolType(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }
}
