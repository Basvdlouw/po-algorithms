package BalancedSymbolChecker;

import CustomStack.CustomStack;

public class BalancedSymbolChecker {

    private CustomStack<Character> stack;

    public void addSymbol(SymbolType type) {
        if (type == SymbolType.OPENING) {
            stack.push(type.getCharacter());
        } else if (type == SymbolType.CLOSING) {
            if (stack.getSize() == 0) {
                System.out.println("ERROR");
            } else {
                Character last = stack.pop();
                if (last == SymbolType.OPENING.getCharacter()) {
                    stack.push(type.getCharacter());
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}